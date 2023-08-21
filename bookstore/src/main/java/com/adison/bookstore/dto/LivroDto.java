package com.adison.bookstore.dto;

import com.adison.bookstore.domain.Livro;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter @Setter @NoArgsConstructor
public class LivroDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String titulo;

    public LivroDto(Livro obj) {
        this.id = obj.getId();
        this.titulo = obj.getTitulo();
    }
}
