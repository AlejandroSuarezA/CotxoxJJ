package org.foobarspam.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Carrera {
	//Attributes
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long Id = null;
	
	private String tarjetaCredito = "No se ha insertado tarjeta";
	private String origen = "punto de origen";
	private String destino = "punto de destino";
	
	private Double distancia = 0.0;
	private Integer tiempoEsperadoMinutos = 0;
	
	@OneToOne
	private Conductor conductor = null;
	
	private double costeTotal = 0.00;
	private int propina = 0;
	
	
	//Constructor
	
	public Carrera(String tarjetaCredito){
		this.tarjetaCredito = tarjetaCredito;
		
	}
	
	//Sets & Gets
	
	public void setOrigen(String origen){
		this.origen = origen;
	}
	
	public void setDestino(String destino){
		this.destino = destino;
	}
	
	public void setDistancia(double distancia){
		this.distancia = distancia;
	}
	
	public void setTiempoEsperado(int tiempoEsperado){
		this.tiempoEsperadoMinutos = tiempoEsperado;
	}
	
	public String getOrigen(){
		return this.origen;
	}
	
	public String getDestino(){
		return this.destino;
	}
	
	public String getTarjetaCredito(){
		return this.tarjetaCredito;
	}
	
	public double getDistancia(){
		return this.distancia;
	}
	
	public double getTiempoEsperado(){
		return this.tiempoEsperadoMinutos;
	}
	
	//Calculate price
	
	public double getCosteEsperado(){
		
		double distancia = this.getDistancia();
		double tiempo = this.getTiempoEsperado();
		
		return Tarifa.getCosteTotalEsperado(tiempo, distancia);
		
	}
	
	//Driver assignment
	
	public Conductor getConductor(){
		return this.conductor;
	}
	
	public String getNombre(){
		return this.conductor.getNombre();
	}
	
	public String getModelo(){
		return this.conductor.getModelo();
	}
	
	public String getValoracion(){
		Double valoracion = this.conductor.getValoracionMedia();
		return valoracion.toString();
	}
	
	public String getCareto(){
		return this.conductor.getCareto();
	}
	
	public void setConductor(Conductor conductor){
		this.conductor = conductor;
	}
	
	/*public void asignarConductor(PoolConductores pool){
		this.setConductor(pool.asignarConductor());
		
	}*/
	
	//Pay & Tip
	public void realizarPago(double precio){
		this.costeTotal = precio;
	}
	
	public Double getCosteTotal(){
		return this.costeTotal;
	}
	
	public void recibirPropina(int propina){
		this.propina = propina;
	}
	
	public int getPropina(){
		return this.propina;
	}
	
	//Driver again available
	public void liberarConductor(){
		this.conductor.liberar();
	}

}
