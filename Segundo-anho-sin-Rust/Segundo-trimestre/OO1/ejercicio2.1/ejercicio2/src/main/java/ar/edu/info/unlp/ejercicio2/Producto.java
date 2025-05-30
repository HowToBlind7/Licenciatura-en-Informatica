package ar.edu.info.unlp.ejercicio2;

public class Producto {
	private double peso;
	private double PrecioPorKilo;
	private String description;
	
	public Producto(double peso,  double PrecioPorKilo, String description) {
		this.peso = peso;
		this.PrecioPorKilo = PrecioPorKilo;
		this.description = description;
	}
	
	public Producto() {
	}

	public double getPrecio() {
		return PrecioPorKilo * peso;
	}
	// Puedo agregar este metodo?
	// ->
	public double getPeso() {
		return peso;
	}
	// -> Para los tests ->
	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getPrecioPorKilo() {
		return PrecioPorKilo;
	}

	public void setPrecioPorKilo(double precioPorKilo) {
		PrecioPorKilo = precioPorKilo;
	}

	public String getdescription() {
		return description;
	}

	public void setdescription(String description) {
		this.description = description;
	}
	
}
