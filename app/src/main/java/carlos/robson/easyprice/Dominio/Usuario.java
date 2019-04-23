package carlos.robson.easyprice.Dominio;

/**
 * Classe que representa um objeto Usuario.
 */
public class Usuario {

    private long cpf;
    private String nome;
    private String login;
    private String senha;
    private int idade;
    private double salario;

    public Usuario(long cpf, String nome, String login, String senha, int idade, double salario) {
        this.cpf = cpf;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.idade = idade;
        this.salario = salario;
    }

    public long getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public int getIdade() {
        return idade;
    }

    public double getSalario() {
        return salario;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
