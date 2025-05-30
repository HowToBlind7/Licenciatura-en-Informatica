package Ejercicio2.PiedraPapelTijeraLagartoSpock;

public class Piedra extends Strategy{
	
	public Piedra() {
		
	}
	@Override
	public String vs(Strategy strategy) {
		return this.vsPiedra(strategy);
	}

	@Override
	public String vsPiedra(Strategy strategy) {
		return "Empate";
	}

	@Override
	public String vsPapel(Strategy strategy) {
		return "Pierde";
	}

	@Override
	public String vsTijera(Strategy strategy) {
		return "Gana";
	}

	@Override
	public String vsLagarto(Strategy strategy) {
		return "Gana";
	}

	@Override
	public String vsSpock(Strategy strategy) {
		return "Pierde";
	}

}
