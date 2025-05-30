package Ejercicio1.Twitter;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TwitTest {
	User u1;
	User u2;
	Twit twit;
	
	@BeforeEach
	void setUp() throws Exception {
		u1 = new User("u1");
		u2 = new User("u2");
		
		u1.createTwit("Primer twit");
		u2.createRetwit(u1.getTwits().get(0), "Primer retwit");
		u1.createRetwit(u2.getTwits().get(0), "Primer retwit del retwit");
		
		u2.createTwit("No me deben eliminar");
	}
	
	@Test
	void testDeleteTwit() {
		u1.getTwits().get(0).deleteTwit();
		assertEquals(u1.getTwits().size(), 0);
		assertEquals(u2.getTwits().size(), 1);
	}

}
