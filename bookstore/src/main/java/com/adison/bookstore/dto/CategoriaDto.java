package com.adison.bookstore.dto;

import com.adison.bookstore.domain.Categoria;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

import org.hibernate.validator.constraints.Length;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class CategoriaDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Integer id;
    
    @NotEmpty(message = "Nome é obrigatório!")
    @Length(min = 3, max = 100, message = "O campo nome deve ter de 3 a 100 caracteres!")
    private String nome;
    
    @NotEmpty(message = "A descrição é obrigatória!")
    @Length(min = 3, max = 200, message = "O campo descrição deve ter de 3 a 200 caracteres!")
    private String descricao;

    public CategoriaDto(Categoria categoria){
        this.id = categoria.getId();
        this.nome = categoria.getNome();
        this.descricao = categoria.getDescricao();
    }
}
