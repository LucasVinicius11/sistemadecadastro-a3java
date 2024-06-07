package executaveis;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entidades.Aluno;
import entidades.Exercicio;
import entidades.Personal;

public class Programa {
	// Listas estáticas para armazenar objetos de alunos, personal trainers e
	// exercícios
	private static ArrayList<Aluno> listaAlunos = new ArrayList<>();
	private static ArrayList<Personal> listaPersonais = new ArrayList<>();
	private static ArrayList<Exercicio> listaDeExercicio = new ArrayList<>();

	public static void main(String[] args) {
		// Inicializa as listas de exercícios, alunos e personal trainers
		exerciciosCadastrados();
		alunosCadastrados();
		personaisCadastrados();

		Scanner sc = new Scanner(System.in); // Cria um scanner para entrada do usuário
		int opcao;
		int opcao2;

		// Loop principal do programa
		do {
			// Menu principal
			System.out.println("\n-----------Academia PeriGym-----------");
			System.out.println("1. Aluno");
			System.out.println("2. Personal");
			System.out.println("3. Exercicios");
			System.out.println("4. Sair");
			System.out.print("Escolha uma opção: ");
			opcao = sc.nextInt();
			sc.nextLine(); // Consumir a nova linha após a leitura de um número inteiro

			switch (opcao) {
			case 1: // Opções relacionadas a alunos
				do {
					// Menu de cadastro de alunos
					System.out.println("\n-----------Sistema de Cadastro de Alunos-----------");
					System.out.println("1. Cadastrar novo aluno");
					System.out.println("2. Listas De Alunos Cadastradas");
					System.out.println("3. Buscar Aluno por CPF");
					System.out.println("4. Cancelar Matricula");
					System.out.println("5. Adicionar Exercício a Aluno");
					System.out.println("6. Sair");
					System.out.print("Escolha uma opção: ");
					opcao2 = sc.nextInt();
					sc.nextLine();

					switch (opcao2) {
					case 1:
						cadastrarAluno(sc);
						break;
					case 2:
						listaAlunos();
						break;
					case 3:
						buscarAlunoPorCpf(sc);
						break;
					case 4:
						removerAlunoPorCpf(sc);
						break;
					case 5:
						adicionarExercicioAluno(sc);
						break;
					case 6:
						System.out.println("Saindo do sistema...");
						break;
					default:
						System.out.println("Opção inválida. Tente novamente.");
					}
				} while (opcao2 != 6);
				break;

			case 2: // Opções relacionadas a personal trainers
				do {
					// Menu de cadastro de personal trainers
					System.out.println("\n-----------Sistema de Cadastro de Personais-----------");
					System.out.println("1. Cadastrar novo Personal");
					System.out.println("2. Listas De Personais Cadastradas");
					System.out.println("3. Buscar Personal por CPF");
					System.out.println("4. Demitir Personal");
					System.out.println("5. Adicionar Aluno ao Personal");
					System.out.println("6. Sair");
					System.out.print("Escolha uma opção: ");
					opcao2 = sc.nextInt();
					sc.nextLine();

					switch (opcao2) {
					case 1:
						cadastrarPersonal(sc);
						break;
					case 2:
						listaPersonais();
						break;
					case 3:
						buscarPersonalPorCpf(sc);
						break;
					case 4:
						removerPersonalPorCpf(sc);
						break;
					case 5:
						adicionarAlunoAoPersonal(sc);
						break;
					case 6:
						System.out.println("Saindo do sistema...");
						break;
					default:
						System.out.println("Opção inválida. Tente novamente.");
					}
				} while (opcao2 != 6);
				break;
			}
		} while (opcao != 4); // Continua executando até que o usuário escolha sair

		sc.close(); // Fecha o scanner
	}

	private static void exerciciosCadastrados() {
		// Adiciona exercícios à lista de exercícios
		listaDeExercicio.add(new Exercicio("elevação lateral"));
		listaDeExercicio.add(new Exercicio("supino com barra"));
		listaDeExercicio.add(new Exercicio("Leg Press"));
		listaDeExercicio.add(new Exercicio("Panturrilha sentado"));
		listaDeExercicio.add(new Exercicio("Agachamento"));
		listaDeExercicio.add(new Exercicio("Cadeira adutora"));
		listaDeExercicio.add(new Exercicio("Remada baixa"));
	}

