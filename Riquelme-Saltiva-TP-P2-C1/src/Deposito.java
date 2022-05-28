import java.util.HashMap;
import java.util.LinkedList;

public class Deposito {

	private HashMap<String,LinkedList<Paquete>> paquetes;
	//private LinkedList<Paquete> productos;
	private boolean tieneRefrigeracion;
	
	public Deposito(boolean tieneRefrigeracion) {
		paquetes = new HashMap<>();
		this.tieneRefrigeracion = tieneRefrigeracion;
	}
	
	public boolean agregarPaquete(String destino, Paquete pac) {	
		//paquetes.put(destino, pac);
		return false;
	}
	//dado un paquete, lo agrega a la coleccion
	
	public boolean quitarPaquete(String destino, Paquete pac) {  //se va a tener que instanciar este metodo cuando se agreguen al transporte
		return paquetes.remove(destino, pac);
	}
	//dado un paquete, lo elimina de la coleccion
	
	public double cargarTransporte(String destino, Transporte t) {
		double paquetesCargados = 0; //se va a acumular 
		for(HashMap.Entry<String, LinkedList<Paquete>> paq : paquetes.entrySet()) { //asi se itera dentro de un hashmap?
			if(t.getDestino().equals(paq.getKey())) {
				for(Paquete prod: paq.getValue()) {
					t.cargarMercaderia(paq.getKey(), prod);
					
				}
			}
		}
		return 0;
	}
}
