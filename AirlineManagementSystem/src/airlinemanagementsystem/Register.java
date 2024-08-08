package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Register extends JFrame implements ActionListener {

    JTextField userIdField;
    JPasswordField passwordField;
    JButton registerButton, loginButton;
 

    public Register() {
        

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("User Registration");
        heading.setBounds(200, 20, 400, 40);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 32));
        heading.setForeground(Color.BLUE);
        add(heading);

        JLabel userIdLabel = new JLabel("User ID:");
        userIdLabel.setBounds(60, 80, 150, 25);
        userIdLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(userIdLabel);

        userIdField = new JTextField();
        userIdField.setBounds(220, 80, 150, 25);
        add(userIdField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(60, 130, 150, 25);
        passwordLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(220, 130, 150, 25);
        add(passwordField);

        registerButton = new JButton("Register");
        registerButton.setBackground(Color.BLACK);
        registerButton.setForeground(Color.WHITE);
        registerButton.setBounds(100, 200, 120, 30);
        registerButton.addActionListener(this);
        add(registerButton);

        loginButton = new JButton("Login");
        loginButton.setBackground(Color.BLACK);
        loginButton.setForeground(Color.WHITE);
        loginButton.setBounds(260, 200, 120, 30);
        loginButton.addActionListener(this);
        add(loginButton);

        setSize(600, 300);
        setLocation(400, 200);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == registerButton) {
            String user = userIdField.getText();
            String pass = passwordField.getText();
            try {
                Conn c = new Conn();
                String query = "SELECT * FROM login WHERE username = '" + user + "'";
                ResultSet rs = c.s.executeQuery(query);
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Username already taken. Try another name.");
                } else {
                    query = "INSERT INTO login (username, password) VALUES ('" + user + "', '" + pass + "');";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "User Registered Successfully");
                }
            } catch (Exception e1) {
                System.out.println(e1.getMessage());
            }
        } else if (ae.getSource() == loginButton) {
            setVisible(false);
            new Login();
        }
    }

    public static void main(String[] args) {
        new Register();
    }
}
