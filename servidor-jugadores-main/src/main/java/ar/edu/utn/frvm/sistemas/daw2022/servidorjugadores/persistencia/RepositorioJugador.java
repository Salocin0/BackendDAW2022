package ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.persistencia;

import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.modelo.Disciplina;
import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.modelo.Facultad;
import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.modelo.Jugador;
import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.modelo.Nacionalidad;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioJugador extends PagingAndSortingRepository<Jugador, Integer> {
    //Iterable<Jugador> findByNombre(String nombre);
    //Iterable<Jugador> findByNombreIgnoreCase(String nombre);
    //Iterable<Jugador> findByNombreContaining(String nombre);
    //Iterable<Jugador> findByNombreIgnoreCaseContaining(String nombre);
    //Iterable<Jugador> findByNombreIgnoreCaseConstraining(String filtro, String disciplina, String facultad, String nacionalidad);
    //Iterable<Jugador> findByDisciplinaIgnoreCaseConstraining(String filtro, String disciplina, String facultad, String nacionalidad);
    //Iterable<Jugador> findByFacultadadIgnoreCaseConstraining(String filtro, String disciplina, String facultad, String nacionalidad);
    //Iterable<Jugador> findByNacionalidadIgnoreCaseConstraining(String filtro, String disciplina, String facultad, String nacionalidad);
    Iterable<Jugador> findByNombreAndDisciplinaAndFacultadAndNacionalidad(String nombre, Disciplina disciplina, Facultad facultad, Nacionalidad nacionalidad);
}
