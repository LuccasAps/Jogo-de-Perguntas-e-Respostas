package entities;

import java.util.List;
import java.util.Map;

public class Partida {
    private int id;
    private List<Jogador> jogadores;
    private List<Pergunta> perguntas;
    private Map<Jogador, Integer> raking;

    public Partida(int id, List<Jogador> jogadores, List<Pergunta> perguntas, Map<Jogador, Integer> raking) {
        this.id = id;
        this.jogadores = jogadores;
        this.perguntas = perguntas;
        this.raking = raking;
    }

    public void registrarResposta(Jogador jogador, int resposta){
        //implementar funcionamento
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
