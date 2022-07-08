package ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.web;

import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.logica.ServicioJugador;
import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.modelo.Jugador;
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
    @RequestMapping(params={"filtro"})
    public Iterable<Jugador> getJugadores(@RequestParam(name="filtro") String filtro){
        return this.servicio.getJugadores(filtro);
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

