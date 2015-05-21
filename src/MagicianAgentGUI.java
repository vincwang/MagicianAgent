
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

public class MagicianAgentGUI extends javax.swing.JFrame {

    // Added by me
    private static Connection connection;

    private List<BookingQueries.BookingEntry> bookingByMagicianResults;
    private List<BookingQueries.BookingEntry> bookingByHolidayResults;

    /**
     * Creates new form MagicianAgentGUI
     */
    public MagicianAgentGUI() {

        // connceton
        connection = ConnectionToMagicianDB.GetConnection();

        initComponents();
        WaitlistQueries.updateWaitlistTab(waitlistUpdateTimeLabel, waitlistStatusTextArea, connection);
        MagicianQueries.updateMagicianComboBox(magicianComboBox, connection);
        HolidayQueries.updateHolidayComboBox(holidayCombobox, connection);
        HolidayQueries.updateHolidayComboBox(holidayComboboxforStatus, connection);
        BookingQueries.updateCustomerComboBox(customerComboBox, connection);
        HolidayQueries.updateCustomerHolidayList(customerComboBox, selectedCustomerHolidayComboBox, connection);
        WaitlistQueries.updateWaitlistByCustomerComboBox(customerComboBox, waitlistByCustomerComboBox, connection);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        waitlistTabbedPane = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        bookingButton = new javax.swing.JButton();
        CustomerLabel = new javax.swing.JLabel();
        customerTextfield = new javax.swing.JTextField();
        holidayLabel = new javax.swing.JLabel();
        holidayCombobox = new javax.swing.JComboBox();
        bookingStatusLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        bookingStatusTextArea = new javax.swing.JTextArea();
        customerToCanceLabel = new javax.swing.JLabel();
        customerComboBox = new javax.swing.JComboBox();
        selectedCustomerHolidayLabel = new javax.swing.JLabel();
        cancelBookingButton = new javax.swing.JButton();
        selectedCustomerHolidayComboBox = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        waitlistByCustomerComboBox = new javax.swing.JComboBox();
        cancelWaitlistButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        magicianListLabel = new javax.swing.JLabel();
        magicianComboBox = new javax.swing.JComboBox();
        magicianStatusButton = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        magicianStatusTextArea = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        newMagicianNameLabel = new javax.swing.JLabel();
        newMagicianTextField = new javax.swing.JTextField();
        addMagicianButton = new javax.swing.JButton();
        magicianTabDisplayNameLabel = new javax.swing.JLabel();
        dropMagicanButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        holidayListLabel = new javax.swing.JLabel();
        holidayComboboxforStatus = new javax.swing.JComboBox();
        holidayStatusButton = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        holidayStatusTextArea = new javax.swing.JTextArea();
        newHolidayLabel = new javax.swing.JLabel();
        newHolidayNameTextField = new javax.swing.JTextField();
        addHolidayButton = new javax.swing.JButton();
        holidayTabDisplayNameLabel = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        waitlistStatusTextArea = new javax.swing.JTextArea();
        waitlistUpdateTimeLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bookingButton.setText("Book");
        bookingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookingButtonActionPerformed(evt);
            }
        });

        CustomerLabel.setText("New Customer Name:");

        customerTextfield.setText("Enter here...");
        customerTextfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerTextfieldActionPerformed(evt);
            }
        });

        holidayLabel.setText("Holiday List:");

        holidayCombobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                holidayComboboxActionPerformed(evt);
            }
        });

        bookingStatusTextArea.setColumns(20);
        bookingStatusTextArea.setRows(5);
        jScrollPane1.setViewportView(bookingStatusTextArea);

        customerToCanceLabel.setText("Customer Name: ");

        customerComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerComboBoxActionPerformed(evt);
            }
        });

        selectedCustomerHolidayLabel.setText("Booked Holiday List: ");

        cancelBookingButton.setText("Cancel booking");
        cancelBookingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBookingButtonActionPerformed(evt);
            }
        });

        selectedCustomerHolidayComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectedCustomerHolidayComboBoxActionPerformed(evt);
            }
        });

        jLabel5.setText("Holiday Watch List:");

        waitlistByCustomerComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                waitlistByCustomerComboBoxActionPerformed(evt);
            }
        });

        cancelWaitlistButton.setText("Cancel waitlist");
        cancelWaitlistButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelWaitlistButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(CustomerLabel)
                    .addComponent(holidayLabel))
                .addGap(18, 18, 18)
                .addComponent(customerTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addComponent(bookingStatusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(selectedCustomerHolidayLabel)
                                    .addComponent(customerToCanceLabel)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel5)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(selectedCustomerHolidayComboBox, 0, 86, Short.MAX_VALUE)
                                    .addComponent(waitlistByCustomerComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addComponent(cancelBookingButton))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(cancelWaitlistButton))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(customerComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(holidayCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bookingButton)
                                .addGap(9, 9, 9)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CustomerLabel)
                    .addComponent(customerTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(holidayLabel)
                    .addComponent(holidayCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bookingButton))
                .addGap(65, 65, 65)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(customerToCanceLabel)
                    .addComponent(customerComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selectedCustomerHolidayLabel)
                    .addComponent(selectedCustomerHolidayComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelBookingButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(waitlistByCustomerComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelWaitlistButton))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bookingStatusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        waitlistTabbedPane.addTab("Booking", jPanel1);

        magicianListLabel.setText("Magician list:");

        magicianComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                magicianComboBoxActionPerformed(evt);
            }
        });

        magicianStatusButton.setText("Status");
        magicianStatusButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                magicianStatusButtonActionPerformed(evt);
            }
        });

        magicianStatusTextArea.setColumns(20);
        magicianStatusTextArea.setRows(5);
        jScrollPane4.setViewportView(magicianStatusTextArea);

        newMagicianNameLabel.setText("New Magician Name: ");

        newMagicianTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newMagicianTextFieldActionPerformed(evt);
            }
        });

        addMagicianButton.setText("Add");
        addMagicianButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMagicianButtonActionPerformed(evt);
            }
        });

        magicianTabDisplayNameLabel.setText(" ");

        dropMagicanButton.setText("Drop");
        dropMagicanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dropMagicanButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane4))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(jLabel1))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(newMagicianNameLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(newMagicianTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(addMagicianButton))
                                    .addComponent(magicianTabDisplayNameLabel)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(magicianListLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(magicianComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(magicianStatusButton)
                                        .addGap(18, 18, 18)
                                        .addComponent(dropMagicanButton)))))
                        .addGap(0, 26, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(magicianListLabel)
                    .addComponent(magicianComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(magicianStatusButton)
                    .addComponent(dropMagicanButton))
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newMagicianNameLabel)
                    .addComponent(newMagicianTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addMagicianButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                .addComponent(magicianTabDisplayNameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        waitlistTabbedPane.addTab("Magician", jPanel2);

        holidayListLabel.setText("Holiday list:");

        holidayComboboxforStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                holidayComboboxforStatusActionPerformed(evt);
            }
        });

        holidayStatusButton.setText("Status");
        holidayStatusButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                holidayStatusButtonActionPerformed(evt);
            }
        });

        holidayStatusTextArea.setColumns(20);
        holidayStatusTextArea.setRows(5);
        jScrollPane5.setViewportView(holidayStatusTextArea);

        newHolidayLabel.setText("New Holiday: ");

        newHolidayNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newHolidayNameTextFieldActionPerformed(evt);
            }
        });

        addHolidayButton.setText("Add");
        addHolidayButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addHolidayButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(newHolidayLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(newHolidayNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(addHolidayButton))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(holidayListLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(holidayComboboxforStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(holidayStatusButton))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(holidayTabDisplayNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(holidayListLabel)
                    .addComponent(holidayComboboxforStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(holidayStatusButton))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newHolidayLabel)
                    .addComponent(newHolidayNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addHolidayButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(holidayTabDisplayNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        waitlistTabbedPane.addTab("Holiday", jPanel3);

        waitlistStatusTextArea.setColumns(20);
        waitlistStatusTextArea.setRows(5);
        jScrollPane6.setViewportView(waitlistStatusTextArea);

        waitlistUpdateTimeLabel.setText("Updated @");

        jLabel2.setText("Customer");

        jLabel3.setText("Holiday");

        jLabel4.setText("TimeStamp ");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(waitlistUpdateTimeLabel)
                .addGap(73, 73, 73))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel2)
                .addGap(44, 44, 44)
                .addComponent(jLabel3)
                .addGap(87, 87, 87)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(waitlistUpdateTimeLabel)
                .addContainerGap(70, Short.MAX_VALUE))
        );

        waitlistTabbedPane.addTab("Waitlist", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(waitlistTabbedPane)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(waitlistTabbedPane)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void magicianStatusButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_magicianStatusButtonActionPerformed
        // TODO add your handling code here:
        bookingByMagicianResults = BookingQueries.getBookingByMagician(magicianComboBox.getSelectedItem().toString(), connection);

        magicianStatusTextArea.setText("");
        magicianTabDisplayNameLabel.setText("Customer          Holiday              Booking time");
        for (BookingQueries.BookingEntry bookingEntry : bookingByMagicianResults) {
            magicianStatusTextArea.append(bookingEntry.getCustomer() + "\t" + bookingEntry.getHoliday() + "\t" + bookingEntry.getTimestamp().toString() + "\n");
        }

    }//GEN-LAST:event_magicianStatusButtonActionPerformed

    private void holidayStatusButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_holidayStatusButtonActionPerformed
        // TODO add your handling code here:
        bookingByHolidayResults = BookingQueries.getBookingByHoliday(holidayComboboxforStatus.getSelectedItem().toString(), connection);

        holidayStatusTextArea.setText("");
        holidayTabDisplayNameLabel.setText("Customer          Holiday               Booking time");
        for (BookingQueries.BookingEntry bookingEntry : bookingByHolidayResults) {
            holidayStatusTextArea.append(bookingEntry.getCustomer() + "\t" + bookingEntry.getMagician() + "\n");
        }
    }//GEN-LAST:event_holidayStatusButtonActionPerformed

    private void magicianComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_magicianComboBoxActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_magicianComboBoxActionPerformed

    private void holidayComboboxforStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_holidayComboboxforStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_holidayComboboxforStatusActionPerformed

    private void holidayComboboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_holidayComboboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_holidayComboboxActionPerformed

    private void customerTextfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerTextfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_customerTextfieldActionPerformed

    private void bookingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookingButtonActionPerformed
        // TODO add your handling code here:
        String freeMagicianName;
        String customerName;
        String holidayName = null;
        boolean ifExisting = false;

        customerName = customerTextfield.getText();
        if (holidayCombobox.getItemCount()!=0)
            holidayName = holidayCombobox.getSelectedItem().toString();

        if (BookingQueries.ifBookingExisting(customerName, holidayName, connection) || WaitlistQueries.ifWaitlistExisting(customerName, holidayName, connection)) {
            ifExisting = true;
        }
        if (ifExisting == false && holidayName != null) {

            freeMagicianName = MagicianQueries.getFreeMagician(holidayName, connection);
            if (freeMagicianName == null) {
                WaitlistQueries.WaitlistEntry currentWaitlistEntry = new WaitlistQueries.WaitlistEntry(customerName, holidayName,
                        new Timestamp(Calendar.getInstance().getTime().getTime()));

                WaitlistQueries.insertNewWaitlistEntry(currentWaitlistEntry, connection);
                bookingStatusTextArea.setText("Sorry, there are no free magicians. " + customerName + " is added to the waitlist");

                WaitlistQueries.updateWaitlistTab(waitlistUpdateTimeLabel, waitlistStatusTextArea, connection);
            } else {
                BookingQueries.BookingEntry currentBookinglistEntry = new BookingQueries.BookingEntry(customerName, freeMagicianName, holidayName,
                        new Timestamp(Calendar.getInstance().getTime().getTime()));
                BookingQueries.addBooking(currentBookinglistEntry, connection);
                bookingStatusTextArea.setText(customerName + " has been assigned to magician " + freeMagicianName);

            }
        } else {
            if (holidayName == null)
                bookingStatusTextArea.setText("No holiday selected yet.");
            else
                bookingStatusTextArea.setText("You can't place the same booking again");
        }

        BookingQueries.updateCustomerComboBox(customerComboBox, connection);
        HolidayQueries.updateCustomerHolidayList(customerComboBox, selectedCustomerHolidayComboBox, connection);
        WaitlistQueries.updateWaitlistByCustomerComboBox(customerComboBox, waitlistByCustomerComboBox, connection);

    }//GEN-LAST:event_bookingButtonActionPerformed

    private void newMagicianTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newMagicianTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newMagicianTextFieldActionPerformed

    private void addMagicianButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMagicianButtonActionPerformed
        // TODO add your handling code here:
        String newMagicianName;
        newMagicianName = newMagicianTextField.getText();

        MagicianQueries.insertNewMagician(newMagicianName, connection);        //add a new magician
        magicianStatusTextArea.setText(newMagicianName + " is added to magician list now! \n");
        magicianTabDisplayNameLabel.setText("Magician List Update! @ " + new Timestamp(Calendar.getInstance().getTime().getTime()).toString());

        MagicianQueries.updateMagicianComboBox(magicianComboBox, connection);

        List<WaitlistQueries.WaitlistEntry> topWaitList = null;
        topWaitList = WaitlistQueries.getTopWaitlist(connection);

        if (!topWaitList.isEmpty()) {
            magicianTabDisplayNameLabel.setText("Magician List & New Booking Update! @ " + new Timestamp(Calendar.getInstance().getTime().getTime()).toString());
        }
        for (int i = 0; i < topWaitList.size(); i++) //make new bookings for the top waitlists
        {
            BookingQueries.BookingEntry newBookingListEntry = new BookingQueries.BookingEntry(topWaitList.get(i).getCustomer(),
                    newMagicianName, topWaitList.get(i).getHoliday(), topWaitList.get(i).getTimestamp());
            BookingQueries.addBooking(newBookingListEntry, connection);
            magicianStatusTextArea.append(newBookingListEntry.getCustomer() + " is assigned to magician " + newBookingListEntry.getMagician() + " for holiday " + newBookingListEntry.getHoliday() + "\n");

            BookingQueries.updateCustomerComboBox(customerComboBox, connection);
            HolidayQueries.updateCustomerHolidayList(customerComboBox, selectedCustomerHolidayComboBox, connection);

            WaitlistQueries.deleteWaitlistEntry(topWaitList.get(i).getTimestamp(), connection);
            WaitlistQueries.updateWaitlistTab(waitlistUpdateTimeLabel, waitlistStatusTextArea, connection);
        }
    }//GEN-LAST:event_addMagicianButtonActionPerformed

    private void cancelBookingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBookingButtonActionPerformed
        // TODO add your handling code here:
        ResultSet waitlistResultSet = null;
        ResultSet bookingResultSet = null;
        String freeMagican = null;
        String waitlistCustomer = null;

        String customerToCancel = null;
        if (customerComboBox.getItemCount() != 0) {
            customerToCancel = customerComboBox.getSelectedItem().toString();
        }

        String holiday = null;
        if (selectedCustomerHolidayComboBox.getItemCount() != 0) {
            holiday = selectedCustomerHolidayComboBox.getSelectedItem().toString();
        }

        Timestamp bookingEntryTimeStamp = null;
        Timestamp waitlistEntryTimestamp = null;

        try {
            if (customerToCancel != null && holiday != null) {
                //Find the booking entry with customer and holiday
                PreparedStatement selectBookingOfCstmHld = connection.prepareStatement("SELECT * FROM BOOKINGTABLE "
                        + "WHERE CUSTOMER = ? AND HOLIDAY = ?");
                selectBookingOfCstmHld.setString(1, customerToCancel);
                selectBookingOfCstmHld.setString(2, holiday);
                bookingResultSet = selectBookingOfCstmHld.executeQuery();

                if (bookingResultSet.next()) {
                    freeMagican = new String(bookingResultSet.getString("MAGICIAN"));
                    bookingEntryTimeStamp = bookingResultSet.getTimestamp("TIMESTAMP");
                }

                //Delete the booking entry with timestamp
                PreparedStatement deleteBookingOfCstmHld = connection.prepareStatement("DELETE FROM BOOKINGTABLE "
                        + "WHERE TIMESTAMP = ?");
                deleteBookingOfCstmHld.setTimestamp(1, bookingEntryTimeStamp);
                deleteBookingOfCstmHld.executeUpdate();

                bookingStatusTextArea.setText("Cancelation succeeded! \n");

                //find top waitlist entries for the holiday
                PreparedStatement selectTopWaitlistEntryOfHld = connection.prepareStatement("SELECT * FROM WAITLISTTABLE "
                        + "WHERE HOLIDAY = ? "
                        + "ORDER BY TIMESTAMP ASC");
                selectTopWaitlistEntryOfHld.setString(1, holiday);
                waitlistResultSet = selectTopWaitlistEntryOfHld.executeQuery();

                if (waitlistResultSet.next()) {
                    waitlistCustomer = new String(waitlistResultSet.getString("CUSTOMER"));
                    waitlistEntryTimestamp = waitlistResultSet.getTimestamp("TIMESTAMP");
                    BookingQueries.BookingEntry newBookingEntry = new BookingQueries.BookingEntry(waitlistCustomer,
                            freeMagican, selectedCustomerHolidayComboBox.getSelectedItem().toString(),
                            new Timestamp(Calendar.getInstance().getTime().getTime()));
                    BookingQueries.addBooking(newBookingEntry, connection);
                    bookingStatusTextArea.append(waitlistCustomer + " from waitlist is now assined to " + freeMagican + "\n");

                    //delete the waitlist entry
                    WaitlistQueries.deleteWaitlistEntry(waitlistEntryTimestamp, connection);
                }
                BookingQueries.updateCustomerComboBox(customerComboBox, connection);
                HolidayQueries.updateCustomerHolidayList(customerComboBox, selectedCustomerHolidayComboBox, connection);
                WaitlistQueries.updateWaitlistTab(waitlistUpdateTimeLabel, waitlistStatusTextArea, connection);
                WaitlistQueries.updateWaitlistByCustomerComboBox(customerComboBox, waitlistByCustomerComboBox, connection);
            }

        } catch (SQLException sQLException) {
            sQLException.printStackTrace();;
            System.exit(1);
        }
        //update customer combobox


    }//GEN-LAST:event_cancelBookingButtonActionPerformed

    private void selectedCustomerHolidayComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectedCustomerHolidayComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_selectedCustomerHolidayComboBoxActionPerformed

    private void dropMagicanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dropMagicanButtonActionPerformed
        // TODO add your handling code here:
        ArrayList<BookingQueries.BookingEntry> abondonedBookingEntryResults = new ArrayList<BookingQueries.BookingEntry>();
        ResultSet resultSet = null;
        String magicianToDrop = magicianComboBox.getSelectedItem().toString();
        magicianStatusTextArea.setText("");
        try {
            PreparedStatement selectAbondonedBookingEntry = connection.prepareStatement("SELECT * FROM BOOKINGTABLE WHERE MAGICIAN = ?");
            selectAbondonedBookingEntry.setString(1, magicianToDrop);
            resultSet = selectAbondonedBookingEntry.executeQuery();

            while (resultSet.next()) {
                abondonedBookingEntryResults.add(new BookingQueries.BookingEntry(resultSet.getString("CUSTOMER"), resultSet.getString("MAGICIAN"), resultSet.getString("HOLIDAY"), resultSet.getTimestamp("TIMESTAMP")));
            }

            PreparedStatement deleteAbondonedBookingEntry = connection.prepareStatement("DELETE FROM BOOKINGTABLE WHERE MAGICIAN = ?");
            deleteAbondonedBookingEntry.setString(1, magicianToDrop);
            deleteAbondonedBookingEntry.executeUpdate();

            PreparedStatement deleteMagician = connection.prepareStatement("DELETE FROM MAGICIANTABLE WHERE MAGICIANNAME = ?");
            deleteMagician.setString(1, magicianToDrop);
            deleteMagician.executeUpdate();
            magicianStatusTextArea.append(magicianToDrop + " has been deleted \n");

            MagicianQueries.updateMagicianComboBox(magicianComboBox, connection);

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.exit(1);
        }

        magicianTabDisplayNameLabel.setText("New Booking Update @ " + new Timestamp(Calendar.getInstance().getTime().getTime()).toString());
        for (int i = 0; i < abondonedBookingEntryResults.size(); i++) {
            String abondonedCustomer = abondonedBookingEntryResults.get(i).getCustomer();
            String holidayWanted = abondonedBookingEntryResults.get(i).getHoliday();
            Timestamp affectedBookingsTimestamp = abondonedBookingEntryResults.get(i).getTimestamp();

            String freeMagician = MagicianQueries.getFreeMagician(holidayWanted, connection);
            if (freeMagician != null) {
                BookingQueries.BookingEntry currentBookingEntry = new BookingQueries.BookingEntry(abondonedCustomer, freeMagician, holidayWanted, new Timestamp(Calendar.getInstance().getTime().getTime()));
                BookingQueries.addBooking(currentBookingEntry, connection);
                magicianStatusTextArea.append(abondonedCustomer + "has been reassigned to magician " + freeMagician + "\n");
            } else {
                WaitlistQueries.WaitlistEntry currentWaitlistEntry = new WaitlistQueries.WaitlistEntry(abondonedCustomer, holidayWanted, affectedBookingsTimestamp);
                WaitlistQueries.insertNewWaitlistEntry(currentWaitlistEntry, connection);
                magicianStatusTextArea.append(abondonedCustomer + " has been added to the front of the waitlist" + "\n");
                WaitlistQueries.updateWaitlistTab(waitlistUpdateTimeLabel, waitlistStatusTextArea, connection);
            }
        }

    }//GEN-LAST:event_dropMagicanButtonActionPerformed

    private void customerComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerComboBoxActionPerformed
        // TODO add your handling code here:
        HolidayQueries.updateCustomerHolidayList(customerComboBox, selectedCustomerHolidayComboBox, connection);
        WaitlistQueries.updateWaitlistByCustomerComboBox(customerComboBox, waitlistByCustomerComboBox, connection);
    }//GEN-LAST:event_customerComboBoxActionPerformed

    private void newHolidayNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newHolidayNameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newHolidayNameTextFieldActionPerformed

    private void addHolidayButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addHolidayButtonActionPerformed
        // TODO add your handling code here:
        String newHoliday = newHolidayNameTextField.getText();
        HolidayQueries.addNewHoliday(newHoliday, connection);
        holidayStatusTextArea.setText(newHoliday + " is now added to the holiday list!");

        HolidayQueries.updateHolidayComboBox(holidayCombobox, connection);
        HolidayQueries.updateHolidayComboBox(holidayComboboxforStatus, connection);
    }//GEN-LAST:event_addHolidayButtonActionPerformed

    private void waitlistByCustomerComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_waitlistByCustomerComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_waitlistByCustomerComboBoxActionPerformed

    private void cancelWaitlistButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelWaitlistButtonActionPerformed
        // TODO add your handling code here:
        String customerToCancel = null;
        if (customerComboBox.getItemCount() != 0) {
            customerToCancel = customerComboBox.getSelectedItem().toString();
        }

        String holiday = null;
        if (waitlistByCustomerComboBox.getItemCount() != 0) {
            holiday = waitlistByCustomerComboBox.getSelectedItem().toString();
        }
        if (customerToCancel != null && holiday != null) {
            try {
                PreparedStatement deleteWaitlistEntry = connection.prepareStatement("DELETE FROM WAITLISTTABLE "
                        + "WHERE CUSTOMER = ? AND HOLIDAY = ?");
                deleteWaitlistEntry.setString(1, customerToCancel);
                deleteWaitlistEntry.setString(2, holiday);
                deleteWaitlistEntry.executeUpdate();
            } catch (SQLException sQLException) {
                sQLException.printStackTrace();
                System.exit(1);
            }
            BookingQueries.updateCustomerComboBox(customerComboBox, connection);
            HolidayQueries.updateCustomerHolidayList(customerComboBox, selectedCustomerHolidayComboBox, connection);
            WaitlistQueries.updateWaitlistByCustomerComboBox(customerComboBox, waitlistByCustomerComboBox, connection);
            WaitlistQueries.updateWaitlistTab(waitlistUpdateTimeLabel, waitlistStatusTextArea, connection);
        }


    }//GEN-LAST:event_cancelWaitlistButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MagicianAgentGUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MagicianAgentGUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MagicianAgentGUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MagicianAgentGUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MagicianAgentGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CustomerLabel;
    private javax.swing.JButton addHolidayButton;
    private javax.swing.JButton addMagicianButton;
    private javax.swing.JButton bookingButton;
    private javax.swing.JLabel bookingStatusLabel;
    private javax.swing.JTextArea bookingStatusTextArea;
    private javax.swing.JButton cancelBookingButton;
    private javax.swing.JButton cancelWaitlistButton;
    private javax.swing.JComboBox customerComboBox;
    private javax.swing.JTextField customerTextfield;
    private javax.swing.JLabel customerToCanceLabel;
    private javax.swing.JButton dropMagicanButton;
    private javax.swing.JComboBox holidayCombobox;
    private javax.swing.JComboBox holidayComboboxforStatus;
    private javax.swing.JLabel holidayLabel;
    private javax.swing.JLabel holidayListLabel;
    private javax.swing.JButton holidayStatusButton;
    private javax.swing.JTextArea holidayStatusTextArea;
    private javax.swing.JLabel holidayTabDisplayNameLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JComboBox magicianComboBox;
    private javax.swing.JLabel magicianListLabel;
    private javax.swing.JButton magicianStatusButton;
    private javax.swing.JTextArea magicianStatusTextArea;
    private javax.swing.JLabel magicianTabDisplayNameLabel;
    private javax.swing.JLabel newHolidayLabel;
    private javax.swing.JTextField newHolidayNameTextField;
    private javax.swing.JLabel newMagicianNameLabel;
    private javax.swing.JTextField newMagicianTextField;
    private javax.swing.JComboBox selectedCustomerHolidayComboBox;
    private javax.swing.JLabel selectedCustomerHolidayLabel;
    private javax.swing.JComboBox waitlistByCustomerComboBox;
    private javax.swing.JTextArea waitlistStatusTextArea;
    private javax.swing.JTabbedPane waitlistTabbedPane;
    private javax.swing.JLabel waitlistUpdateTimeLabel;
    // End of variables declaration//GEN-END:variables
}
