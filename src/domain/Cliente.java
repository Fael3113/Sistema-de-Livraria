package domain;

import java.util.UUID;

public class Cliente {
	private UUID clienteId;
	private String nomeCliente;
	private String email;

	public Cliente(UUID clienteId, String nomeCliente, String email) {
		this.clienteId = clienteId;
		this.nomeCliente = nomeCliente;
		this.email = email;
	}

	@Override
	public String toString() {
		return "\n  Cliente:" +
				"\n Id do Client: " + clienteId +
				"\n Nome: " + nomeCliente +
				"\n Email: " + email;
	}

	public UUID getClienteId() {
		return clienteId;
	}

	public void setClienteId(UUID clienteId) {
		this.clienteId = clienteId;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
