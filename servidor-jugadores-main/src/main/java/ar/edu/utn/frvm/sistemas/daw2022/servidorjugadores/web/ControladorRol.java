package ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.web;
import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.logica.ServicioRol;
import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.modelo.Rol;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
@Slf4j
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/rol")
@RestController
public class ControladorRol {
    //atributos
    private ServicioRol servicio;
    //constructor
    public ControladorRol(ServicioRol servicio) {
        this.servicio = servicio;
    }
    //GET todas
    @RequestMapping
    public Iterable<Rol> getRol(){
        return this.servicio.getRoles();
    }
    //GET todas + filtro
    @RequestMapping(params={"filtro"})
    public Iterable<Rol> getRol(@RequestParam(name="filtro") String filtro){
        return this.servicio.getRoles(filtro);
    }
    //GET 1
    @RequestMapping(value = "/{id}")
    public Rol getRol(@PathVariable("id") Integer id) {
        return this.servicio.getRol(id);
    }
    //POST
    @RequestMapping(method = RequestMethod.POST)
    public Rol guardar(@RequestBody Rol f){
        return this.servicio.guardar(f);
    }
    //PUT
    @RequestMapping(method = RequestMethod.PUT)
    public Rol actualizar(@RequestBody Rol f){
        return this.servicio.actualizar(f);
    }
    //DELETE
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void eliminar(@PathVariable("id") Integer id){
    this.servicio.eliminar(id);
    }   
}