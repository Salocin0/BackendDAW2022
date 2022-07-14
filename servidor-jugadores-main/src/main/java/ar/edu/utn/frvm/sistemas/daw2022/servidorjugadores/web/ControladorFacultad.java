package ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.web;

import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.logica.ServicioFacultad;
import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.modelo.Facultad;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    //GET todas
    @RequestMapping
    public Iterable<Facultad> getFacultades(){
        return this.servicio.getFacultades();
    }

    @RequestMapping(params = {"page"})
    public Page<Facultad> getFacultades(Pageable pagina){
        return this.servicio.getFacultades(pagina);
    }
    
    @RequestMapping(params={"nombre","codigo","codigoNumerico"})
    public Iterable<Facultad> getFacultades(@RequestParam(name="nombre") String nombre,@RequestParam(name="codigo",required = false) String codigo,@RequestParam(name="codigoNumerico",required = false) String codigoNumerico){
        return this.servicio.getFacultades(nombre, codigo, codigoNumerico);
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
