package com.mysql.BusReservationSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Bus {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        final String URL = "jdbc:mysql://localhost:3306/BusReservationSystem";
        final String USER = "root";
        final String PASSWORD = "Praveen@123";

        String sql = "INSERT INTO Bus (bus_id, bus_number, capacity) VALUES (?, ?, ?)";
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
        PreparedStatement pst = con.prepareStatement(sql);

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter bus Id: ");
        int busId = scanner.nextInt();
        pst.setInt(1, busId);

        System.out.print("Enter bus number: ");
        int busNumber = scanner.nextInt();
        pst.setInt(2, busNumber);

        System.out.print("Enter capacity: ");
        int capacity = scanner.nextInt();
        pst.setInt(3, capacity);

        pst.executeUpdate();
        System.out.println("Bus Added successfully");

        scanner.close();
        pst.close();
        con.close();
    }
}
