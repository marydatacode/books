package com.alura.literatura.service;

import com.alura.literatura.DTO.LivroDTO;
import com.alura.literatura.model.Livro;
import com.alura.literatura.repository.LivroRepository;
import com.alura.literatura.utils.HttpClientUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public List<Livro> listarTodos() {
        return livroRepository.findAll();
    }

    public List<Livro> listarPorIdioma(String idioma) {
        return livroRepository.findByIdioma(idioma);
    }

    public Livro buscarPorTitulo(String titulo) {
        String url = "https://gutendex.com/books/?search=" + titulo.replace(" ", "%20");
        Optional<String> resposta = HttpClientUtil.get(url);
        if (resposta.isPresent()) {
            try {
                ObjectMapper mapper = new ObjectMapper();
                LivroDTO livroDTO = mapper.readValue(resposta.get(), LivroDTO.class);
                Livro livro = new Livro();
                livro.setTitulo(livroDTO.getTitulo());
                livro.setIdioma(livroDTO.getIdioma());

                livroRepository.save(livro);
                return livro;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }
}
