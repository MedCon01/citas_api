
package es.upm.dit.isst.citas_api.repository;

import org.springframework.data.repository.CrudRepository;
import es.upm.dit.isst.citas_api.model.Paciente;

public interface PacienteRepository extends CrudRepository<Paciente, String> {
    // aquí se añadirán las cosas que pueda devolver el repositorio de paciente
    Paciente findByIdpaciente (String idpaciente);
    Paciente findByDni (String dni);
    Paciente findByNtarjeta (String ntarjeta);
    void deleteByIdpaciente(String idpaciente);
}


