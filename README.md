Airline Management System

Welcome to the Airline Management System! This project is designed to manage flight bookings, cancellations, and user registrations efficiently.

## Features

- User Registration and Login
- Book Flights
- Cancel Tickets
- View Flight Information
- User Dashboard

## Technologies Used

- Java Swing for the user interface
- MySQL for the database management
- JDBC for database connectivity

## Database

The MySQL database used for this project has been uploaded and is available in the repository. Make sure to configure the database connection settings according to your local setup.

### Database Structure

- login- Stores user credentials.
- passenger- Contains passenger information.
- flight- Holds flight details.
- reservation- Manages booking details.
- cancel- Tracks canceled tickets.

## Installation Instructions

1. Clone the Repository
   ```bash
   git clone https://github.com/khansohailahmed/airlinemanagementsystem.git
   ```

2. Set Up the Database
   - Import the provided SQL script to your MySQL server.
   - Update the `Conn` class with your database credentials:
     ```java
     conn = DriverManager.getConnection("jdbc:mysql:///airlinemanagementsystem", "yourusername", "yourpassword");
     ```

3. Run the Application
   - Compile and run the project in your preferred Java IDE.

## Usage

- Register a new user- Use the registration screen to create a new account.
- Login- Access the system using your registered credentials.
- Book a Flight- Search for available flights and complete your booking.
- Cancel a Ticket- Enter your PNR number to cancel a reservation.
- View Flight Information- Access the flight details from the main menu.

## Contributions

Feel free to fork this repository and make contributions. If you have any suggestions or improvements, please create an issue or submit a pull request.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for more details.

## Contact

For questions or feedback, please reach out via GitHub.

---

Thank you for checking out the Airline Management System! Happy flying! ✈️
