//import java.util.LinkedList;
import java.util.HashMap;
import java.util.Iterator;

public class Empresa {

	private HashMap<String, Transporte> transportes;
	private Deposito depositoConRefrig;
	private Deposito depositoSinRefrig;
	private HashMap<String, Integer> destinos;
	
	private String cuit;
	private String nombre;
	private double capacidadDepositos;
	
	public Empresa(String cuit, String nombre, int capacidadDeCadaDeposito) {
		transportes = new HashMap<String, Transporte>();
		
		depositoConRefrig = new Deposito(true);
		depositoSinRefrig = new Deposito(false);
		destinos = new HashMap<String, Integer>();
		
		this.cuit = cuit;
		this.nombre = nombre;
		capacidadDepositos = capacidadDeCadaDeposito;
		
	}
	
	public void agregarDestino(String destino, int km) {
		if(!destinos.containsKey(destino)) {
			destinos.put(destino, km);
		}
		else {
			throw new RuntimeException("Ese destino ya está almacenado");
		}
	} 
	
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
	
	public void asignarDestino(String matricula, String destino) {
		
		if(destinos.containsKey(destino)) {
			transportes.get(matricula).asignarDestino(destino);
		}
		else {
			throw new RuntimeException("El destino no está registrado");
		}
	
	}
	
	public boolean incorporarPaquete(String destino, double peso, double volumen, boolean necesitaFrio) {
		Paquete paq = new Paquete(peso, volumen, necesitaFrio); 

		if(necesitaFrio && tieneEspacioDisponible(depositoConRefrig))
			return depositoConRefrig.agregarPaquete(destino, paq);
		
		else if (!necesitaFrio && tieneEspacioDisponible(depositoSinRefrig))
			return depositoSinRefrig.agregarPaquete(destino, paq);

		else
			throw new RuntimeException("El depósito no tiene espacio disponible para incorporar paquetes");
	}
	

	
	public double cargarTransporte(String matricula) {
		double paquetesCargados = 0;
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
		return paquetesCargados;
	}	
	
	public void iniciarViaje(String matricula) {

		if(transportes.get(matricula).estaEnViaje() || !transportes.get(matricula).tienePaquetesCargados()) {
			throw new RuntimeException("El transporte ya está en viaje,  o no tiene paquetes cargados");
		}
		else {
			transportes.get(matricula).iniciarViaje();
		}			
	}	

	public void finalizarViaje(String matricula) {
		if(transportes.get(matricula).estaEnViaje()) {
			transportes.get(matricula).finalizarViaje();
		}
		else {
			throw new RuntimeException("El camión con esa matrícula no está actualmente en viaje");
		}
	}
	
	public double obtenerCostoViaje(String matricula) {
		if(transportes.get(matricula).estaEnViaje()) {
			String destino = transportes.get(matricula).getDestino();
			return transportes.get(matricula).obtenerCostoViaje(destinos.get(destino));
		}
		else {
			throw new RuntimeException("El camión con esa matrícula no está actualmente en viaje");
		}
	}

	public String obtenerTransporteIgual(String matricula) {
		return "";
	}
	
	public boolean tieneEspacioDisponible(Deposito dep) {
		return capacidadDepositos - dep.capacidadActual() >= 0;
	}
	
	@Override
	public String toString() {
		StringBuilder st = new StringBuilder();
		st.append("Empresa: ");
		st.append(nombre);
		st.append(", CUIT: ");
		st.append(cuit);
		
		return st.toString();
	}
}
