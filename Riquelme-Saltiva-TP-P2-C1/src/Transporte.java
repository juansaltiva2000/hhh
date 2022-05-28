import java.util.HashMap;
import java.util.LinkedList;

public abstract class Transporte {

	private double cargaMax;
	private double capacidad;
	private boolean tieneRefrigeracion;
	private double costoKm;
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
	private void setEstaEnViaje(boolean estaEnViaje) {
		this.estaEnViaje = estaEnViaje;
		
	}

	//setea en true el atributo estaEnViaje
	
	public boolean finalizarViaje() {
		return false;
	}
	//vacía su carga, blanquea su destino y setea en false estaEnViaje
	
	private boolean vaciarCarga() {
		return false;
	}
	//elimina los elementos de paquetes
	
	public boolean tieneDestino() {
		return !destino.isEmpty();
	}
	//devuelve si el transporte tiene destino
	
	public void asignarDestino(String destino) {
		this.destino.replace(0, destino.length()-1, destino);
	}
	//setea el valor de destino
	
	private void blanquearDestino() {
		destino.delete(0, destino.length()-1);
	}
	
	
	public boolean getEstaEnViaje() {
		return estaEnViaje;
	}
	
	public boolean tienePaquetesCargados() {
		return false;
	}
	//devuelve si paquetes está vacío

	public String getDestino() {
		// TODO Auto-generated method stub
		return "";
	}

	public boolean getTieneRefrigeracion() {
		// TODO Auto-generated method stub
		return false;
	}

	public double getCapacidad() {
		return capacidad;
	}
	
	//volumen cargado, peso cargado -> atributos o metodos?
}

