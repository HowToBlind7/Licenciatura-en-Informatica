package practica4;

public class Alumno implements Comparable<Alumno> {
    private int legajo;
    private String apellido;
    private String nombre;
    private int dni;

    public Alumno(int legajo, String apellido, String nombre, int dni) {
        this.legajo = legajo;
        this.apellido = apellido;
        this.nombre = nombre;
        this.dni = dni;
    }

    public int getLegajo() { return legajo; }
    public String getApellido() { return apellido; }
    public String getNombre() { return nombre; }
    public int getDni() { return dni; }


    // Define el orden natural por número de legajo
    @Override
    public int compareTo(Alumno otro) {
        return Integer.compare(this.legajo, otro.legajo);
    }


    /*
    // Inciso d) (Una forma de hacerlo. La otra, es instanciar el constructor del set con un comparator
    @Override
    public int compareTo(Alumno otro) {
        int resultado = this.getApellido().compareTo(otro.getApellido());
        if (resultado != 0) return resultado;
        return this.getNombre().compareTo(otro.getNombre());
    }
    */

    @Override
    public String toString() {
        return String.format("Legajo: %d | %s, %s (DNI: %d)", legajo, apellido, nombre, dni);
    }
}