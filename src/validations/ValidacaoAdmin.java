package validations;

import entities.Admin;

public class ValidacaoAdmin {
    public static boolean validacaoNomeESenha(String nome, String senha, Admin admin){
        return admin.getNome().equals(nome) && admin.getPassword().equals(senha);
    }
}
