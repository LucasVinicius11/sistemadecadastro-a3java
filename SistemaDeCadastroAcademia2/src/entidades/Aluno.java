package entidades;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Aluno extends Pessoa {
    // Fields specific to the Aluno class
    private String atestadoMedico; // Medical certificate status
    private List<Exercicio> listaDeTreino; // List of exercises associated with the student

    // Static list to store all Aluno objects
    private static ArrayList<Aluno> listaAlunos = new ArrayList<>();

    // Default constructor
    public Aluno() {
    }

    // Constructor to initialize an Aluno object
    public Aluno(String nome, String cpf, int idade, String email, String telefone, String atestadoMedico, List<Exercicio> listaDeTreino) {
        super(nome, idade, cpf, email, telefone); // Call the constructor of the superclass Pessoa
        this.atestadoMedico = atestadoMedico;
        this.listaDeTreino = listaDeTreino;
    }

    // Getter for the medical certificate status
    public String getAtestadoMedico() {
        if (atestadoMedico.equalsIgnoreCase("n")) { // Check if the medical certificate indicates unfitness
            System.out.println("Você não está apto e não poderá ser nosso aluno!");
        }
        return atestadoMedico;
    }

    // Setter for the medical certificate status
    public void setAtestadoMedico(String atestadoMedico) {
        this.atestadoMedico = atestadoMedico;
    }

    // Getter for the list of exercises
    public List<Exercicio> getListaDeTreino() {
        return listaDeTreino;
    }

    // Setter for the list of exercises
    public void setListaDeTreino(List<Exercicio> listaDeTreino) {
        this.listaDeTreino = listaDeTreino;
    }

    // Override the toString method to return a string representation of the Aluno object
    @Override
    public String toString() {
        return "Aluno{" +
                "nome='" + getNome() + '\'' +
                ", idade=" + getIdade() +
                ", cpf='" + getCpf() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", telefone='" + getTelefone() + '\'' +
                ", atestadoMedico='" + atestadoMedico + '\'' +
                ", listaDeTreino=" + listaDeTreino +
                '}';
    }

    // Static method to get the list of all Aluno objects
    public static ArrayList<Aluno> getListaAlunos() {
        return listaAlunos;
    }

    // Method to remove a student from the list based on their CPF
    public void removerAlunoPorCpf() {
        // Placeholder for scanning user input; Scanner should be initialized outside this method
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter CPF to remove: ");
        String cpf = sc.nextLine(); // Note: This will throw a NullPointerException if Scanner is not initialized

        // Example static and dynamic arrays for handling students (not a recommended approach)
        String[] arrayEstatico = {"Ana", "Bruno", "Carlos", "Daniela", "Eduardo", "Fernanda", "Gabriel"};
        ArrayList<String> arrayDinamico = new ArrayList<>();
        for (String nome : arrayEstatico) {
            arrayDinamico.add(nome);
        }

        // Loop through the list of students to find and remove the student with the matching CPF
        for (Pessoa pessoa : listaAlunos) {
            if (pessoa.getCpf().equals(cpf)) {
                arrayDinamico.remove(pessoa.getNome()); // This line needs to find the index of the element to remove correctly
                System.out.println("Cancelando matricula de " + pessoa);
                return;
            }
        }

        System.out.println("Aluno com CPF " + cpf + " não encontrado.");
    }
}
