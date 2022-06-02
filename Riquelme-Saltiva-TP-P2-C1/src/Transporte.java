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
	protected double espacioOcupado;
	protected double cargaActual;
	
	public Transporte(double cargaMax, double capacidad, boolean tieneRefrigeracion, double costoKm) {
		this.cargaMax = cargaMax;
		this.capacidad = capacidad;
		this.tieneRefrigeracion = tieneRefrigeracion;
		this.costoKm = costoKm;
		
		paquetesCargados = 0;
		paquetes = new LinkedList<Paquete>();
		estaEnViaje = false;
		destino = "";
		espacioOcupado = 0;
		cargaActual = 0;
	}
	
	public boolean cargarMercaderia(Paquete paq) {
		if(tieneEspacioDisponible(paq)) {
			paquetesCargados++;
			espacioOcupado += paq.getVolumen();
			cargaActual+=paq.getPeso();
			return paquetes.add(paq);
		}
		return false;
	}
	
	public abstract double obtenerCostoViaje(double distancia);
	
	public void iniciarViaje() {
		estaEnViaje = true;
	}
	
	public void finalizarViaje() {
		estaEnViaje = false;
		blanquearDestino();
		vaciarCarga();
	}
	
	private void vaciarCarga() {
		Iterator<Paquete> paquete = paquetes.iterator();
		while(paquete.hasNext()) {
			
			paquete.next();
			paquete.remove();
			paquetesCargados--;	
		}
		cargaActual = 0;
		espacioOcupado = 0;
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
	
	protected boolean tieneLosMismosPaquetes(Transporte t1) {
		boolean tieneLosMismosPaquetes = false;
		LinkedList<Paquete> paquetes1 = this.getPaquetes();
		LinkedList<Paquete> paquetes2 = t1.getPaquetes();


		boolean pasaronTodos = true;
		for(Paquete p1: paquetes1) {
			boolean paso = false;
			for (Paquete p2: paquetes2) {
				if(p1.equals(p2)) {
					paso = true;
					break;
				}
			}

			pasaronTodos = pasaronTodos && paso;
			if (!pasaronTodos) {
				break;
			}
		}
		tieneLosMismosPaquetes = pasaronTodos;
		return tieneLosMismosPaquetes;
	}
	
	@Override
	public boolean equals(Object ob) {
		if(ob == null)
			return false;
		
		if(ob instanceof TrailerComun && this instanceof TrailerComun) {
			TrailerComun tc = (TrailerComun) ob;
			return tc.getDestino().equals(destino) &&
				   tc.cargaActual() == this.cargaActual()
				   && tc.espacioOcupado == this.espacioOcupado
				   && tc.tieneLosMismosPaquetes(this);
				}
		
		if(ob instanceof MegaTrailer && this instanceof MegaTrailer) {
			MegaTrailer mt = (MegaTrailer) ob;
			return mt.getDestino().equals(destino)  &&
				   mt.cargaActual() == this.cargaActual()
				   && mt.espacioOcupado == this.espacioOcupado
				   && mt.tieneLosMismosPaquetes(this);
		}
		
		if(ob instanceof Flete && this instanceof Flete) {
			Flete f = (Flete) ob;
			return f.getDestino().equals(this.destino)&&
				   f.cargaActual == this.cargaActual
				   && f.espacioOcupado == this.espacioOcupado
			       && f.tieneLosMismosPaquetes(this);
		}
		return false;
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

	public double getEspacioOcupado() {
		return espacioOcupado;
	}

	public void setEspacioOcupado(double espacioOcupado) {
		this.espacioOcupado = espacioOcupado;
	}

	public LinkedList<Paquete> getPaquetes() {
		return paquetes;
	}

}

