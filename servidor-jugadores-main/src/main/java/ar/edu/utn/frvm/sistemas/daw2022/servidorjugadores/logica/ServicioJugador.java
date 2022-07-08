package ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.logica;

import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.modelo.Jugador;
import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.persistencia.RepositorioJugador;
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

    public Iterable<Jugador> getJugadores(){
        return this.repositorio.findAll();
    }

    public Iterable<Jugador> getJugadores(String filtro){
        return this.repositorio.findByNombreIgnoreCaseContaining(filtro);
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
