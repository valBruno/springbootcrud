package com.empresa.springbootcrud.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ValicacaoHandler {

    @Qualifier("messageSource")
    @Autowired
    private MessageSource ms;

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ErroDTO> handler(MethodArgumentNotValidException e) {
        List<ErroDTO> retorno = new ArrayList<>();
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();

        fieldErrors.forEach(fieldError -> {
            String mensagem = ms.getMessage(fieldError, LocaleContextHolder.getLocale());
            ErroDTO erroDTO = new ErroDTO(fieldError.getField(), mensagem);
            retorno.add(erroDTO);
        });

        return retorno;
    }
}
