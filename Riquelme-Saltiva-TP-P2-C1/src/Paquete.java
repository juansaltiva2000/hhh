import java.util.LinkedList;

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
	
	public boolean equals(Paquete paq) {
		return paq.getNecesitaFrio() == necesitaFrio && paq.peso == peso && paq.volumen == volumen;
	}

	public boolean paqueteEsIgualAOtro(LinkedList<Paquete> paquetes) {
		boolean ret = false;
		for(Paquete paq: paquetes) {
			ret = ret || this.equals(paq);
		}
		return ret;
	}
}
