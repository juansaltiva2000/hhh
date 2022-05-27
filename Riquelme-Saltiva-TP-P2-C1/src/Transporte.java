import java.util.HashMap;
import java.util.LinkedList;

public abstract class Transporte {

	private double cargaMax;
	private double capacidad;
	private boolean tieneRefrigeracion;
	private double costoKm;
	private HashMap<String,LinkedList<Paquete>> paquetes;
	private boolean estaEnViaje;
	private String destino;
	
	public Transporte(double cargaMax, double capacidad, boolean tieneRefrigeracion, double costoKm) {
		this.cargaMax = cargaMax;
		this.capacidad = capacidad;
		this.tieneRefrigeracion = tieneRefrigeracion;
		this.costoKm = costoKm;
		
		
		paquetes = new HashMap<String,LinkedList<Paquete>>();
		estaEnViaje = false;
		destino = "";
	}
	
	public double cargarMercaderia(Deposito dep) {
		return 0;
	}
	//se le pasa como parametro los productos que tiene el deposito y pregunta si tienen el mismo destino que el transporte
	//en caso verdadero, carga aquellos productos que coincidan, en caso falso no hace nada
	
	protected abstract double obtenerCostoViaje(double distancia);
	
	public void iniciarViaje() {
		estaEnViaje = false;
	}
	//setea en true el atributo estaEnViaje
	
	public boolean finalizarViaje() {
		return false;
	}
	//vac�a su carga, blanquea su destino y setea en false estaEnViaje
	
	private boolean vaciarCarga() {
		return false;
	}
	//elimina los elementos de paquetes
	
	private boolean tieneDestino() {
		return destino!="";
	}
	//devuelve si el transporte tiene destino
	
	private void asignarDestino(String destino) {
		this.destino = destino;
	}
	//setea el valor de destino
	
	private void blanquearDestino() {
		destino = "";
	}
	
	
	public boolean getEstaEnViaje() {
		return estaEnViaje;
	}
	
	public boolean tienePaquetesCargados() {
		return false;
	}
	//devuelve si paquetes est� vac�o
	
	//volumen cargado, peso cargado -> atributos o metodos?
}

