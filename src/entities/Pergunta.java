package entities;

import entities.enums.Dificuldade;

import java.util.List;

public class Pergunta {

    private int id;
    private String enunciado;
    private List<String> opcoes;
    private String respostaCerta;
    private int pontuacao;

    private Dificuldade dificuldade;

    public Pergunta(int id, String enunciado, List<String> opcoes, String respostaCerta, int pontuacao, Dificuldade dificuldade) {
        this.id = id;
        this.enunciado = enunciado;
        this.opcoes = opcoes;
        this.respostaCerta = respostaCerta;
        this.pontuacao = pontuacao;
        this.dificuldade = dificuldade;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public List<String> getOpcoes() {
        return opcoes;
    }

    public void setOpcoes(List<String> opcoes) {
        this.opcoes = opcoes;
    }

    public String getRespostaCerta() {
        return respostaCerta;
    }

    public void setRespostaCerta(String respostaCerta) {
        this.respostaCerta = respostaCerta;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public Dificuldade getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(Dificuldade dificuldade) {
        this.dificuldade = dificuldade;
    }

    @Override
    public String toString() {
        return "Pergunta[" +
                "id=" + id +
                ", enunciado='" + enunciado + '\'' +
                ", opcoes=" + opcoes +
                ", respostaCerta='" + respostaCerta + '\'' +
                ", pontuacao=" + pontuacao +
                ", dificuldade=" + dificuldade +
                ']';
    }
}
