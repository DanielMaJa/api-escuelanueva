package pe.com.apiescuelanueva.service;

import java.util.List;
import java.util.Optional;
import pe.com.apiescuelanueva.entity.DistritoEntity;



public interface DistritoService {
    //Función que te permita mostrar todos los datos
    List<DistritoEntity> findAll();
    //Función que permita mostrar todos los datos habilitados
    List<DistritoEntity> findAllCustom();
    //Función para poder buscar por código
    Optional<DistritoEntity> findById(Long id);
    //Función para registrar datos
    DistritoEntity add(DistritoEntity d);
    //Función para actualizar datos
    DistritoEntity update(DistritoEntity d);
    //Función para eliminar datos
    DistritoEntity delete(DistritoEntity d);
    
}
