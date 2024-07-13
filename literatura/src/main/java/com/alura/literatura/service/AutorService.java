package com.alura.literatura.service;

import com.alura.literatura.model.Autor;
import com.alura.literatura.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    public List<Autor> listarTodos() {
        return autorRepository.findAll();
    }

    public List<Autor> listarPorNome(String nome) {
        return autorRepository.findByNome(nome);
    }
}
