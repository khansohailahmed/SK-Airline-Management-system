package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class Cancel extends JFrame implements ActionListener {

    JTextField tpnr;
    JLabel heading, pnr, name, tname, cancellation, tcancellation, fcode, tfcode, date, tdate;
    JButton fetch, cancel;
    Random random = new Random();

    public Cancel() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        heading = new JLabel("Cancel Ticket");
        heading.setBounds(420, 20, 500, 35);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 32));
        heading.setForeground(Color.BLUE);
        add(heading);

        pnr = new JLabel("PNR No");
        pnr.setBounds(60, 80, 150, 25);
        pnr.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(pnr);
        tpnr = new JTextField();
        tpnr.setBounds(220, 80, 150, 25);
        add(tpnr);

        fetch = new JButton("Fetch PNR");
        fetch.setBackground(Color.BLACK);
        fetch.setForeground(Color.WHITE);
        fetch.setBounds(380, 80, 120, 25);
        fetch.addActionListener(this);
        add(fetch);

        name = new JLabel("Name");
        name.setBounds(60, 130, 150, 25);
        name.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(name);
        tname = new JLabel();
        tname.setBounds(220, 130, 150, 25);
        add(tname);

        cancellation = new JLabel(" Cancellation no");
        cancellation.setBounds(60, 180, 150, 25);
        cancellation.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(cancellation);
        tcancellation = new JLabel(" " + random.nextInt(1000000));
        tcancellation.setBounds(220, 180, 150, 25);
        tcancellation.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(tcancellation);

        fcode = new JLabel("Flight Code");
        fcode.setBounds(60, 230, 150, 25);
        fcode.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(fcode);
        tfcode = new JLabel();
        tfcode.setBounds(220, 230, 150, 25);
        add(tfcode);

        date = new JLabel("Date of journey");
        date.setBounds(60, 280, 150, 25);
        date.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(date);
        tdate = new JLabel();
        tdate.setBounds(220, 280, 150, 25);
        add(tdate);

        cancel = new JButton("Cancel Ticket");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(380, 380, 120, 25);
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/Icons/1585.png"));
        Image i2 = i1.getImage().getScaledInstance(450, 320, Image.SCALE_DEFAULT);
        ImageIcon image = new ImageIcon(i2);
        JLabel lblimage = new JLabel(image);
        lblimage.setBounds(550, 80, 500, 410);
        add(lblimage);

        setSize(1100, 700);
        setLocation(200, 50);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == fetch) {
            String pnr= tpnr.getText();

            try {
                Conn conn = new Conn();

                String query = "select * from reservation where PNR = '" +pnr+ "'";

                ResultSet rs = conn.s.executeQuery(query);

                if (rs.next()) {
                    tname.setText(rs.getString("name"));
                    tfcode.setText(rs.getString("f_code"));
                    tdate.setText(rs.getString("ddate"));

                } else {
                    JOptionPane.showMessageDialog(null, "Please enter correct PNR");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (ae.getSource() == cancel) {

            String name = tname.getText();
            String pnr = tpnr.getText();
            String cancelno = tcancellation.getText();
            String fcode = tfcode.getText();
            String ddate = tdate.getText();

            try {
                Conn conn = new Conn();

                String query = "insert into cancel values('" + pnr + "','" + name + "','" + cancelno+" ','"+fcode+"','"+ddate+"')";
                

                conn.s.executeUpdate(query);
               conn.s.executeUpdate("DELETE FROM reservation WHERE PNR = '" + pnr + "'");
                JOptionPane.showMessageDialog(null, "Ticket Cancel");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Cancel();
    }
}
