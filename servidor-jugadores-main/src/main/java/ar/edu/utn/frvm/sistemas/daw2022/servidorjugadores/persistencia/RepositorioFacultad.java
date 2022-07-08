package ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.persistencia;

import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.modelo.Facultad;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioFacultad extends PagingAndSortingRepository<Facultad, Integer> {
    Iterable<Facultad> findByNombre(String nombre);
    Iterable<Facultad> findByNombreIgnoreCase(String nombre);
    Iterable<Facultad> findByNombreContaining(String nombre);
    Iterable<Facultad> findByNombreIgnoreCaseContaining(String nombre);

}
