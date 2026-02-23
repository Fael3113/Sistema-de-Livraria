package domain;

import java.time.LocalDate;
import java.util.UUID;

public class Emprestimo {
	private UUID emprestimoId;
	private Livro livro;
	private Cliente cliente;
	private LocalDate dataEmprestimo;
	private LocalDate dataDevolucao;

	public Emprestimo(UUID emprestimoId, Livro livro, Cliente cliente, LocalDate dataEmprestimo, LocalDate dataDevolucao) {
		this.emprestimoId = emprestimoId;
		this.livro = livro;
		this.cliente = cliente;
		this.dataEmprestimo = dataEmprestimo;
		this.dataDevolucao = dataDevolucao;
	}

	@Override
	public String toString() {
		return "\n  Emprestimo:" +
				"\n Id do emprestimo: " + emprestimoId +
				"\n Nome do Livro: " + livro.getTitulo() +
				"\n Nome do Cliente: " + cliente.getNomeCliente() +
				"\n Data de Emprestimo: " + dataEmprestimo +
				"\n Data de Devolucao: " + dataDevolucao;
	}

	public UUID getEmprestimoId() {
		return emprestimoId;
	}

	public void setEmprestimoId(UUID emprestimoId) {
		this.emprestimoId = emprestimoId;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public LocalDate getDataEmprestimo() {
		return dataEmprestimo;
	}

	public void setDataEmprestimo(LocalDate dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	public LocalDate getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(LocalDate dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}
}
