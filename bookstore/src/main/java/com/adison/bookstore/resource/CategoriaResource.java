package com.adison.bookstore.resource;

import com.adison.bookstore.domain.Categoria;
import com.adison.bookstore.dto.CategoriaDto;
import com.adison.bookstore.service.CategoriaService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/categorias")
public class CategoriaResource {
    @Autowired
    private CategoriaService service;
    @GetMapping("/{id}")
    public ResponseEntity<Categoria> findById(@PathVariable Integer id){
        Categoria obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
    @GetMapping
    public ResponseEntity<List<CategoriaDto>> findAll(){
        List<Categoria> list = service.findAll();
        List<CategoriaDto> listDTO = list.stream().map(CategoriaDto::new).toList();
        return ResponseEntity.ok().body(listDTO);
    }
    @PostMapping
    public ResponseEntity<Categoria> create(@Valid @RequestBody Categoria categoria){
        categoria = service.create(categoria);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(categoria.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<CategoriaDto> update(@Valid @PathVariable Integer id, @RequestBody CategoriaDto categoriaDTO){
        Categoria newCategoria = service.update(id, categoriaDTO);
        return ResponseEntity.ok().body(new CategoriaDto(newCategoria));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
