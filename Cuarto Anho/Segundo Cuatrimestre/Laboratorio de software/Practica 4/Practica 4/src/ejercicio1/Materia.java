package practica4;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class Materia {
    private String nombre;
    private SortedSet<Alumno> alumnos;

    public Materia(String nombre) {
        this.nombre = nombre;
        this.alumnos = new TreeSet<>(); // Mantiene el conjunto ordenado automáticamente por el orden default establecido por el metodo compareTo() en Alumno.
    }

    public Materia(String nombre, Comparator<Alumno> comparator) {
        this.nombre = nombre;
        this.alumnos = new TreeSet<>(comparator);
    }

    public String getNombre() {
        return nombre;
    }

    // b) Agrega un alumno a la nómina
    public void agregaAlumno(Alumno a) {
        this.alumnos.add(a);
    }

    // b) Retorna el conjunto de alumnos inscriptos
    public SortedSet<Alumno> getAlumnos() {
        return this.alumnos;
    }
}