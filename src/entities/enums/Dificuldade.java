package entities.enums;

public enum Dificuldade {
    FACIL (1),
    MEDIO (2),
    DIFICIL(3);

    private int code;

    private Dificuldade(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
