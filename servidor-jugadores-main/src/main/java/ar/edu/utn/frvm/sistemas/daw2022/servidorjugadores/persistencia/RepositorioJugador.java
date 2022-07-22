package ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.persistencia;
import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.modelo.Jugador;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface RepositorioJugador extends PagingAndSortingRepository<Jugador, Integer> {
    //metodo de busqueda
    //Page<Jugador> findByDisciplinaNombreIgnoreCaseContainingOrFacultadNombreIgnoreCaseContainingOrNacionalidadIgnoreCaseContainingOrNombreIgnoreCaseContainingOrApellidoIgnoreCaseContainingOrTelefonoIgnoreCaseContainingOrEmailIgnoreCaseContaining(String filtroDisciplina, String filtroFacultad, String filtroNacionalidad, String nombre, String apellido,String telefono,String email,Pageable pageable);
    Page<Jugador> findByNombreIgnoreCaseContainingOrApellidoIgnoreCaseContainingOrTelefonoIgnoreCaseContainingOrEmailIgnoreCaseContaining(String nombre ,String apellido, String telefono, String email, Pageable pageable);
    
    Page<Jugador> findByFacultadNombreIgnoreCaseContainingAndDisciplinaNombreIgnoreCaseContainingAndNacionalidadIgnoreCaseContaining(String facultadFiltro,String DisciplinaFiltro,String nacionalidadFiltro, Pageable pageable);
    //Page<Jugador> findByDisciplinaNombreAndFacultadNombreAndNacionalidadOrNombreOrApellidoOrTelefonoOrEmail(String filtroDisciplina, String filtroFacultad, String filtroNacionalidad, String nombre, String apellido,String telefono,String email,Pageable pageable);
}