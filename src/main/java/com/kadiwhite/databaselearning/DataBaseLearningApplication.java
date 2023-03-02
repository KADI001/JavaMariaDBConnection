package com.kadiwhite.databaselearning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.*;

//@SpringBootApplication
public class DataBaseLearningApplication {

    public static void main(String[] args) throws ClassNotFoundException {

        String userName = "djamal";
        String password = "yjkPqgjU99GmZfv";
        String url = "jdbc:mariadb://10.0.0.222:3306/dealer";

        try(Connection connection = DriverManager.getConnection(url, userName, password)){
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM DealersPayment");

            int columns = result.getMetaData().getColumnCount();

            while(result.next()){
                for (int i = 1; i <= columns; i++){
                    System.out.print(result.getString(i) + "\t");
                }
                System.out.println();
            }
            System.out.println();

            if(result != null)
                result.close();
            if(statement != null)
                statement.close();
            if(connection != null)
                connection.close();

        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }

        //SpringApplication.run(DataBaseLearningApplication.class, args);


    }

}
