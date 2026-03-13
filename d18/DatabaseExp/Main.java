// package d18.DatabaseExp;

// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.ResultSet;
// import java.sql.Statement;

// public class Main {

//     public static void main(String[] args) {
//         // DatabaseMetaData database = new DatabaseMetaData();
//         System.out.println("Hello, Database Experiment!");
//         String url = "jdbc:mysql://localhost:3306/music";
//         String username = "ak";
//         String password = "123123";

//         try (Connection conn = DriverManager.getConnection(url, username, password)) {
//             System.out.println("Connected to the database successfully!");

//             // Create a statement
//             Statement stmt = conn.createStatement();

//             // Execute a query
//             String sql = "SELECT * FROM songs";
//             ResultSet rs = stmt.executeQuery(sql);

//             // Process the result set
//             while (rs.next()) {
//                 int id = rs.getInt("id");
//                 String title = rs.getString("title");
//                 String artist = rs.getString("artist");
//                 System.out.println("ID: " + id + ", Title: " + title + ", Artist: " + artist);
//             }
//         } catch (Exception e) {
//             e.printStackTrace();
//         }
//     }
// }
