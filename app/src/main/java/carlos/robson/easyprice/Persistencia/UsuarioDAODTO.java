package carlos.robson.easyprice.Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Classe que implementa os métodos da classe UsuarioDAO.
 */
public class UsuarioDAODTO implements UsuarioDAO {

    /**
     * Método que insere um usuário na base de dados.
     * No nosso contexto, esse método é o que de fato cria uma conta para um usuário.
     *
     * @param usuario objeto usuário que será inserido no banco de dados
     * @return 1 para sucesso
     */
    @Override
    public int incluir(UsuarioDTO usuario) {

        //Comando de insert no banco de dados oracle
        String sql = "INSERT INTO USUARIO(CPF, NOME, LOGIN, SENHA, IDADE, FAIXA_SALARIAL) VALUES(?, ?, ?, ?, ?, ?)";
        //Variável para retorno de resultado
        int resultado;

        //Abre conexão com o banco
        try (Connection conexao = InicializaBD.getConnection()) {
            try (PreparedStatement statement = conexao.prepareStatement(sql)) {
                //Seta os valores de cada campo
                statement.setString(1, usuario.getCpf());
                statement.setString(2, usuario.getNome());
                statement.setString(3, usuario.getLogin());
                statement.setString(4, usuario.getSenha());
                statement.setInt(5, usuario.getIdade());
                statement.setDouble(6, usuario.getSalario());
                //Executa o comando sql
                resultado = statement.executeUpdate();
            }
        } catch (SQLException ex) {
            return ex.getErrorCode();
        }
        //Retorna 1 se a linha foi inserida com sucesso
        return resultado;
    }

    @Override
    public void alterar(UsuarioDTO usuario) {

    }

    @Override
    public boolean excluir(UsuarioDTO usuario) {
        return false;
    }

    @Override
    public UsuarioDTO obter(UsuarioDTO usuario) {
        return null;
    }
}
