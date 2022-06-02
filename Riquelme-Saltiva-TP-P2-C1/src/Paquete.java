public class Paquete {

	private double peso;
	private double volumen;
	private boolean necesitaFrio;
	
	public Paquete(double peso, double volumen, boolean necesitaFrio) {
		this.peso = peso;
		this.volumen = volumen;
		this.necesitaFrio = necesitaFrio;
	}
	
	public double getPeso() {
		return peso;
	}
	
	public double getVolumen() {
		return volumen;
	}
	
	public boolean getNecesitaFrio() {
		return necesitaFrio;
	}
	
	@Override
	public boolean equals(Object o) {
		Paquete paq = (Paquete) o;
		return paq.necesitaFrio == necesitaFrio && paq.peso == peso && paq.volumen == volumen;
	}

}
