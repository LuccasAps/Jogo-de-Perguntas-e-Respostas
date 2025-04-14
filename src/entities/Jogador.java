package entities;

public class Jogador extends Usuario {
    private int pontuacao;
    private int vitorias;
    private int desistencias;

    public Jogador(int id, String nome, String password, int pontuacao, int vitorias) {
        super(id, nome, password);
        this.pontuacao = pontuacao;
        this.vitorias = vitorias;
        this.desistencias = 0;
    }

    public void desistirPergunta(){

        //aplicando penalidade por desistir de uma pergunta
        this.pontuacao -= 5;
        //verificando se a pontuacao ficou negativa
        if(this.pontuacao < 0){
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
        return "Jogador[" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", vitorias=" + vitorias +
                ", pontuacao=" + pontuacao +
                ", desistencias=" + desistencias +
                ']';
    }
}