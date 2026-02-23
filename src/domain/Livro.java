package domain;

import java.time.LocalDate;
import java.util.UUID;

public class Livro {
	private UUID livroId;
	private String titulo;
	private Autor autor;
	private boolean isDisponivel;
	private LocalDate dataCadastro;
	private LocalDate dataAtualizacao;

	public Livro(UUID livroId, String titulo, Autor autor, boolean isDisponivel, LocalDate dataCadastro, LocalDate dataAtualizacao) {
		this.livroId = livroId;
		this.titulo = titulo;
		this.autor = autor;
		this.isDisponivel = isDisponivel;
		this.dataCadastro = dataCadastro;
		this.dataAtualizacao = dataAtualizacao;
	}

	@Override
	public String toString() {
		return "\n  Livro:" +
				"\n Id do Livro: " + livroId +
				"\n Titulo: " + titulo +
				"\n Autor: " + autor.getNome() +
				"\n Está Disponivel ? " + isDisponivel +
				"\n Data de Cadastro: " + dataCadastro +
				"\n Data de Atualizacao: " + dataAtualizacao;
	}

	public UUID getLivroId() {
		return livroId;
	}

	public void setLivroId(UUID livroId) {
		this.livroId = livroId;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public boolean isDisponivel() {
		return isDisponivel;
	}

	public void setDisponivel(boolean disponivel) {
		isDisponivel = disponivel;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public LocalDate getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(LocalDate dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}
}
