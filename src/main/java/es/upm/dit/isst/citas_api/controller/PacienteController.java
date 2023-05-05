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
import es.upm.dit.isst.citas_api.model.Paciente;
import es.upm.dit.isst.citas_api.repository.PacienteRepository;

@RestController
public class PacienteController {
    private final PacienteRepository pacienteRepository;
    public PacienteController(PacienteRepository p){
        this.pacienteRepository = p;
    }
   
@GetMapping("/pacientes") // lee todos los pacientes 
List<Paciente> readAll(){
    return(List<Paciente>) pacienteRepository.findAll();
}
@PostMapping("/pacientes") // crea paciente -en cuerpo
ResponseEntity<Paciente> create(@RequestBody Paciente newPaciente) throws URISyntaxException{
    Paciente result = pacienteRepository.save(newPaciente);
    return ResponseEntity.created(new URI("/pacientes/" + result.getIdpaciente())).body(result);
}
@GetMapping("/pacientes/{idpaciente}") // lee el paciente con ese idpaciente
ResponseEntity<Paciente> read(@PathVariable String idpaciente){
    return pacienteRepository.findById(idpaciente).map( paciente -> 
    ResponseEntity.ok().body(paciente)).orElse(new ResponseEntity<Paciente>(HttpStatus.NOT_FOUND));
}
// @GetMapping("/pacientes/{ntarjeta}") // lee el paciente con ese numero de tarjeta
//Paciente readTarjeta(@PathVariable String ntarjeta){
//    return pacienteRepository.findByNtarjeta(ntarjeta);
// }


@PutMapping("/pacientes/{idpaciente}") // actualiza paciente con ese idpaciente -en cuerpo
ResponseEntity<Paciente> update(@RequestBody Paciente newPaciente, @PathVariable String idpaciente){
    return pacienteRepository.findById(idpaciente).map(paciente -> { 
        paciente.setIdpaciente(newPaciente.getIdpaciente());
        paciente.setDni(newPaciente.getDni());
        paciente.setNombre(newPaciente.getNombre());
        paciente.setFecha_nacimiento(newPaciente.getFecha_nacimiento());
        paciente.setNtarjeta(newPaciente.getNtarjeta());
        paciente.setPresente(newPaciente.getPresente());
        paciente.setLlamado(newPaciente.getLlamado());
        paciente.setConsultallamada(newPaciente.getConsultallamada());
        pacienteRepository.save(paciente);
        return ResponseEntity.ok().body(paciente);
        }).orElse(new ResponseEntity<Paciente>(HttpStatus.NOT_FOUND));
}
@DeleteMapping("/pacientes/{idpaciente}") // borra el paciente con ese idpaciente
ResponseEntity<Paciente> delete(@PathVariable String idpaciente){
    pacienteRepository.deleteById(idpaciente);
    return ResponseEntity.ok().body(null);
}
}

