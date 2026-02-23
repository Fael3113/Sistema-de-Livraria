# Sistema de Livraria

Sistema de gerenciamento de livraria desenvolvido em Java, permitindo o cadastro e controle de livros, autores e empréstimos.

## Estrutura do Projeto

Arquitetura em camadas

```
src/
├── service/
|   └── Biblioteca.java 
├── domain/
│   ├── Livro.java
│   ├── Autor.java
│   └── Emprestimo.java
├── service/
│   ├── LivroService.java
│   ├── AutorService.java
│   └── EmprestimoService.java
└── Main.java
```

## Funcionalidades

- Cadastro de autores
- Cadastro de livros vinculados a autores
- Realização de empréstimos
- Devolução de livros
- Busca de livros por título
- Listagem completa do acervo

## Modelo de Dados

**Autor**
- `autorId` — Identificador único (UUID)
- `nome` — Nome do autor
- `dataNascimento` — Data de nascimento

**Livro**
- `livroId` — Identificador único (UUID)
- `titulo` — Título do livro
- `autor` — Objeto do tipo Autor
- `isDisponivel` — Disponibilidade para empréstimo
- `dataCadastro` — Data de cadastro
- `dataAtualizacao` — Atualizado ao emprestar ou devolver

**Empréstimo**
- `emprestimoId` — Identificador único (UUID)
- `livro` — Objeto do tipo Livro
- `nomeCliente` — Nome do cliente
- `dataEmprestimo` — Data do empréstimo
- `dataDevolucao` — Data de devolução (nula se ainda não devolvido)

## Como executar

1. Clone o repositório:
```bash
git clone https://github.com/Fael3113/Sistema-de-Livraria.git
```

2. Abra o projeto em sua IDE (IntelliJ, Eclipse, etc.)

3. Execute a classe `Main.java`

4. Navegue pelo menu interativo:
```
=== BIBLIOTECA ===
1 - Adicionar Autor
2 - Adicionar Livro
3 - Adicionar Empréstimo
4 - Devolver Livro
5 - Buscar livro por título
6 - Listar tudo
0 - Sair
```

## Tecnologias

- Java 11
- UUID para geração de identificadores únicos
- LocalDate para manipulação de datas

## 📐 Arquitetura

O projeto segue o padrão **Service Layer**, separando as responsabilidades:

- **domain** — Classes de modelo (entidades)
- **service** — Regras de negócio e manipulação dos dados
- **controller** — Coordena os serviços e expõe o menu ao usuário

Projeto-Desafio de Sistema de Livraria proposto pelo RocketSeat: https://app.rocketseat.com.br/projetos/desafio-sistema-de-livraria?module_slug=sistema-de-livraria&origin=%2Fprojetos

Solução desenvolvida por Rafael de Melo Santiago
