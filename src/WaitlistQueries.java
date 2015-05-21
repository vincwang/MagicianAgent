
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javafx.scene.control.TextArea;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class WaitlistQueries {

    private static PreparedStatement selectAllWaitlist;
    private static PreparedStatement addNewWaitlistEntry;
    private static PreparedStatement selectTopWaitlistOnHoliday;
    private static PreparedStatement deleteWaitlistEntry;

    public WaitlistQueries() {

    }

    public static class WaitlistEntry {

        private String customer;
        private String holiday;
        private Timestamp timestamp;

        public WaitlistEntry(String customer, String holiday, Timestamp timestamp) {
            this.customer = customer;
            this.holiday = holiday;
            this.timestamp = timestamp;
        }

        public String getCustomer() {
            return customer;
        }

        public String getHoliday() {
            return holiday;
        }

        public Timestamp getTimestamp() {
            return timestamp;
        }

    }

    public static List<WaitlistEntry> getAllWaitlist(Connection connection) {

        ArrayList< WaitlistEntry> waitlistResults = new ArrayList<WaitlistEntry>();
        ResultSet resultSet = null;

        try {
            selectAllWaitlist = connection.prepareStatement("SELECT * FROM WAITLISTTABLE ORDER BY TIMESTAMP ASC");
            resultSet = selectAllWaitlist.executeQuery();
            while (resultSet.next()) {
                waitlistResults.add(new WaitlistEntry(resultSet.getString("CUSTOMER"), resultSet.getString("HOLIDAY"), resultSet.getTimestamp("TIMESTAMP")));
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.exit(1);
        }
        return waitlistResults;
    }

    public static void insertNewWaitlistEntry(WaitlistEntry waitlistEntry, Connection connection) {
        try {
            connection = ConnectionToMagicianDB.GetConnection();
            addNewWaitlistEntry = connection.prepareStatement("INSERT INTO WAITLISTTABLE "
                    + "(CUSTOMER, HOLIDAY, TIMESTAMP) VALUES (?, ? ,?)");
            addNewWaitlistEntry.setString(1, waitlistEntry.getCustomer());
            addNewWaitlistEntry.setString(2, waitlistEntry.getHoliday());
            addNewWaitlistEntry.setTimestamp(3, waitlistEntry.getTimestamp());
            addNewWaitlistEntry.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.exit(1);
        }
    }

    public static List<WaitlistEntry> getTopWaitlist(Connection connection) {

        List<Object> holidayResults = HolidayQueries.getAllHoliday(connection);
        ResultSet resultSet = null;
        ArrayList<WaitlistEntry> topWaitlistResults = new ArrayList<WaitlistEntry>();

        try {
            selectTopWaitlistOnHoliday = connection.prepareStatement("SELECT *"
                    + " FROM WAITLISTTABLE"
                    + " WHERE HOLIDAY = ?"
                    + " ORDER BY TIMESTAMP ASC"
            );
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.exit(1);
        }

        for (int i = 0; i < holidayResults.size(); i++) {
            try {
                selectTopWaitlistOnHoliday.setString(1, holidayResults.get(i).toString());
                resultSet = selectTopWaitlistOnHoliday.executeQuery();

                if (resultSet.next()) {
                    topWaitlistResults.add(new WaitlistEntry(resultSet.getString("CUSTOMER"), resultSet.getString("HOLIDAY"), resultSet.getTimestamp("TIMESTAMP")));
                }
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
                System.exit(1);
            }
        }
        return topWaitlistResults;
    }

    public static void deleteWaitlistEntry(Timestamp timeStamp, Connection connection) {
        try {
            deleteWaitlistEntry = connection.prepareStatement("DELETE FROM WAITLISTTABLE WHERE TIMESTAMP = ?");
            deleteWaitlistEntry.setTimestamp(1, timeStamp);
            deleteWaitlistEntry.executeUpdate();

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.exit(1);
        }

    }

    public static void updateWaitlistTab(JLabel waitlistUpdateTimeLabel, JTextArea waitlistStatusTextArea, Connection connection) {
        List<WaitlistQueries.WaitlistEntry> waitlistStatusResults = WaitlistQueries.getAllWaitlist(connection);
        waitlistUpdateTimeLabel.setText("Updated @ " + new Timestamp(Calendar.getInstance().getTime().getTime()).toString());
        waitlistStatusTextArea.setText("");
        for (WaitlistQueries.WaitlistEntry waitlistEntry : waitlistStatusResults) {
            waitlistStatusTextArea.append(waitlistEntry.getCustomer() + "\t" + waitlistEntry.getHoliday() + "\t" + waitlistEntry.getTimestamp().toString() + "\n");
        }
    }

    public static boolean ifWaitlistExisting(String customer, String holiday, Connection connection) {
        ResultSet resultSet;
        boolean ifExisting = false;
        try {
            PreparedStatement findWaitlist = connection.prepareStatement("SELECT * FROM WAITLISTTABLE "
                    + "WHERE CUSTOMER = ? AND HOLIDAY = ?");
            findWaitlist.setString(1, customer);
            findWaitlist.setString(2, holiday);
            resultSet = findWaitlist.executeQuery();
            if (resultSet.next()) {
                ifExisting = true;
            }
        } catch (SQLException sQLException) {
            sQLException.printStackTrace();;
            System.exit(1);
        }
        return ifExisting;
    }

    public static List<WaitlistEntry> getWaitlistByCustomer(String customer, Connection connection) {
        ArrayList<WaitlistEntry> waitlistByCustomerResult = new ArrayList<WaitlistEntry>();
        ResultSet results = null;

        try {
            PreparedStatement selectWaitlistByCustoemr = connection.prepareStatement("SELECT * FROM WAITLISTTABLE "
                    + "WHERE CUSTOMER = ?");
            selectWaitlistByCustoemr.setString(1, customer);
            results = selectWaitlistByCustoemr.executeQuery();
            while (results.next()) {
                waitlistByCustomerResult.add(new WaitlistEntry(results.getString("CUSTOMER"), results.getString("HOLIDAY"), results.getTimestamp("TIMESTAMP")));
            }
        } catch (SQLException sQLException) {
            sQLException.printStackTrace();
            System.exit(1);
        }
        return waitlistByCustomerResult;
    }

    public static void updateWaitlistByCustomerComboBox(JComboBox customerComboBox, JComboBox waitlistByCustomerComboBox, Connection connection) {
        String customerToFind = null;
        if (customerComboBox.getItemCount() != 0) {
            customerToFind = customerComboBox.getSelectedItem().toString();
        }
        List<WaitlistEntry> getWaitlistByCustomer = WaitlistQueries.getWaitlistByCustomer(customerToFind, connection);
        List<Object> waitlistResult = new ArrayList<Object>();
        for (int i = 0; i < getWaitlistByCustomer.size(); i++) {
            waitlistResult.add(getWaitlistByCustomer.get(i).getHoliday());
        }
        waitlistByCustomerComboBox.setModel(new DefaultComboBoxModel(waitlistResult.toArray()));
    }

}
