package ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.logica;
import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.modelo.Disciplina;
import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.persistencia.RepositorioDisciplina;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.Optional;
@Service
public class ServicioDisciplina {
    //atributos
    private RepositorioDisciplina repositorio;
    //constructor
    public ServicioDisciplina(RepositorioDisciplina repositorio) {
        this.repositorio = repositorio;
    }
    //GET por id
    public Disciplina getDisciplina(Integer id) {
        Optional<Disciplina> rta = this.repositorio.findById(id);
        if (rta.isPresent()) {
            return rta.get();
        }
        return null;
    }
    //GET todas + paginacion
    public Page<Disciplina> paginas(String filtro, Pageable pageable){
        return repositorio.findByNombreIgnoreCaseContainingOrCodigoIgnoreCaseContainingOrDescripcionIgnoreCaseContaining(filtro, filtro, filtro, pageable);
    }
    //GET todas
    public Iterable<Disciplina> getDisciplinas(){
        return this.repositorio.findAll();
    }
    //guardar
    public Disciplina guardar(Disciplina f) {
        return this.repositorio.save(f);
    }
    //actualizar
    public Disciplina actualizar(Disciplina f) {
        return this.guardar(f);
    }
    //eliminar
    public void eliminar(Integer id) {
        this.repositorio.deleteById(id);
    }
}