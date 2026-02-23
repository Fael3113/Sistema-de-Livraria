package service;

import domain.Autor;
import domain.Livro;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class LivroService {
	private List<Livro> livros = new ArrayList<>();

	public void cadastrarDados(AutorService autorService) {
		Autor autor1 = autorService.getAutores().get(0);
		Autor autor2 = autorService.getAutores().get(1);

		Livro livro1 = new Livro(UUID.randomUUID(), "Kingdom", autor1, true,
				LocalDate.of(2006, 1, 26), LocalDate.of(2026, 2, 19));

		Livro livro2 = new Livro(UUID.randomUUID(), "Dragon Ball", autor2, true,
				LocalDate.of(1989, 11, 3), LocalDate.of(2026, 2, 19));

		livros.add(livro1);
		livros.add(livro2);
	}

	public void buscarPorTitulo() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Título do livro: ");
		String titulo = scanner.nextLine();

		Livro livro = livros.stream()
				.filter(l -> l.getTitulo().equalsIgnoreCase(titulo))
				.findFirst()
				.orElse(null);
		if (livro == null) {
			System.out.println("Livro não encontrado!");
			return;
		}

		System.out.println(livro);
	}

	public void adicionarLivro(AutorService autorService) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Título: ");
		String titulo = scanner.nextLine();

		System.out.print("Nome do autor: ");
		String nomeAutor = scanner.nextLine();

		Autor autor = autorService.getAutores().stream()
				.filter(a -> a.getNome().equalsIgnoreCase(nomeAutor))
				.findFirst()
				.orElse(null);

		if (autor == null) {
			System.out.println("Autor não encontrado!");
			return;
		}

		Livro livro = new Livro(UUID.randomUUID(), titulo, autor, true,
				LocalDate.now(), LocalDate.now());
		livros.add(livro);
		System.out.println("Livro adicionado com sucesso!");
	}


	public List<Livro> getLivros() {
		return livros;
	}
}
