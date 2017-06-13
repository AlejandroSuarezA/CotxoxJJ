package org.foobarspam.model;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConductorRepository extends CrudRepository<Conductor, Long> {

		public List<Conductor> findByOcupado(Boolean ocupado);
}
