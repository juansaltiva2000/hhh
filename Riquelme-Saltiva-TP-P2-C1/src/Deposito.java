import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class Deposito {

	private HashMap<String,LinkedList<Paquete>> paquetes;
	private boolean tieneRefrigeracion;
	double cargaActual;
	
	public Deposito(boolean tieneRefrigeracion) {
		paquetes = new HashMap<>();
		this.tieneRefrigeracion = tieneRefrigeracion;
	}
	
	public boolean agregarPaquete(String destino, Paquete paq, double capacidadMax) {	
		boolean ret = true; 
		if(tieneEspacioDisponible(paq, capacidadMax)) {
			if(paquetes.containsKey(destino)) {
				ret = ret && paquetes.get(destino).add(paq);
				cargaActual += paq.getVolumen();
			}
			else {
				paquetes.put(destino, new LinkedList<Paquete>());
				ret = ret && paquetes.get(destino).add(paq);
				cargaActual += paq.getVolumen();
			}
		}
		else {
			return false;
		}
		return ret;
	}

	public boolean quitarPaquete(String destino, Paquete paq) {  
		cargaActual -= paq.getVolumen();
		return paquetes.remove(destino, paq);
	}

	public double cargarTransporte(Transporte t) {	
		double paquetesCargados = 0;  
		
		for(Paquete paq: paquetes.get(t.getDestino())) { 
			t.cargarMercaderia(paq);
			paquetesCargados += paq.getVolumen();
		}
		return paquetesCargados;
	}
	
	public double cargaActual() {
		return cargaActual;
	}
	
	public boolean tieneEspacioDisponible(Paquete paq, double capacidadMax) {
		return capacidadMax - paq.getVolumen() >= 0;
	}
	
}
