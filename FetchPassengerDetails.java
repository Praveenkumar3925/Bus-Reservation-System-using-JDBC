package com.mysql.BusReservationSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class FetchPassengerDetails {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        final String URL = "jdbc:mysql://localhost:3306/BusReservationSystem";
        final String USER = "root";
        final String PASSWORD = "Praveen@123";

        String sql = "SELECT p.passenger_id, p.name, p.email, " +
                     "r.route_id, r.source, r.destination, " +
                     "res.seat_number, res.reservation_date, b.bus_number " +
                     "FROM Passenger p " +
                     "JOIN Reservation res ON p.passenger_id = res.passenger_id " +
                     "JOIN Route r ON res.route_id = r.route_id " +
                     "JOIN Bus b ON res.bus_id = b.bus_id " +
                     "WHERE res.reservation_id = ?";

        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pst = con.prepareStatement(sql)) {

            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter reservation ID: ");
           
            int reservationId = scanner.nextInt();
            System.out.println();
            System.out.println("Full details of Passenger:");
            System.out.println();

            pst.setInt(1, reservationId);
            ResultSet rs = pst.executeQuery();

            boolean hasResults = false;
            while (rs.next()) {
                hasResults = true;
                int passengerId = rs.getInt("passenger_id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                int routeId = rs.getInt("route_id");
                String source = rs.getString("source");
                String destination = rs.getString("destination");
                int seatNumber = rs.getInt("seat_number");
                String reservationDate = rs.getString("reservation_date");
                String busNumber = rs.getString("bus_number");

                System.out.println("Passenger ID :" + passengerId);
                System.out.println("Name :" + name);
                System.out.println("Email: " + email);
                System.out.println("Route ID: " + routeId);
                System.out.println("Source: " + source);
                System.out.println("Destination: " + destination);
                System.out.println("Seat Number: " + seatNumber);
                System.out.println("Reservation Date: " + reservationDate);
                System.out.println("Bus Number: " + busNumber);
                System.out.println("-------------********---------------");
            }

            if (!hasResults) {
                System.out.println("No passenger found with the reservation ID: " + reservationId);
            }

            scanner.close();
        }
    }
}
S