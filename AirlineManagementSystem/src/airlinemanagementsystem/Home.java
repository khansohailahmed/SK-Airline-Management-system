package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener {

    Home() {
        // Set layout to null for absolute positioning
        setLayout(null);

        // Load the image from the specified path
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/Icons/front.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1700, 850, Image.SCALE_DEFAULT);
        ImageIcon image = new ImageIcon(i2);
        JLabel lblimage = new JLabel(image);
        lblimage.setBounds(0, 0, 1700, 850);
        add(lblimage);
        
        
        // Add a heading label to the image
        JLabel heading = new JLabel("Welcome Sk Fly");
        heading.setBounds(350, 20, 1000, 150);
        heading.setFont(new Font("Tahoma", Font.BOLD, 75));
        heading.setForeground(Color.CYAN);
        lblimage.add(heading);

        // Create a menu bar
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        // Add 'Details' menu to the menu bar
        JMenu details = new JMenu("Details");
        menuBar.add(details);
        
        // Add menu items to the 'Details' 
        JMenuItem flightDetails = new JMenuItem("Flight Details");
        flightDetails.addActionListener(this);
        details.add(flightDetails);
        
        JMenuItem addCustomerDetails = new JMenuItem("Add Customer Details");
        addCustomerDetails.addActionListener(this);
        details.add(addCustomerDetails);
        
        JMenuItem bookFlight = new JMenuItem("Book Flight");
        bookFlight.addActionListener(this);
        details.add(bookFlight);

        JMenuItem journeyDetails = new JMenuItem("Journey Details");
        journeyDetails.addActionListener(this);
        details.add(journeyDetails);

        JMenuItem ticketCancellationDetails = new JMenuItem("Cancel Ticket");
        ticketCancellationDetails.addActionListener(this);
        details.add(ticketCancellationDetails);

        // Add 'Ticket' menu to the menu bar
        JMenu ticket = new JMenu("Ticket");
        menuBar.add(ticket);

        // Add 'Boarding Pass' menu item to the 'Ticket' menu
        JMenuItem boardingPass = new JMenuItem("Boarding Pass");
        boardingPass.addActionListener(this);
        ticket.add(boardingPass);

        // Set the frame to be maximized
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        // Make the frame visible
        setVisible(true);
    }

    // Handle action events here
    public void actionPerformed(ActionEvent e) {
        String text = e.getActionCommand();
        if (text.equals("Add Customer Details")) {
            new AddCustomer();
        } else if (text.equals("Flight Details")) {
            new FlightInFo();
        }else if(text.equals("Book Flight")){
        new BookFlight();
        }else if(text == "Journey Details"){
        new JourneyDetails();
        }else if(text == "Cancel Ticket"){
        new Cancel();
        }else if( text == "Boarding Pass"){
            new BoardingPass();


      }

        
    }
    

    public static void main(String[] args) {
        
        new Home();
    }
}
