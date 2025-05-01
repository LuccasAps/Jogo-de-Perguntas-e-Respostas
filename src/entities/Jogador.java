package entities;

import java.util.UUID;

public class Jogador extends Usuario {
    private int pontuacao;
    private int vitorias;
    private int desistencias;

    public Jogador(UUID id, String nome, String password) {
        super(id, nome, password);
        this.pontuacao = 0;
        this.vitorias = 0;
        this.desistencias = 0;
    }

    public void desistirPergunta() {
        this.pontuacao -= 5;
        if (this.pontuacao < 0) {
            this.pontuacao = 0;
        }
        this.desistencias++;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public int getVitorias() {
        return vitorias;
    }

    public void setVitorias(int vitorias) {
        this.vitorias = vitorias;
    }

    @Override
    public String toString() {
        return "Jogador: " + nome + " | Pontuação: " + pontuacao;
    }
}