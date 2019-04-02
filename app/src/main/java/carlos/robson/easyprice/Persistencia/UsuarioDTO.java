package carlos.robson.easyprice.Persistencia;

/**
 * Classe que representa um objeto de transferencia do usuário.
 */
public class UsuarioDTO {

    private String nome;
    private String cpf;

    public String getNome(){
        return nome;
    }

    public String getCpf(){
        return cpf;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setCpf(String cpf){
        this.cpf = cpf;
    }
}
