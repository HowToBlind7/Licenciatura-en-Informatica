@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class MisionEspacial(val archivoBitacora: String = "bitacora_espacial.txt")
