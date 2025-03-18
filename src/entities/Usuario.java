package entities;

public abstract class Usuario {

    protected int id;
    protected String nome;
    protected String password;

    public Usuario(int id, String nome, String password) {
        this.id = id;
        this.nome = nome;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Usuario[" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ']';
    }
}