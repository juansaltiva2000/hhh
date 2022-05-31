import java.util.HashMap;
import java.util.LinkedList;

public class Deposito {

	private HashMap<String,LinkedList<Paquete>> paquetes;
	private boolean tieneRefrigeracion;
	double capacidadActual;
	
	public Deposito(boolean tieneRefrigeracion) {
		paquetes = new HashMap<>();
		this.tieneRefrigeracion = tieneRefrigeracion;
	}
	
	public boolean agregarPaquete(String destino, Paquete paq) {	
		boolean ret = true; 
		if(paquetes.containsKey(destino)) {
			ret = ret && paquetes.get(destino).add(paq);
			capacidadActual -= paq.getVolumen();
		}
		else {
			paquetes.put(destino, new LinkedList<Paquete>());
			ret = ret && paquetes.get(destino).add(paq);
			capacidadActual -= paq.getVolumen();
		}
		return ret;
	}


	public boolean quitarPaquete(String destino, Paquete pac) {  //se va a tener que instanciar este metodo cuando se agreguen al transporte
		capacidadActual -= pac.getVolumen();
		return paquetes.remove(destino, pac);
	}

	public double cargarTransporte(Transporte t) {	
		double paquetesCargados = 0;  
		
		for(Paquete paq: paquetes.get(t.getDestino())) { //hay un problema con stringbuilder
			t.cargarMercaderia(paq);
			paquetesCargados += paq.getVolumen();
		}
		return paquetesCargados;
	}
	
	public double capacidadActual() {
		return capacidadActual;
	}
	
}
