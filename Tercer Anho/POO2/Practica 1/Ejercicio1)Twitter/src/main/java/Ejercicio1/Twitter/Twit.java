package Ejercicio1.Twitter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Twit {
	private String text;
	private User user;
	private List<Twit> retwits;
	private Optional<Twit> originalTwit;
	
	public Twit(String text, User user) {
		this.text = text;
		this.user = user;
		this.retwits = new ArrayList<>();
		this.originalTwit = Optional.empty();
	}
	
	public Twit(String text, User user, Twit originalTwit) {
		this.text = text;
		this.user = user;
		this.retwits = new ArrayList<>();
		this.originalTwit = Optional.of(originalTwit);
	}
	
	public void addRetwit(Twit twit) {
		this.retwits.add(twit);
	}
	
	/**
	 * This function deletes each element in a loop,
	 * sending the message ".deletTwit" recursively.
	 * Base case: The twit has no re-twits, then each 
	 * twit gonna sends a request to its owner user to delete from
	 * his owned twits list. Guaranteeing that all the
	 * re - twits are deleted.
	 */
	public void deleteTwit() {
		this.retwits.
		stream().
		forEach(rt -> rt.deleteTwit())
		;
		this.retwits.clear();
		this.user.deleteTwit(this);
	}
	
	/**
	 * Functions for tests:
	 */
	public List<Twit> getRetwits() {
		return this.retwits;
	}
}
