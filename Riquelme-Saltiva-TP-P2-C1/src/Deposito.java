import java.util.HashMap;
import java.util.LinkedList;

public class Deposito {

	private HashMap<String,LinkedList<Paquete>> paquetes;
	private boolean tieneRefrigeracion;
	
	public Deposito(boolean tieneRefrigeracion) {
		paquetes = new HashMap<>();
		this.tieneRefrigeracion = tieneRefrigeracion;
	}
	
	public boolean agregarPaquete(String destino, Paquete pac) {	
		return paquetes.put(destino, pac);
	}
	//dado un paquete, lo agrega a la coleccion
	
	public boolean quitarPaquete(String destino, Paquete pac) {  //se va a tener que instanciar este metodo cuando se agreguen al transporte
		return paquetes.remove(destino, pac);
	}
	//dado un paquete, lo elimina de la coleccion
	
	public void cargarPaquetesEnTransporte() {
		
	}
}
