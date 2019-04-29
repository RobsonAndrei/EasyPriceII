package carlos.robson.easyprice.Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import carlos.robson.easyprice.Dominio.Produto;

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
                statement.setDate(4, produto.getValidade());
                statement.setDate(5, produto.getUltAtualizacao());
                statement.setString(6, produto.getCpf());
                statement.setInt(7, produto.getIdSupermercado());
                statement.setInt(8, produto.getIdCategoria());
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

        List<ProdutoDTO> produtos = new LinkedList<>();

        String sql = "select * from usuarios where nome = " + nome; //busca pelo nome informado
        try (Connection conexao = InicializaBD.getConnection()) {
            try (Statement statement = conexao.createStatement()) {
                try (ResultSet busca = statement.executeQuery(sql)) {
                    while (busca.next()) {

                        ProdutoDTO produto = new ProdutoDTO();

                        produto.setIdProduto(busca.getInt("ID_PRODUTO"));
                        produto.setNome(busca.getString("NOME"));
                        produto.setPreco(busca.getDouble("PRECO"));
                        produto.setValidade(busca.getDate("DATA_VALIDADE"));
                        produto.setUltAtualizacao(busca.getDate("ULT_ATUALIZACAO"));
                        produto.setCpf(busca.getString("CPF"));
                        produto.setIdSupermercado(busca.getInt("ID_SUPERMERCADO"));
                        produto.setIdCategoria(busca.getInt("ID_CATEGORIA"));

                        produtos.add(produto);
                    }
                }
            }

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        }

        return produtos;
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
