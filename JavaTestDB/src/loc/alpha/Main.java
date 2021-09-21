package loc.alpha;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\rotina\\Documents\\Coding Practices\\JavaTestDB\\testjava.db");
            Statement statement = conn.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS contacts (name TEXT, phone INTEGER, email TEXT)");
//            statement.execute("INSERT INTO contacts VALUES('Roshan', 345789, 'roshan@gmail.com')");
//            statement.execute("INSERT INTO contacts VALUES('Rocky', 908762, 'rocky@gmail.com')");
//            statement.execute("UPDATE contacts SET phone=002255, email='kanini@gmail.com' WHERE name='Sharon'");
//            statement.execute("DELETE FROM contacts WHERE name = 'Rocky'");
//            statement.execute("SELECT * FROM contacts");
//            ResultSet results = statement.getResultSet();
            ResultSet results = statement.executeQuery("SELECT * FROM contacts");
            while(results.next()){
                System.out.println(results.getString("name") + " "+
                        results.getInt("phone") + " "+
                        results.getString("email"));
            }
            results.close();
            statement.close();
            conn.close();
        } catch(SQLException e) {
            System.out.println( "DB Connection Error" +e.getMessage());
        }
    }
}
