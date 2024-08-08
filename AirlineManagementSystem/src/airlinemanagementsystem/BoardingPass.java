package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BoardingPass extends JFrame implements ActionListener {

    JTextField tpnr;
    JLabel heading,h2, pnr, name, tname, nationality, tnationality,src,tsrc,dest,tdest,fname,tfname, fcode, tfcode, date, tdate;
    JButton fetch;
    
    public BoardingPass() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        heading = new JLabel("SK FLY");
        heading.setBounds(420, 05, 500, 35);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 32));
        add(heading);
        h2 = new JLabel("Boarding Pass Details");
        h2.setBounds(340, 40, 500, 35);
        h2.setFont(new Font("Tahoma", Font.PLAIN, 32));
        h2.setForeground(Color.BLUE);
        add(h2);

        pnr = new JLabel("PNR No");
        pnr.setBounds(60, 100, 150, 25);
        pnr.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(pnr);
        tpnr = new JTextField();
        tpnr.setBounds(220, 100, 150, 25);
        add(tpnr);

        fetch = new JButton("Fetch PNR");
        fetch.setBackground(Color.BLACK);
        fetch.setForeground(Color.WHITE);
        fetch.setBounds(380, 100, 120, 25);
        fetch.addActionListener(this);
        add(fetch);

        name = new JLabel("Name -");
        name.setBounds(60, 140, 150, 25);
        name.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(name);
        tname = new JLabel();
        tname.setBounds(220, 140, 150, 25);
        add(tname);

        nationality = new JLabel(" Nationality -");
        nationality.setBounds(60, 180, 150, 25);
        nationality.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(nationality);
        tnationality = new JLabel();
        tnationality.setBounds(220, 180, 150, 25);
        tnationality.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(tnationality);
        
        src = new JLabel(" SRC  -");
        src.setBounds(60, 220, 150, 25);
        src.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(src);
        tsrc = new JLabel();
        tsrc.setBounds(220, 220, 150, 25);
        tsrc.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(tsrc);
        
        dest = new JLabel(" DEST  -");
        dest.setBounds(290, 220, 150, 25);
        dest.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(dest);
        tdest = new JLabel();
        tdest.setBounds(410, 220, 150, 25);
        tdest.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(tdest);
        
        fname = new JLabel(" Filght Name  -");
        fname.setBounds(60, 285, 150, 25);
        fname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(fname);
        tfname = new JLabel();
        tfname.setBounds(220, 285, 150, 25);
        tfname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(tfname);
        
        fcode = new JLabel("Flight Code -");
        fcode.setBounds(290, 285, 150, 25);
        fcode.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(fcode);
        tfcode = new JLabel();
        tfcode.setBounds(410, 285, 150, 25);
        add(tfcode);

        date = new JLabel("Date of journey");
        date.setBounds(60, 340, 150, 25);
        date.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(date);
        tdate = new JLabel();
        tdate.setBounds(220, 340, 150, 25);
        add(tdate);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/Icons/b.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon image = new ImageIcon(i2);
        JLabel lblimage = new JLabel(image);
        lblimage.setBounds(450, 80, 400, 350);
        add(lblimage);

        setSize(900, 500);
        setLocation(250, 100);
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
                    tnationality.setText(rs.getString("nationality"));
                    tsrc.setText(rs.getString("src"));
                    tdest.setText(rs.getString("dest"));
                    tfname.setText(rs.getString("f_name"));                    
                    tfcode.setText(rs.getString("f_code"));
                    tdate.setText(rs.getString("ddate"));

                } else {
                    JOptionPane.showMessageDialog(null, "Please enter correct PNR");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        } 
    }

    public static void main(String[] args) {
        new BoardingPass();
    }
}
