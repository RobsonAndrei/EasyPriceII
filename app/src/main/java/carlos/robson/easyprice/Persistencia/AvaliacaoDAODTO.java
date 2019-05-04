package carlos.robson.easyprice.Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class AvaliacaoDAODTO implements AvaliacaoDAO {

    @Override
    public int inserir(AvaliacaoDTO avaliacaoDTO) throws SQLException {
        //Comando de insert no banco de dados oracle
        String sql = "INSERT INTO AVALIACAO(ID_AVALIACAO, COMENTARIO, NOTA, DATA_AVALIACAO, ID_PRODUTO, ID_CATEGORIA, ID_SUPERMERCADO, CPF) VALUES (?, ?, ?, CURRENT_TIMESTAMP, ?, ?, ?, ?)";
        //Variável para retorno de resultado
        int resultado;

        //Abre conexão com o banco
        try (Connection conexao = InicializaBD.getConnection()) {
            try (PreparedStatement statement = conexao.prepareStatement(sql)) {
                //Seta os valores de cada campo
                statement.setInt(1, avaliacaoDTO.getIdAvaliacao());
                statement.setString(2, avaliacaoDTO.getComentario());
                statement.setDouble(3, avaliacaoDTO.getNota());
                statement.setInt(5, avaliacaoDTO.getIdProduto());
                statement.setInt(6, avaliacaoDTO.getIdCategoria());
                statement.setInt(7, avaliacaoDTO.getIdSupermercado());
                statement.setString(8, avaliacaoDTO.getCpf());
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
    public List<AvaliacaoDTO> buscarAvaliacoes(String cpf) throws SQLException {

        List<AvaliacaoDTO> avaliacoes = new LinkedList<>();

        String sql = "SELECT * FROM AVALIACAO WHERE CPF = " + "'" + cpf + "'";

        try (Connection conexao = InicializaBD.getConnection()) {
            try (Statement statement = conexao.createStatement()) {
                try (ResultSet busca = statement.executeQuery(sql)) {
                    while (busca.next()) {

                        AvaliacaoDTO avaliacao = new AvaliacaoDTO();

                        avaliacao.setIdAvaliacao(busca.getInt("ID_AVALIACAO"));
                        avaliacao.setComentario(busca.getString("COMENTARIO"));
                        avaliacao.setNota(busca.getDouble("NOTA"));
                        avaliacao.setDataAvaliacao(busca.getDate("DATA_AVALIACAO"));
                        avaliacao.setIdProduto(busca.getInt("ID_PRODUTO"));
                        avaliacao.setIdCategoria(busca.getInt("ID_CATEGORIA"));
                        avaliacao.setIdSupermercado(busca.getInt("ID_SUPERMERCADO"));
                        avaliacao.setCpf(busca.getString("CPF"));

                        avaliacoes.add(avaliacao);
                    }
                }
            }

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        }

        return avaliacoes;
    }
}
