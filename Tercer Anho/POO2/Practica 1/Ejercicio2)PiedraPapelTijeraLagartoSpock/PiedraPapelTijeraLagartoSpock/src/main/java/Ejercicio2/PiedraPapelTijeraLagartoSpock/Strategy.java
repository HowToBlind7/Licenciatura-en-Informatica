package Ejercicio2.PiedraPapelTijeraLagartoSpock;

public abstract class Strategy {
	public abstract String vs(Strategy strategy);
	public abstract String vsPiedra(Strategy strategy);
	public abstract String vsPapel(Strategy strategy);
	public abstract String vsTijera(Strategy strategy);
	public abstract String vsLagarto(Strategy strategy);
	public abstract String vsSpock(Strategy strategy);
	
	
}
