package ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.persistencia;

import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.modelo.Disciplina;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface RepositorioDisciplina extends PagingAndSortingRepository<Disciplina, Integer> {
    //metodo de busqueda
    Page<Disciplina> findByNombreIgnoreCaseContainingOrCodigoIgnoreCaseContainingOrDescripcionIgnoreCaseContaining(String nombre, String codigo, String descripcion, Pageable pageable);
}