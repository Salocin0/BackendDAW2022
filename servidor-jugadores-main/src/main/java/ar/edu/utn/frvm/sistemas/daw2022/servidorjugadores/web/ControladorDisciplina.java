package ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.web;

import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.logica.ServicioDisciplina;
import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.modelo.Disciplina;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/disciplinas")
@RestController
public class ControladorDisciplina {
    private ServicioDisciplina servicio;

    public ControladorDisciplina(ServicioDisciplina servicio) {
        this.servicio = servicio;
    }
    //GET todas
    @RequestMapping
    public Iterable<Disciplina> getDisciplinas(){
        return this.servicio.getDisciplinas();
    }
    @RequestMapping(params={"filtro"})
    public Iterable<Disciplina> getDisciplinas(@RequestParam(name="filtro") String filtro){
        return this.servicio.getDisciplinas(filtro);
    }
    //GET 1
    @RequestMapping(value = "/{id}")
    public Disciplina getDisciplina(@PathVariable("id") Integer id) {
        return this.servicio.getDisciplina(id);
    }
    //POST
    @RequestMapping(method = RequestMethod.POST)
    public Disciplina guardar(@RequestBody Disciplina f){
        return this.servicio.guardar(f);
    }
    //PUT
    @RequestMapping(method = RequestMethod.PUT)
    public Disciplina actualizar(@RequestBody Disciplina f){
        return this.servicio.actualizar(f);
    }
    //DELETE
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        this.servicio.eliminar(id);
    }

}
