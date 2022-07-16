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

    public Iterable<Facultad> getFacultades(String filtro, String codigo, String codigoNumerico){
        return this.repositorio.findByNombreIgnoreCaseContainingAndCodigoIgnoreCaseContainingAndCodigoNumericoIgnoreCaseContaining(filtro, codigo, codigoNumerico);
    }

    public Iterable<Facultad> getFacultadesOrdenNombre(String filtro, String codigo, String codigoNumerico,String orden){
        if("ASC".equals(orden)){
            return this.repositorio.findByNombreIgnoreCaseContainingAndCodigoIgnoreCaseContainingAndCodigoNumericoIgnoreCaseContainingOrderByNombreAsc(filtro, codigo, codigoNumerico);
        }else if("DESC".equals(orden)){
            return this.repositorio.findByNombreIgnoreCaseContainingAndCodigoIgnoreCaseContainingAndCodigoNumericoIgnoreCaseContainingOrderByNombreDesc(filtro, codigo, codigoNumerico);
        }else{
            return this.repositorio.findByNombreIgnoreCaseContainingAndCodigoIgnoreCaseContainingAndCodigoNumericoIgnoreCaseContaining(filtro, codigo, codigoNumerico);
        }
    }

    public Iterable<Facultad> getFacultadesOrdenCodigo(String filtro, String codigo, String codigoNumerico,String orden){
        if("ASC".equals(orden)){
            return this.repositorio.findByNombreIgnoreCaseContainingAndCodigoIgnoreCaseContainingAndCodigoNumericoIgnoreCaseContainingOrderByCodigoAsc(filtro, codigo, codigoNumerico);
        }else if("DESC".equals(orden)){
            return this.repositorio.findByNombreIgnoreCaseContainingAndCodigoIgnoreCaseContainingAndCodigoNumericoIgnoreCaseContainingOrderByCodigoDesc(filtro, codigo, codigoNumerico);
        }else{
            return this.repositorio.findByNombreIgnoreCaseContainingAndCodigoIgnoreCaseContainingAndCodigoNumericoIgnoreCaseContaining(filtro, codigo, codigoNumerico);
        }
    }

    public Iterable<Facultad> getFacultadesOrdenCodigoNumerico(String filtro, String codigo, String codigoNumerico,String orden){
        if("ASC".equals(orden)){
            return this.repositorio.findByNombreIgnoreCaseContainingAndCodigoIgnoreCaseContainingAndCodigoNumericoIgnoreCaseContainingOrderByCodigoNumericoAsc(filtro, codigo, codigoNumerico);
        }else if("DESC".equals(orden)){
            return this.repositorio.findByNombreIgnoreCaseContainingAndCodigoIgnoreCaseContainingAndCodigoNumericoIgnoreCaseContainingOrderByCodigoNumericoDesc(filtro, codigo, codigoNumerico);
        }else{
            return this.repositorio.findByNombreIgnoreCaseContainingAndCodigoIgnoreCaseContainingAndCodigoNumericoIgnoreCaseContaining(filtro, codigo, codigoNumerico);
        }
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
