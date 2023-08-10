package com.adison.bookstore.service;

import com.adison.bookstore.domain.Categoria;
import com.adison.bookstore.domain.Livro;
import com.adison.bookstore.repositories.CategoriaRepository;
import com.adison.bookstore.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private LivroRepository livroRepository;

    public void instaciaBaseDeDados(){
        Categoria categoria_1 = new Categoria(null, "Informática", "Livros de TI");
        Categoria categoria_2 = new Categoria(null, "Ficção Científica", "Livros de Ficção");
        Categoria categoria_3 = new Categoria(null, "Biografias", "Livros de Biografias");

        Livro livro_1 = new Livro(null, categoria_1, "Clean code", "Robert C.Martin", "Loren ipsum");
        Livro livro_2 = new Livro(null, categoria_1, "Engenharia de software", "Louis V. Gerstner", "Loren ipsum");
        Livro livro_3 = new Livro(null, categoria_2, "Staw Wars", "George Lucas", "Loren ipsum");
        Livro livro_4 = new Livro(null, categoria_2, "Elysium", "Neill Blomkamp", "Loren ipsum");
        Livro livro_5 = new Livro(null, categoria_2, "Tron: o legado", "J.W. Rinzler", "Loren ipsum");

        categoria_1.getLivros().addAll(Arrays.asList(livro_1, livro_2));
        categoria_2.getLivros().addAll(Arrays.asList(livro_3, livro_4, livro_5));

        this.categoriaRepository.saveAll(Arrays.asList(categoria_1, categoria_2, categoria_3));
        this.livroRepository.saveAll(Arrays.asList(livro_1, livro_2, livro_3, livro_4, livro_5));
    }
}
