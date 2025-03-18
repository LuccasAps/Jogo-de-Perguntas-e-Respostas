package entities;

public class Jogador extends Usuario {
    private int pontuacao;
    private int vitorias;

    public Jogador(int id, String nome, String password, int pontuacao, int vitorias) {
        super(id, nome, password);
        this.pontuacao = pontuacao;
        this.vitorias = vitorias;
    }

    public void desistirPergunta(){
        //implementar funcionamento
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
        return "Jogador[" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", vitorias=" + vitorias +
                ", pontuacao=" + pontuacao +
                ']';
    }
}
