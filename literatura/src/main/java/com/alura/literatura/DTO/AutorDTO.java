package com.alura.literatura.DTO;

import com.alura.literatura.model.Autor;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class AutorDTO {
    private String nome;
    private int dataNascimento;
    private int dataFalecimento;

    public AutorDTO(String nome, int dataNascimento, int dataFalecimento) {
    }


    private List<AutorDTO> convertData(List<Autor> autor) {
        return autor.stream()
                .map(a -> new AutorDTO(a.getNome(),
                        a.getDataNascimento(),a.getDataFalecimento()))
                .collect(Collectors.toList());
    }

}


