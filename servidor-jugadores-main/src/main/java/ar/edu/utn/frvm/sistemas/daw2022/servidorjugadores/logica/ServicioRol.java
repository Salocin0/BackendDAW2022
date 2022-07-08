package ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.logica;

import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.modelo.Rol;
import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.persistencia.RepositorioRol;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServicioRol {
    private RepositorioRol repositorio;

    public ServicioRol(RepositorioRol repositorio) {
        this.repositorio = repositorio;
    }

    public Rol getRol(Integer id) {
        Optional<Rol> rta = this.repositorio.findById(id);
        if (rta.isPresent()) {
            return rta.get();
        }
        return null;
    }

    public Iterable<Rol> getRoles(){
        return this.repositorio.findAll();
    }

    public Iterable<Rol> getRoles(String filtro){
        return this.repositorio.findByNombreIgnoreCaseContaining(filtro);
    }

    public Rol guardar(Rol f) {
        return this.repositorio.save(f);
    }

    public Rol actualizar(Rol f) {
        return this.guardar(f);
    }

    public void eliminar(Integer id) {
        this.repositorio.deleteById(id);
    }
}