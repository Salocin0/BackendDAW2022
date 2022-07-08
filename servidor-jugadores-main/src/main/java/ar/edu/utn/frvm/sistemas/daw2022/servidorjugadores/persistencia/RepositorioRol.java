package ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.persistencia;

import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.modelo.Rol;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioRol extends CrudRepository<Rol, Integer> {

    Iterable<Rol> findByNombre(String nombre);
    Iterable<Rol> findByNombreIgnoreCase(String nombre);
    Iterable<Rol> findByNombreContaining(String nombre);
    Iterable<Rol> findByNombreIgnoreCaseContaining(String nombre);

}