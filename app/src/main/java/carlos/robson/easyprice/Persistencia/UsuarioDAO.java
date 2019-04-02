package carlos.robson.easyprice.Persistencia;

/**
 * Interface que contém os métodos usados com o banco de dados.
 */
public interface UsuarioDAO {

    boolean incluir(UsuarioDTO usuario) throws ExceptionDAO;

    void alterar(UsuarioDTO usuario) throws ExceptionDAO;

    boolean excluir(UsuarioDTO usuario) throws ExceptionDAO;

    UsuarioDTO obter(UsuarioDTO usuario) throws ExceptionDAO;
}
