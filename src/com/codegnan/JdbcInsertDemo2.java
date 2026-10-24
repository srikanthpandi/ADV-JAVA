
package com.codegnan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcInsertDemo2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        System.out.println("enter the product name");
        String productName= scanner.nextLine();
        System.out.println("Enter the price of the product");
        double productPrice= scanner.nextDouble();

        System.out.println("enter the customername");
        String customerName= scanner.next();

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
                    + "VALUES('" +productName+ "',"+productPrice+")";

            int numOfRowsAffected = stmt.executeUpdate(sql1);

            if (numOfRowsAffected > 0) {
                System.out.println("Record 1 inserted successfully");
            }

            String sql2 = "INSERT INTO customer(name) "
                    + "VALUES('" +customerName+ "')";

            numOfRowsAffected = stmt.executeUpdate(sql2);

            if (numOfRowsAffected > 0) {
                System.out.println("Record 2 from table 2 inserted successfully");
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
