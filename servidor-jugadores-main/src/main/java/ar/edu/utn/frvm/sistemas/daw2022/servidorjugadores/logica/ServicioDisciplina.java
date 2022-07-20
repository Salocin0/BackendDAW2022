package ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.logica;

import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.modelo.Disciplina;
import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.persistencia.RepositorioDisciplina;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServicioDisciplina {
    private RepositorioDisciplina repositorio;
    
    
    public ServicioDisciplina(RepositorioDisciplina repositorio) {
        this.repositorio = repositorio;
    }

    public Disciplina getDisciplina(Integer id) {
        Optional<Disciplina> rta = this.repositorio.findById(id);
        if (rta.isPresent()) {
            return rta.get();
        }
        return null;
    }

    public Page<Disciplina> paginas(String filtro, String codigo, String descripcion, Pageable pageable){
        return repositorio.findByNombreIgnoreCaseContainingAndCodigoIgnoreCaseContainingAndDescripcionIgnoreCaseContaining(filtro, codigo, descripcion, pageable);
    }

    public Iterable<Disciplina> getDisciplinas(){
        return this.repositorio.findAll();
    }

    public Disciplina guardar(Disciplina f) {
        return this.repositorio.save(f);
    }

    public Disciplina actualizar(Disciplina f) {
        return this.guardar(f);
    }

    public void eliminar(Integer id) {
        this.repositorio.deleteById(id);
    }
}