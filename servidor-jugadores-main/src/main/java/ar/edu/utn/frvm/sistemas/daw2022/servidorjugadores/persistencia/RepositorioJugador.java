package ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.persistencia;

import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.modelo.Jugador;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioJugador extends PagingAndSortingRepository<Jugador, Integer> {
    Page<Jugador> findByNombreIgnoreCaseContainingOrApellidoIgnoreCaseContainingOrTelefonoIgnoreCaseContainingOrEmailIgnoreCaseContainingAndDisciplinaNombreIgnoreCaseContainingAndFacultadNombreIgnoreCaseContainingAndNacionalidadNombreIgnoreCaseContaining(String nombre,String apellido,String telefono,String email, String filtroDisciplina, String filtroFacultad, String filtroNacionalidad,Pageable pageable);
}
