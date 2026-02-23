package service;

import domain.Autor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class AutorService {
	private List<Autor> autores = new ArrayList<>();

	public void cadastrarDados() {
		Autor autor1 = new Autor(UUID.randomUUID(), "Hara", LocalDate.of(1975, 6, 9));
		Autor autor2 = new Autor(UUID.randomUUID(), "Akira", LocalDate.of(1955, 4, 5));
		autores.add(autor1);
		autores.add(autor2);
	}

	public void adicionarAutor() {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Nome do autor: ");
		String nome = scanner.nextLine();

		System.out.print("Data de nascimento (YYYY-MM-DD): ");
		LocalDate dataNascimento = LocalDate.parse(scanner.nextLine());

		Autor autor = new Autor(UUID.randomUUID(), nome, dataNascimento);
		autores.add(autor);
		System.out.println("Autor adicionado com sucesso!");
	}


	public List<Autor> getAutores() {
		return autores;
	}
}
