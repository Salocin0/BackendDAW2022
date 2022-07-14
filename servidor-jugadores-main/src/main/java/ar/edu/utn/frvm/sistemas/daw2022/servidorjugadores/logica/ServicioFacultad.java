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

    /*public Iterable<Facultad> getFacultadesNombre(String nombre){
        return this.repositorio.findByNombreIgnoreCaseContaining(nombre);//agregar resto
    }*/

    /*public Iterable<Facultad> getFacultadesCodigo(String codigo){
        return this.repositorio.findByCodigoIgnoreCaseContaining(codigo);//agregar resto
    }*/

    public Iterable<Facultad> getFacultades(String filtro, String codigo, String codigoNumerico){
        return this.repositorio.findByNombreIgnoreCaseContainingAndCodigoIgnoreCaseContainingAndCodigoNumericoIgnoreCaseContaining(filtro, codigo, codigoNumerico);//agregar resto
    } 

    public Page<Facultad> getFacultades(Pageable pagina){
        return this.repositorio.findAll(pagina);
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
