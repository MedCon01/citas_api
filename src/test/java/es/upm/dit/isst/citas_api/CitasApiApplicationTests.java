package es.upm.dit.isst.citas_api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import es.upm.dit.isst.citas_api.repository.*;
import es.upm.dit.isst.citas_api.model.*;


@SpringBootTest
class CitasApiApplicationTests {
	
	@Autowired
	private CitaRepository citaRepository;
	@Autowired
	private MedicoRepository medicoRepository;
	@Autowired
	private PacienteRepository pacienteRepository;
	LocalDate fechaTest = LocalDate.of(2023, 5, 9);
	LocalTime horaTest = LocalTime.of(12,00,00);

	@Test
	void testCita() {
		Cita citatest = new Cita();
		// Crear cita para el 9/05/2023 a las 12.00h de AGI493 con medico 11111111A
		citatest.setFecha(fechaTest);
		citatest.setHora(horaTest);
		citatest.setMedicoDni("11111111A");
		citatest.setPacienteId("AGI493");
		citaRepository.save(citatest);
		// Comprobar que la cita creada es correcta
		Optional<Cita> cita = citaRepository.findById(citatest.getId());
        assertEquals(cita.get().getFecha(), fechaTest);
        assertEquals(cita.get().getHora(), horaTest);
		assertEquals(cita.get().getMedicoDni(), "11111111A");
        assertEquals(cita.get().getPacienteId(), "AGI493");
		citaRepository.delete(citatest);
	}

	@Test
	void testMedico(){
		Medico medicotest = new Medico();
		// Crear medico test
		medicotest.setDni("00000000M");
		medicotest.setNombre("Juan Pérez López");
		medicotest.setNColegiado("000000000000");
		medicotest.setConsulta(001);
		medicotest.setEspecialidad("Pruebas");
		medicoRepository.save(medicotest);
		// Comprobar que el medico creado es correcto 
		Optional<Medico> medico = medicoRepository.findById("00000000M"); 
		assertEquals(medico.get().getDni(),"00000000M");
		assertEquals(medico.get().getNombre(),"Juan Pérez López");
		assertEquals(medico.get().getNColegiado(),"000000000000");
		assertEquals(medico.get().getConsulta(),001);
		assertEquals(medico.get().getEspecialidad(),"Pruebas");
		medicoRepository.delete(medicotest);
	}

	@Test 
	void testPaciente(){
		Paciente pacientetest = new Paciente();
		// Crear paciente test
		pacientetest.setDni("00000000P");
		pacientetest.setNombre("María García Sánchez");
		pacientetest.setFecha_nacimiento(fechaTest);
		pacientetest.setIdpaciente("MGS359");
		pacientetest.setNtarjeta("000000000000");
		pacientetest.setPresente(false);
		pacienteRepository.save(pacientetest);
		// Comprobar que el paciente creado es correcto 
		Optional<Paciente> paciente = pacienteRepository.findById("MGS359"); 
		assertEquals(paciente.get().getDni(),"00000000P");
		assertEquals(paciente.get().getNombre(),"María García Sánchez");
		assertEquals(paciente.get().getFecha_nacimiento(),fechaTest);
		assertEquals(paciente.get().getNtarjeta(),"000000000000");
		assertFalse(paciente.get().getPresente());
		assertEquals(paciente.get().getConsultallamada(),0);
		pacienteRepository.delete(pacientetest);
	}
}
