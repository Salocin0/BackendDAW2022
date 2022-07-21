package ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.logica;
import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.modelo.Rol;
import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.persistencia.RepositorioRol;
import org.springframework.stereotype.Service;
import java.util.Optional;
@Service
public class ServicioRol {
    //atributos
    private RepositorioRol repositorio;
    //constructor
    public ServicioRol(RepositorioRol repositorio) {
        this.repositorio = repositorio;
    }
    //GET por id
    public Rol getRol(Integer id) {
        Optional<Rol> rta = this.repositorio.findById(id);
        if (rta.isPresent()) {
            return rta.get();
        }
        return null;
    }
    //GET todas
    public Iterable<Rol> getRoles(){
        return this.repositorio.findAll();
    }
    //GET todas + filtro
    public Iterable<Rol> getRoles(String filtro){
        return this.repositorio.findByNombreIgnoreCaseContaining(filtro);
    }
    //guardar
    public Rol guardar(Rol f) {
        return this.repositorio.save(f);
    }
    //actualizar
    public Rol actualizar(Rol f) {
        return this.guardar(f);
    }
    //eñiminar
    public void eliminar(Integer id) {
        this.repositorio.deleteById(id);
    }
}