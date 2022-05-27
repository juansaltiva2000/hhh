
public class Flete extends Transporte {

	private int cantAcompaniantes;
	private double costoxAcompaniante;
	
	public Flete(double pesoMax, double volumenMax, boolean tieneRefrigeracion, double costoKm, int cantAcompaniantes, double costoxAcompaniante) {
		super(pesoMax, volumenMax, tieneRefrigeracion, costoKm);
		this.cantAcompaniantes = cantAcompaniantes;
		this.costoxAcompaniante = costoxAcompaniante;
	}
	
	public double obtenerCostoViaje(double distancia) {
		return 0;
	}
	//dada una distancia, calcula (distancia*costoKm) + (cantAcompaniantes*costoxAcompaniante)
}
