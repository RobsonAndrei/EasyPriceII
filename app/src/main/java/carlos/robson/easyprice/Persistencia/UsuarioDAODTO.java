package carlos.robson.easyprice.Persistencia;

import carlos.robson.easyprice.Dominio.Usuario;

/**
 * Classe que implementa os métodos da classe UsuarioDAO.
 */
public class UsuarioDAODTO implements UsuarioDAO {


    @Override
    public boolean incluir(UsuarioDTO usuario) throws ExceptionDAO {
        return false;
    }

    @Override
    public void alterar(UsuarioDTO usuario) throws ExceptionDAO {

    }

    @Override
    public boolean excluir(UsuarioDTO usuario) throws ExceptionDAO {
        return false;
    }

    @Override
    public UsuarioDTO obter(UsuarioDTO usuario) throws ExceptionDAO {
        return null;
    }
}
