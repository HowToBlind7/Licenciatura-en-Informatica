import java.lang.reflect.Field
import java.util.concurrent.ThreadLocalRandom

object FabricaDeSensores {
    /*
     * Verifica que claseSensor esté anotada con @ComponenteSensor. Luego instancia cant objetos de tipo T utilizando reflexión.
     * Por cada objeto creado, busca el atributo String anotado con @UbicacionesPosibles y le inyecta una ubicación elegida al azar del arreglo,
     * y busca el atributo Integer anotado con @RangoValores (nota: en Kotlin Int? compila a java.lang.Integer en el bytecode) y le inyecta un entero
     * al azar entre min y max. Devuelve la lista de tamaño cant con las instancias ya inicializadas.
     * */
    fun <T : SensorBase?> generarLote(claseSensor: Class<T?>, cant: Int): MutableList<T?> {
        val resultado: MutableList<T?> = ArrayList<T?>()

        if (!claseSensor.isAnnotationPresent(ComponenteSensor::class.java)) {
            return resultado
        }
        var campoUbicacionesPosibles: Field? = null
        var campoRangoValores: Field? = null
        var ubicacionesPosibles: Array<String?>? = null
        var rangoValores: Rango? = null

        for (f in claseSensor.getDeclaredFields()) {
            if (f.isAnnotationPresent(UbicacionesPosibles::class.java)) {
                campoUbicacionesPosibles = f
                ubicacionesPosibles = f.getAnnotation<UbicacionesPosibles?>(UbicacionesPosibles::class.java).value
            } else if (f.isAnnotationPresent(RangoValores::class.java)) {
                campoRangoValores = f
                rangoValores = Rango(
                    f.getAnnotation<RangoValores?>(RangoValores::class.java).min,
                    f.getAnnotation<RangoValores?>(RangoValores::class.java).max
                )
            }
        }

        if (campoRangoValores == null || campoUbicacionesPosibles == null) {
            return resultado
        }
        campoRangoValores.setAccessible(true)
        campoUbicacionesPosibles.setAccessible(true)
        for (i in 0..<cant) {
            try {
                val instancia = claseSensor.getDeclaredConstructor().newInstance()
                campoUbicacionesPosibles.set(
                    instancia,
                    ubicacionesPosibles!![ThreadLocalRandom.current().nextInt(ubicacionesPosibles.size)]
                )
                campoRangoValores.set(
                    instancia,
                    ThreadLocalRandom.current().nextInt(rangoValores!!.min, rangoValores.max)
                )

                resultado.add(instancia)
            } catch (e: Throwable) {
                println("Ha ocurrido un error")
            }
        }

        return resultado
    }

    fun <T> volcarEnRegistro(origen: MutableList<out T?>, destino: MutableList<in T?>) {
        destino.addAll(origen)
    }

    @JvmRecord
    private data class Rango(val min: Int, val max: Int)
}
