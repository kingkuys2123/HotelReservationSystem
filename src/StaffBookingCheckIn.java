/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author kyleq
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

public class StaffBookingCheckIn extends javax.swing.JFrame {

    private String databaseUrl = "jdbc:mysql://localhost:3306/hotel?zeroDateTimeBehavior=CONVERT_TO_NULL";
    private String username = "root";
    private String password = "";
    private HotelDatabaseManager hotelDBM = new HotelDatabaseManager(databaseUrl, username, password);
    
    private int booking_id;
    private String room_number;
    private String guest_name;
    private String booking_date;
    private String checkin_date;
    private String checkout_date;
    private String total_cost;
      
    
    private Staff staff = null;
    private User user = null;
    
    public StaffBookingCheckIn(Staff staff, User user, int booking_id, String room_number, String guest_name, String booking_date, String checkin_date, String checkout_date, String total_cost){
        this.staff=staff;
        this.user=user;
        this.booking_id=booking_id;
        this.room_number=room_number;
        this.guest_name=guest_name;
        this.booking_date=booking_date;
        this.checkin_date=checkin_date;
        this.checkout_date=checkout_date;
        this.total_cost=total_cost;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        navPanel = new javax.swing.JPanel();
        hotelLabelImg = new javax.swing.JLabel();
        roomsButton = new javax.swing.JButton();
        servicesButton = new javax.swing.JButton();
        feedbackButon = new javax.swing.JButton();
        logOutButton = new javax.swing.JButton();
        staffNameLabel = new javax.swing.JLabel();
        bookingsButton4 = new javax.swing.JButton();
        checkInsButtons2 = new javax.swing.JButton();
        billsButton = new javax.swing.JButton();
        headerPanel6 = new javax.swing.JPanel();
        bookingsHeader = new javax.swing.JLabel();
        lowerPanel = new javax.swing.JPanel();
        notifLabel = new javax.swing.JLabel();
        confirmCheckInButton = new javax.swing.JButton();
        guestNameHeaderLabel = new javax.swing.JLabel();
        roomNumberHeaderLabel = new javax.swing.JLabel();
        dateBookedHeaderLabel = new javax.swing.JLabel();
        checkInDateHeaderLabel = new javax.swing.JLabel();
        checkOutDateHeaderLabel = new javax.swing.JLabel();
        totalCostHeaderLabel = new javax.swing.JLabel();
        issueKeyCardCheckBox = new javax.swing.JCheckBox();
        issueKeyCardHeaderLabel = new javax.swing.JLabel();
        arrivalHeaderLabel = new javax.swing.JLabel();
        arrivalComboBox = new javax.swing.JComboBox<>();
        guestNameLabel = new javax.swing.JLabel();
        roomNumberLabel = new javax.swing.JLabel();
        dateBookedLabel = new javax.swing.JLabel();
        checkInDateLabel = new javax.swing.JLabel();
        totalCostLabel = new javax.swing.JLabel();
        checkOutDateLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("User Home");
        setResizable(false);

        navPanel.setBackground(new java.awt.Color(196, 167, 111));
        navPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        hotelLabelImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/hotel-label.png"))); // NOI18N

        roomsButton.setBackground(new java.awt.Color(88, 73, 16));
        roomsButton.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        roomsButton.setForeground(new java.awt.Color(255, 255, 255));
        roomsButton.setText("Rooms");
        roomsButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        roomsButton.setBorderPainted(false);
        roomsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roomsButtonActionPerformed(evt);
            }
        });

        servicesButton.setBackground(new java.awt.Color(88, 73, 16));
        servicesButton.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        servicesButton.setForeground(new java.awt.Color(255, 255, 255));
        servicesButton.setText("Services");
        servicesButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        servicesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                servicesButtonActionPerformed(evt);
            }
        });

        feedbackButon.setBackground(new java.awt.Color(88, 73, 16));
        feedbackButon.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        feedbackButon.setForeground(new java.awt.Color(255, 255, 255));
        feedbackButon.setText("Feedbacks");
        feedbackButon.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        feedbackButon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                feedbackButonActionPerformed(evt);
            }
        });

        logOutButton.setBackground(new java.awt.Color(88, 73, 16));
        logOutButton.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        logOutButton.setForeground(new java.awt.Color(255, 255, 255));
        logOutButton.setText("Logout");
        logOutButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        logOutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOutButtonActionPerformed(evt);
            }
        });

        staffNameLabel.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        staffNameLabel.setForeground(new java.awt.Color(88, 73, 16));
        staffNameLabel.setText("staffName");
        staffNameLabel.setToolTipText("");

        bookingsButton4.setBackground(new java.awt.Color(88, 73, 16));
        bookingsButton4.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        bookingsButton4.setForeground(new java.awt.Color(255, 255, 255));
        bookingsButton4.setText("Bookings");
        bookingsButton4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bookingsButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookingsButton4ActionPerformed(evt);
            }
        });

        checkInsButtons2.setBackground(new java.awt.Color(88, 73, 16));
        checkInsButtons2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        checkInsButtons2.setForeground(new java.awt.Color(255, 255, 255));
        checkInsButtons2.setText("Check Ins");
        checkInsButtons2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        checkInsButtons2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkInsButtons2ActionPerformed(evt);
            }
        });

        billsButton.setBackground(new java.awt.Color(88, 73, 16));
        billsButton.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        billsButton.setForeground(new java.awt.Color(255, 255, 255));
        billsButton.setText("Bills");
        billsButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        billsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                billsButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout navPanelLayout = new javax.swing.GroupLayout(navPanel);
        navPanel.setLayout(navPanelLayout);
        navPanelLayout.setHorizontalGroup(
            navPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, navPanelLayout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addGroup(navPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(billsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(staffNameLabel, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(roomsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(hotelLabelImg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(servicesButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(feedbackButon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(logOutButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bookingsButton4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(checkInsButtons2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18))
        );
        navPanelLayout.setVerticalGroup(
            navPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(hotelLabelImg)
                .addGap(18, 18, 18)
                .addComponent(staffNameLabel)
                .addGap(18, 18, 18)
                .addComponent(roomsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bookingsButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checkInsButtons2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(servicesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(billsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(feedbackButon, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(logOutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        staffNameLabel.setText("Hello, " + staff.getFirstName());

        headerPanel6.setBackground(new java.awt.Color(216, 196, 156));
        headerPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        bookingsHeader.setFont(new java.awt.Font("Times New Roman", 0, 48)); // NOI18N
        bookingsHeader.setForeground(new java.awt.Color(88, 73, 16));
        bookingsHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bookingsHeader.setText("BOOKINGS");

        javax.swing.GroupLayout headerPanel6Layout = new javax.swing.GroupLayout(headerPanel6);
        headerPanel6.setLayout(headerPanel6Layout);
        headerPanel6Layout.setHorizontalGroup(
            headerPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bookingsHeader, javax.swing.GroupLayout.DEFAULT_SIZE, 699, Short.MAX_VALUE)
                .addContainerGap())
        );
        headerPanel6Layout.setVerticalGroup(
            headerPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bookingsHeader, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                .addContainerGap())
        );

        notifLabel.setForeground(new java.awt.Color(255, 102, 102));
        notifLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        confirmCheckInButton.setText("Confirm Check In");
        confirmCheckInButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmCheckInButtonActionPerformed(evt);
            }
        });

        guestNameHeaderLabel.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        guestNameHeaderLabel.setText("Guest:");

        roomNumberHeaderLabel.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        roomNumberHeaderLabel.setText("Room Number:");

        dateBookedHeaderLabel.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        dateBookedHeaderLabel.setText("Date Booked:");

        checkInDateHeaderLabel.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        checkInDateHeaderLabel.setText("Check In Date:");

        checkOutDateHeaderLabel.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        checkOutDateHeaderLabel.setText("Check Out Date:");

        totalCostHeaderLabel.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        totalCostHeaderLabel.setText("Total Cost:");

        issueKeyCardCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                issueKeyCardCheckBoxActionPerformed(evt);
            }
        });

        issueKeyCardHeaderLabel.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        issueKeyCardHeaderLabel.setText("Issue Key Card:");

        arrivalHeaderLabel.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        arrivalHeaderLabel.setText("Arrival:");

        arrivalComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Early", "Late" }));

        javax.swing.GroupLayout lowerPanelLayout = new javax.swing.GroupLayout(lowerPanel);
        lowerPanel.setLayout(lowerPanelLayout);
        lowerPanelLayout.setHorizontalGroup(
            lowerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(confirmCheckInButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(lowerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(lowerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lowerPanelLayout.createSequentialGroup()
                        .addGroup(lowerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(notifLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 703, Short.MAX_VALUE)
                            .addGroup(lowerPanelLayout.createSequentialGroup()
                                .addGroup(lowerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(checkInDateHeaderLabel)
                                    .addComponent(checkOutDateHeaderLabel)
                                    .addComponent(dateBookedHeaderLabel)
                                    .addComponent(totalCostHeaderLabel)
                                    .addComponent(roomNumberHeaderLabel))
                                .addGap(18, 18, 18)
                                .addGroup(lowerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(roomNumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dateBookedLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(checkInDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(totalCostLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(checkOutDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(300, 300, 300)
                                .addComponent(arrivalComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lowerPanelLayout.createSequentialGroup()
                        .addGroup(lowerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(lowerPanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(arrivalHeaderLabel))
                            .addGroup(lowerPanelLayout.createSequentialGroup()
                                .addGap(72, 72, 72)
                                .addComponent(guestNameHeaderLabel)
                                .addGap(18, 18, 18)
                                .addComponent(guestNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(issueKeyCardHeaderLabel)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(issueKeyCardCheckBox)
                        .addGap(111, 111, 111))))
        );
        lowerPanelLayout.setVerticalGroup(
            lowerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lowerPanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(lowerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(lowerPanelLayout.createSequentialGroup()
                        .addGroup(lowerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(lowerPanelLayout.createSequentialGroup()
                                .addGroup(lowerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(lowerPanelLayout.createSequentialGroup()
                                        .addGroup(lowerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(issueKeyCardCheckBox, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(guestNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(lowerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(guestNameHeaderLabel)
                                                .addComponent(issueKeyCardHeaderLabel)))
                                        .addGap(34, 34, 34)
                                        .addGroup(lowerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(roomNumberHeaderLabel)
                                            .addComponent(arrivalHeaderLabel)
                                            .addComponent(arrivalComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(roomNumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(29, 29, 29)
                                .addComponent(dateBookedHeaderLabel))
                            .addComponent(dateBookedLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addComponent(checkInDateHeaderLabel))
                    .addComponent(checkInDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(lowerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkOutDateHeaderLabel)
                    .addComponent(checkOutDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(lowerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(totalCostHeaderLabel)
                    .addComponent(totalCostLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(notifLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(confirmCheckInButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        guestNameLabel.setText(this.guest_name);
        roomNumberLabel.setText(this.room_number);
        dateBookedLabel.setText(this.booking_date);
        checkInDateLabel.setText(this.checkin_date);
        totalCostLabel.setText(this.total_cost);
        checkOutDateLabel.setText(this.checkout_date);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(navPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(headerPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lowerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(navPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(headerPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lowerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void roomsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roomsButtonActionPerformed
        StaffRooms staffRoom = new StaffRooms(staff, user);
        staffRoom.setVisible(true);
        dispose();
    }//GEN-LAST:event_roomsButtonActionPerformed

    private void servicesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_servicesButtonActionPerformed
        Login login = new Login();
        login.setVisible(true);
        dispose();
    }//GEN-LAST:event_servicesButtonActionPerformed

    private void feedbackButonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_feedbackButonActionPerformed
        StaffFeedback staffFeedback = new StaffFeedback(staff, user);
        staffFeedback.setVisible(true);
        dispose();
    }//GEN-LAST:event_feedbackButonActionPerformed

    private void logOutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOutButtonActionPerformed
        StaffServices staffServices = new StaffServices(staff, user);
        staffServices.setVisible(true);
        dispose();
    }//GEN-LAST:event_logOutButtonActionPerformed

    private void bookingsButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookingsButton4ActionPerformed
        StaffBookings staffBookings = new StaffBookings(staff, user);
        staffBookings.setVisible(true);
        dispose();
    }//GEN-LAST:event_bookingsButton4ActionPerformed

    private void checkInsButtons2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkInsButtons2ActionPerformed
        StaffCheckIns staffCheckIns = new StaffCheckIns(staff, user);
        staffCheckIns.setVisible(true);
        dispose();
    }//GEN-LAST:event_checkInsButtons2ActionPerformed

    private void confirmCheckInButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmCheckInButtonActionPerformed
        LocalDate checkinDate = parseDate(this.checkin_date);
        LocalDate checkoutDate = parseDate(this.checkout_date);
        double totalCost = Double.parseDouble(this.total_cost.replace("₱", ""));

        LocalDate currentDate = LocalDate.now();
        
        if (currentDate.isBefore(checkinDate)){
            notifLabel.setText("Can't process check in as it is not yet " + this.checkin_date + "!");
        } 
        else if (currentDate.isAfter(checkoutDate)){
            notifLabel.setText("Can't process check in as the current date is beyond the check-in and check-out period!");
        } 
        else {
            if (issueKeyCardCheckBox.isSelected()) {
                if(hotelDBM.updateBookingCheckIn(booking_id)){
                    if(hotelDBM.updateRoomStatus(Integer.parseInt(room_number), "Occupied")){
                        if(hotelDBM.registerCheckIn(arrivalComboBox.getSelectedItem().toString(), booking_id)){
                            if(hotelDBM.registerBill(totalCost, hotelDBM.retrieveCheckInID(booking_id))){
                                StaffBookings staffBookings = new StaffBookings(staff, user);
                                staffBookings.setVisible(true);
                                dispose();

                                JOptionPane.showMessageDialog(this, "Guest has successfully checked in!", "Check in", JOptionPane.INFORMATION_MESSAGE);
                            }
                            else{
                                notifLabel.setText("Error occured in registerBill!");
                            }
                        }
                        else{
                            notifLabel.setText("Error occured in registerCheckIn!");
                        }
                    }
                    else{
                        
                    }
                }
                else{
                    notifLabel.setText("Error occured in updateBookingCheckIn!");
                }
            } 
            else {
                notifLabel.setText("Check the key card issuance to process check-in!");
            }
        }
    }//GEN-LAST:event_confirmCheckInButtonActionPerformed

    private static LocalDate parseDate(String dateStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
        return LocalDate.parse(dateStr, formatter);
    }    
    
    private void issueKeyCardCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_issueKeyCardCheckBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_issueKeyCardCheckBoxActionPerformed

    private void billsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_billsButtonActionPerformed
        StaffBills staffBills = new StaffBills(staff, user);
        staffBills.setVisible(true);
        dispose();
    }//GEN-LAST:event_billsButtonActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> arrivalComboBox;
    private javax.swing.JLabel arrivalHeaderLabel;
    private javax.swing.JButton billsButton;
    private javax.swing.JButton bookingsButton4;
    private javax.swing.JLabel bookingsHeader;
    private javax.swing.JLabel checkInDateHeaderLabel;
    private javax.swing.JLabel checkInDateLabel;
    private javax.swing.JButton checkInsButtons2;
    private javax.swing.JLabel checkOutDateHeaderLabel;
    private javax.swing.JLabel checkOutDateLabel;
    private javax.swing.JButton confirmCheckInButton;
    private javax.swing.JLabel dateBookedHeaderLabel;
    private javax.swing.JLabel dateBookedLabel;
    private javax.swing.JButton feedbackButon;
    private javax.swing.JLabel guestNameHeaderLabel;
    private javax.swing.JLabel guestNameLabel;
    private javax.swing.JPanel headerPanel6;
    private javax.swing.JLabel hotelLabelImg;
    private javax.swing.JCheckBox issueKeyCardCheckBox;
    private javax.swing.JLabel issueKeyCardHeaderLabel;
    private javax.swing.JButton logOutButton;
    private javax.swing.JPanel lowerPanel;
    private javax.swing.JPanel navPanel;
    private javax.swing.JLabel notifLabel;
    private javax.swing.JLabel roomNumberHeaderLabel;
    private javax.swing.JLabel roomNumberLabel;
    private javax.swing.JButton roomsButton;
    private javax.swing.JButton servicesButton;
    private javax.swing.JLabel staffNameLabel;
    private javax.swing.JLabel totalCostHeaderLabel;
    private javax.swing.JLabel totalCostLabel;
    // End of variables declaration//GEN-END:variables
}