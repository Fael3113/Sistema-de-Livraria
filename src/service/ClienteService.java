package service;

import domain.Cliente;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class ClienteService {
	private List<Cliente> clientes = new ArrayList<>();

	public void cadastrarDados() {
		Cliente cliente1 = new Cliente(UUID.randomUUID(), "Rafael", "pedido@gmail.com");
		Cliente cliente2 = new Cliente(UUID.randomUUID(), "Mathias", "ouryou@hotmail.com");
		clientes.add(cliente1);
		clientes.add(cliente2);
	}

	public void adicionarCliente() {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Nome do cliente: ");
		String nome = scanner.nextLine();

		System.out.print("Email do cliente: ");
		String email = scanner.nextLine();

		Cliente cliente = new Cliente(UUID.randomUUID(), nome, email);
		clientes.add(cliente);
		System.out.println("Cliente adicionado com sucesso!");
	}

	public List<Cliente> getClientes() {
		return clientes;
	}
}
