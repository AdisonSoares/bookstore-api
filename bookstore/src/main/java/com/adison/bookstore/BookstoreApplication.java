package com.adison.bookstore;

import com.adison.bookstore.domain.Categoria;
import com.adison.bookstore.domain.Livro;
import com.adison.bookstore.repositories.CategoriaRepository;
import com.adison.bookstore.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class BookstoreApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private LivroRepository livroRepository;

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria categoria_1 = new Categoria(null, "Informática", "Livros de TI");
		Livro livro_1 = new Livro(null, categoria_1, "Clean code", "Robert C.Martin", "Loren ipsum");

		categoria_1.getLivros().addAll(Arrays.asList(livro_1));

		this.categoriaRepository.saveAll(Arrays.asList(categoria_1));
		this.livroRepository.saveAll(Arrays.asList(livro_1));
	}
}
