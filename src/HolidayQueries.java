
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

public class HolidayQueries {

    private static PreparedStatement selectAllHoliday;

    public HolidayQueries() {

    }

    public static List< Object> getAllHoliday(Connection connection) {

        ArrayList< Object> holidayResults = new ArrayList<Object>();
        ResultSet resultSet = null;

        try {
            selectAllHoliday = connection.prepareStatement("SELECT * FROM HOLIDAYTABLE");
            resultSet = selectAllHoliday.executeQuery();
            while (resultSet.next()) {
                holidayResults.add(new String(resultSet.getString(1)));
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.exit(1);
        }
        return holidayResults;
    }

    public static void updateHolidayComboBox(JComboBox holidayComboBox, Connection connection) {
        List<Object> holidayResults = HolidayQueries.getAllHoliday(connection);
        holidayComboBox.setModel(new javax.swing.DefaultComboBoxModel(holidayResults.toArray()));
    }

    public static void updateCustomerHolidayList(JComboBox customerComboBox, JComboBox selectedCustomerHolidayComboBox, Connection connection) {
        String customerToFind = null;
        if (customerComboBox.getItemCount() != 0) {
            customerToFind = customerComboBox.getSelectedItem().toString();            
        }
        List<Object> customerHolidayResults = BookingQueries.getCustomersHolidaylist(customerToFind, connection);
        selectedCustomerHolidayComboBox.setModel(new DefaultComboBoxModel(customerHolidayResults.toArray()));
    }

    public static void addNewHoliday(String holidayName, Connection connection) {
        try {
            PreparedStatement makeNewHoliday = connection.prepareStatement("INSERT INTO HOLIDAYTABLE (HOLIDAYNAME) VALUES(?)");
            makeNewHoliday.setString(1, holidayName);
            makeNewHoliday.executeUpdate();
        } catch (SQLException sQLException) {
            sQLException.printStackTrace();;
            System.exit(1);
        }

    }
}
