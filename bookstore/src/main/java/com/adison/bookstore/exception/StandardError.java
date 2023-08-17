package com.adison.bookstore.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class StandardError {
    private Long timesTamp;
    private Integer status;
    private String error;

    public StandardError(){
        super();
    }
}
