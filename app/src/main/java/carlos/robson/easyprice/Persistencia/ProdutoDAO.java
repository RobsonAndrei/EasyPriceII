package carlos.robson.easyprice.Persistencia;

import java.sql.SQLException;
import java.util.List;

public interface ProdutoDAO {

    int incluir(ProdutoDTO produto) throws SQLException;

    List<ProdutoDTO> buscarPorNome(String nome) throws SQLException;

    List<ProdutoDTO> buscarPorCategoria(int codigoCategoria) throws SQLException;

    List<ProdutoDTO> buscarPorPreco(double preco) throws SQLException;
}
