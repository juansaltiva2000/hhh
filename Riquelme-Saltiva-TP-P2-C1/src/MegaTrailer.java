
public class MegaTrailer extends Transporte {

	private boolean seguroDeCarga; //tal vez podria estar en Transporte directamente y en Flete se setea en false
	private double costoFijo;
	private double gastoComidaDeConductor;
	
	public MegaTrailer(double pesoMax, double volumenMax, boolean tieneRefrigeracion, double costoKm, boolean seguroDeCarga, double costoFijo, double gastoComidaDeConductor) {
		super(pesoMax, volumenMax, tieneRefrigeracion, costoKm);
		this.seguroDeCarga = seguroDeCarga;
		this.costoFijo = costoFijo;
		this.gastoComidaDeConductor = gastoComidaDeConductor;
	}
	
	public double obtenerCostoViaje(double distancia) {
		return 0;
	}
	//
}
