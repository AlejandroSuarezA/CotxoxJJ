package org.foobarspam.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CotxoxService {
	
	@Autowired
	private ConductorRepository conductoresDb;
	
	@Autowired
	private CarreraRepository carreraDb;
	
	@Autowired
	private LocalizacionesRepository sitios;
	
	@PostConstruct
	public void init(){
		conductoresDb.save(new Conductor("Jésus"));
		conductoresDb.save(new Conductor("Yisus"));
		conductoresDb.save(new Conductor("Jebús"));
		conductoresDb.save(new Conductor("Super Jesus"));
		
		sitios.save(new Localizaciones("Magaluf", 5.0 , 25));
		sitios.save(new Localizaciones("La Catedral", 15.0 , 5));
		sitios.save(new Localizaciones("Aeropuerto", 25.0 , 15));
		sitios.save(new Localizaciones("Mordor", 40.0 , 50));

	}
	
	
	public ConductorRepository getDB(){
		return this.conductoresDb;
	}
	
	public Long getFlotila(){
		return conductoresDb.count();
	}
	
	public void addCarrera(Carrera carrera){
		this.carreraDb.save(carrera);
	}
	
	public Conductor getADriver(){
		List<Conductor> disponibles = this.conductoresDb.findByOcupado(false);
		
		Conductor random = disponibles.get(new Random().nextInt(disponibles.size()));
		
		return random;
	}
	
	public Localizaciones getMapa(String sitio){
		return sitios.findByName(sitio);
	}

}
