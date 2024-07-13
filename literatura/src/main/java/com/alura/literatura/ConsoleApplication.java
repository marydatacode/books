package com.alura.literatura;

import com.alura.literatura.model.Livro;
import com.alura.literatura.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class ConsoleApplication implements CommandLineRunner {

    @Autowired
    private LivroService livroService;

    public static void main(String[] args) {
        SpringApplication.run(ConsoleApplication.class, args);
    }

    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Listar todos os livros");
            System.out.println("2. Listar livros por idioma");
            System.out.println("3. Buscar livro por título");
            System.out.println("4. Sair");
            int escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    listarTodos();
                    break;
                case 2:
                    listarPorIdioma(scanner);
                    break;
                case 3:
                    buscarPorTitulo(scanner);
                    break;
                case 4:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Escolha inválida, tente novamente.");
            }
        }
    }

    private void listarTodos() {
        List<Livro> livros = livroService.listarTodos();
        livros.forEach(System.out::println);
    }

    private void listarPorIdioma(Scanner scanner) {
        System.out.println("Digite o idioma:");
        String idioma = scanner.nextLine();
        List<Livro> livros = livroService.listarPorIdioma(idioma);
        livros.forEach(System.out::println);
    }

    private void buscarPorTitulo(Scanner scanner) {
        System.out.println("Digite o título:");
        String titulo = scanner.nextLine();
        Livro livro = livroService.buscarPorTitulo(titulo);
        if (livro != null) {
            System.out.println(livro);
        } else {
            System.out.println("Livro não encontrado.");
        }
    }
}
