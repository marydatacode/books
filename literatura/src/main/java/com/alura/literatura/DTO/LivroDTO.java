package com.alura.literatura.DTO;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LivroDTO {

    private String titulo;
    private String idioma;

    public String getTitulo() {
    }

    public String getIdioma() {
    }
}
