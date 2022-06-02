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
		LinkedList<Paquete> p = paquetes.get(destino);
		return p.remove(paq);
	}

	public double cargarTransporte(Transporte t) {	
		double volumenCargado = 0; 
		Iterator<Paquete> paq = paquetes.get(t.getDestino()).iterator();
		
		while(paq.hasNext()) {
			Paquete p = (Paquete)paq.next();
			t.cargarMercaderia(p);
			volumenCargado += p.getVolumen();
			cargaActual -= p.getVolumen();
			paq.remove();	
		}
		return volumenCargado;
	}
	
	public boolean tieneEspacioDisponible(Paquete paq, double capacidadMax) {
		return capacidadMax - paq.getVolumen() >= 0;
	}
	
}
