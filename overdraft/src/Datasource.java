import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;
import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Datasource {

    public static DataSource dataSource(){
        FileInputStream fileIS;
        Properties prop = new Properties();
        StringBuilder stringBuilder = new StringBuilder();
        MysqlDataSource dataSource = new MysqlConnectionPoolDataSource();
        try {
            fileIS = new FileInputStream("resources/db.properties");
            prop.load(fileIS);
            stringBuilder.append(prop.getProperty("DB_Endpoint"))
                    .append(":")
                    .append(prop.getProperty("DB_PORT"))
                    .append("/")
                    .append(prop.getProperty("DB_NAME"));
            dataSource.setURL(stringBuilder.toString());
            dataSource.setUser(prop.getProperty("DB_USERNAME"));
            dataSource.setPassword(prop.getProperty("DB_PASSWORD"));
        } catch (IOException e){
            System.out.println("Error fetching resource " +e.getMessage());
        }
        return dataSource;
    }
}
