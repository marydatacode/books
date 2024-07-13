package com.alura.literatura.repository;

import com.alura.literatura.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {
    List<Autor> findByDataNascimento(int ano);

    List<Autor> findByDataFalecimento(int ano);

    List<Autor> findByNome(String nome);
}
