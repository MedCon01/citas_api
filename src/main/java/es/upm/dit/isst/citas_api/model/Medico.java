package es.upm.dit.isst.citas_api.model;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Transient;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List; 

@Entity
public class Medico {
    @Id
    private String dni;
    private String nombre;
    private String ncolegiado;
    private int consulta;
    private String especialidad;
    private String password;
    
    public Medico(){}
    
    public Medico(String dni, String nombre, String ncolegiado, int consulta, String especialidad) {
        this.dni = dni;
        this.nombre = nombre;
        this.ncolegiado = ncolegiado;
        this.consulta = consulta;
        this.especialidad = especialidad;
    }

    // Getter y setter de 'dni'
    public String getDni() {
        return dni;
    }
    
    public void setDni(String dni) {
        this.dni = dni;
    }
    
    // Getter y setter de 'nombre'
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    // Getter y setter de 'ncolegiado'
    public String getNColegiado() {
        return ncolegiado;
    }
    
    public void setNColegiado(String ncolegiado) {
        this.ncolegiado = ncolegiado;
    }
    
    // Getter y setter de 'consulta'
    public int getConsulta() {
        return consulta;
    }
    
    public void setConsulta(int consulta) {
        this.consulta = consulta;
    }
    
    // Getter y setter de 'especialidad'
    public String getEspecialidad() {
        return especialidad;
    }
    
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    // Getter y setter de 'password'
    public String getPassword(){
        return this.password;
    }
    public void setPassword(String password){
        this.password = password;
    }
    @Override
    public String toString() {
        return "Medico{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", ncolegiado='" + ncolegiado + '\'' +
                ", consulta=" + consulta +
                ", especialidad='" + especialidad + '\'' +
                '}';
    }
}
