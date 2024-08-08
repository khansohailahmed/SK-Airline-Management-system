package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class JourneyDetails extends JFrame implements ActionListener {
    JTextField tpnr;
    JButton show;
    JTable table;
    JLabel lpnr;
    
    
    public JourneyDetails() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        Font f = new Font("Tahoma",Font.PLAIN,25);
        
        lpnr = new JLabel("PNR Details");
        lpnr.setBounds(50,50,150,25);
        lpnr.setFont(f);
        add(lpnr);
        tpnr = new JTextField();
        tpnr.setBounds(220,50,150,25);
        add(tpnr);
        
        show = new JButton("Show Details");
        show.setBackground(Color.BLACK);
        show.setForeground(Color.WHITE);
        show.setFont(f);
        show.setBounds(400,50,200,30);
        show.addActionListener(this);
        add(show);
        
        table = new JTable();
        
        JScrollPane j = new JScrollPane(table);
        j.setBounds(0, 100, 800, 150);
        add(j);
        
        setSize(800, 600);
        setLocation(400, 100);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent a) {
        // Define actions here if needed
        try{
            
            Conn c = new Conn();
            ResultSet rs =c.s.executeQuery("select * from reservation where PNR = '"+tpnr.getText()+"'");
            if(!rs.isBeforeFirst()){
                JOptionPane.showMessageDialog(null,"PRN Doesn't Exist");
            }
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        
        }catch(Exception e1){
        e1.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new JourneyDetails();
    }
}
