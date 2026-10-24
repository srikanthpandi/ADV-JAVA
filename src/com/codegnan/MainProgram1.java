package com.codegnan;

import java.sql.*;
public class MainProgram1 {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Sqlnotes",
                    "root",
                    "123@123"
            );

            Statement statement = con.createStatement();

            System.out.println("Connection Established");

            statement.close();
            con.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
