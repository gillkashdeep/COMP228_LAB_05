package Excercise1;
import java.sql.*;

public class ConnectURL {
    String connectionURL = "jdbc:sqlserver://localhost:1433;database=COMP228GameDB;integratedSecurity=true"; // Using windows authentication

    Connection con ;
    Statement stmt1 ;
    ResultSet rs ;
    PreparedStatement stmt;
    public static void main(String[] args) {

        ConnectURL c = new ConnectURL();
        try{
        c.incrementID();}
        catch (Exception e)
        {System.out.println(e);}
/*
        try {
            // Establishing a connection to your database
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(connectionURL);

            // Create and execute an SQL statement that returns some data
            String SQL = "SELECT * FROM Game";
            stmt = con.createStatement();
            rs = stmt.executeQuery(SQL);

            while(rs.next()) {
                System.out.println(rs.getString("game_id") + " " + rs.getString("game_title") );
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        finally {
            if(rs != null) {
                try {
                    rs.close();
                }
                catch (Exception e) { }
            }
            if(stmt != null) {
                try {
                    stmt.close();
                }
                catch (Exception e) {}
            }
            if(con != null) {
                try {
                    con.close();
                }
                catch (Exception e) {}
            }
        }*/
    }
    public void addNewPlayer(int newID, String firstName, String lastName, String address,
                             String province, String zipCode, String phoneNumber) throws SQLException, IllegalStateException{
        stmt = con.prepareStatement("INSERT into Player (player_id, first_name, last_name, address, province, postal_code, phone_number) " +
                        "VALUES (?,?,?,?,?,?,?)");
        stmt.setInt(1, newID);
        stmt.setString(2, firstName);
        stmt.setString(3, lastName);
        stmt.setString(4, address);
        stmt.setString(5, province);
        stmt.setString(6, zipCode);
        stmt.setString(7, phoneNumber);
        stmt.executeUpdate();

    }

    public int incrementID() throws SQLException, IllegalStateException{
        int incrID = 0;
        stmt = con.prepareStatement("SELECT MAX(player_id) from Player");
        ResultSet rs = stmt.executeQuery();
        System.out.println(rs);

        if (rs.next()) {
            incrID = rs.getInt(1) + 1;
        }
        rs.close();
        return incrID;
    }
}

