package ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.web;

import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.logica.ServicioDisciplina;
import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.modelo.Disciplina;
import lombok.extern.slf4j.Slf4j;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    
    @RequestMapping("/disciplinasPage")
    public ResponseEntity<Page<Disciplina>> paginas(
        @RequestParam(defaultValue="") String nombre,
        @RequestParam(defaultValue="") String codigo,
        @RequestParam(defaultValue="") String descripcion,
        @RequestParam(defaultValue="0") int page,
        @RequestParam(defaultValue="5") int size,
        @RequestParam(defaultValue="nombre") String order,
        @RequestParam(defaultValue="true") boolean asc
    ){
        Page<Disciplina> disciplina=servicio.paginas(
            nombre, codigo, descripcion, PageRequest.of(page, size, Sort.by(order)));
            if(!asc)
                disciplina=servicio.paginas(
                    nombre, codigo, descripcion, PageRequest.of(page, size, Sort.by(order).descending()));
            return new ResponseEntity<Page<Disciplina>>(disciplina,HttpStatus.OK);
    }
    
    //GET todas
    @RequestMapping
    public Iterable<Disciplina> getDisciplinas(){
        return this.servicio.getDisciplinas();
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
