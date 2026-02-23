package service;

import domain.Emprestimo;
import domain.Livro;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class EmprestimoService {
	private List<Emprestimo> emprestimos = new ArrayList<>();
	private LivroService livroService;

	public EmprestimoService(LivroService livroService) {
		this.livroService = livroService;
	}

	public void cadastrarDados() {
		Livro livro1 = livroService.getLivros().get(0);
		Emprestimo emprestimo1 = new Emprestimo(UUID.randomUUID(), livro1, "Rafael",
				LocalDate.of(2026, 6, 9), LocalDate.of(2026, 6, 12));
		emprestimos.add(emprestimo1);
	}

	public void adicionarEmprestimo() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Livros disponíveis:");
		livroService.getLivros().stream()
				.filter(Livro::isDisponivel)
				.forEach(l -> System.out.println(l.getLivroId() + " - " + l.getTitulo()));

		System.out.print("ID do livro: ");
		UUID livroId = UUID.fromString(scanner.nextLine());

		Livro livro = livroService.getLivros().stream()
				.filter(l -> l.getLivroId().equals(livroId))
				.findFirst()
				.orElse(null);

		if (livro == null) {
			System.out.println("Livro não encontrado!");
			return;
		}

		if (!livro.isDisponivel()) {
			System.out.println("Livro não está disponível!");
			return;
		}

		System.out.print("Nome do cliente: ");
		String nomeCliente = scanner.nextLine();

		Emprestimo emprestimo = new Emprestimo(UUID.randomUUID(), livro, nomeCliente,
				LocalDate.now(), null);

		livro.setDisponivel(false);
		livro.setDataAtualizacao(LocalDate.now());

		emprestimos.add(emprestimo);
		System.out.println("Empréstimo realizado com sucesso!");
	}

	public void devolverLivro() {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Título do livro: ");
		String titulo = scanner.nextLine();

		Emprestimo emprestimo = emprestimos.stream()
				.filter(e -> e.getLivro().getTitulo().equalsIgnoreCase(titulo)
						&& e.getDataDevolucao() == null)
				.findFirst()
				.orElse(null);

		if (emprestimo == null) {
			System.out.println("Empréstimo não encontrado!");
			return;
		}

		emprestimo.setDataDevolucao(LocalDate.now());
		emprestimo.getLivro().setDisponivel(true);
		emprestimo.getLivro().setDataAtualizacao(LocalDate.now());

		System.out.println("Livro devolvido com sucesso!");
	}

	public List<Emprestimo> getEmprestimos() {
		return emprestimos;
	}
}
