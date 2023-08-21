package com.adison.bookstore.resource;

import com.adison.bookstore.domain.Livro;
import com.adison.bookstore.dto.LivroDto;
import com.adison.bookstore.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
