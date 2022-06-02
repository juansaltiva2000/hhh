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
	private int paquetesCargados;
	
	public Transporte(double cargaMax, double capacidad, boolean tieneRefrigeracion, double costoKm) {
		this.cargaMax = cargaMax;
		this.capacidad = capacidad;
		this.tieneRefrigeracion = tieneRefrigeracion;
		this.costoKm = costoKm;
		
		paquetesCargados = 0;
		paquetes = new LinkedList<Paquete>();
		estaEnViaje = false;
		destino = "";
	}
	
	public boolean cargarMercaderia(Paquete paq) {
		if(tieneEspacioDisponible(paq)) {
			paquetesCargados++;
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
			paquetesCargados--;
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

	public double cargaActual() {
		double cont = 0;
		for(Paquete paq: paquetes) {
			cont += paq.getPeso();
		}
		return cont;
	}
	
	public double espacioOcupado() {
		double cont = 0;
		for(Paquete paq: paquetes) {
			cont += paq.getVolumen();
		}
		return cont;
	}
	
	public boolean equals(Transporte tr) {
		boolean ret = true; 
		ret = ret && tr.destino.compareTo(this.destino) == 0 
				&& tr.cargaActual() == this.cargaActual() 
				&& tr.espacioOcupado() == this.espacioOcupado()
				&& tr.tieneRefrigeracion == this.tieneRefrigeracion
				&& tr.paquetesCargados == this.paquetesCargados;
		
		for(Paquete paq: tr.paquetes) {
			ret = ret && paq.paqueteEsIgualAOtro(this.paquetes);
		}
		return ret;
	}

	@Override
	public String toString() {
		StringBuilder st = new StringBuilder();
		st.append("Destino: ");
		st.append(destino);
		st.append(", Carga máxima: ");
		st.append(cargaMax);
		st.append(", Capacidad del camión: ");
		st.append(capacidad);
		st.append(", Tiene refrigeración: ");
		st.append(tieneRefrigeracion);
		st.append(", Cantidad de paquetes cargados: ");
		st.append(paquetesCargados);
		
		return st.toString();
	}

	
}

