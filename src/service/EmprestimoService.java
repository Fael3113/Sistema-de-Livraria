package service;

import domain.Cliente;
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
	private ClienteService clienteService;

	public EmprestimoService(LivroService livroService, ClienteService clienteService) {
		this.livroService = livroService;
		this.clienteService = clienteService;
	}

	public void cadastrarDados() {
		Livro livro1 = livroService.getLivros().get(0);
		Cliente cliente1 = clienteService.getClientes().get(0);
		Emprestimo emprestimo1 = new Emprestimo(UUID.randomUUID(), livro1, cliente1,
				LocalDate.of(2026, 6, 9), LocalDate.of(2026, 6, 12));
		emprestimos.add(emprestimo1);
	}

	public void adicionarEmprestimo() {
		Scanner scanner = new Scanner(System.in);

		//Procura livro cadastrado disponível
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

		//Procura cliente cadastrado disponível
		System.out.println("Clientes disponíveis:");
		clienteService.getClientes().forEach(c ->
				System.out.println(c.getClienteId() + " " + c.getNomeCliente()));

		System.out.println("Id do cliente: ");
		UUID clienteId = UUID.fromString(scanner.nextLine());

		Cliente cliente = clienteService.getClientes().stream()
				.filter(c -> c.getClienteId().equals(clienteId))
				.findFirst()
				.orElse(null);

		if (cliente == null){
			System.out.println("Cliente não encontrado!");
			return;
		}

		//Efetua o empréstimo
		Emprestimo emprestimo = new Emprestimo(UUID.randomUUID(), livro, cliente,
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

	public void historicoEmprestimos() {
		if (emprestimos.isEmpty()) {
			System.out.println("Nenhum empréstimo registrado!");
			return;
		}

		System.out.println("\n=== HISTÓRICO DE EMPRÉSTIMOS ===");
		emprestimos.forEach(e -> System.out.println(e));
	}

	public List<Emprestimo> getEmprestimos() {
		return emprestimos;
	}
}
