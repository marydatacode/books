package com.alura.literatura.model;

import jakarta.persistence.*;

@Entity
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private int dataNascimento;
    private int dataFalecimento;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDataNascimento() {
        return dataNascimento;
    }

    public int setDataNascimento(int dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public int getDataFalecimento() {
        return dataFalecimento;
    }

    public int setDataFalecimento(int dataFalecimentoa) {
        this.dataFalecimento = dataFalecimento;
    }

    @Override
    public String toString() {
        return  "nome='" + nome + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", dataFalecimento=" + dataFalecimento;
    }
}
