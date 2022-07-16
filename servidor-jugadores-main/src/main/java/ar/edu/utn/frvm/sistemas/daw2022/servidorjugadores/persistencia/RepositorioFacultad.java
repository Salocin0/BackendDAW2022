package ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.persistencia;

import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.modelo.Facultad;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Sort;

@Repository
public interface RepositorioFacultad extends PagingAndSortingRepository<Facultad, Integer> {

    //Iterable<Facultad> findByNombreIgnoreCaseContaining(String nombre);
    //Iterable<Facultad> findByCodigoIgnoreCaseContaining(String codigo);
    Iterable<Facultad> findByNombreIgnoreCaseContainingAndCodigoIgnoreCaseContainingAndCodigoNumericoIgnoreCaseContaining(String nombre, String codigo, String codigoNumerico);
    Iterable<Facultad> findByNombreIgnoreCaseContainingAndCodigoIgnoreCaseContainingAndCodigoNumericoIgnoreCaseContainingOrderByNombreAsc(String nombre, String codigo, String codigoNumerico);
    Iterable<Facultad> findByNombreIgnoreCaseContainingAndCodigoIgnoreCaseContainingAndCodigoNumericoIgnoreCaseContainingOrderByNombreDesc(String nombre, String codigo, String codigoNumerico);
    Iterable<Facultad> findByNombreIgnoreCaseContainingAndCodigoIgnoreCaseContainingAndCodigoNumericoIgnoreCaseContainingOrderByCodigoAsc(String nombre, String codigo, String codigoNumerico);
    Iterable<Facultad> findByNombreIgnoreCaseContainingAndCodigoIgnoreCaseContainingAndCodigoNumericoIgnoreCaseContainingOrderByCodigoDesc(String nombre, String codigo, String codigoNumerico);
    Iterable<Facultad> findByNombreIgnoreCaseContainingAndCodigoIgnoreCaseContainingAndCodigoNumericoIgnoreCaseContainingOrderByCodigoNumericoAsc(String nombre, String codigo, String codigoNumerico);
    Iterable<Facultad> findByNombreIgnoreCaseContainingAndCodigoIgnoreCaseContainingAndCodigoNumericoIgnoreCaseContainingOrderByCodigoNumericoDesc(String nombre, String codigo, String codigoNumerico);
}
