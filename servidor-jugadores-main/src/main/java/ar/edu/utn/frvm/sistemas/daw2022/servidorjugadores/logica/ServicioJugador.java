package ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.logica;
import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.modelo.Jugador;
import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.persistencia.RepositorioJugador;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.Optional;
@Service
public class ServicioJugador {
    //atributos
    private RepositorioJugador repositorio;
    //costructor
    public ServicioJugador(RepositorioJugador repositorio) {
        this.repositorio = repositorio;
    }
    //Get por id
    public Jugador getJugador(Integer id) {
        Optional<Jugador> rta = this.repositorio.findById(id);
        if (rta.isPresent()) {
            return rta.get();
        }
        return null;
    }
    //GET todas + paginacion
    public Page<Jugador> paginas(String filtro, String filtroDisciplina, String filtroFacultad, String filtroNacionalidad, Pageable pageable){
        return repositorio.findByNombreIgnoreCaseContainingOrApellidoIgnoreCaseContainingOrTelefonoIgnoreCaseContainingOrEmailIgnoreCaseContainingAndDisciplinaNombreIgnoreCaseContainingAndFacultadNombreIgnoreCaseContainingAndNacionalidadIgnoreCaseContaining(filtro, filtro, filtro, filtro, filtroDisciplina, filtroFacultad, filtroNacionalidad, pageable);
    }
    //GET todas
    public Iterable<Jugador> getJugadores(){
        return this.repositorio.findAll();
    }
    //guardar
    public Jugador guardar(Jugador f) {
        return this.repositorio.save(f);
    }
    //actualizar
    public Jugador actualizar(Jugador f) {
        return this.guardar(f);
    }
    //eliminar
    public void eliminar(Integer id) {
        this.repositorio.deleteById(id);
    }
}