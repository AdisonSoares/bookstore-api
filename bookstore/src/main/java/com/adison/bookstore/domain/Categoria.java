package com.adison.bookstore.domain;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name="categoria")
public class Categoria  implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @OneToMany(mappedBy = "categoria")
    private List<Livro> livros = new ArrayList<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    private String nome;
    private String descricao;

    public Categoria(Integer id, String nome, String descricao){
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }
}
