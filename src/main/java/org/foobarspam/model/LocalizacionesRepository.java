package org.foobarspam.model;

import org.springframework.data.repository.CrudRepository;

public interface LocalizacionesRepository extends CrudRepository<Localizaciones, String> {

	public Localizaciones findByName(String nombre);
	
}
