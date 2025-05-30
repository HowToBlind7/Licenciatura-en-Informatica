package ar.edu.unlp.info.oo2.biblioteca;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BibliotecaTest {
	String text;
	Biblioteca biblioteca;
	Socio socio1;
	Socio socio2;
	String jsonString;
	String separator;
	
	
	@BeforeEach
	void setUp() throws Exception {
		biblioteca = new Biblioteca();
		socio1 = new Socio("Juan", "Mail@gmail.com", "1999/9");
		biblioteca.agregarSocio(socio1);
		socio2 = new Socio("Nicolas Cage", "NC@gmail.com", "0888/8");
		biblioteca.agregarSocio(socio2);
		jsonString = biblioteca.exportarSocios();
		separator = System.lineSeparator();
	}
	
    @Test
    public void testJsonString() {
    	assertTrue(jsonString.contains("["));
    	assertTrue(jsonString.contains("{"));
    	assertTrue(jsonString.contains("]"));
    	assertTrue(jsonString.contains("}"));
    	assertTrue(jsonString.contains("\t\t\"nombre\": \"" + socio1.getNombre() + "\"," + separator));
    	assertTrue(jsonString.contains("\t\t\"email\": \"" + socio1.getEmail() + "\"," + separator));
    	assertTrue(jsonString.contains("\t\t\"legajo\": \"" + socio1.getLegajo() + "\"" + separator));
    	assertTrue(jsonString.contains("\t\t\"nombre\": \"" + socio2.getNombre() + "\"," + separator));
    	assertTrue(jsonString.contains("\t\t\"email\": \"" + socio2.getEmail() + "\"," + separator));
    	assertTrue(jsonString.contains("\t\t\"legajo\": \"" + socio2.getLegajo() + "\"" + separator));
    	
    }

    @Test
    public void testJsonStringVacio() {
    	biblioteca = new Biblioteca();
    	assertTrue(biblioteca.exportarSocios().equals("[]"));
    }
}
