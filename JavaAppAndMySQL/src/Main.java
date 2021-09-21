
import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;
import com.mysql.cj.jdbc.MysqlDataSource;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class Main {
    private static final String sqlQuery = "SELECT * FROM employee";

    public static void main(String[] args) {
        MysqlDataSource dataSource = getMysqlDataSource();

        try(Connection con = dataSource.getConnection();
            PreparedStatement ps = con.prepareStatement(sqlQuery);
            ResultSet rs = ps.executeQuery()){
            while(rs.next()){
                /*System.out.println("Emp ID= " +rs.getString(1) +
                    "  Employee Name= " +rs.getString(2));*/
                System.out.println("Emp ID= " +rs.getString("EMP_ID") +
                        "  Employee Name= " +rs.getString("EMP_NAME"));
            }
        } catch (SQLException e) {
            System.out.println("DB Connection Error: " +e.getMessage());
        }
    }

    public static MysqlDataSource getMysqlDataSource() {
        //FileInputStream fileIS = new FileInputStream("src/resources/db.properties");
        FileInputStream fileIS;
        Properties props = new Properties();
        MysqlDataSource dataSource = new MysqlConnectionPoolDataSource();
        try{
            fileIS = new FileInputStream("src/resources/db.properties");
            props.load(fileIS);
            dataSource.setURL(props.getProperty("mysql.url"));
            dataSource.setUser(props.getProperty("mysql.username"));
            dataSource.setPassword(props.getProperty("mysql.password"));
        } catch (IOException e) {
            System.out.println("Error fetching configuration file: " +e.getMessage());
        }

        return dataSource;
    }
}
