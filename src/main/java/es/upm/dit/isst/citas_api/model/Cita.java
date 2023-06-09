package es.upm.dit.isst.citas_api.model;

import java.time.LocalDate;
import java.time.LocalTime;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table (name = "Cita")
public class Cita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private LocalDate fecha;
    @Column(nullable = false)
    private LocalTime hora;
    @Column(name = "paciente_id", nullable = false)
    private String pacienteId;
    @Column(name = "medico_dni", nullable = false)
    private String medicoDni;

    public Cita(){}

    // Getter y Setter id
    public Integer getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
    // Getter y Setter fecha
    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    // Getter y Setter hora
    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }
    // Getter y Setter pacienteId
    public String getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(String pacienteId) {
        this.pacienteId = pacienteId;
    }
    // Getter y Setter medicoDni
    public String getMedicoDni() {
        return medicoDni;
    }

    public void setMedicoDni(String medicoDni) {
        this.medicoDni = medicoDni;
    }
    
    // Método toString
    @Override
    public String toString() {
        return "Cita [id=" + id + ", fecha=" + fecha + ", hora=" + hora + ", pacienteId=" + pacienteId + ", medicoDni=" + medicoDni
                + "]";
    }

}

