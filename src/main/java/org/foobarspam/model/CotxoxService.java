package org.foobarspam.model;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CotxoxService {
	
	@Autowired
	private ConductorRepository conductoresDb;
	
	
	@PostConstruct
	public void init(){
		conductoresDb.save(new Conductor("Jésus"));
		conductoresDb.save(new Conductor("Yisus"));
		conductoresDb.save(new Conductor("Jebús"));
	}
	
	
	public ConductorRepository getDB(){
		return this.conductoresDb;
	}
	
	public Long getFlotila(){
		return conductoresDb.count();
	}

}
