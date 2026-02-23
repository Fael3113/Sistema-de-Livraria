package domain;

import java.time.LocalDate;
import java.util.UUID;

public class Emprestimo {
	private UUID emprestimoId;
	private Livro livro;
	private String nomeCliente;
	private LocalDate dataEmprestimo;
	private LocalDate dataDevolucao;

	public Emprestimo(UUID emprestimoId, Livro livro, String nomeCliente, LocalDate dataEmprestimo, LocalDate dataDevolucao) {
		this.emprestimoId = emprestimoId;
		this.livro = livro;
		this.nomeCliente = nomeCliente;
		this.dataEmprestimo = dataEmprestimo;
		this.dataDevolucao = dataDevolucao;
	}

	@Override
	public String toString() {
		return "\n  Emprestimo:" +
				"\n Id do emprestimo: " + emprestimoId +
				"\n Nome do Livro: " + livro.getTitulo() +
				"\n Nome do Cliente: " + nomeCliente +
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

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
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
