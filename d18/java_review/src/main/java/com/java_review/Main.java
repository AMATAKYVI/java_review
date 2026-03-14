package com.java_review;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world!");
        String url = "jdbc:mysql://localhost:3306/music";
        String userName = "ak";
        String password = "123123";

        // try (Connection conn = DriverManager.getConnection(url, userName, password)) {
        //     System.out.println("Connected to the database successfully!");
        //     // You can now use the 'conn' object to interact with the database
        //     // For example, you can create a Statement object and execute SQL queries
        //     try (var stmt = conn.createStatement()) {
        //         var sql = "SELECT * FROM `music`.`albums`";
        //         var rs = stmt.executeQuery(sql);
        //         //album_id, album_name, artist_id
        //         while (rs.next()) {
        //             int albumId = rs.getInt("album_id");
        //             String albumName = rs.getString("album_name");
        //             int artistId = rs.getInt("artist_id");
        //             System.out.println("Album ID: " + albumId + ", Album Name: " + albumName + ", Artist ID: " + artistId);
        //         }
        //     } catch (SQLException e) {
        //         System.out.println("Error executing SQL query.");
        //         e.printStackTrace();
        //     }
        // } catch (SQLException e) {
        //     System.out.println("Failed to connect to the database.");
        //     e.printStackTrace();
        // }
        // //prevent sql injection
        // String userInput = "some user input"; // This should come from user input, e
        // add to database
        /*
        CREATE TABLE `albums` (
  `album_id` int NOT NULL AUTO_INCREMENT,
  `album_name` text,
  `artist_id` int DEFAULT NULL,
  PRIMARY KEY (`album_id`),
  KEY `FK_ARTISTID` (`artist_id`),
  CONSTRAINT `FK_ARTISTID` FOREIGN KEY (`artist_id`) REFERENCES `artists` (`artist_id`)
) ENGINE=InnoDB AUTO_INCREMENT=879 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
        
         */
        try (Connection conn = DriverManager.getConnection(url, userName, password)) {
            String sql = "INSERT INTO `music`.`albums` (album_name, artist_id) VALUES (?, ?)";
            try (var pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, "New Album Name");
                pstmt.setInt(2, 1); // Assuming artist_id 1 exists
                int rowsAffected = pstmt.executeUpdate();
                System.out.println("Inserted " + rowsAffected + " row(s) into the albums table.");
            } catch (SQLException e) {
                System.out.println("Error executing SQL query.");
                e.printStackTrace();
            }
        } catch (SQLException e) {
            System.out.println("Failed to connect to the database.");
            e.printStackTrace();
        }
        System.out.println("Done reading ------");
    }
}
