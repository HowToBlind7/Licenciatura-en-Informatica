package Ejercicio1.Twitter;

import java.util.ArrayList;
import java.util.List;

public class User {
	private String screenName;
	private List<Twit> twits;
	
	public User(String screenName) {
		this.screenName = screenName;
		this.twits = new ArrayList<>();
	}
	
	public void createTwit(String text) {
		this.twits.add(new Twit(text, this));
	}
	
	public void createRetwit(Twit twit, String text) {
		Twit retwit = new Twit(text, this, twit);
		twit.addRetwit(retwit);
		this.twits.add(retwit);
	}
	
	public String getScreenName() {
		return this.screenName;
	}
	
	public void deleteTwits() {
		/*this.twits.
		stream().
		forEach(t -> t.deleteTwit())
		;*/
		int amount = this.twits.size();
		for (int i = 0; i < amount; i++) {
			this.twits.get(0).deleteTwit();
		}
	}
	
	public void deleteTwit(Twit twit) {
		this.twits.remove(twit);
	}
	
	/**
	 * Metodos auxiliares para los tests:
	 */
	
	public List<Twit> getTwits() {
		return this.twits;
	}
}
