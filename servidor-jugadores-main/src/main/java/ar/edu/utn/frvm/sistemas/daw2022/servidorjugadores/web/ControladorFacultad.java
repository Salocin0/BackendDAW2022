package ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.web;

import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.logica.ServicioFacultad;
import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.modelo.Facultad;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/facultades")
@RestController
public class ControladorFacultad {

    private ServicioFacultad servicio;
    public ControladorFacultad(ServicioFacultad servicio) {
        this.servicio = servicio;
    }

    @RequestMapping("/facultadesPage")
    public ResponseEntity<Page<Facultad>> paginas(
        @RequestParam(defaultValue="") String nombre,
        @RequestParam(defaultValue="") String codigo,
        @RequestParam(defaultValue="") String codigoNumerico,
        @RequestParam(defaultValue="0") int page,
        @RequestParam(defaultValue="5") int size,
        @RequestParam(defaultValue="nombre") String order,
        @RequestParam(defaultValue="true") boolean asc
    ){
        Page<Facultad> facultades=servicio.paginas(
            nombre, codigo, codigoNumerico, PageRequest.of(page, size, Sort.by(order)));
            if(!asc)
                facultades=servicio.paginas(
                    nombre, codigo, codigoNumerico, PageRequest.of(page, size, Sort.by(order).descending()));
            return new ResponseEntity<Page<Facultad>>(facultades,HttpStatus.OK);
    }

    //GET todas
    @RequestMapping
    public Iterable<Facultad> getFacultades(){
        return this.servicio.getFacultades();
    }
    //GET 1
    @RequestMapping(value = "/{id}")
    public Facultad getFactultad(@PathVariable("id") Integer id) {
        return this.servicio.getFacultad(id);
    }
    //POST
    @RequestMapping(method = RequestMethod.POST)
    public Facultad guardar(@RequestBody Facultad f){
        return this.servicio.guardar(f);
    }
    //PUT
    @RequestMapping(method = RequestMethod.PUT)
    public Facultad actualizar(@RequestBody Facultad f){
        return this.servicio.actualizar(f);
    }
    //DELETE
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        this.servicio.eliminar(id);
    }
    
}