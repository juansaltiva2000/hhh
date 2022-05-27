import java.util.LinkedList;
import java.util.HashMap;

public class Empresa {

	private HashMap<String, Transporte> transportes;
	private Deposito depositoConRefrig;
	private Deposito depositoSinRefrig;
	private LinkedList<Viaje> viajes;
	//private HashMap<Integer, Viaje> viajes; //en este caso habria que eliminar cada viaje una vez terminado
	
	public Empresa() {
		transportes = new HashMap<String, Transporte>();
		
		depositoConRefrig = new Deposito(true);
		depositoSinRefrig = new Deposito(false);
	}
	
	public void incorporarPaqueteADeposito(Deposito dep, String destino, double volumen, double peso, 
			boolean necesitaFrio) {
		
		Paquete paq = new Paquete(volumen, peso, necesitaFrio);
		if(necesitaFrio)
			depositoConRefrig.agregarPaquete(destino, paq);
		else
			depositoSinRefrig.agregarPaquete(destino, paq);
	}
	
	public void agregarTrailerComun(String matricula, double pesoMax, double capacidad, boolean tieneRefrigeracion,  
			double costoKm, double segCarga) {
		
		TrailerComun tc = new TrailerComun(pesoMax, capacidad, tieneRefrigeracion, costoKm, segCarga);
		transportes.put(matricula, tc);
	}
	
	public void agregarMegaTrailer(String matricula, double cargaMax, double capacidad, boolean tieneRefrigeracion, 
			double costoKm, double segCarga, double costoFijo, double costoComida) {
	
		MegaTrailer mt = new MegaTrailer(cargaMax, capacidad, tieneRefrigeracion, costoKm, segCarga, costoFijo, costoComida);
		transportes.put(matricula, mt);
	}
	
	public void agregarFlete(String matricula, double cargaMax, double capacidad, boolean tieneRefrigeracion, 
			double costoKm, int cantAcompaniantes, double costoxAcompaniante) {
		
		Flete f = new Flete(cargaMax, capacidad, tieneRefrigeracion, costoKm, cantAcompaniantes, costoxAcompaniante);
		transportes.put(matricula, f);
	}
	
	public void asignarDestinoATransporte(String matricula, String destino, double cantKm) {
		
	}
	
	//recorre la coleccion de transportes, hasta encontrar la key = idTransporte pasado como parametro
	//una vez que lo encuentra, pregunta si esta en viaje
	//si no esta en viaje y la cantKm es valida para ese tipo, le asigna el destino
	//si esta en viaje y/o la cantKm no es valida para ese tipo, lanza una excepcion
	//va a llamar al metodo asignarDestino()
	
	public double cargarTransporteConMercaderia(int idTransporte) {
		return 0;
	}	
	//recorre la coleccion de transportes, hasta encontrar la key = idTransporte pasado como parametro
	//una vez que lo encuentra, pregunta si tiene un destino asignado o si esta en viaje
	//si alguna de esas es true, entonces lanza una excepcion
	//sino, dependiendo del camion (si tiene refrigeracion o no), va hasta el deposito correspondiente
	//y ahi se van a cargar los paquetes con el mismo destino que el camion
	//para cargar los paquetes se va usar el metodo quitarPaquete del Deposito
	
	
	public void iniciarViaje(int idTransporte) {
		
	}	
	//recorre la coleccion de transportes, hasta encontrar la key = idTransporte pasado como parametro
	//dentro del transporte, cambia el valor de estaEnViaje
	//pregunta  getEstaEnViaje(), tieneDestino(), tienePaquetesCargados()
	//si alguna de esas es true, genera una excepcion
	
	public void finalizarViaje(int idTransporte) {
		
	}
	//recorre la coleccion de transportes, hasta encontrar la key = idTransporte pasado como parametro
	//pregunta getEstaEnViaje(), si es false, genera una excepcion
	//sino, dentro del transporte, vacía su carga, blanquea su destino y setea en false estaEnViaje	
	
	
	public double obtenerCostoDeViaje(int idTransporte) {

		return 0;
	}
	//recorre la coleccion de viajes, hasta encontrar el mismo destino --> O(n) + O(1)
	//una vez que la encuentra, de ahi saca la distancia en km
	
	//recorre la coleccion de transportes, hasta encontrar la key = idTransporte pasado como parametro
	//llama al metodo obtenerCostoViaje pasando como argumento el destino que sacamos de viaje

	
}
