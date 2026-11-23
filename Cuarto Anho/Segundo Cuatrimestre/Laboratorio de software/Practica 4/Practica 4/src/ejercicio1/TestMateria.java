package practica4;

import java.util.Comparator;

public class TestMateria {
    public static void main(String[] args) {
        Materia labo = new Materia("Laboratorio de Software");

        labo.agregaAlumno(new Alumno(1050, "Gómez", "Lucía", 42111222));
        labo.agregaAlumno(new Alumno(1010, "Gómez", "Juan", 40333444));
        labo.agregaAlumno(new Alumno(1080, "Rodríguez", "Martín", 43555666));
        labo.agregaAlumno(new Alumno(1002, "López", "Ana", 41777888));
        labo.agregaAlumno(new Alumno(1095, "Fernández", "Diego", 44999000));
        labo.agregaAlumno(new Alumno(1033, "Martínez", "Sofía", 42123456));
        labo.agregaAlumno(new Alumno(1015, "Gómez", "Carlos", 40654321));
        labo.agregaAlumno(new Alumno(1070, "Sánchez", "Paula", 43987654));
        labo.agregaAlumno(new Alumno(1005, "Díaz", "Mateo", 41112233));
        labo.agregaAlumno(new Alumno(1042, "Romero", "Valentina", 42445566));

        System.out.println("Nómina de alumnos en " + labo.getNombre() + ":");
        for (Alumno a : labo.getAlumnos()) {
            System.out.println(a);
        }
        // Inciso d) realizado de la otra manera.
        Materia labo2 = new Materia("Laboratorio de Software 2", Comparator.comparing(Alumno::getApellido).thenComparing(Alumno::getNombre));

        labo2.agregaAlumno(new Alumno(1050, "Gómez", "Lucía", 42111222));
        labo2.agregaAlumno(new Alumno(1010, "Gómez", "Juan", 40333444));
        labo2.agregaAlumno(new Alumno(1080, "Rodríguez", "Martín", 43555666));
        labo2.agregaAlumno(new Alumno(1002, "López", "Ana", 41777888));
        labo2.agregaAlumno(new Alumno(1003, "López", "Ana", 41777889)); // No lo agrega por ser "igual" a la otra Lopez Ana.
        labo2.agregaAlumno(new Alumno(1095, "Fernández", "Diego", 44999000));
        labo2.agregaAlumno(new Alumno(1033, "Martínez", "Sofía", 42123456));
        labo2.agregaAlumno(new Alumno(1015, "Gómez", "Carlos", 40654321));
        labo2.agregaAlumno(new Alumno(1070, "Sánchez", "Paula", 43987654));
        labo2.agregaAlumno(new Alumno(1005, "Díaz", "Mateo", 41112233));
        labo2.agregaAlumno(new Alumno(1042, "Romero", "Valentina", 42445566));

        System.out.println(labo2.getNombre() + " y sus alumnos ordenados por apellido y nombre utilizando la sobrecarga en el constructor de Materia pasandole un comparator distinto");
        for (Alumno a:  labo2.getAlumnos()) {
            System.out.println(a);
        }
    }
}
/*
* Inciso d): ¿Qué requisito tuvo que cumplir para poder mantenerla ordenada?Según la teoría de SortedSet y TreeSet:   Usar una implementación ordenada de Set (TreeSet):
*  A diferencia de HashSet (que no garantiza ningún orden), TreeSet implementa la interfaz SortedSet mediante una estructura de árbol que mantiene los elementos en orden
* ascendente.   Elementos comparables: Para que TreeSet pueda determinar el orden e insertar cada objeto en su posición correcta, se debió cumplir uno de estos dos
* requisitos:   Que la clase de los elementos (Alumno) implemente la interfaz Comparable<Alumno> sobrescribiendo el método compareTo(Alumno otro) (estableciendo así su
* orden natural).   O bien, suministrarle un objeto Comparator<Alumno> al constructor del TreeSet en el momento de su creación.
*
* Inciso f): Enfoque 1: Jerarquía de herencia con una superclase Persona (Polimorfismo)Dado que Alumno, Empleado y Cliente comparten datos comunes (nombre, apellido, DNI),
* se define una clase abstracta o superclase Persona (que implemente Comparable<Persona>, por ejemplo por DNI o por Apellido y Nombre) de la cual hereden Alumno, Empleado
* y Cliente.Definición de la colección:JavaSortedSet<Persona> nomina = new TreeSet<>();
Esto permite almacenar en una misma nómina instancias de Alumno, Empleado y Cliente de forma segura.Enfoque 2: Clase contenedora genérica Nomina<T>
* (Parametrización con Tipos Genéricos)Si lo que se busca es reutilizar la estructura para tener una nómina homogénea de alumnos, otra de empleados y otra de clientes,
* se parametriza la clase contenedora restringiendo el tipo genérico T a objetos comparables:   Definición de la clase y colección:
* public class Nomina<T extends Comparable<T>> {
    private SortedSet<T> elementos = new TreeSet<>();

    public void agregar(T elemento) {
        elementos.add(elemento);
    }

    public SortedSet<T> getElementos() {
        return elementos;
    }
}
Así se puede instanciar Nomina<Alumno>, Nomina<Empleado> o Nomina<Cliente> reutilizando el mismo código con chequeo fuerte de tipos en compilación.
 * */