package com.adison.bookstore.domain;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Livro {
    
    @EqualsAndHashCode.Include
    private Integer id;

    private String titulo;
    private String nome_autor;
    private String texto;
    private Categoria categoria;
}