	private static void alunosCadastrados() {
		// Adiciona alunos à lista de alunos
		listaAlunos
				.add(new Aluno("Ana", "123.456.789-00", 25, "ana@example.com", "1111-1111", "APTO", new ArrayList<>()));
		listaAlunos.add(
				new Aluno("Bruno", "234.567.890-11", 30, "bruno@example.com", "2222-2222", "APTO", new ArrayList<>()));
		listaAlunos.add(new Aluno("Carlos", "345.678.901-22", 28, "carlos@example.com", "3333-3333", "APTO",
				new ArrayList<>()));
		listaAlunos.add(new Aluno("Daniela", "456.789.012-33", 22, "daniela@example.com", "4444-4444", "APTO",
				new ArrayList<>()));
		listaAlunos.add(new Aluno("Eduardo", "567.890.123-44", 35, "eduardo@example.com", "5555-5555", "APTO",
				new ArrayList<>()));
		listaAlunos.add(new Aluno("Fernanda", "678.901.234-55", 27, "fernanda@example.com", "6666-6666", "APTO",
				new ArrayList<>()));
		listaAlunos.add(new Aluno("Gabriel", "789.012.345-66", 32, "gabriel@example.com", "7777-7777", "APTO",
				new ArrayList<>()));
	}


	private static void cadastrarAluno(Scanner sc) {
		// Solicita informações para cadastrar um novo aluno
		System.out.println();
		System.out.print("Digite o nome: ");
		String nome = sc.nextLine();
		System.out.print("Digite a idade: ");
		int idade = sc.nextInt();
		sc.nextLine(); // Consumir a nova linha pendente
		System.out.print("Digite o CPF: ");
		String cpf = sc.nextLine();
		System.out.print("Digite o email: ");
		String email = sc.nextLine();
		System.out.print("Digite o telefone: ");
		String telefone = sc.nextLine();
		System.out.print("Digite se o aluno está apto a fazer exercicios: ");
		String atestadoMedico = sc.nextLine();

		// Cria um novo objeto Aluno com as informações fornecidas e adiciona à lista de
		// alunos
		Aluno aluno = new Aluno(nome, cpf, idade, email, telefone, atestadoMedico, new ArrayList<>());
		listaAlunos.add(aluno);
		System.out.println("Aluno cadastrado!");
	}

	private static void listaAlunos() {
		// Exibe uma tabela com os detalhes de todos os alunos cadastrados
		System.out.println("-----------------------------------------------------------------");
		System.out.printf("%-20s %-10s %-20s %-10s\n", "Nome", "Idade", "CPF", "Exercício");
		System.out.println("-----------------------------------------------------------------");
		for (Aluno aluno : listaAlunos) {
			// Formata a lista de exercícios, mostrando "Nenhum" se não houver exercícios
			String exercicios = aluno.getListaDeTreino().isEmpty() ? "Nenhum" : aluno.getListaDeTreino().toString();
			System.out.printf("%-20s %-10d %-20s %-10s\n", aluno.getNome(), aluno.getIdade(), aluno.getCpf(),
					exercicios);
		}
		System.out.println("-----------------------------------------------------------------");
	}

	private static void buscarAlunoPorCpf(Scanner sc) {
		// Permite buscar um aluno pelo seu CPF
		System.out.print("Digite o CPF do aluno: ");
		String cpf = sc.nextLine();
		Aluno aluno = buscarAlunoPorCpf(cpf);
		if (aluno == null) {
			System.out.println("Aluno não encontrado.");
		} else {
			System.out.println(aluno);
		}
	}

	private static void removerAlunoPorCpf(Scanner sc) {
		// Remove um aluno da lista de alunos pelo seu CPF
		System.out.print("Digite o CPF do aluno: ");
		String cpf = sc.nextLine();
		Aluno aluno = buscarAlunoPorCpf(cpf);
		if (aluno == null) {
			System.out.println("Aluno não encontrado.");
		} else {
			listaAlunos.remove(aluno);
			System.out.println("Aluno removido.");
		}
	}

	private static Aluno buscarAlunoPorCpf(String cpf) {
		// Busca um aluno na lista de alunos pelo seu CPF e retorna o aluno, se
		// encontrado
		for (Aluno aluno : listaAlunos) {
			if (aluno.getCpf().equals(cpf)) {
				return aluno;
			}
		}
		return null;
	}

