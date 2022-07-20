package ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.logica;

import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.modelo.Jugador;
import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.persistencia.RepositorioJugador;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServicioJugador {
    private RepositorioJugador repositorio;

    public ServicioJugador(RepositorioJugador repositorio) {
        this.repositorio = repositorio;
    }

    public Jugador getJugador(Integer id) {
        Optional<Jugador> rta = this.repositorio.findById(id);
        if (rta.isPresent()) {
            return rta.get();
        }
        return null;
    }

    public Page<Jugador> paginas(String filtro, String filtroDisciplina, String filtroFacultad, String filtroNacionalidad, Pageable pageable){
        return repositorio.findByNombreIgnoreCaseContainingOrApellidoIgnoreCaseContainingOrTelefonoIgnoreCaseContainingOrEmailIgnoreCaseContainingAndDisciplinaNombreIgnoreCaseContainingAndFacultadNombreIgnoreCaseContainingAndNacionalidadNombreIgnoreCaseContaining(filtro, filtro, filtro, filtro, filtroDisciplina, filtroFacultad, filtroNacionalidad, pageable);
    }

    public Iterable<Jugador> getJugadores(){
        return this.repositorio.findAll();
    }

    public Jugador guardar(Jugador f) {
        return this.repositorio.save(f);
    }

    public Jugador actualizar(Jugador f) {
        return this.guardar(f);
    }

    public void eliminar(Integer id) {
        this.repositorio.deleteById(id);
    }
}
