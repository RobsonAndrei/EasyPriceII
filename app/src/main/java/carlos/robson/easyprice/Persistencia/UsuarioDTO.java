package carlos.robson.easyprice.Persistencia;

/**
 * Classe que representa um objeto de transferencia do usuário.
 */
public class UsuarioDTO {

    private long cpf;
    private String nome;
    private String login;
    private String senha;
    private int idade;
    private double salario;

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
