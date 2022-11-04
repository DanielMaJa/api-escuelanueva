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
import pe.com.apiescuelanueva.entity.ParentescoEntity;
import pe.com.apiescuelanueva.service.ParentescoService;

@RestController
@RequestMapping("/parentesco")
public class ParentescoController {
    
    @Autowired
    private ParentescoService parentescoService;
    
    @GetMapping
    public List<ParentescoEntity> findAll(){
        return parentescoService.findAll();
    };
    
    @GetMapping("/custom")
    public List<ParentescoEntity> findAllCustom(){
        return parentescoService.findAllCustom();
    }
    
    @GetMapping("/{id}")
    public Optional<ParentescoEntity> findById(@PathVariable Long id){
        return parentescoService.findById(id);
    }
    
    @PostMapping
    public ParentescoEntity add(@RequestBody ParentescoEntity p){
        return parentescoService.add(p);
    }
    
    @PutMapping("/{id}")
    public ParentescoEntity update(@PathVariable long id, @RequestBody ParentescoEntity p){
        p.setCodigo(id);
        return parentescoService.update(p);
    }
    
    @DeleteMapping("/{id}")
    public ParentescoEntity update(@PathVariable long id){
        ParentescoEntity objParentesco = new ParentescoEntity();
        objParentesco.setEstado(false);
        return parentescoService.delete(ParentescoEntity.builder().codigo(id).build());
    }
}
