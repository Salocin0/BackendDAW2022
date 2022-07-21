package ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.modelo;
import lombok.*;
import javax.persistence.*;
import java.util.Date;
@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
public class Jugador {
    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Jugador_id_seq")
    @SequenceGenerator(name = "Jugador_id_seq", sequenceName = "Jugador_id_seq", allocationSize = 1)
    private Integer id;

    @NonNull
    @ManyToOne
    private Facultad facultad;

    @NonNull
    private String nacionalidad;
    
    @ManyToOne
    private Rol rol;
    
    @ManyToOne
    private Disciplina disciplina;

    @NonNull
    private String nombre;

    @NonNull
    private String apellido;

    @NonNull
    private String telefono;

    @NonNull
    private Integer dni;

    @NonNull
    private Integer legajo;

    @NonNull
    private String email;

    @NonNull
    private Date fechaNacimiento;
    
    //get nombre y apellido
    public String getApellidoNombre(){
        return this.apellido+ ", "+this.nombre;
    }
    //get fecha en formato 1
    public String getFechaFormat(){
        return ((this.fechaNacimiento.getDate()+1) +"/"+(this.fechaNacimiento.getMonth()+1)+"/"+(this.fechaNacimiento.getYear()+1900));
    }
    //get fecha en formato 1
    public String getFechaFormat2(){
        return ((this.fechaNacimiento.getYear()+1900)+"-"+(this.fechaNacimiento.getMonth()+1)+"-"+(this.fechaNacimiento.getDate()+1));
    }
    //get nombre de facultad
    public String getFacultadNombrada(){
        return this.facultad.getNombre();
    }
    //get nombre de disciplina
    public String getDisciplinaNombrada(){
        return this.disciplina.getNombre();
    }
}