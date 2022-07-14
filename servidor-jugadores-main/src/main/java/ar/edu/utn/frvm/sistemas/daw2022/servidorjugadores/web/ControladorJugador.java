package ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.web;

import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.logica.ServicioJugador;
import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.modelo.Disciplina;
import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.modelo.Facultad;
import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.modelo.Jugador;
import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.modelo.Nacionalidad;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/jugadores")
@RestController
public class ControladorJugador {

    private ServicioJugador servicio;
    public ControladorJugador(ServicioJugador servicio) {
        this.servicio = servicio;
    }

    //GET todas
    @RequestMapping
    public Iterable<Jugador> getJugadores(){
        return this.servicio.getJugadores();
    }
    //GET todas aplicando filtros
    @RequestMapping(params={"nombre","disciplina","facultad","nacionalidad"})
    public Iterable<Jugador> getJugadores(@RequestParam(name="nombre",required = false) String nombre, @RequestParam(name="disciplina",required = false) Disciplina disciplina, @RequestParam(name="facultad",required = false) Facultad facultad, @RequestParam(name="nacionalidad",required = false) Nacionalidad nacionalidad){
        return this.servicio.getJugadores(nombre,disciplina,facultad,nacionalidad);
    }
    //GET 1
    @RequestMapping(value = "/{id}")
    public Jugador getJugador(@PathVariable("id") Integer id) {
        return this.servicio.getJugador(id);
    }
    //POST
    @RequestMapping(method = RequestMethod.POST)
    public Jugador guardar(@RequestBody Jugador f){
        return this.servicio.guardar(f);
    }
    //PUT
    @RequestMapping(method = RequestMethod.PUT)
    public Jugador actualizar(@RequestBody Jugador f){
        return this.servicio.actualizar(f);
    }
    //DELETE
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        this.servicio.eliminar(id);
    }
    
}

