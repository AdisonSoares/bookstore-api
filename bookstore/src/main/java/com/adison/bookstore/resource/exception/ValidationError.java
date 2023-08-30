package com.adison.bookstore.resource.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter @NoArgsConstructor
public class ValidationError extends StandardError{
    private final List<FieldMessage> errors = new ArrayList<>();

    public ValidationError(Long timesTamp, Integer status, String error) {
        super(timesTamp, status, error);
    }
    public void addErrors(String fieldName, String message){
        this.errors.add(new FieldMessage(fieldName, message));
    }
}
