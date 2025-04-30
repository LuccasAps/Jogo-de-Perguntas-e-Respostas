package entities;

import java.util.ArrayList;
import java.util.List;

public class Jogo {
    private int numeroParticipantes;
    private int numeroRodadas;
    private List<Pergunta>perguntas;
    private List<Jogador>jogadores;
    private boolean jogoEmAndamento;
    private int rodadaAtual;

    public Jogo(int numeroParticipantes, int numeroRodadas) {
        this.numeroParticipantes = numeroParticipantes;
        this.numeroRodadas = numeroRodadas;
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
            System.out.println("O vencedor é: " + vencedor.getNome());
        }
    }

    public int getNumeroParticipantes() {
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



    @Override
    public String toString() {
        return "Jogo[" +
                ", numeroParticipantes=" + numeroParticipantes +
                ", numeroRodadas=" + numeroRodadas +
                ']';
    }
}