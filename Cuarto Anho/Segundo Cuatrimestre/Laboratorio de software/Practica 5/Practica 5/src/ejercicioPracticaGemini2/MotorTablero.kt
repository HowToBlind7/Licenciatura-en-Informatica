package ejercicioPracticaGemini2

import com.sun.net.httpserver.HttpExchange
import com.sun.net.httpserver.HttpHandler
import com.sun.net.httpserver.HttpServer
import java.io.FileWriter
import java.io.IOException
import java.io.PrintWriter
import java.lang.reflect.InvocationTargetException
import java.net.InetSocketAddress
import java.time.LocalDate
import java.util.concurrent.Executors

object MotorTablero {
    private val LOCK_LOG = Any()

    fun publicar(clasePanel: Class<*>) {
        val servicio = clasePanel.getAnnotation<PanelControl?>(PanelControl::class.java)

        if (servicio != null) {
            try {
                val sistemaRouter = clasePanel.getDeclaredConstructor().newInstance() as SistemaRouter
                val server = HttpServer.create(InetSocketAddress(servicio.puerto), 0)
                server.createContext("/favicon.ico", HttpHandler { exchange: HttpExchange? ->
                    exchange!!.sendResponseHeaders(404, -1)
                    exchange.close()
                })
                server.createContext("/", MiHandler(sistemaRouter, servicio.historial))
                server.setExecutor(Executors.newFixedThreadPool(servicio.hilos))
                server.start()
                println(
                    "Servidor lanzado y escuchando en: " + server.getAddress().getHostName() + ":" + server.getAddress()
                        .getPort()
                )
            } catch (e: NoSuchMethodException) {
                println("No fue posible acceder al constructor.")
            } catch (e: InstantiationException) {
                println("No fue posible acceder al constructor.")
            } catch (e: IllegalAccessException) {
                println("El método (constructor) no es accesible.")
            } catch (e: InvocationTargetException) {
                println("Ha ocurrido un error interno en el constructor.")
            } catch (e: IOException) {
                throw RuntimeException(e)
            }
        }
    }

    private class MiHandler(private val sistemaRouter: SistemaRouter, private val log: String) : HttpHandler {
        @Throws(IOException::class)
        override fun handle(exchange: HttpExchange) {
            val servicio: Class<out SistemaRouter?> = sistemaRouter.javaClass

            var estadoServicio = " - "

            for (m in servicio.getDeclaredMethods()) {
                if (m.isAnnotationPresent(Metrica::class.java) && m.getReturnType() == String::class.java) {
                    m.setAccessible(true)
                    try {
                        estadoServicio = estadoServicio + " - " + m.invoke(sistemaRouter)
                        println("EstadoServicio actual: " + estadoServicio)
                    } catch (e: InvocationTargetException) {
                        throw RuntimeException(e)
                    } catch (e: IllegalAccessException) {
                        throw RuntimeException(e)
                    }
                }
            }

            val date = LocalDate.now().toString()
            val ip = exchange.getRemoteAddress().getAddress().getHostAddress()
            val mensajeLog = ("Fecha y hora: " + date
                    + ", IP del cliente: " + ip
                    + estadoServicio)

            PrintWriter(FileWriter(log, true)).use { out ->
                synchronized(LOCK_LOG) {
                    out.println(mensajeLog)
                }
                println("Se ha logueado: " + mensajeLog)
            }
            exchange.sendResponseHeaders(200, mensajeLog.toByteArray().size.toLong())
            exchange.getResponseBody().use { out ->
                out.write(mensajeLog.toByteArray())
            }
            exchange.close()
        }
    }
}
