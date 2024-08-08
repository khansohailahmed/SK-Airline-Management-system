package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class FlightInFo extends JFrame implements ActionListener {

    public FlightInFo() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        // Create a JTable to display the data
        JTable table = new JTable();
        
        try {
            Conn c = new Conn();
            // Corrected the SQL query
            ResultSet rs = c.s.executeQuery("SELECT * FROM flight");
            // Set the model for the JTable using DbUtils
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        
        // Add the JTable to a JScrollPane
        JScrollPane j = new JScrollPane(table);
        j.setBounds(0, 0, 800, 500);
        add(j);
        
        setSize(800, 500);
        setLocation(300, 100);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent a) {
        // Define actions here if needed
    }

    public static void main(String[] args) {
        new FlightInFo();
    }
}
