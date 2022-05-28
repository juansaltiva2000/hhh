
public class TrailerComun extends Transporte {

	private double segCarga;
	
	
	public TrailerComun(double pesoMax, double volumenMax, boolean tieneRefrigeracion, double costoKm, double segCarga) {
		
		super(pesoMax, volumenMax, tieneRefrigeracion, costoKm);
		this.segCarga = segCarga;
	}
	
	public double obtenerCostoViaje(double distancia) {
		return (costoKm*distancia) + segCarga;
	}
	//dada una distancia, calcula distancia*costoKm
}
