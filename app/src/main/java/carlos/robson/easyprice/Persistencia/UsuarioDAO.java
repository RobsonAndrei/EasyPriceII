package carlos.robson.easyprice.Persistencia;

import java.sql.SQLException;

/**
 * Interface que contém os métodos usados com o banco de dados.
 */
public interface UsuarioDAO {

    int incluir(UsuarioDTO usuario) throws SQLException;

    void alterar(UsuarioDTO usuario) throws ExceptionDAO;

    boolean excluir(UsuarioDTO usuario) throws ExceptionDAO;

    UsuarioDTO obter(UsuarioDTO usuario) throws ExceptionDAO;
}
