package Ejercicio1.Twitter;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserTest {
	User u1;
	User u2;
	
	@BeforeEach
	void setUp() throws Exception {
		u1 = new User("u1");
		u2 = new User("u2");
		
		u1.createTwit("Primer twit");
		u1.createTwit("Segundo twit");
		u1.createTwit("Tercer twit");
		u2.createRetwit(u1.getTwits().get(0), "Primer retiwt del primer twit");
		u2.createRetwit(u1.getTwits().get(0), "Segundo retiwt del primer twit");
		u2.createRetwit(u1.getTwits().get(1), "Primer retiwt del segundo twit");
		u2.createRetwit(u1.getTwits().get(2), "Primer retiwt del tercer twit");
		u2.createRetwit(u2.getTwits().get(3), "Primer retiwt del retwit del tercer twit");
		
		u2.createTwit("Este twit no debe eliminarse");
	}
	
	@Test
	void test() {
		u1.deleteTwits();
		assertEquals(u1.getTwits().size(), 0);
		assertEquals(u2.getTwits().size(), 1);
	}
}
