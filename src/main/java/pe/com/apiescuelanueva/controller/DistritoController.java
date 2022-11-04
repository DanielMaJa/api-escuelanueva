package pe.com.apiescuelanueva.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.apiescuelanueva.entity.DistritoEntity;
import pe.com.apiescuelanueva.service.DistritoService;


// @Controller --> Indica que es un controlador de tipo Spring
// @ResponseBody --> Cuando se agrega esta anotación se vuelve un REST
// @RestController = @Controller + @ResponseBody
// @RestController aparece en la versión 4 de Spring
// @RestController --> Indica que es un controlador de tipo REST
@RestController
// @RequestMapping --> Permite definir el nombre del ENDPOINT
@RequestMapping("/distrito")
public class DistritoController {
    @Autowired
    private DistritoService distritoService;
    
    // @GetMapping sirve para obtener valores
    @GetMapping
    public List<DistritoEntity> findAll(){
        return distritoService.findAll();
    };
    
    @GetMapping("/custom")
    public List<DistritoEntity> findAllCustom(){
        return distritoService.findAllCustom();
    }
    
    @GetMapping("/{id}")
    public Optional<DistritoEntity> findById(@PathVariable Long id){
        return distritoService.findById(id);
    }
    
    @PostMapping
    public DistritoEntity add(@RequestBody DistritoEntity d){
        return distritoService.add(d);
    }
    
    @PutMapping("/{id}")
    public DistritoEntity update(@PathVariable long id, @RequestBody DistritoEntity d){
        d.setCodigo(id);
        return distritoService.update(d);
    }
    
    @DeleteMapping("/{id}")
    public DistritoEntity update(@PathVariable long id){
        DistritoEntity objDistrito = new DistritoEntity();
        objDistrito.setEstado(false);
        return distritoService.delete(DistritoEntity.builder().codigo(id).build());
    }
}
