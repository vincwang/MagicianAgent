
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;

public class MagicianQueries {

    private static PreparedStatement selectAllMagician;
    private static PreparedStatement selectFreeMagician;
    private static PreparedStatement addNewMagician;

    public MagicianQueries() {
    }

    public static List< Object> getAllMagician(Connection connection) {

        ArrayList< Object> magicianResults = new ArrayList< Object>();;
        ResultSet resultSet = null;
                
        try {
            selectAllMagician = connection.prepareStatement("SELECT * FROM MAGICIANTABLE");        
            resultSet = selectAllMagician.executeQuery();
            while (resultSet.next()) 
                magicianResults.add(new String(resultSet.getString(1)));            
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.exit(1);
        }
        return magicianResults;
    }
    
    public static void updateMagicianComboBox (JComboBox magicianComboBox, Connection connection) {
        List<Object> magicianResults = MagicianQueries.getAllMagician(connection);
        magicianComboBox.setModel(new javax.swing.DefaultComboBoxModel(magicianResults.toArray()));
    }

    public static String getFreeMagician(String holidayName, Connection connection) {
        String freeMagicianResult = new String();
        ResultSet resultSet = null;
        
        try {
            selectFreeMagician = connection.prepareStatement("SELECT MAGICIANNAME FROM MAGICIANTABLE "
                    + "WHERE MAGICIANNAME NOT IN "
                    + "(SELECT MAGICIAN FROM BOOKINGTABLE WHERE HOLIDAY = ?)");
            selectFreeMagician.setString(1, holidayName);
            resultSet = selectFreeMagician.executeQuery();

            if (resultSet.next()) {
                freeMagicianResult = resultSet.getString(1);
            } else {
                freeMagicianResult = null;
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.exit(1);
        }
        return freeMagicianResult;
    }
    
    public static void insertNewMagician (String magicianName, Connection connection) {
        try {
            addNewMagician = connection.prepareStatement("INSERT INTO MAGICIANTABLE "
                    + "(MAGICIANNAME) VALUES (?)");       
            addNewMagician.setString(1, magicianName);
            addNewMagician.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.exit(1);
        }
    }
}
