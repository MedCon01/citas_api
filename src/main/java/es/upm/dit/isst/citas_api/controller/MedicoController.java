package es.upm.dit.isst.citas_api.controller;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import es.upm.dit.isst.citas_api.model.Medico;
import es.upm.dit.isst.citas_api.repository.MedicoRepository;

@RestController
public class MedicoController {
    private final MedicoRepository medicoRepository;
    public MedicoController(MedicoRepository m){
        this.medicoRepository = m;
    }
   
@GetMapping("/medicos") // lee todos los medicos 
List<Medico> readAll(){
    return(List<Medico>) medicoRepository.findAll();
}
@PostMapping("/medicos") // crea medico -en cuerpo
ResponseEntity<Medico> create(@RequestBody Medico newMedico) throws URISyntaxException{
    Medico result = medicoRepository.save(newMedico);
    return ResponseEntity.created(new URI("/medicos/" + result.getDni())).body(result);
}
@GetMapping("/medicos/{dni}") // lee el medico con ese dni
ResponseEntity<Medico> read(@PathVariable String dni){
    return medicoRepository.findById(dni).map( medico -> 
    ResponseEntity.ok().body(medico)).orElse(new ResponseEntity<Medico>(HttpStatus.NOT_FOUND));
}


@PutMapping("/medicos/{dni}") // actualiza Medico con ese dni -en cuerpo
ResponseEntity<Medico> update(@RequestBody Medico newMedico, @PathVariable String dni){
    return medicoRepository.findById(dni).map((Medico medico) -> { 
        medico.setDni(newMedico.getDni());
        medico.setNombre(newMedico.getNombre());
        medico.setNColegiado(newMedico.getNColegiado());
        medico.setConsulta(newMedico.getConsulta());
        medico.setEspecialidad(newMedico.getEspecialidad());
        medicoRepository.save(medico);
        return ResponseEntity.ok().body(medico);
        }).orElse(new ResponseEntity<Medico>(HttpStatus.NOT_FOUND));
}
@DeleteMapping("/medicos/{dni}") // borra el medico con ese dni
ResponseEntity<Medico> delete(@PathVariable String dni){
    medicoRepository.deleteById(dni);
    return ResponseEntity.ok().body(null);
}
}
