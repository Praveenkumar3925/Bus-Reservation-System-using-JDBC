package com.mysql.BusReservationSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Route {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        final String URL = "jdbc:mysql://localhost:3306/BusReservationSystem";
        final String USER = "root";
        final String PASSWORD = "Praveen@123";

        String insertRouteSql = "INSERT INTO Route (route_id, source, destination) VALUES (?, ?, ?)";

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
        PreparedStatement insertRoutePst = con.prepareStatement(insertRouteSql);

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Route ID: ");
        int route_id = scanner.nextInt();
        insertRoutePst.setInt(1, route_id);
        scanner.nextLine(); // Consume the leftover newline character

        System.out.print("Enter source: ");
        String source = scanner.nextLine();
        insertRoutePst.setString(2, source);

        System.out.print("Enter destination: ");
        String destination = scanner.nextLine();
        insertRoutePst.setString(3, destination);

        insertRoutePst.executeUpdate();
        System.out.println("Route added successfully");

        scanner.close();
        insertRoutePst.close();
        con.close();
    }
}
