package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class AddCustomer extends JFrame implements ActionListener {

    JLabel l1, l2, l3, l4, l5, l6, l7, l8;
    JTextField t1, t2, t3, t4, t5;
    JRadioButton rbmale, rbfemale, rbother;
    JButton b1;

    AddCustomer() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        Font f = new Font("Tahoma", Font.PLAIN, 32);

        l1 = new JLabel("Add Customer Details");
        l1.setBounds(290, 50, 500, 50);
        l1.setFont(f);
        l1.setForeground(Color.BLUE);
        add(l1);

        l2 = new JLabel("Name");
        l2.setBounds(100, 100, 100, 50);
        l2.setFont(f);
        add(l2);
        t1 = new JTextField();
        t1.setBounds(230, 110, 200, 35);
        add(t1);

        l3 = new JLabel("Nationality");
        l3.setBounds(100, 180, 150, 50);
        l3.setFont(f);
        add(l3);
        t2 = new JTextField();
        t2.setBounds(270, 192, 200, 35);
        add(t2);

        l4 = new JLabel("Phone");
        l4.setBounds(100, 265, 150, 50);
        l4.setFont(f);
        add(l4);
        t3 = new JTextField();
        t3.setBounds(210, 278, 200, 35);
        add(t3);

        l5 = new JLabel("Address");
        l5.setBounds(100, 340, 150, 50);
        l5.setFont(f);
        add(l5);
        t4 = new JTextField();
        t4.setBounds(250, 350, 200, 35);
        add(t4);

        l6 = new JLabel("Aadhar No");
        l6.setBounds(100, 420, 150, 50);
        l6.setFont(f);
        add(l6);
        t5 = new JTextField();
        t5.setBounds(260, 430, 200, 35);
        add(t5);

        ButtonGroup gendergroup = new ButtonGroup();

        l7 = new JLabel("Gender");
        l7.setBounds(100, 500, 150, 25);
        l7.setFont(f);
        add(l7);

        rbmale = new JRadioButton("Male");
        rbmale.setBounds(220, 500, 70, 25);
        rbmale.setBackground(Color.WHITE);
        add(rbmale);

        rbfemale = new JRadioButton("Female");
        rbfemale.setBounds(300, 500, 70, 25);
        rbfemale.setBackground(Color.WHITE);
        add(rbfemale);

        rbother = new JRadioButton("Other");
        rbother.setBounds(380, 500, 70, 25);
        rbother.setBackground(Color.WHITE);
        add(rbother);

        gendergroup.add(rbmale);
        gendergroup.add(rbfemale);
        gendergroup.add(rbother);

        b1 = new JButton("SAVE");
        b1.setBounds(375, 550, 150, 50);
        b1.setFont(f);
        add(b1);
        b1.addActionListener(this);

        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/Icons/Customer.jpeg"));
        l8 = new JLabel(image);
        l8.setBounds(500, 100, 450, 450);
        add(l8);

        setSize(900, 900);
        setLocation(500, 10);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent a) {
        String name = t1.getText();
        String nationality = t2.getText();
        String phone = t3.getText();
        String address = t4.getText();
        String aadhar = t5.getText();

        String gender = null;
        if (rbmale.isSelected()) {
            gender = "Male";
        } else if (rbfemale.isSelected()) {
            gender = "Female";
        } else if (rbother.isSelected()) {
            gender = "Other";
        }

        if (name.isEmpty() || nationality.isEmpty() || phone.isEmpty() || address.isEmpty() || aadhar.isEmpty() || gender == null) {
            JOptionPane.showMessageDialog(null, "Your details are incomplete", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                Conn c = new Conn();
                String query = "INSERT INTO passenger(name, nationality, phone, address, aadhar, gender) VALUES(?, ?, ?, ?, ?, ?)";
                PreparedStatement pstmt = c.getConnection().prepareStatement(query);
                pstmt.setString(1, name);
                pstmt.setString(2, nationality);
                pstmt.setString(3, phone);
                pstmt.setString(4, address);
                pstmt.setString(5, aadhar);
                pstmt.setString(6, gender);
                pstmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Customer details saved successfully");
                setVisible(false);
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new AddCustomer();
    }
}
