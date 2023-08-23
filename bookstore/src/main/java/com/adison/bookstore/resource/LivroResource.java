package com.adison.bookstore.resource;

import com.adison.bookstore.domain.Livro;
import com.adison.bookstore.dto.LivroDto;
import com.adison.bookstore.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/livros")
public class LivroResource {

    @Autowired
    private LivroService service;

    @GetMapping("/{id}")
    public ResponseEntity<Livro> findById(@PathVariable Integer id){
        Livro obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping
    public ResponseEntity<List<LivroDto>> findAll(@RequestParam(value = "categoria", defaultValue = "0") Integer id_cat){
        List<Livro> list = service.findAll(id_cat);
        List<LivroDto> listDto = list.stream().map(LivroDto::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Livro> update(@PathVariable Integer id, @RequestBody Livro obj){
        Livro newObj = service.update(id, obj);
        return ResponseEntity.ok().body(newObj);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Livro> updatePatch(@PathVariable Integer id, @RequestBody Livro obj){
        Livro newObj = service.update(id, obj);
        return ResponseEntity.ok().body(newObj);
    }

    @PostMapping
    public ResponseEntity<Livro> create(@RequestParam(value = "categoria", defaultValue = "0") Integer id_cat,
                                        @RequestBody Livro obj){
        Livro newObj = service.create(id_cat, obj);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/livros/{id}")
                .buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
