package entidades;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Personal extends Pessoa {
    private Double salario; // Salary of the personal trainer
    private List<Aluno> listaAlunos; // List of students associated with the personal trainer

    // Static list to store all Personal objects
    private static ArrayList<Personal> listaPersonais = new ArrayList<>();

    // Default constructor initializing the list of students
    public Personal() {
        super();
        listaAlunos = new ArrayList<>();
    }

    // Constructor to initialize a Personal object with specific attributes
    public Personal(String nome, String cpf, Integer idade, String email, String telefone, Double salario, List<Aluno> listaAlunos) {
        super(nome, idade, cpf, email, telefone); // Call the superclass constructor
        this.salario = salario;
        this.listaAlunos = listaAlunos;
    }

    // Getter for the salary
    public Double getSalario() {
        return salario;
    }

    // Setter for the salary
    public void setSalario(Double salario) {
        this.salario = salario;
    }

    // Getter for the list of Personal objects
    public static ArrayList<Personal> getListaPersonais() {
        return listaPersonais;
    }

    // Getter for the list of students associated with this personal trainer
    public List<Aluno> getListaAlunos() {
        return listaAlunos;
    }

    // Method to determine if the trainer has a Bachelor's degree
    public static boolean Professor() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Você tem Bacharelado no Currículo? S / N");
        char professor = sc.next().charAt(0); // Read the user's input
        if (professor == 'S' || professor == 's') { // Check if the input is 'S' or 's'
            System.out.println("Você está contratado!!");
            return true;
        } else {
            System.out.println("Você ainda não tem competência para atuar na área!");
            return false;
        }
    }

    // Method to remove a personal trainer from the list based on their CPF
    public void removerPersonalPorCpf() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter CPF to remove: ");
        String cpf = sc.nextLine(); // Read the CPF input

        // Loop through the list of personal trainers to find and remove the one with the matching CPF
        for (Personal personal : listaPersonais) {
            if (personal.getCpf().equals(cpf)) {
                listaPersonais.remove(personal); // Remove the personal trainer from the list
                System.out.println("Cancelando matrícula de " + personal);
                return;
            }
        }
        System.out.println("CPF não encontrado.");
    }

    // Method to calculate the salary based on hourly rate and hours worked
    public static Double calcularSalario(Double precoHora, int horas) {
        return precoHora * horas;
    }

    // Override the toString method to return a string representation of the Personal object
    @Override
    public String toString() {
        return "Personal [" +
                "nome='" + getNome() + '\'' +
                ", idade=" + getIdade() +
                ", cpf='" + getCpf() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", telefone='" + getTelefone() + '\'' +
                ", salario='" + salario + '\'' +
                ", listaAlunos=" + listaAlunos +
                ']';
    }
}
