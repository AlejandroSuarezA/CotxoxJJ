package org.foobarspam.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConductorRepository extends CrudRepository<Conductor, Long> {

}
