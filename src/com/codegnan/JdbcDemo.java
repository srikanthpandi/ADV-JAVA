
package com.codegnan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDemo {
    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Sqlnotes",
                    "root",
                    "123@123"
            );

            System.out.println("Connection Established");

            Statement stmt = con.createStatement();

            String sql1 = "INSERT INTO product(product_name, product_price) "
                    + "VALUES('coffe', 30)";

            int numOfRowsAffected = stmt.executeUpdate(sql1);

            if (numOfRowsAffected > 0) {
                System.out.println("Record 1 inserted successfully");
            }

            String sql2 = "INSERT INTO product(product_name, product_price) "
                    + "VALUES('vennila-shacke', 220)";

            numOfRowsAffected = stmt.executeUpdate(sql2);

            if (numOfRowsAffected > 0) {
                System.out.println("Record 2 inserted successfully");
            }

            String sql3 = "INSERT INTO customer(name) "
                    + "VALUES('ramesh')";

            numOfRowsAffected = stmt.executeUpdate(sql3);

            if (numOfRowsAffected > 0) {
                System.out.println("Record 3 inserted successfully");
            }
            String sql4 = "INSERT INTO customer(name) "
                    + "VALUES('kushal')";

            numOfRowsAffected = stmt.executeUpdate(sql4);

            if (numOfRowsAffected > 0) {
                System.out.println("Record 4 inserted successfully");
            }
            stmt.close();
            con.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
