package entidades;

public class Exercicio {
    // Private field to store the name of the exercise
    private String nome;

    // Constructor to initialize the exercise with a name
    public Exercicio(String nome) {
        this.nome = nome;
    }
    
    // Getter method to return the name of the exercise
    public String getNome() {
        return nome;
    }

    // Setter method to set the name of the exercise
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Override the toString method to provide a string representation of the exercise
    @Override
    public String toString() {
        return nome; // Returns the name of the exercise
    }
}


