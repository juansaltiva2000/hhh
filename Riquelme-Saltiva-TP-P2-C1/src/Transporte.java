import java.util.HashMap;
import java.util.LinkedList;

public abstract class Transporte {

	private double cargaMax;
	private double capacidad;
	private boolean tieneRefrigeracion;
	protected double costoKm;
	private LinkedList<Paquete> paquetes; 
	private boolean estaEnViaje;
	private StringBuilder destino;
	
	public Transporte(double cargaMax, double capacidad, boolean tieneRefrigeracion, double costoKm) {
		this.cargaMax = cargaMax;
		this.capacidad = capacidad;
		this.tieneRefrigeracion = tieneRefrigeracion;
		this.costoKm = costoKm;
		
		paquetes = new LinkedList<Paquete>();
		estaEnViaje = false;
		destino = new StringBuilder();
	}
	
	public boolean cargarMercaderia(Paquete paq) {
		if(tieneEspacioDisponible(paq)) {
			return paquetes.add(paq);
		}
		return false;
	}
	
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
		boolean ret = true;
		for(Paquete p: paquetes) {
			ret = ret && paquetes.remove(p);
		}
		return ret;
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
	public boolean estaEnViaje() {
		return estaEnViaje == true;
	}
	
	public StringBuilder getDestino() {
		return destino;
	}

	public boolean getTieneRefrigeracion() {
		return tieneRefrigeracion;
	}

	public boolean tieneEspacioDisponible(Paquete paq) {
		return paq.getVolumen() - capacidad >= 0;
	}
	
	
	
}

