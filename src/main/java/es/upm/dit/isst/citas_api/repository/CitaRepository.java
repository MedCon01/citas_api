package es.upm.dit.isst.citas_api.repository;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import es.upm.dit.isst.citas_api.model.Cita;

public interface CitaRepository extends CrudRepository<Cita,Integer> {
    List<Cita>  findByPacienteId(String pacienteId);
    List<Cita>  findByMedicoDni(String medicoDni);
    // List<Cita> findAllByMedicoDni(String medicoDni);
    // List<Cita> findAllByPacienteId(String pacienteId);
    Cita findByHora(int hora);

}
