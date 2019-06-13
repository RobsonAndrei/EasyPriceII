package carlos.robson.easyprice.Sessao;

public class SessaoUsuario {

    private static String email;
    private static String cpf;

    public SessaoUsuario(String email, String cpf){
        this.email = email;
        this.cpf = cpf;
    }

    public static String getEmailUsuarioLogado(){
        return email;
    }

    public static String getCpfUsuarioLogado(){
        return cpf;
    }

    public static void logofUsuario(){
        email = "";
        cpf = "";
    }
}
