package com.adison.bookstore.service;

import com.adison.bookstore.domain.Categoria;
import com.adison.bookstore.dto.CategoriaDto;
import com.adison.bookstore.repository.CategoriaRepository;
import com.adison.bookstore.service.exception.DataIntegrityViolationException;
import com.adison.bookstore.service.exception.ObjectNotFoundException;
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

    public Categoria update(Integer id, CategoriaDto categoriaDTO) {
        Categoria categoria = findById(id);
        categoria.setNome(categoriaDTO.getNome());
        categoria.setDescricao(categoriaDTO.getDescricao());
        return repository.save(categoria);
    }

    public void delete(Integer id) {
        findById(id);
        try {
            repository.deleteById(id);
        } catch (org.springframework.dao.DataIntegrityViolationException e){
            throw new DataIntegrityViolationException("Categoria possui livros associados não pode ser deletada!");
        }
    }
}


















