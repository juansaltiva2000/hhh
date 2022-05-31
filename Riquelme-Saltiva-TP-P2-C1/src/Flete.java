
public class Flete extends Transporte {

	private int cantAcompaniantes;
	private double costoxAcompaniante;
	
	public Flete(double pesoMax, double volumenMax, double costoKm, int cantAcompaniantes, double costoxAcompaniante) {
		super(pesoMax, volumenMax, false, costoKm);
		this.cantAcompaniantes = cantAcompaniantes;
		this.costoxAcompaniante = costoxAcompaniante;
	}
	
	@Override
	public double obtenerCostoViaje(double distancia) {
		return (costoKm*distancia) + (cantAcompaniantes*costoxAcompaniante);
	}
	//dada una distancia, calcula (distancia*costoKm) + (cantAcompaniantes*costoxAcompaniante)
}
