package ar.edu.unlp.info.oo2.biblioteca;

public class ProgramaBiblioteca {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Biblioteca biblioteca = new Biblioteca();
		Socio socio = new Socio("Juan", "Mail@gmail.com", "1999/9");
		biblioteca.agregarSocio(socio);
		socio = new Socio("PEPE", "PEPE@gmail.com", "12165/3");
		biblioteca.agregarSocio(socio);
		System.out.println(biblioteca.exportarSocios());
		biblioteca.setExporter(new JsonAdapter());
		System.out.print(biblioteca.exportarSocios());
	}

}
