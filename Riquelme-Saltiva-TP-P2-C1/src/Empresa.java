//import java.util.LinkedList;
import java.util.HashMap;
import java.util.Iterator;

public class Empresa {

	private HashMap<String, Transporte> transportes;
	private Deposito depositoConRefrig;
	private Deposito depositoSinRefrig;
	private double capacidadDepositos;
	private HashMap<String, Integer> destinos;
	
	public Empresa(String cuit, String nombre, int capacidadDeCadaDeposito) {
		transportes = new HashMap<String, Transporte>();
		
		depositoConRefrig = new Deposito(true);
		depositoSinRefrig = new Deposito(false);
		capacidadDepositos = capacidadDeCadaDeposito;
	}
	
	// Incorpora un nuevo destino y su distancia en km.
	// Es requisito previo, para poder asignar un destino a un transporte.
	// Si ya existe el destino se debe generar una excepción.
	public void agregarDestino(String destino, double km) {
		
	} 
	
	// Los siguientes métodos agregan los tres tipos de transportes a la
	// empresa, cada uno con sus atributos correspondientes.
	// La matrícula funciona como identificador del transporte.
	public void agregarTrailer(String matricula, double pesoMax, double capacidad, boolean tieneRefrigeracion,  
			double costoKm, double segCarga) {
		
		TrailerComun tc = new TrailerComun(pesoMax, capacidad, tieneRefrigeracion, costoKm, segCarga);
		transportes.put(matricula, tc);
	}
	
	public void agregarMegaTrailer(String matricula, double cargaMax, double capacidad, boolean tieneRefrigeracion, 
			double costoKm, double segCarga, double costoFijo, double costoComida) {
	
		MegaTrailer mt = new MegaTrailer(cargaMax, capacidad, tieneRefrigeracion, costoKm, segCarga, costoFijo, costoComida);
		transportes.put(matricula, mt);
	}
	
	public void agregarFlete(String matricula, double cargaMax, double capacidad, 
			double costoKm, int cantAcompaniantes, double costoxAcompaniante) {
		
		Flete f = new Flete(cargaMax, capacidad,  costoKm, cantAcompaniantes, costoxAcompaniante);
		transportes.put(matricula, f);
	}
	
	// Se asigna un destino a un transporte dada su matrícula (el destino
	// debe haber sido agregado previamente, con el método agregarDestino).
	// Si el destino no está registrado, se debe generar una excepción.
	public void asignarDestino(String matricula, String destino) {
		
		for(HashMap.Entry<String, Transporte> t: transportes.entrySet()) {
			if(t.getKey().equals(matricula)) {
				t.getValue().asignarDestino(destino);
			}
		}
		
	
	}
	
	/* Se incorpora un paquete a algún depósito de la empresa.
	// Devuelve verdadero si se pudo incorporar, es decir,
	// si el depósito acorde al paquete tiene suficiente espacio disponible. */
	public boolean incorporarPaquete(String destino, double peso, double volumen, boolean necesitaFrio) {
		
		//falta contemplar la capacidad de los depositos
		Paquete paq = new Paquete(peso, volumen, necesitaFrio); //fn aux hayEspacioParaElPaquete
	
		if(necesitaFrio)
			return depositoConRefrig.agregarPaquete(destino, paq);
		else
			return depositoSinRefrig.agregarPaquete(destino, paq);
	}
	
	
	/* Dado un ID de un transporte se pide cargarlo con toda la mercadería
	// posible, de acuerdo al destino del transporte. No se debe permitir
	// la carga si está en viaje o si no tiene asignado un destino.
	// Utilizar el depósito acorde para cargarlo.
	// Devuelve un double con el volumen de los paquetes subidos
	 al transporte.
	*/
	
	public double cargarTransporte(String matricula) {
		double paquetesCargados = 0;
			if(transportes.containsKey(matricula)) {
				if(!transportes.get(matricula).estaEnViaje() && !transportes.get(matricula).tienePaquetesCargados()) { 
					if(transportes.get(matricula).getTieneRefrigeracion()) {
						paquetesCargados += depositoConRefrig.cargarTransporte(transportes.get(matricula));
					}	
					else {
						paquetesCargados += depositoSinRefrig.cargarTransporte(transportes.get(matricula));
					}
				}
				else {
					throw new RuntimeException("El camión ya está en viaje y/o no tiene un destino asignado");
				}
		}
			else {
				throw new RuntimeException("No existe un camión con esa matrícula en la empresa");
			}
		return paquetesCargados;
	}

	
	/*recorre la coleccion de transportes, hasta encontrar la key = idTransporte pasado como parametro
	//una vez que lo encuentra, pregunta si esta en viaje
	//si no esta en viaje y la cantKm es valida para ese tipo, le asigna el destino
	//si esta en viaje y/o la cantKm no es valida para ese tipo, lanza una excepcion
	//va a llamar al metodo asignarDestino()
	

	//recorre la coleccion de transportes, hasta encontrar la key = idTransporte pasado como parametro
	//una vez que lo encuentra, pregunta si tiene un destino asignado o si esta en viaje
	//si alguna de esas es true, entonces lanza una excepcion
	//sino, dependiendo del camion (si tiene refrigeracion o no), va hasta el deposito correspondiente
	//y ahi se van a cargar los paquetes con el mismo destino que el camion
	//para cargar los paquetes se va usar el metodo quitarPaquete del Deposito*/
	
	
	public void iniciarViaje(String matricula) {
		
		if(transportes.containsKey(matricula)) {
			if(transportes.get(matricula).estaEnViaje() || !transportes.get(matricula).tienePaquetesCargados()) {
				throw new RuntimeException("El transporte ya está en viaje,  o no tiene paquetes cargados");
			}
			else {
				transportes.get(matricula).iniciarViaje();
			}
		}
		else {
			throw new RuntimeException("No existe un camión con esa matrícula en la empresa");
		}
		
		
	}	
	
	public void finalizarViaje(String matricula) {
		
	}
	
	public double obtenerCostoViaje(String matricula) {
		if(transportes.get(matricula).estaEnViaje()) {
			//transportes.get(matricula).obtenerCostoViaje();
		}
		return 0;
	}


	public String obtenerTransporteIgual(String matricula) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/*recorre la coleccion de transportes, hasta encontrar la key = idTransporte pasado como parametro
	//llama al metodo obtenerCostoViaje pasando como argumento el destino que sacamos de viaje*/

	
	@Override
	public String toString() {
		return "";
	}
}
