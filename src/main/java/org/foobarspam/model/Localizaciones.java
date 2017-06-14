package org.foobarspam.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Localizaciones {
	
	@Id
	private String name;
	
	private double distancia;
	private int tiempo;
	
	public Localizaciones(){
		
	}
	
	public Localizaciones(String nombre, double distancia, int tiempo){
		this.name = nombre;
		this.distancia = distancia;
		this.tiempo = tiempo;
	}
	
	public String getName(){
		return this.name;
	}
	
	public double getDistancia(){
		return this.distancia;
	}
	
	public int getTiempo(){
		return this.tiempo;
	}

}
