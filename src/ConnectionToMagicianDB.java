
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public abstract class ConnectionToMagicianDB {
    final static String DATABASE_URL = "jdbc:derby://localhost:1527/MagicianAgentDB";
    
                 
    public static Connection GetConnection () {
        Connection connection = null;
        try {
        connection = DriverManager.getConnection(DATABASE_URL, "MagicianAgent", "magician");        
        }           
        
        catch (SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        
        return connection;
    }
    
}
