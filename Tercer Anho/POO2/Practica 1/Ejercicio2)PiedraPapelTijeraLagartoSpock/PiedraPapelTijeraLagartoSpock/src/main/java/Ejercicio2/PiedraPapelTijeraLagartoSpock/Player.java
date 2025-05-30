package Ejercicio2.PiedraPapelTijeraLagartoSpock;

public class Player {
	private Strategy strategy;
	
	public Player() {
		
	}
	
	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
	}
	
	public String jugar(Strategy strategy) {
		return this.strategy.vs(strategy);
	}
}
