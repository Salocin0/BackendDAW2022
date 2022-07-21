package ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.logica;
import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.modelo.Facultad;
import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.persistencia.RepositorioFacultad;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.Optional;
@Service
public class ServicioFacultad {
    //atributos
    private RepositorioFacultad repositorio;
    //constructor
    public ServicioFacultad(RepositorioFacultad repositorio) {
        this.repositorio = repositorio;
    }
    //GET todas + paginacion
    public Page<Facultad> paginas(String filtro, Pageable pageable){
        return repositorio.findByNombreIgnoreCaseContainingOrCodigoIgnoreCaseContainingOrCodigoNumericoIgnoreCaseContaining(filtro, filtro, filtro, pageable);
    }
    //GET por id
    public Facultad getFacultad(Integer id) {
        Optional<Facultad> rta = this.repositorio.findById(id);
        if (rta.isPresent()) {
            return rta.get();
        }
        return null;
    }
    //GET todas
    public Iterable<Facultad> getFacultades(){
        return this.repositorio.findAll();
    }
    //guardar
    public Facultad guardar(Facultad f) {
        return this.repositorio.save(f);
    }
    //actualizar
    public Facultad actualizar(Facultad f) {
        return this.guardar(f);
    }
    //eliminar
    public void eliminar(Integer id) {
        this.repositorio.deleteById(id);
    }
}