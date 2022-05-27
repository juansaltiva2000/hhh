import java.util.LinkedList;

public class Deposito {

	private LinkedList<Paquete> paquetes;
	private boolean tieneRefrigeracion;
	
	public Deposito(boolean tieneRefrigeracion) {
		paquetes = new LinkedList<Paquete>();
		this.tieneRefrigeracion = tieneRefrigeracion;
	}
	
	public boolean agregarPaquete(Paquete pac) {	
		return paquetes.add(pac);
	}
	//dado un paquete, lo agrega a la coleccion
	
	public boolean quitarPaquete(Paquete pac) {  //se va a tener que instanciar este metodo cuando se agreguen al transporte
		return paquetes.remove(pac);
	}
	//dado un paquete, lo elimina de la coleccion
	
}
