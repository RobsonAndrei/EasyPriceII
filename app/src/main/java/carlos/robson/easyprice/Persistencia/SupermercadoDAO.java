package carlos.robson.easyprice.Persistencia;

import java.sql.SQLException;
import java.util.List;

import carlos.robson.easyprice.Dominio.Supermercado;

public interface SupermercadoDAO {

    int incluir(SupermercadoDTO supermercado) throws SQLException;

    List<SupermercadoDTO> listarProximos() throws SQLException;
}
