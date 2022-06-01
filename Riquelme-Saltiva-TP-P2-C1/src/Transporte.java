import java.util.Iterator;
import java.util.LinkedList;

public abstract class Transporte {

	private double cargaMax;
	private double capacidad;
	private boolean tieneRefrigeracion;
	protected double costoKm;
	private LinkedList<Paquete> paquetes; 
	private boolean estaEnViaje;
	private String destino;
	
	public Transporte(double cargaMax, double capacidad, boolean tieneRefrigeracion, double costoKm) {
		this.cargaMax = cargaMax;
		this.capacidad = capacidad;
		this.tieneRefrigeracion = tieneRefrigeracion;
		this.costoKm = costoKm;
		
		paquetes = new LinkedList<Paquete>();
		estaEnViaje = false;
		destino = "";
	}
	
	public boolean cargarMercaderia(Paquete paq) {
		if(tieneEspacioDisponible(paq)) {
			return paquetes.add(paq);
		}
		return false;
	}
	
	protected abstract double obtenerCostoViaje(double distancia);
	
	public void iniciarViaje() {
		estaEnViaje = true;
	}
	
	public void finalizarViaje() {
		estaEnViaje = false;
		blanquearDestino();
		vaciarCarga();
	}
	
	private void vaciarCarga() {
		Iterator<Paquete> iterador = paquetes.iterator();
		while(iterador.hasNext()) {
			iterador.next();
			iterador.remove();
		}
	}
	
	public boolean tieneDestino() {
		return !destino.isEmpty();
	}
	
	public void asignarDestino(String destino) {
		this.destino = destino;
	}
	
	private void blanquearDestino() {
		destino = "";
	}
	
	public boolean tienePaquetesCargados() {
		return !paquetes.isEmpty();
	}

	public boolean estaEnViaje() {
		return estaEnViaje == true;
	}
	
	public String getDestino() {
		return destino.toString();
	}

	public boolean getTieneRefrigeracion() {
		return tieneRefrigeracion;
	}

	private boolean tieneEspacioDisponible(Paquete paq) {
		return capacidad - paq.getVolumen() >= 0;
	}
	
	public boolean equals(Transporte t) {
		return false;
	}
	
	
}

