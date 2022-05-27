import java.util.LinkedList;
import java.util.HashMap;

public class Empresa {

	private HashMap<Integer, Transporte> transportes;
	private Deposito depositoConRefrig;
	private Deposito depositoSinRefrig;
	private LinkedList<Viaje> viajes;
	//private HashMap<Integer, Viaje> viajes; //en este caso habria que eliminar cada viaje una vez terminado
	
	public Empresa() {
		transportes = new HashMap<Integer, Transporte>();
		
		depositoConRefrig = new Deposito(true);
		depositoSinRefrig = new Deposito(false);
	}
	
	//va a instanciar a los objetos deposito
	//crea una coleccion (vacia) de transportes
	
	public boolean incorporarPaqueteADeposito(Deposito dep, double volumen, double peso, boolean necesitaFrio) {
		return false;
	}
	//crea un paquete -> usa el constructor de paquete
	
	public boolean agregarUnTransporte(int idTransporte, double pesoMax, double volumenMax, boolean tieneRefrig, String tipo) {
		return false;
		/* en este metodo en algun momento vamos a tener que pedirle al usuario que ingrese los datos
		 * referentes al tipo (seguro de carga, costofijo, acompañantes, etc) porque despues para crear
		 * un transporte de determinado tipo vamos a necesitar esos datos
		 *  */
	}
	
	//teniendo en cuenta el tipo pasado como parametro, se le va a pedir al usuario los datos faltantes para crear
	//un objeto de tipo trailercomun, megatrailer o flete (se van a usar sus constructores)
	
	public void asignarDestinoATransporte(int idTransporte, String destino, double cantKm) {
		
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
