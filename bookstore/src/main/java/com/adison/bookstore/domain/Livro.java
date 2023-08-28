package com.adison.bookstore.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

import org.hibernate.validator.constraints.Length;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Livro implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    @NotEmpty(message = "Título é obrigatório!")
    @Length(min = 3, max = 50, message = "O título deve ter de 3 a 50 caracteres!")
    private String titulo;
    
    @NotEmpty(message = "Nome do autor é obrigatório!")
    @Length(min = 3, max = 50, message = "O nome do autor deve ter de 3 a 50 caracteres!")
    private String nome_autor;
    
    @NotEmpty(message = "Texto é obrigatório!")
    @Length(min = 10, max = 100000, message = "O texto deve ter de 10 a 100.000 caracteres!")
    private String texto;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;


}













