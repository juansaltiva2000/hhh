import java.util.HashMap;
import java.util.LinkedList;

public abstract class Transporte {

	private double cargaMax;
	private double capacidad;
	private boolean tieneRefrigeracion;
	protected double costoKm;
	private HashMap<String,LinkedList<Paquete>> paquetes; 
	private boolean estaEnViaje;
	private StringBuilder destino;
	
	public Transporte(double cargaMax, double capacidad, boolean tieneRefrigeracion, double costoKm) {
		this.cargaMax = cargaMax;
		this.capacidad = capacidad;
		this.tieneRefrigeracion = tieneRefrigeracion;
		this.costoKm = costoKm;
		
		paquetes = new HashMap<String, LinkedList<Paquete>>();
		estaEnViaje = false;
		destino = new StringBuilder();
	}
	
	public boolean cargarMercaderia(String destino, Paquete paq) {
		return paquetes.get(destino).add(paq);
	}
	//se le pasa como parametro los productos que tiene el deposito y pregunta si tienen el mismo destino que el transporte
	//en caso verdadero, carga aquellos productos que coincidan, en caso falso no hace nada
	
	protected abstract double obtenerCostoViaje(double distancia);
	
	public void iniciarViaje() {
		setEstaEnViaje(true);
	}
	
	public boolean finalizarViaje() {
		setEstaEnViaje(false);
		blanquearDestino();
		return vaciarCarga();
	}
	
	private boolean vaciarCarga() {
		return paquetes.remove(destino, paquetes.get(destino)); //no estoy segura de que esté bien
	}
	
	public boolean tieneDestino() {
		return !destino.isEmpty();
	}
	
	public void asignarDestino(String destino) {
		this.destino.replace(0, destino.length()-1, destino);
	}
	
	private void blanquearDestino() {
		destino.delete(0, destino.length()-1);
	}
	
	public boolean tienePaquetesCargados() {
		return !paquetes.isEmpty();
	}

	private void setEstaEnViaje(boolean estaEnViaje) {
		this.estaEnViaje = estaEnViaje;
		
	}
	public boolean getEstaEnViaje() {
		return estaEnViaje;
	}
	
	public StringBuilder getDestino() {
		return destino;
	}

	public boolean getTieneRefrigeracion() {
		return tieneRefrigeracion;
	}

	public double getCapacidad() {
		return capacidad;
	}
	
}

