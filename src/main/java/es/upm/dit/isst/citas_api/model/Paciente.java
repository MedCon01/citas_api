package es.upm.dit.isst.citas_api.model;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Paciente {
    
    @Id
    private String idpaciente;
    private String dni;
    private String nombre;
    private LocalDate fecha_nacimiento;
    private String ntarjeta;
    private Boolean presente;
    private boolean llamado;
    
    // Constructor sin argumentos
    public Paciente() {
    }
    
    // Constructor con argumentos
    public Paciente(String idpaciente, String dni, String nombre, LocalDate fecha_nacimiento, String ntarjeta,
                    Boolean presente, Boolean llamado) {
        this.idpaciente = idpaciente;
        this.dni = dni;
        this.nombre = nombre;
        this.fecha_nacimiento = fecha_nacimiento;
        this.ntarjeta = ntarjeta;
        this.presente = presente;
        this.llamado = llamado;
    }
    
    // Getter y setter idpaciente
    public String getIdpaciente() {
        return idpaciente;
    }

    public void setIdpaciente(String idpaciente) {
        this.idpaciente = idpaciente;
    }
    // Getter y setter dni
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
    // Getter y setter nombre
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    // Getter y setter fecha_nacimiento
    public LocalDate getFecha_nacimiento() {
        return fecha_nacimiento;
    }
    
    public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }
    // Getter y setter ntarjeta
    public String getNtarjeta() {
        return ntarjeta;
    }

    public void setNtarjeta(String ntarjeta) {
        this.ntarjeta = ntarjeta;
    }
    
    // Getter y setter presente
    public Boolean getPresente(){
        return this.presente;
    }
    public void setPresente(boolean presente){
        this.presente = presente;
    }
    // Getter y setter idpaciente
    public Boolean getLlamado() {
        return this.llamado;
    }

    public void setLlamado(boolean llamado) {
        this.llamado = llamado;
    }
    // Método toString
    @Override
    public String toString() {
        return "Paciente{" +
                "idpaciente='" + idpaciente + '\'' +
                ", dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", fecha_nacimiento=" + fecha_nacimiento +
                ", ntarjeta='" + ntarjeta + '\'' +
                ", presente=" + presente +
                ", llamado=" + llamado +
                '}';
    }
    
}