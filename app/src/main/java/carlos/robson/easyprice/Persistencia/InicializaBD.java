package carlos.robson.easyprice.Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classse que abre a conexão com o banco de dados.
 */
class InicializaBD {

    private static String url = "jdbc:oracle:thin:@localhost:1521:xe";
    private static String username = "easyprice";
    private static String password = "appeasyprice";

    static Connection getConnection(){

        Connection connection = null;

        try
        {
            connection = DriverManager.getConnection(url, username, password);
        }
        catch (SQLException ex)
        {
            System.out.println(ex);
        }

        return connection;
    }

}
