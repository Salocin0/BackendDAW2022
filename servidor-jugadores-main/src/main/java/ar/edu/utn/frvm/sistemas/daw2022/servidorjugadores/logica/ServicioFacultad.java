package ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.logica;

import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.modelo.Facultad;
import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.persistencia.RepositorioFacultad;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class ServicioFacultad {

    private RepositorioFacultad repositorio;

    public ServicioFacultad(RepositorioFacultad repositorio) {
        this.repositorio = repositorio;
    }

    public Page<Facultad> paginas(String nombre, String codigo, String codigoNumerico, Pageable pageable){
        return repositorio.findByNombreIgnoreCaseContainingAndCodigoIgnoreCaseContainingAndCodigoNumericoIgnoreCaseContaining(nombre, codigo, codigoNumerico, pageable);
    }

    public Facultad getFacultad(Integer id) {
        Optional<Facultad> rta = this.repositorio.findById(id);
        if (rta.isPresent()) {
            return rta.get();
        }
        return null;
    }

    public Iterable<Facultad> getFacultades(){
        return this.repositorio.findAll();
    }

    public Facultad guardar(Facultad f) {
        return this.repositorio.save(f);
    }

    public Facultad actualizar(Facultad f) {
        return this.guardar(f);
    }

    public void eliminar(Integer id) {
        this.repositorio.deleteById(id);
    }
}
