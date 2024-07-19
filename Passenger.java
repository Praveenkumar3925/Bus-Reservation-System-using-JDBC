package com.mysql.BusReservationSystem;




import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Passenger {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        final String URL = "jdbc:mysql://localhost:3306/BusReservationSystem";
        final String USER = "root";
        final String PASSWORD = "Praveen@123"; 

        String sql = "INSERT INTO Passenger (passenger_id,name, email) VALUES (?,?, ?)";
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
        PreparedStatement pst = con.prepareStatement(sql);

        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter passenger ID: ");
        int id = scanner.nextInt();
        pst.setInt(1, id);
        scanner.nextLine();

        System.out.print("Enter passenger name: ");
        String name = scanner.nextLine();
        pst.setString(2, name);

        System.out.print("Enter passenger email: ");
        String email = scanner.nextLine();
        pst.setString(3, email);

        pst.executeUpdate();
        System.out.println("Passenger added successfully");

        scanner.close();
        pst.close();
        con.close();
    }
}
