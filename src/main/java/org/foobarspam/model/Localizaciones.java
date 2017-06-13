package org.foobarspam.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Localizaciones {
	
	@Id
	private String name;
	
	private Double distancia;
	private Integer tiempo;
	
	public Localizaciones(String nombre, Double distancia, Integer tiempo){
		this.name = nombre;
		this.distancia = distancia;
		this.tiempo = tiempo;
	}
	
	public String getName(){
		return this.name;
	}
	
	public Double getDistancia(){
		return this.distancia;
	}
	
	public Integer getTiempo(){
		return this.tiempo;
	}

}
