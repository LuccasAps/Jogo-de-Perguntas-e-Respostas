package entities;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Partida {
    private int id;
    private List<Jogador> jogadores;
    private List<Pergunta> perguntas;
    private Map<Jogador, Integer> raking = new HashMap<>();

    public Partida(int id, List<Jogador> jogadores, List<Pergunta> perguntas, Map<Jogador, Integer> raking) {
        this.id = id;
        this.jogadores = jogadores;
        this.perguntas = perguntas;
        this.raking = raking;
    }

    public void registrarResposta(Jogador jogador, int resposta, int indexPergunta){
        Pergunta pergunta = perguntas.get(indexPergunta);
        if (Objects.equals(pergunta.getRespostaCerta(), pergunta.getOpcoes().get(resposta))) {
            jogador.setPontuacao(jogador.getPontuacao() + pergunta.acrescentaPontuacao()); // Somar pontos
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Jogador> getJogadores() {
        return jogadores;
    }

    public void setJogadores(List<Jogador> jogadores) {
        this.jogadores = jogadores;
    }

    public List<Pergunta> getPerguntas() {
        return perguntas;
    }

    public void setPerguntas(List<Pergunta> perguntas) {
        this.perguntas = perguntas;
    }

    public Map<Jogador, Integer> getRaking() {
        return raking;
    }

    public void setRaking(Map<Jogador, Integer> raking) {
        this.raking = raking;
    }

    @Override
    public String toString() {
        return "Partida[" +
                "id=" + id +
                ", jogadores=" + jogadores +
                ", perguntas=" + perguntas +
                ", raking=" + raking +
                ']';
    }
}