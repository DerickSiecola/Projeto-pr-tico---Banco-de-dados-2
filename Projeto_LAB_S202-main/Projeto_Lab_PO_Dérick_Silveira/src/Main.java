import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Criando um Arquivo
        Arquivo arq = new Arquivo();
        ArrayList<Clube> clubes = new ArrayList<>(); // Lista de clubes

        // Apresentando as informações dos jogadores

        // Criando um menu para deixar a aplicação dinâmica

        // Controladora do while
        boolean flag = true;

        // Opção de escolha do usuário
        int opcao;

        // Entrada e saída de dados
        Scanner sc = new Scanner(System.in);

        while(flag){
            ArrayList<Jogador> jogadoresEncontrados = arq.lerArquivos();

            System.out.println("+++++++++++ BEM VINDO(A) AO MENU DO OLHEIRO(A) PARA OBSERVAÇÃO DE JOGADORES");
            System.out.println("1- Listar um novo jogador observado");
            System.out.println("2- Lista de jogadores observados");
            System.out.println("3- SAIR DA APLICAÇÃO");
            System.out.println("4- Remover jogador da lista");
            System.out.println("5- Atualizar salário e valor de mercado de um jogador da lista: ");
            System.out.println("6- Listar jogadores de um clube: "); // Nova opção
            opcao = sc.nextInt(); // Entrando com a opção do usuário
            sc.nextLine(); // Limpando o buffer

            switch (opcao){
                case 1:
                    // Adicionando um jogador no Arquivo
                    String nome;
                    String clube;
                    double salario;
                    double valor;
                    int idade;
                    String posicao;

                    System.out.println("Nome e Sobrenome: ");
                    nome = sc.nextLine();

                    System.out.println("Clube atual: ");
                    clube = sc.nextLine();

                    System.out.println("Posição: ");
                    posicao = sc.nextLine();

                    System.out.println("Salário: ");
                    salario = sc.nextDouble();

                    System.out.println("Valor de mercado: ");
                    valor = sc.nextDouble();

                    System.out.println("Idade: ");
                    idade = sc.nextInt();

                    // Procurar se o clube já existe
                    Clube clubeEncontrado = null;
                    for (Clube c : clubes) {
                        if (c.getNome().equalsIgnoreCase(clube)) {
                            clubeEncontrado = c;
                            break;
                        }
                    }

                    if (clubeEncontrado == null) {
                        // Se o clube não existe, criar um novo
                        clubeEncontrado = new Clube(clube);
                        clubes.add(clubeEncontrado);
                    }

                    // Criando o jogador
                    Jogador jog = new Jogador(nome, clubeEncontrado, salario, valor, idade, posicao);

                    // Escrevendo as informações deste jogador dentro do arquivo
                    arq.escreverArquivo(jog);
                    clubeEncontrado.adicionarJogador(jog); // Adicionando jogador ao clube
                    break;
                case 2:
                    // Apresentando as informações dos jogadores observados
                    for (Jogador jogador : jogadoresEncontrados) {
                        System.out.println("NOME: " + jogador.getNome());
                        System.out.println("CLUBE ATUAL: " + jogador.getClube().getNome());
                        System.out.println("SALÁRIO: " + jogador.getSalario());
                        System.out.println("VALOR DE MERCADO: " + jogador.getValor());
                        System.out.println("IDADE: " + jogador.getIdade());
                        System.out.println("POSIÇÃO: " + jogador.getPosicao());
                    }
                    break;
                case 3:
                    flag = false;
                    break;
                case 4:
                    // Remover jogador da lista
                    System.out.println("Digite o nome do jogador a ser excluído da lista:");
                    String nomeExcluir = sc.nextLine();

                    // Buscar o jogador a ser excluído
                    Jogador jogadorExcluir = null;
                    for (Jogador jogador : jogadoresEncontrados) {
                        if (jogador.getNome().equals(nomeExcluir)) {
                            jogadorExcluir = jogador;
                            break;
                        }
                    }

                    // Verificar se o jogador foi encontrado e removê-lo da lista
                    if (jogadorExcluir != null) {
                        jogadoresEncontrados.remove(jogadorExcluir);
                        arq.atualizarArquivo(jogadoresEncontrados);
                        jogadorExcluir.getClube().removerJogador(jogadorExcluir); // Removendo jogador do clube
                        System.out.println("Jogador excluído com sucesso!");
                    } else {
                        System.out.println("Jogador não encontrado.");
                    }
                    break;

                case 5:
                    // Ajustar valor e salário de um jogador existente
                    System.out.println("Digite o nome do jogador a ser ajustado:");
                    String nomeAjustar = sc.nextLine();

                    // Buscar o jogador a ser ajustado
                    Jogador jogadorAjustar = null;
                    for (Jogador jogador : jogadoresEncontrados) {
                        if (jogador.getNome().equals(nomeAjustar)) {
                            jogadorAjustar = jogador;
                            break;
                        }
                    }

                    // Verificar se o jogador foi encontrado e ajustar os valores
                    if (jogadorAjustar != null) {
                        System.out.println("Digite o novo valor de mercado:");
                        double novoValor = sc.nextDouble();
                        jogadorAjustar.setValor(novoValor);

                        System.out.println("Digite o novo salário:");
                        double novoSalario = sc.nextDouble();
                        jogadorAjustar.setSalario(novoSalario);

                        // Atualizar o arquivo com as informações atualizadas do jogador
                        arq.atualizarArquivo(jogadoresEncontrados);
                        System.out.println("Jogador ajustado com sucesso!");
                    } else {
                        System.out.println("Jogador não encontrado.");
                    }
                    break;

                case 6:
                    // Listar jogadores de um clube
                    System.out.println("Digite o nome do clube:");
                    String nomeClube = sc.nextLine();

                    // Buscar o clube
                    Clube clubeBusca = null;
                    for (Clube c : clubes) {
                        if (c.getNome().equalsIgnoreCase(nomeClube)) {
                            clubeBusca = c;
                            break;
                        }
                    }

                    // Verificar se o clube foi encontrado e listar os jogadores
                    if (clubeBusca != null) {
                        System.out.println("Jogadores do clube " + clubeBusca.getNome() + ":");
                        for (Jogador jogador : clubeBusca.getJogadores()) {
                            System.out.println("Nome: " + jogador.getNome());
                            System.out.println("Posição: " + jogador.getPosicao());
                            System.out.println("Salário: " + jogador.getSalario());
                            System.out.println("Valor de mercado: " + jogador.getValor());
                            System.out.println("Idade: " + jogador.getIdade());
                            System.out.println();
                        }
                    } else {
                        System.out.println("Clube não encontrado.");
                    }
                    break;
            }
        }

        sc.close(); // Fechando a entrada de dados

    }
}
