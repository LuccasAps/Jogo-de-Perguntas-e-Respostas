import entities.Admin;
import entities.Jogador;
import entities.Partida;
import entities.Pergunta;
import entities.Jogo;
import entities.enums.Dificuldade;
import validations.NomeOuSenhaIncorretos;
import validations.ValidacaoAdmin;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Jogador> listaJogadores = new ArrayList<>();
        List<Pergunta> listaPerguntas = new ArrayList<>();
        Admin adminCadastro = null;
        Jogo jogoAtual = null;
        int qtdPartidas = 0;

        System.out.println("BEM VINDO AO JOGO!");

        int op;
        do {
            System.out.println("1 - Cadastrar Jogador");
            System.out.println("2 - Cadastrar Admin");
            System.out.println("3 - Criar Jogo");
            System.out.println("4 - Cadastrar Pergunta");
            System.out.println("5 - Iniciar Partida");
            System.out.println("0 - Sair");

            op = sc.nextInt();
            sc.nextLine();
            switch (op) {
                case 1:
                    try{
                        System.out.println("Cadastrando Jogador...");
                        System.out.print("Digite o nome do jogador: ");
                        String nome = sc.nextLine();
                        System.out.print("Digite a senha do jogador: ");
                        String password = sc.nextLine();

                        Jogador jogador = new Jogador(UUID.randomUUID(), nome, password);
                        listaJogadores.add(jogador);
                        System.out.println(jogador);
                        System.out.println("Jogador cadastrado com sucesso!");

                    }catch (NomeOuSenhaIncorretos e){
                        throw new NomeOuSenhaIncorretos(e.getMessage());
                    }finally {
                        break;
                    }
                case 2:
                    try{
                        System.out.println("Cadastrando Admin...");
                        System.out.println("Digite o nome do admin: ");
                        String nome = sc.nextLine();
                        System.out.println("Digite a senha do admin: ");
                        String password = sc.nextLine();

                        adminCadastro = new Admin(UUID.randomUUID(), nome, password);
                        System.out.println("Admin cadastrado com sucesso!");
                    }catch (NomeOuSenhaIncorretos e){
                        throw new NomeOuSenhaIncorretos(e.getMessage());
                    }finally {
                        break;
                    }


                case 3:
                    try{
                        System.out.println("Criando Jogo...");
                        System.out.println("Somente um Admin pode criar um jogo");
                        System.out.println("Digite o nome e senha para se autenticar: ");
                        System.out.println("Nome: ");
                        String nome = sc.nextLine();
                        System.out.println("Senha: ");
                        String password = sc.nextLine();

                        if (adminCadastro == null) {
                            System.out.println("Cadastre o Admin primeiro!");
                            break;
                        }
                        try {
                            if (!ValidacaoAdmin.validacaoNomeESenha(nome, password, adminCadastro)) {
                                throw new NomeOuSenhaIncorretos("Nome ou senha incorretos");
                            }
                        } catch (NomeOuSenhaIncorretos e) {
                            System.out.println(e.getMessage());
                            break;
                        }

                        System.out.println("Autenticado com sucesso");
                        System.out.println("Criando Jogo: ");
                        System.out.println("Digite o numero de rodadas: ");
                        int rodadas = sc.nextInt();
                        sc.nextLine();

                        jogoAtual = adminCadastro.criarJogo(listaJogadores.size(), rodadas);
                        for (Jogador j : listaJogadores) {
                            jogoAtual.adicionarJogador(j);
                        }
                        System.out.println("Jogo criado com sucesso!");
                    }catch (RuntimeException e){
                        e.getMessage();
                    }finally {
                        break;
                    }

                case 4:
                    try{
                        System.out.println("Cadastrando Pergunta...");
                        System.out.println("Digite o nome e senha para se autenticar: ");
                        System.out.println("Nome: ");
                        String nome = sc.nextLine();
                        System.out.println("Senha: ");
                        String password = sc.nextLine();

                        if (adminCadastro == null) {
                            System.out.println("Cadastre o Admin primeiro!");
                            break;
                        }
                        try {
                            if (!ValidacaoAdmin.validacaoNomeESenha(nome, password, adminCadastro)) {
                                throw new NomeOuSenhaIncorretos("Nome ou senha incorretos");
                            }
                        } catch (NomeOuSenhaIncorretos e) {
                            System.out.println(e.getMessage());
                            break;
                        }

                        System.out.println("Autenticado com sucesso");
                        System.out.println("Cadastrando Pergunta: ");
                        System.out.println("Digite o id da pergunta: ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Digite o enunciado da pergunta: ");
                        String enunciado = sc.nextLine();
                        System.out.println("Digite o numero de opcoes: ");
                        int numeroOpcoes = sc.nextInt();
                        sc.nextLine();

                        List<String> opcoes = new ArrayList<>();
                        for (int i = 0; i < numeroOpcoes; i++) {
                            System.out.println("Digite uma opção de resposta (" + i + ")");
                            String opcao = sc.nextLine();
                            opcoes.add(opcao);
                        }

                        System.out.println("Digite qual delas é a resposta certa: (o index)");
                        int respostaCertaIdx = sc.nextInt();
                        System.out.println("Digite a pontuação da pergunta: ");
                        int pontuacao = sc.nextInt();
                        System.out.println("Digite a dificuldade da pergunta: FACIL, MEDIO, DIFICIL");
                        String dificuldade = sc.next();

                        Pergunta pergunta = adminCadastro.cadastrarPergunta(id, enunciado, opcoes,
                                opcoes.get(respostaCertaIdx), pontuacao, Dificuldade.valueOf(dificuldade.toUpperCase()));
                        listaPerguntas.add(pergunta);
                        if (jogoAtual != null) {
                            jogoAtual.adicionarPergunta(pergunta);
                        }
                        System.out.println("Pergunta Cadastrada com sucesso!");
                    } catch (RuntimeException e) {

                    }finally {
                        break;
                    }

                case 5:
                    try{
                        System.out.println("Iniciando a partida...");
                        qtdPartidas++;
                        List<Pergunta> perguntasPartida = jogoAtual.getPerguntas().subList(0, jogoAtual.getNumeroRodadas());
                        Partida partida = new Partida(qtdPartidas, jogoAtual.getJogadores(), perguntasPartida, new HashMap<>());
                        System.out.println("Partida iniciada com sucesso!");
                        System.out.println("Bem-vindo à partida! Responda às perguntas escolhendo o número da opção correta.");


                        System.out.println("\nJogadores na partida:");
                        for (int i = 0; i < partida.getJogadores().size(); i++) {
                            System.out.println(partida.getJogadores().get(i));
                        }


                        for (int i = 0; i < partida.getPerguntas().size(); i++) {
                            System.out.println("\n--- Pergunta " + (i + 1) + " ---");
                            System.out.println(partida.getPerguntas().get(i));
                            for (int j = 0; j < partida.getJogadores().size(); j++) {
                                System.out.print("Jogador " + partida.getJogadores().get(j).getNome() + ", sua resposta: ");
                                int resposta = sc.nextInt();
                                int numOpcoes = partida.getPerguntas().get(i).getOpcoes().size();
                                while (resposta < 0 || resposta >= numOpcoes) {
                                    System.out.println("Resposta inválida. Digite um número entre 0 e " + (numOpcoes - 1));
                                    resposta = sc.nextInt();
                                }
                                partida.registrarResposta(partida.getJogadores().get(j), resposta, i);

                            }
                        }
                      
                        System.out.println("\nPartida finalizada com sucesso!");
                        System.out.println("Resultados da partida:");
                        for (Jogador j : partida.getJogadores()) {
                            System.out.println(j);
                        }
                    } catch (RuntimeException e) {

                    }finally {
                        break;
                    }

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção Invalida");
                    break;
            }
        } while (op != 0);
        sc.close();
    }
}