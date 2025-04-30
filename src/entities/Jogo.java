package entities;

import java.util.ArrayList;
import java.util.List;

public class Jogo {
    private int numeroParticipantes;
    private int numeroRodadas;
    private List<String> assuntos;
    private List<Pergunta>perguntas;
    private List<Jogador>jogadores;
    private boolean jogoEmAndamento;
    private int rodadaAtual;

    public Jogo(int numeroParticipantes, int numeroRodadas) {
        this.numeroParticipantes = numeroParticipantes;
        this.numeroRodadas = numeroRodadas;
        this.assuntos = new ArrayList<>();
        this.perguntas = new ArrayList<>();
        this.jogadores = new ArrayList<>();
        this.jogoEmAndamento = false;
        this.rodadaAtual = 0;
    }

    public void iniciarJogo(){
        if(jogadores.size() != numeroParticipantes){
            throw new IllegalStateException("Número de jogadores não corresponde ao " +
                    "número de participantes definido");
        }

        if(perguntas.size() <numeroRodadas){
            throw new IllegalStateException("Numero de perguntas insuficiente para o número de rodadas");
        }

        for(Jogador jogador : jogadores){
            jogador.setPontuacao(0);
        }

        jogoEmAndamento = true;
        rodadaAtual = 1;
        System.out.println("Jogo iniciando com "+numeroParticipantes+" participantes e "+ numeroRodadas +" rodadas");
    }

    public void finalizarJogo(){
        if(!jogoEmAndamento){
            throw new IllegalStateException("O jogo não está em andamento");
        }

        //encontra o jogador com maior pontuacao
        Jogador vencedor = null ;
        int maiorPontuacao = -1;

        for(Jogador jogador : jogadores){
            if(jogador.getPontuacao() > maiorPontuacao){
                maiorPontuacao = jogador.getPontuacao();
                vencedor = jogador;
            }
        }

        if(vencedor != null){
            System.out.println("O vencedor é: " + vencedor.getNome() + " com " + vencedor.getPontuacao() + " pontos!");
        } else{
            System.out.println("O jogo terminou em empate!");
        }
        jogoEmAndamento = false;
        rodadaAtual = 0;
        System.out.println("Jogo finalizado!");
    }

    public void proximaRodada(){
        if(!jogoEmAndamento){
            throw new IllegalStateException("O jogo não está em andamento");
        }

        if(rodadaAtual>= numeroRodadas){
            throw new IllegalStateException("Todas as rodadas já foram jogadas");
        }

        rodadaAtual++;
        System.out.println("iniciando rodada "+ rodadaAtual);
    }

    public Pergunta getPerguntaAtual(){
        if(!jogoEmAndamento){
            throw new IllegalStateException("O jogo não está em andamento");
        }
        if (rodadaAtual <= 0|| rodadaAtual > perguntas.size()) {
            throw new IllegalStateException("Rodada inválida");
        }
        return perguntas.get(rodadaAtual-1);
    }

    public void adicionarJogador(Jogador jogador){
        if(jogadores.size() < numeroParticipantes){
            jogadores.add(jogador);
        }
        else {
            throw new IllegalStateException("Número máximo de jogadores já atingido");
        }
    }

    public void adicionarPergunta(Pergunta pergunta){
        perguntas.add(pergunta);
    }

    public void adicionarAssunto(String assunto){
        assuntos.add(assunto);
    }

    public boolean isJogoEmAndamento() {
        return jogoEmAndamento;
    }
    public int getRodadaAtual() {
        return rodadaAtual;
    }
    public int getNumeroParticipantes(){
        return numeroParticipantes;
    }
    public void setNumeroParticipantes(int numeroParticipantes) {
        this.numeroParticipantes = numeroParticipantes;
    }

    public int getNumeroRodadas() {
        return numeroRodadas;
    }

    public void setNumeroRodadas(int numeroRodadas) {
        this.numeroRodadas = numeroRodadas;
    }

    public List<String> getAssuntos() {
        return assuntos;
    }
    public void setAssuntos(List<String> assuntos) {
        this.assuntos = assuntos;
    }

    public List<Pergunta> getPerguntas() {
        return perguntas;
    }
    public void setPerguntas(List<Pergunta> perguntas) {
        this.perguntas = perguntas;
    }
    public List<Jogador> getJogadores() {
        return jogadores;
    }

    public void setJogadores(List<Jogador> jogadores) {
        this.jogadores = jogadores;
    }

    @Override
    public String toString() {
        return "Jogo[" +
                "numeroParticipantes=" + numeroParticipantes +
                ", numeroRodadas=" + numeroRodadas +
                ", assuntos=" + assuntos +
                ", jogoEmAndamento=" + jogoEmAndamento +
                ", rodadaAtual=" + rodadaAtual +
                ']';
    }
}