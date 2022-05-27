import java.util.LinkedList;

public abstract class Transporte {

	private double pesoMax;
	private double volumenMax;
	private boolean tieneRefrigeracion;
	private double costoKm;
	private LinkedList<Paquete> paquetes;
	private boolean estaEnViaje;
	private String destino;
	
	public Transporte(double pesoMax, double volumenMax, boolean tieneRefrigeracion, double costoKm) {
		this.pesoMax = pesoMax;
		this.volumenMax = volumenMax;
		this.tieneRefrigeracion = tieneRefrigeracion;
		this.costoKm = costoKm;
		
		
		paquetes = new LinkedList<Paquete>();
		estaEnViaje = false;
		destino = "";
	}
	
	public double cargarMercaderia(LinkedList<Paquete> mercaderia) {
		return 0;
	}
	//se le pasa como parametro los productos que tiene el deposito y pregunta si tienen el mismo destino que el transporte
	//en caso verdadero, carga aquellos productos que coincidan, en caso falso no hace nada
	
	public abstract double obtenerCostoViaje(double distancia);
	
	public void iniciarViaje() {
		estaEnViaje = false;
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
	//devuelve si paquetes está vacío
	
	//volumen cargado, peso cargado -> atributos o metodos?
}

