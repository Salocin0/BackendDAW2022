package ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.web;
import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.logica.ServicioJugador;
import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.modelo.Jugador;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@Slf4j
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/jugadores")
@RestController
public class ControladorJugador {
    // atributos
    private ServicioJugador servicio;
    // constructor
    public ControladorJugador(ServicioJugador servicio) {
        this.servicio = servicio;
    }
    // GET todas con paginacion
    @RequestMapping("/jugadoresPage")
    public ResponseEntity<Page<Jugador>> paginas(
            @RequestParam(defaultValue = "", required = false) String filtro,
            @RequestParam(defaultValue = "", required = false) String disciplina,
            @RequestParam(defaultValue = "", required = false) String facultad,
            @RequestParam(defaultValue = "", required = false) String nacionalidad,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "nombre") String order,
            @RequestParam(defaultValue = "true") boolean asc) {
        Page<Jugador> jugador = servicio.paginas(
                filtro, disciplina, facultad, nacionalidad, PageRequest.of(page, size, Sort.by(order)));
        if (!asc)
            jugador = servicio.paginas(
                    filtro, disciplina, facultad, nacionalidad,
                    PageRequest.of(page, size, Sort.by(order).descending()));
        return new ResponseEntity<Page<Jugador>>(jugador, HttpStatus.OK);
    }
    // GET todas
    @RequestMapping
    public Iterable<Jugador> getJugadores() {
        return this.servicio.getJugadores();
    }
    // GET 1
    @RequestMapping(value = "/{id}")
    public Jugador getJugador(@PathVariable("id") Integer id) {
        return this.servicio.getJugador(id);
    }
    // POST
    @RequestMapping(method = RequestMethod.POST)
    public Jugador guardar(@RequestBody Jugador f) {
        return this.servicio.guardar(f);
    }
    // PUT
    @RequestMapping(method = RequestMethod.PUT)
    public Jugador actualizar(@RequestBody Jugador f) {
        return this.servicio.actualizar(f);
    }
    // DELETE
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        this.servicio.eliminar(id);
    }
}