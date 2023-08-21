package com.adison.bookstore.service;

import com.adison.bookstore.domain.Livro;
import com.adison.bookstore.repository.LivroRepository;
import com.adison.bookstore.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository repository;
    public Livro findById(Integer id){
        Optional<Livro> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não econtrado! Id:"+id+", Tipo: "+Livro.class.getName()));
    }
}



















