package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JLabel l1, l2;
    JTextField t1;
    JPasswordField p1;
    JButton b1, b2, b3, b4;
    Register registerWindow; // Reference to Register window

    Login() {
        getContentPane().setBackground(Color.WHITE);
        setTitle("Login");
        setSize(500, 500); // Set initial size of the JFrame
        setLocationRelativeTo(null); // Center the JFrame on the screen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initialize components
        l1 = new JLabel("User Name/ID");
        l1.setBounds(100, 100, 100, 50);
        add(l1);

        l2 = new JLabel("Password");
        l2.setBounds(100, 200, 100, 50);
        add(l2);

        t1 = new JTextField();
        t1.setBounds(250, 115, 200, 30);
        add(t1);

        p1 = new JPasswordField();
        p1.setBounds(250, 215, 200, 30);
        add(p1);

        b1 = new JButton("Close");
        b1.setBounds(50, 300, 100, 50);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Submit");
        b2.setBounds(200, 300, 100, 50);
        b2.addActionListener(this);
        add(b2);

        b3 = new JButton("Clear");
        b3.setBounds(350, 300, 100, 50);
        b3.addActionListener(this);
        add(b3);

        b4 = new JButton("Register");
        b4.setBounds(200, 370, 150, 50);
        b4.addActionListener(this);
        add(b4);

        setLayout(null); // Set layout after adding components

        setVisible(true); // Set JFrame visible after all components are added
    }

    public void actionPerformed(ActionEvent a) {
        if (a.getSource() == b1) {
            setVisible(false); // Close JFrame if Close button is clicked
        } else if (a.getSource() == b3) {
            t1.setText(""); // Clear username field
            p1.setText(""); // Clear password field
        } else if (a.getSource() == b4) {
            setVisible(false); // Hide Login window
            registerWindow = new Register(); // Open Register window
        } else if (a.getSource() == b2) {
            String Username = t1.getText();
            String Password = new String(p1.getPassword());
            try {
                // fro database connection and query execution (you need to implement Conn class)
                Conn c = new Conn();
                String query = "select * from login where username = '" + Username + "' and password ='" + Password + "'";
                ResultSet rs = c.s.executeQuery(query);
                if (rs.next()) {
                    new Home();
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Username or Password");// Show message dialog for invalid login
                    setVisible(false);
                }

            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Login();
        
    }
}
