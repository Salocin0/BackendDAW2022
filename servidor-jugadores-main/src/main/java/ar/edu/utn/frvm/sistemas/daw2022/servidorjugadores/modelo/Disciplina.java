package ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.modelo;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
public class Disciplina{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Disciplina_id_seq")
    @SequenceGenerator(name = "Disciplina_id_seq", sequenceName = "Disciplina_id_seq", allocationSize = 1)
    private Integer id;
    @NonNull
    private String nombre;
    @NonNull
    private String codigo;
    @NonNull
    private String descripcion;
}

