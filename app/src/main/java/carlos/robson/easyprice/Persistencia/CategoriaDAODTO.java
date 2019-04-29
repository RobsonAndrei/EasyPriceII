package carlos.robson.easyprice.Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CategoriaDAODTO implements CategoriaDAO {
    @Override

    public int incluir(CategoriaDTO categoria) throws SQLException {

        //Comando de insert no banco de dados oracle
        String sql = "INSERT INTO CATEGORIA(ID_CATEGORIA, NOME) VALUES(?, ?)";
        //Variável para retorno de resultado
        int resultado;

        //Abre conexão com o banco
        try (Connection conexao = InicializaBD.getConnection()) {
            try (PreparedStatement statement = conexao.prepareStatement(sql)) {
                //Seta os valores de cada campo
                statement.setInt(1, categoria.getIdCategoria());
                statement.setString(2, categoria.getNomeCategoria());
                //Executa o comando sql
                resultado = statement.executeUpdate();
            }
        } catch (SQLException ex) {
            return ex.getErrorCode();
        }
        //Retorna 1 se a linha foi inserida com sucesso
        return resultado;

    }
}