	private static void listarExercicios() {
		// Exibe a lista de exercícios disponíveis para os alunos
		System.out.println("Lista de Exercícios Disponíveis:");
		for (Exercicio exercicio : listaDeExercicio) {
			System.out.println(exercicio.getNome());
		}
	}

	private static void adicionarExercicioAluno(Scanner sc) {
		// Adiciona um exercício a um aluno específico
		System.out.print("Digite o CPF do aluno: ");
		String cpf = sc.nextLine();
		Aluno aluno = buscarAlunoPorCpf(cpf);
		if (aluno == null) {
			System.out.println("Aluno não encontrado.");
			return;
		}

		listarExercicios();
		System.out.print("Digite o nome do exercício a ser adicionado: ");
		String nomeExercicio = sc.nextLine();

		for (Exercicio exercicio : listaDeExercicio) {
			if (exercicio.getNome().equalsIgnoreCase(nomeExercicio)) {
				aluno.getListaDeTreino().add(exercicio);
				System.out.println("Exercício adicionado ao aluno " + aluno.getNome());
				return;
			}
		}

		System.out.println("Exercício não encontrado.");
	}

	private static void personaisCadastrados() {
		// Inicializa e adiciona alguns personal trainers ao sistema
		Personal maria = new Personal("Maria", "321.456.789-00", 25, "maria@example.com", "3333-3333", 1.412,
				new ArrayList<>());
		Personal joao = new Personal("João", "432.567.890-11", 30, "joao@example.com", "5555-5555", 1.412,
				new ArrayList<>());
		Personal mario = new Personal("Mário", "543.678.901-22", 28, "mario@example.com", "8888-8888", 1.412,
				new ArrayList<>());
		Personal danilo = new Personal("Danilo", "654.789.012-33", 22, "danilo@example.com", "9999-9999", 1.412,
				new ArrayList<>());
		Personal flavio = new Personal("Flávio", "765.890.123-44", 35, "flavio@example.com", "6666-6666", 1.412,
				new ArrayList<>());
		Personal giovana = new Personal("Giovana", "876.901.234-55", 27, "giovana@example.com", "1111-1111", 1.412,
				new ArrayList<>());
		Personal leandra = new Personal("Leandra", "987.012.345-66", 32, "leandra@example.com", "2222-2222", 1.412,
				new ArrayList<>());

		listaPersonais.add(maria);
		listaPersonais.add(joao);
		listaPersonais.add(mario);
		listaPersonais.add(danilo);
		listaPersonais.add(flavio);
		listaPersonais.add(giovana);
		listaPersonais.add(leandra);
	}

	private static void cadastrarPersonal(Scanner sc) {
	    // Verifica se o usuário tem privilégios de professor
	    if (!Personal.Professor()) {
	        return;
	    }

	    // Solicita informações para cadastrar um novo personal trainer
	    System.out.println("Digite o nome do personal: ");
	    String nome = sc.nextLine();
	    System.out.print("Digite a idade do personal: ");
	    int idade = sc.nextInt();
	    sc.nextLine(); // Consumir a nova linha pendente
	    System.out.print("Digite o CPF do personal: ");
	    String cpf = sc.nextLine();
	    System.out.print("Digite o email do personal: ");
	    String email = sc.nextLine();
	    System.out.print("Digite o telefone do personal: ");
	    String telefone = sc.nextLine();
	    System.out.print("Quanto custa a hora de trabalho do personal? ");
	    Double precoHora = sc.nextDouble();
	    System.out.print("Quantas horas irá trabalhar o personal? ");
	    int horas = sc.nextInt();
	    sc.nextLine(); // Consumir a nova linha pendente

	    // Calcula o salário do personal trainer
	    Double salario = Personal.calcularSalario(precoHora, horas);
	    // Cria um novo objeto Personal e adiciona à lista de personals
	    Personal personal = new Personal(nome, cpf, idade, email, telefone, salario, new ArrayList<>());
	    listaPersonais.add(personal);
	    System.out.println("Personal cadastrado!");
	}

