import entities.Admin;
import entities.Jogador;
import entities.Partida;
import entities.Pergunta;
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
                    System.out.println("Cadastrando Jogador...");

                    System.out.print("Digite o nome do jogador: ");
                    String nome = sc.nextLine();

                    System.out.print("Digite a senha do jogador: ");
                    String password = sc.nextLine();

                    Jogador jogador = new Jogador(UUID.randomUUID(), nome, password);
                    listaJogadores.add(jogador);

                    System.out.println(jogador);

                    System.out.println("Jogador cadastrado com sucesso!");

                    break;

                case 2:
                    System.out.println("Cadastrando Admin...");

                    System.out.println("Digite o nome do admin: ");
                    nome = sc.nextLine();

                    System.out.println("Digite a senha do admin: ");
                    password = sc.nextLine();

                    adminCadastro = new Admin(UUID.randomUUID(), nome, password);

                    System.out.println("Admin cadastrado com sucesso!");

                    break;

                case 3:
                    System.out.println("Criando Jogo...");

                    System.out.println("Somente um Admin pode criar um jogo");

                    System.out.println("Digite o nome e senha para se autenticar: ");
                    System.out.println("Nome: ");
                    nome = sc.nextLine();
                    System.out.println("Senha: ");
                    password = sc.nextLine();

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


                    adminCadastro.criarJogo(listaJogadores.size(), rodadas);


                    break;

                case 4:

                    System.out.println("Cadastrando Pergunta...");
                    System.out.println("Digite o nome e senha para se autenticar: ");
                    System.out.println("Nome: ");
                    nome = sc.nextLine();
                    System.out.println("Senha: ");
                    password = sc.nextLine();

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

                    //System.out.println("Digite o id da pergunta: ");
                    //int id = sc.nextInt();

                    //sc.nextLine();

                    System.out.println("Digite o enunciado da pergunta: ");
                    String enunciado = sc.nextLine();

                    System.out.println("Digite o numero de opcoes: ");
                    int numeroOpcoes = sc.nextInt();

                    sc.nextLine();

                    List<String> opcoes = new ArrayList<>();
                    for(int i = 0; i < numeroOpcoes; i++){
                        System.out.println("Digite uma opção de resposta (" + i + ")");
                        String opcao = sc.nextLine();
                        opcoes.add(opcao);
                    }

                    System.out.println("Digite qual delas é a resposta certa: (o index)");
                    int respostaCerta = sc.nextInt();

                    System.out.println("Digite a pontuação da pergunta: ");
                    int pontuacao = sc.nextInt();

                    System.out.println("Digite a dificuldade da pergunta: FACIL, MEDIO, DIFICIL");
                    String dificuldade = sc.next();

                    listaPerguntas.add(adminCadastro.cadastrarPergunta(enunciado, opcoes, opcoes.get(respostaCerta), pontuacao, Dificuldade.valueOf(dificuldade.toUpperCase())));

                    System.out.println("Pergunta Cadastrada com sucesso!");

                    break;

                case 5:
                    System.out.println("Iniciando a partida...");
                    System.out.println("Digite o nome e senha para se autenticar: ");
                    System.out.println("Nome: ");
                    nome = sc.nextLine();
                    System.out.println("Senha: ");
                    password = sc.nextLine();
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
                    qtdPartidas++;
                    Partida partida = new Partida(qtdPartidas, listaJogadores, listaPerguntas, new HashMap<Jogador, Integer>());

                    System.out.println("Partida iniciada com sucesso!");

                    for(int i = 0; i < listaJogadores.size(); i++){
                        System.out.println("Jogador " + (i+1) + ": " + listaJogadores.get(i));
                    }

                    for(int i = 1; i < listaPerguntas.size(); i++){
                        System.out.println("Pergunta " + (i+1) + ": " + listaPerguntas.get(i));
                        System.out.println("Resposta:");
                        for(int j = 0; j < listaJogadores.size(); j++){
                            System.out.println("Jogador " + (j+1) + ": ");
                            int resposta = sc.nextInt();
                            partida.registrarResposta(listaJogadores.get(j), resposta, listaPerguntas.get(i).getId());
                        }
                    }
                    System.out.println("Partida finalizada com sucesso!");

                    break;
                default:
                    System.out.println("Opção Invalida");
                    break;
            }
        }
        while (op != 0);
    }
}