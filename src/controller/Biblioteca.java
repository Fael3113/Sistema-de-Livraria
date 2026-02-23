package controller;

import service.AutorService;
import service.EmprestimoService;
import service.LivroService;

import java.util.Scanner;

public class Biblioteca {
	private AutorService autorService;
	private LivroService livroService;
	private EmprestimoService emprestimoService;

	public Biblioteca() {
		this.autorService = new AutorService();
		this.livroService = new LivroService();
		this.emprestimoService = new EmprestimoService(livroService);
		cadastrarDados();
	}

	private void cadastrarDados() {
		autorService.cadastrarDados();
		livroService.cadastrarDados(autorService);
		emprestimoService.cadastrarDados();
	}

	public void adicionarEmprestimo() {
		emprestimoService.adicionarEmprestimo();
	}

	public void devolverLivro() {
		emprestimoService.devolverLivro();
	}

	public void adicionarAutor(){
		autorService.adicionarAutor();
	}

	public void adicionarLivro(){
		livroService.adicionarLivro(autorService);
	}

	public void buscarPorTitulo(){
		livroService.buscarPorTitulo();
	}

	public void menu() {
		Scanner scanner = new Scanner(System.in);
		int opcao;

		do {
			System.out.println("\n=== Biblioteca ===");
			System.out.println("1 - Adicionar Autor");
			System.out.println("2 - Adicionar Livro");
			System.out.println("3 - Adicionar Empréstimo");
			System.out.println("4 - Devolver Livro");
			System.out.println("5 - Buscar por Titulo");
			System.out.println("6 - Listar tudo");
			System.out.println("0 - Sair");
			System.out.print("Escolha: ");
			opcao = scanner.nextInt();

			switch (opcao) {
				case 1:
					adicionarAutor();
					break;
				case 2:
					adicionarLivro();
					break;
				case 3:
					adicionarEmprestimo();
					break;
				case 4:
					devolverLivro();
					break;
				case 5:
					buscarPorTitulo();
					break;
				case 6:
					System.out.println(this);
					break;
				case 0:
					System.out.println("Saindo...");
					break;
				default:
					System.out.println("Opção inválida!");

			}
		} while (opcao != 0);
	}

	@Override
	public String toString() {
		return "\nBiblioteca:" +
				"\n Livros:" + livroService.getLivros() +
				"\n Autores:" + autorService.getAutores() +
				"\n Emprestimos:" + emprestimoService.getEmprestimos();
	}
}
