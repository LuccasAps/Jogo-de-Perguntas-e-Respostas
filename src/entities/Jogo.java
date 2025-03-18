package entities;

import java.util.List;

public class Jogo {
    private List<String> assuntos;
    private int numeroParticipantes;
    private int numeroRodadas;
    private String regras;

    public Jogo(List<String> assuntos, int numeroParticipantes, int numeroRodadas, String regras) {
        this.assuntos = assuntos;
        this.numeroParticipantes = numeroParticipantes;
        this.numeroRodadas = numeroRodadas;
        this.regras = regras;
    }

    public void iniciarJogo(){
        //implementar funcionamento
    }

    public void finalizarJogo(){
        //implementar funcionamento
    }

    public List<String> getAssuntos() {
        return assuntos;
    }

    public void setAssuntos(List<String> assuntos) {
        this.assuntos = assuntos;
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

    public String getRegras() {
        return regras;
    }

    public void setRegras(String regras) {
        this.regras = regras;
    }

    @Override
    public String toString() {
        return "Jogo[" +
                "assuntos=" + assuntos +
                ", numeroParticipantes=" + numeroParticipantes +
                ", numeroRodadas=" + numeroRodadas +
                ", regras='" + regras + '\'' +
                ']';
    }
}
