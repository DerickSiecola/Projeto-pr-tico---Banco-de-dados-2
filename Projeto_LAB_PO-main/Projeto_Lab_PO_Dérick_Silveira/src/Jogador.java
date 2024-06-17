public class Jogador {
    // Atributos do jogador
    private String nome;
    private Clube clube;
    private double salario;
    private double valor;
    private int idade;
    private String posicao;

    // Construtor

    public Jogador(String nome, Clube clube, double salario, double valor, int idade, String posicao) {
        this.nome = nome;
        this.clube = clube;
        this.salario = salario;
        this.valor = valor;
        this.idade = idade;
        this.posicao = posicao;
    }

    // Getters e Setters

    public String getNome() {
        return nome;
    }

    public Clube getClube() {
        return clube;
    }

    public double getSalario() {
        return salario;
    }

    public double getValor() {
        return valor;
    }

    public int getIdade() {
        return idade;
    }

    public String getPosicao() {
        return posicao;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
