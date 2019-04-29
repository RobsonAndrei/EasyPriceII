package carlos.robson.easyprice.Persistencia;

import java.sql.SQLException;

public interface CategoriaDAO {

    int incluir(CategoriaDTO categoria) throws SQLException;
}
