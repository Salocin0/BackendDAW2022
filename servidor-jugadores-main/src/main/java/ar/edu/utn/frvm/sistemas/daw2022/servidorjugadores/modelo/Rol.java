package ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.modelo;
import lombok.*;
import javax.persistence.*;
@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
public class Rol {
    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Rol_id_seq")
    @SequenceGenerator(name = "Rol_id_seq", sequenceName = "Rol_id_seq", allocationSize = 1)
    private Integer id;
    @NonNull
    private String nombre;
    @NonNull
    private String codigo;
    @NonNull
    private String descripcion;
}