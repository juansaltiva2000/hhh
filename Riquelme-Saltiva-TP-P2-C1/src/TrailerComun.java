
public class TrailerComun extends Transporte {

	private boolean seguroDeCarga;
	
	
	public TrailerComun(double pesoMax, double volumenMax, boolean tieneRefrigeracion, double costoKm, boolean seguroDeCarga) {
		
		super(pesoMax, volumenMax, tieneRefrigeracion, costoKm);
		this.seguroDeCarga = seguroDeCarga;
	}
	
	public double obtenerCostoViaje(double distancia) {
		return 0;
	}
	//dada una distancia, calcula distancia*costoKm
}
