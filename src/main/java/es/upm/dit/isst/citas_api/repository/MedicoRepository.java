
package es.upm.dit.isst.citas_api.repository;

import org.springframework.data.repository.CrudRepository;

import es.upm.dit.isst.citas_api.model.Medico;

public interface MedicoRepository extends CrudRepository<Medico,String>{
   Medico findByDni(String dni);
   Medico findByNcolegiado(String ncolegiado);
}

