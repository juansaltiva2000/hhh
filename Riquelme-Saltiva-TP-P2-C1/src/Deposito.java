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
	
	public double cargarTransporte(Transporte t) {
		double paquetesCargados = 0; //se va a acumular 
		
		//itero dentro de la coleccion de paquetes
		for(HashMap.Entry<String, LinkedList<Paquete>> paq : paquetes.entrySet()) { //asi se itera dentro de un hashmap?
			
			//busco los paquetes que tengan el mismo destino que el transporte t
			if(t.getDestino().equals(paq.getKey())) {
				
				//dentro de los paquetes con el mismo destino, cargo cada uno en el transporte
				for(Paquete prod: paq.getValue()) {
					
					if(paquetesCargados<=t.getCapacidad()) {
						paquetesCargados += prod.getVolumen();
						t.cargarMercaderia(paq.getKey(), prod);
						quitarPaquete(paq.getKey(), prod);
					}
				}
			}
		}
		return paquetesCargados;
	}
}