	private static void listaPersonais() {
	    // Exibe uma tabela com os detalhes de todos os personal trainers cadastrados
	    System.out.println("--------------------------------------------------------");
	    System.out.printf("%-20s %-10s %-20s %-10s %-20s\n", "Nome", "Idade", "CPF", "Salário", "Alunos Associados");
	    System.out.println("--------------------------------------------------------");
	    for (Personal personal : listaPersonais) {
	        // Cria uma lista de informações sobre os alunos associados ao personal
	        StringBuilder alunosInfo = new StringBuilder();
	        for (Aluno aluno : personal.getListaAlunos()) {
	            alunosInfo.append("[ " + aluno.getNome() + " - " + aluno.getCpf() + "], ");
	        }
	        String alunos = alunosInfo.length() > 0 ? alunosInfo.substring(0, alunosInfo.length() - 2) : "Nenhum";
	        System.out.printf("%-20s %-10d %-20s %-10s %-20s\n", personal.getNome(), personal.getIdade(),
	                personal.getCpf(), personal.getSalario(), alunos);
	    }
	    System.out.println("--------------------------------------------------------");
	}

	private static String getNomesECpfDosAlunos(List<Aluno> alunos) {
	    // Retorna uma string com os nomes e CPFs dos alunos
	    StringBuilder sb = new StringBuilder();
	    for (Aluno aluno : alunos) {
	        sb.append("[ " + aluno.getNome() + ", CPF: " + aluno.getCpf() + " ]");
	    }
	    return sb.toString();
	}

	private static Personal buscarPersonalPorCpf(String cpf) {
	    // Busca um personal trainer na lista pelo CPF
	    for (Personal personal : listaPersonais) {
	        if (personal.getCpf().equals(cpf)) {
	            return personal;
	        }
	    }
	    System.out.println("Personal não encontrado.");
	    return null;
	}

	private static void buscarPersonalPorCpf(Scanner sc) {
	    // Solicita o CPF do personal para busca
	    System.out.print("Digite o CPF do Personal: ");
	    String cpf = sc.nextLine();
	    Personal personal = buscarPersonalPorCpf(cpf);
	    if (personal == null) {
	        System.out.println("Personal não encontrado.");
	    } else {
	        System.out.println(personal);
	    }
	}

	private static void adicionarAlunoAoPersonal(Scanner sc) {
	    // Adiciona um aluno ao personal trainer
	    System.out.println("Digite o CPF do personal: ");
	    String cpfPersonal = sc.nextLine();
	    Personal personal = buscarPersonalPorCpf(cpfPersonal);
	    if (personal == null) {
	        System.out.println("Personal não encontrado.");
	        return;
	    }
	    listaAlunos();
	    System.out.println("Digite o CPF do aluno a ser adicionado: ");
	    String cpfAluno = sc.nextLine();
	    Aluno aluno = null;
	    for (Aluno a : listaAlunos) {
	        if (a.getCpf().equals(cpfAluno)) {
	            aluno = a;
	            break;
	        }
	    }
	    if (aluno == null) {
	        System.out.println("Aluno não encontrado.");
	        return;
	    }
	    personal.getListaAlunos().add(aluno);
	    System.out.println("Aluno " + aluno.getNome() + " adicionado ao Personal " + personal.getNome());
	}

	private static void removerPersonalPorCpf(Scanner sc) {
	    // Remove um personal trainer da lista pelo CPF
	    System.out.print("Digite o CPF do personal a ser removido: ");
	    String cpf = sc.nextLine();

	    // Confirmação de remoção
	    System.out.println("Você tem certeza que quer remover? S / N");
	    char remove = sc.next().charAt(0);
	    sc.nextLine(); // Consumir a nova linha pendente

	    if (remove == 'S' || remove == 's') {
	        Personal personalRemover = null;
	        for (Personal personal : listaPersonais) {
	            if (personal.getCpf().equals(cpf)) {
	                personalRemover = personal;
	                break;
	            }
	        }

	        if (personalRemover != null) {
	            listaPersonais.remove(personalRemover);
	            System.out.println("Personal " + personalRemover.getNome() + " demitido. Obrigado pela colaboração!");
	        } else {
	            System.out.println("Personal não encontrado.");
	        }
	    }
	}

	public static void main() {
	    // Exemplo de uso da remoção de aluno pelo CPF
	    Aluno aluno = new Aluno();
	    aluno.removerAlunoPorCpf();
	}

	public static void java() {
	    // Exemplo de uso da remoção de personal pelo CPF
	    Personal personal = new Personal();
	    personal.removerPersonalPorCpf();
	}
	
}
