import java.util.ArrayList;

public class Clube {
    private String nome;
    private ArrayList<Jogador> jogadores;

    public Clube(String nome) {
        this.nome = nome;
        this.jogadores = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void adicionarJogador(Jogador jogador) {
        jogadores.add(jogador);
    }

    public void removerJogador(Jogador jogador) {
        jogadores.remove(jogador);
    }

    public ArrayList<Jogador> getJogadores() {
        return jogadores;
    }
}
