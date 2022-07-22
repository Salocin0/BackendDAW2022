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
        Page<Jugador> p2 = repositorio.findByNombreIgnoreCaseContainingOrApellidoIgnoreCaseContainingOrTelefonoIgnoreCaseContainingOrEmailIgnoreCaseContaining(filtro,filtro,filtro,filtro,pageable);
        Page<Jugador> p1 = repositorio.findByFacultadNombreIgnoreCaseContainingAndDisciplinaNombreIgnoreCaseContainingAndNacionalidadIgnoreCaseContaining(filtroFacultad,filtroDisciplina,filtroNacionalidad,pageable);
        System.out.println(p1.getContent().size());
        System.out.println(p2.getContent().size());
        try {
            for(int i=0;i<p1.getContent().size();i++){
                if(!p2.getContent().contains(p1.getContent().get(i))){
                    p1.getContent().remove(p1.getContent().get(i));
                }
            }
            return p1;
        } catch (Exception e) {
            for(int i=0;i<p2.getContent().size();i++){
                if(!p1.getContent().contains(p2.getContent().get(i))){
                    p1.getContent().remove(p2.getContent().get(i));
                }
            }
            return p2;
        }
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