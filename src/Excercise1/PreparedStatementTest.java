package Excercise1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedStatementTest extends Exercise1 {

    Exercise1 e = new Exercise1();

    private PreparedStatement pst;
    private Connection con;

    // JDBC driver name and database URL
    private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String DATABASE_URL = "jdbc:sqlserver://localhost:1433;database=Book;integratedSecurity=true";

    public void Insert() {
        try {
            Class.forName(DRIVER);

            // Establish connection
            con = DriverManager.getConnection(DATABASE_URL);

            pst = con.prepareStatement("INSERT into Game ( game_title) VALUES(?)");
           // pst.setString(1,playerFirstNameInput.T);

            //pst = con.prepareStatement("Select * from Seller");

            pst.executeUpdate();
            //pst.execute();

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            System.out.println("Done!");
            try {
                pst.close();
                con.close();
            }
            catch (Exception e) {}
        }
    }

    public static void main(String[] args) {
        //PreparedStatementTest pst = new PreparedStatementTest();
    }

}
