package entities;

import java.util.List;
import java.util.UUID;

import entities.enums.Dificuldade;

public class Admin extends Usuario {

    public Admin(UUID id, String nome, String password) {
        super(id, nome, password);
    }

    public Jogo criarJogo(int numeroParticipantes, int numeroRodadas) {
        if (numeroParticipantes <= 0) {
            throw new IllegalArgumentException("O numero de participantes deve ser maior que zero");
        }
        if (numeroRodadas <= 0) {
            throw new IllegalArgumentException("O numero de rodadas deve ser maior que zero");
        }

        return new Jogo(numeroParticipantes, numeroRodadas);
    }

    public Pergunta cadastrarPergunta(int id, String enunciado, List<String> opcoes,
                                      String respostaCerta, int pontuacao, Dificuldade dificuldade) {
        if (enunciado == null || enunciado.isEmpty()) {
            throw new IllegalArgumentException("O enunciado não pode estar vazio");
        }
        if (opcoes == null || opcoes.size() < 2) {
            throw new IllegalArgumentException("A pergunta deve ter pelo menos 2 opções");
        }
        if (respostaCerta == null || respostaCerta.isEmpty()) {
            throw new IllegalArgumentException("A resposta certa não pode estar vazia");
        }
        if (!opcoes.contains(respostaCerta)) {
            throw new IllegalArgumentException("A resposta certa deve estar entre as opções");
        }
        if (pontuacao <= 0) {
            throw new IllegalArgumentException("A pontuação deve ser maior que zero");
        }
        if (dificuldade == null) {
            throw new IllegalArgumentException("A dificuldade não pode ser nula");
        }

        return new Pergunta(id, enunciado, opcoes, respostaCerta, pontuacao, dificuldade);

    }
}