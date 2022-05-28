
public class MegaTrailer extends Transporte {

	private double segCarga; //tal vez podria estar en Transporte directamente y en Flete se setea en false
	private double costoFijo;
	private double costoComida;
	
	public MegaTrailer(double cargaMax, double capacidad, boolean tieneRefrigeracion, double costoKm, double segCarga, double costoFijo, double costoComida) {
		super(cargaMax, capacidad, tieneRefrigeracion, costoKm);
		this.segCarga = segCarga;
		this.costoFijo = costoFijo;
		this.costoComida = costoComida;
	}

	
	public double obtenerCostoViaje(double distancia) {
		return (costoKm*distancia)+ segCarga + costoFijo + costoComida;
	}
	//
}
