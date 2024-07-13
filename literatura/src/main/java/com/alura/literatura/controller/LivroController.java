package com.alura.literatura.controller;

import com.alura.literatura.model.Livro;
import com.alura.literatura.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping
    public List<Livro> listarTodos() {
        return livroService.listarTodos();
    }

    @GetMapping("/idioma/{idioma}")
    public List<Livro> listarPorIdioma(@PathVariable String idioma) {
        return livroService.listarPorIdioma(idioma);
    }

    @GetMapping("/titulo/{titulo}")
    public Livro buscarPorTitulo(@PathVariable String titulo) {
        return livroService.buscarPorTitulo(titulo);
    }
}
