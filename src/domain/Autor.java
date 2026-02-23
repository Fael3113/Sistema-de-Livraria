package domain;

import java.time.LocalDate;
import java.util.UUID;

public class Autor {
	private UUID autorId;
	private String nome;
	private LocalDate dataNascimento;

	public Autor(UUID autorId, String nome, LocalDate dataNascimento) {
		this.autorId = autorId;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
	}

	@Override
	public String toString() {
		return "\n  Autor: " +
				"\n Id do Autor: " + autorId +
				"\n Nome: " + nome +
				"\n Data de Nascimento: " + dataNascimento;
	}

	public UUID getId() {
		return autorId;
	}

	public void setId(UUID autorId) {
		this.autorId = autorId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
}
