package ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.persistencia;
import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.modelo.Facultad;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
@Repository
public interface RepositorioFacultad extends PagingAndSortingRepository<Facultad, Integer> {
    //metodo de busqueda
    Page<Facultad> findByNombreIgnoreCaseContainingOrCodigoIgnoreCaseContainingOrCodigoNumericoIgnoreCaseContaining(String nombre, String codigo, String codigoNumerico, Pageable pageable);
}