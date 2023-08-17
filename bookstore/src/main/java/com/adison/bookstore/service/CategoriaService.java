package com.adison.bookstore.service;

import com.adison.bookstore.domain.Categoria;
import com.adison.bookstore.dto.CategoriaDTO;
import com.adison.bookstore.exception.ObjectNotFoundException;
import com.adison.bookstore.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository repository;

    public Categoria findById(Integer id){
        Optional<Categoria> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! id:" + id + ", Tipo: "+Categoria.class.getName()));
    }

    public List<Categoria> findAll(){
        return repository.findAll();
    }

    public Categoria create(Categoria categoria){
        categoria.setId(null);
        return repository.save(categoria);
    }

    public Categoria update(Integer id, CategoriaDTO categoriaDTO) {
        Categoria categoria = findById(id);
        categoria.setNome(categoriaDTO.getNome());
        categoria.setDescricao(categoriaDTO.getDescricao());
        return repository.save(categoria);
    }

    public void delete(Integer id) {
        findById(id);
        repository.deleteById(id);
    }
}


















