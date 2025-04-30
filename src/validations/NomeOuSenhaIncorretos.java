package validations;

public class NomeOuSenhaIncorretos extends RuntimeException {
    public NomeOuSenhaIncorretos(String message) {
        super(message);
    }
}
