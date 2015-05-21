    
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;


public class BookingQueries {

    private static PreparedStatement selectAllBookingsByMagician;
    private static PreparedStatement selectAllBookingsByHoliday;
    private static PreparedStatement makeNewBooking;

    public BookingQueries() {

    }

    public static class BookingEntry {

        private String customer;
        private String magician;
        private String holiday;
        private Timestamp timestamp;

        public BookingEntry(String customer, String magician, String holiday, Timestamp timestamp) {
            this.customer = customer;
            this.magician = magician;
            this.holiday = holiday;
            this.timestamp = timestamp;
        }

        public Timestamp getTimestamp() {
            return timestamp;
        }

        public String getCustomer() {
            return customer;
        }

        public String getMagician() {
            return magician;
        }

        public String getHoliday() {
            return holiday;
        }

    }

    public static List< BookingEntry> getBookingByMagician(String magicianName, Connection connection) {
        ArrayList<BookingEntry> bookingByMagicianResults = new ArrayList<BookingEntry>();
        ResultSet resultSet = null;

        try {
            selectAllBookingsByMagician = connection.prepareStatement("SELECT * FROM BOOKINGTABLE WHERE MAGICIAN = ?");
            selectAllBookingsByMagician.setString(1, magicianName);
            resultSet = selectAllBookingsByMagician.executeQuery();

            while (resultSet.next()) {
                bookingByMagicianResults.add(new BookingEntry(resultSet.getString("CUSTOMER"), magicianName, resultSet.getString("HOLIDAY"), resultSet.getTimestamp("TIMESTAMP")));
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.exit(1);
        }
        return bookingByMagicianResults;
    }

    public static List<BookingEntry> getBookingByHoliday(String holidayName, Connection connection) {
        ArrayList<BookingEntry> bookingByHolidayResults = new ArrayList<BookingEntry>();
        ResultSet resultSet = null;

        try {
            selectAllBookingsByHoliday = connection.prepareStatement("SELECT * FROM BOOKINGTABLE WHERE HOLIDAY = ?");
            selectAllBookingsByHoliday.setString(1, holidayName);
            resultSet = selectAllBookingsByHoliday.executeQuery();

            while (resultSet.next()) {
                bookingByHolidayResults.add(new BookingEntry(resultSet.getString("CUSTOMER"), resultSet.getString("MAGICIAN"), holidayName, resultSet.getTimestamp("TIMESTAMP")));
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.exit(1);
        }
        return bookingByHolidayResults;
    }

    public static void addBooking(BookingEntry bookingEntry, Connection connection) {
        try {
            makeNewBooking = connection.prepareStatement("INSERT INTO BOOKINGTABLE "
                    + "(CUSTOMER, MAGICIAN, HOLIDAY, TIMESTAMP) "
                    + "VALUES (?,?,?,?)");
            makeNewBooking.setString(1, bookingEntry.getCustomer());
            makeNewBooking.setString(2, bookingEntry.getMagician());
            makeNewBooking.setString(3, bookingEntry.getHoliday());
            makeNewBooking.setTimestamp(4, bookingEntry.getTimestamp());
            makeNewBooking.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.exit(1);
        }
    }

    public static List<Object> getAllCustomer(Connection connection) {
        ArrayList<Object> customerReuslts = new ArrayList<Object>();
        ResultSet bookingResultSet = null;
        ResultSet waitlistResutSet = null;

        try {
            PreparedStatement selectAllBookingEntries = connection.prepareStatement("SELECT * FROM BOOKINGTABLE");
            bookingResultSet = selectAllBookingEntries.executeQuery();

            while (bookingResultSet.next()) {
                if (!customerReuslts.contains(bookingResultSet.getString("CUSTOMER")))
                    customerReuslts.add(new String(bookingResultSet.getString("CUSTOMER")));
            }
            
            PreparedStatement selectAllWaitlistEntries = connection.prepareStatement("SELECT * FROM WAITLISTTABLE");
            waitlistResutSet = selectAllWaitlistEntries.executeQuery();
            
            while (waitlistResutSet.next())
            {
                if (!customerReuslts.contains(waitlistResutSet.getString("CUSTOMER")))
                {
                    customerReuslts.add(new String(waitlistResutSet.getString("CUSTOMER")));
                }
            }

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.exit(1);
        }

        return customerReuslts;
    }

    public static void updateCustomerComboBox(JComboBox customerComboBox, Connection connection) {
        List<Object> customerResults = BookingQueries.getAllCustomer(connection);
        customerComboBox.setModel(new DefaultComboBoxModel(customerResults.toArray()));
    }

    public static List<Object> getCustomersHolidaylist(String customerToFind, Connection connection) {
        ArrayList<Object> customerholidayResults = new ArrayList<Object>();
        ResultSet customerBookingResultSet = null;

        try {
            PreparedStatement selectCustomerBookings = connection.prepareStatement("SELECT * FROM BOOKINGTABLE WHERE CUSTOMER = ?");
            selectCustomerBookings.setString(1, customerToFind);
            customerBookingResultSet = selectCustomerBookings.executeQuery();

            while (customerBookingResultSet.next()) {
                customerholidayResults.add(new String(customerBookingResultSet.getString("HOLIDAY")));
            }

        } catch (SQLException sQLException) {
            sQLException.printStackTrace();;
            System.exit(1);
        }

        return customerholidayResults;
    }

    public static boolean ifBookingExisting(String customer, String holiday, Connection connection) {
        ResultSet resultSet = null;
        boolean existing = false;
        try {
            PreparedStatement selectBookingEntry = connection.prepareStatement("SELECT * FROM BOOKINGTABLE "
                    + "WHERE CUSTOMER = ? AND HOLIDAY = ?");
            selectBookingEntry.setString(1, customer);
            selectBookingEntry.setString(2, holiday);
            resultSet = selectBookingEntry.executeQuery();
            if (resultSet.next())
                existing = true;
        } catch (SQLException sQLException) {
            sQLException.printStackTrace();
            System.exit(1);
        }        
        return existing;
    }
}
