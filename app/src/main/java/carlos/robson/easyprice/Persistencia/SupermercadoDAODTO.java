package carlos.robson.easyprice.Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class SupermercadoDAODTO implements SupermercadoDAO {

    @Override
    public int incluir(SupermercadoDTO supermercado){

        //Comando de insert no banco de dados oracle
        String sql = "INSERT INTO SUPERMERCADO(ID_SUPERMERCADO, LATITUDE, LONGITUDE, TELEFONE, CPF, NOME) VALUES (SEQ_IDSUPERMERCADO.NEXTVAL, ?, ?, ?, ?, ?)";
        //Variável para retorno de resultado
        int resultado;

        //Abre conexão com o banco
        try (Connection conexao = InicializaBD.getConnection()) {
            try (PreparedStatement statement = conexao.prepareStatement(sql)) {
                //Seta os valores de cada campo
                statement.setString(1, supermercado.getLatitude());
                statement.setString(2, supermercado.getLongitude());
                statement.setLong(3, supermercado.getTelefone());
                statement.setLong(4, supermercado.getCpf());
                statement.setString(5, supermercado.getNome());
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
    public List<SupermercadoDTO> listarProximos(){
        return null;
    }
}
