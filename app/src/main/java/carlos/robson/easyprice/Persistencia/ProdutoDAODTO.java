package carlos.robson.easyprice.Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ProdutoDAODTO implements ProdutoDAO {

    @Override
    public int incluir(ProdutoDTO produto) throws SQLException {

        //Comando de insert no banco de dados oracle
        String sql = "INSERT INTO PRODUTO(ID_PRODUTO, NOME, PRECO, DATA_VALIDADE, ULT_ATUALIZACAO, CPF, ID_SUPERMERCADO, ID_CATEGORIA) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        //Variável para retorno de resultado
        int resultado;

        //Abre conexão com o banco
        try (Connection conexao = InicializaBD.getConnection()) {
            try (PreparedStatement statement = conexao.prepareStatement(sql)) {
                //Seta os valores de cada campo
                statement.setInt(1, produto.getIdProduto());
                statement.setString(2, produto.getNome());
                statement.setDouble(3, produto.getPreco());
                statement.setDate(4, produto.getUltAtualizacao());
                statement.setLong(5, produto.getCpf());
                statement.setInt(6, produto.getIdSupermercado());
                statement.setInt(7, produto.getIdCategoria());
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
    public List<ProdutoDTO> buscarPorNome(String nome) throws SQLException {
        return null;
    }

    @Override
    public List<ProdutoDTO> buscarPorCategoria(int codigoCategoria) throws SQLException {
        return null;
    }

    @Override
    public List<ProdutoDTO> buscarPorPreco(double preco) throws SQLException {
        return null;
    }
}
