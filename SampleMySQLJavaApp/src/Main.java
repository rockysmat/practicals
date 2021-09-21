import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static final String sqlQuery = "SELECT * FROM employee";

    public static void main(String[] args) {
        MysqlDataSource dataSource = MyDataSourceFactory.getMysqlDataSource();
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

       try{
           con = dataSource.getConnection();
           st = con.createStatement();
           rs = st.executeQuery(sqlQuery);
           while(rs.next()){
               System.out.println("Employee ID=" +rs.getInt(1) +
                       ", Name=" +rs.getString(2));
           }
       } catch (SQLException e) {
           e.printStackTrace();
       } finally {
           try{
               if(rs != null)
                   rs.close();
               if(st != null)
                   st.close();
               if(con != null)
                   con.close();
           } catch (SQLException e){
               e.printStackTrace();
           }
       }
    }
}
