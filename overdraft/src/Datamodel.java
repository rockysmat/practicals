import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Datamodel {
    private static final String QUERY_ALL_SUB_INFO = "SELECT * FROM SUBSCRIPTION_TBL";
    public static final String  INSERT_SUBSCRIBER = "INSERT INTO SUBSCRIPTION_TBL (IDENTITY_ID, MM_IDENTITY_ID, IDENTITY," +
            "IDENTITY_NAME, IDENTITY_EMAIL, DOCUMENT_ID, DOCUMENT_TYPE, STATUS, LANGUAGE, SUB_DATE, UPDATE_DATE)" +
            "VALUES (?, ?, ?, ?, ?, ?, ?, + 'ACTIVE', ?, NOW(), NOW())";
    public static final String UPDATE_SUBSCRIBER = "UPDATE SUBSCRIPTION_TBL SET STATUS = 'INACTIVE', UNSUB_DATE = NOW(), " +
            "UPDATE_DATE = NOW() WHERE IDENTITY = ?";
    public static final String UPDATE_SUBSCRIBER_EMAIL = "UPDATE SUBSCRIPTION_TBL SET IDENTITY_EMAIL = ?, UPDATE_DATE = NOW() " +
            "WHERE IDENTITY = ?";

    DataSource ds = Datasource.dataSource();

    public void getSubscriberInfo(){
        try{
            Connection con = ds.getConnection();
            PreparedStatement ps = con.prepareStatement(QUERY_ALL_SUB_INFO);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                System.out.println("Customer Name: " +rs.getString("IDENTITY_NAME") +
                    " Mobile Number: " +rs.getString("IDENTITY") +
                    " Email: " +rs.getString("IDENTITY_EMAIL") +
                    " Identity ID: " +rs.getString("DOCUMENT_ID") +
                    " Status: " +rs.getString("STATUS") +
                    " Language: " +rs.getString("LANGUAGE"));
            }
        } catch (SQLException e){
            System.out.println("Database Error: " +e.getMessage());
        }
    }

    public boolean insertSubscriberInfo(Subscriber sub){
        int insertNumber = 0;
        boolean insertSuccess = false;
        try{
            Connection con = ds.getConnection();
            PreparedStatement ps = con.prepareStatement(INSERT_SUBSCRIBER);
            ps.setString(1, sub.getIdentity());
            ps.setString(2, sub.getMmIdentityId());
            ps.setString(3, sub.getIdentity());
            ps.setString(4, sub.getIdentityName());
            ps.setString(5, sub.getIdentityEmail());
            ps.setString(6, sub.getDocumentId());
            ps.setString(7, sub.getDocumentType());
            ps.setString(8, sub.getLanguage());
            insertNumber = ps.executeUpdate();
        } catch (SQLException e){
            System.out.println("Database Error: " +e.getMessage());
        }
        if(insertNumber == 1) {
            insertSuccess = true;
        }
        return insertSuccess;
    }

    //opt out of service
    public boolean updateSubscriberInfo(String identity){
        int updateNumber = 0;
        boolean updateSuccess = false;
        try{
            Connection con = ds.getConnection();
            PreparedStatement ps = con.prepareStatement(UPDATE_SUBSCRIBER);
            ps.setString(1, identity);
            updateNumber = ps.executeUpdate();
        } catch (SQLException e){
            System.out.println("Database Error: " +e.getMessage());
        }
        if(updateNumber == 1){
            updateSuccess = true;
        }
        return updateSuccess;
    }

    public boolean updateSubscriberEmail(String identity, String email){
        Subscriber sub = new Subscriber();
        boolean updateEmailSuccess = false;
        try {
            sub.setIdentityEmail(email);
        } catch (Exception e){
            System.out.println("Incorrect email format");
        }
        if(sub.getIdentityEmail() != null) {
            int updateNumber = 0;
            try {
                Connection con = ds.getConnection();
                PreparedStatement ps = con.prepareStatement(UPDATE_SUBSCRIBER_EMAIL);
                ps.setString(1, sub.getIdentityEmail());
                ps.setString(2, identity);
                updateNumber = ps.executeUpdate();
            } catch (SQLException e) {
                System.out.println("Database Error: " + e.getMessage());
            }
            if (updateNumber == 1) {
                updateEmailSuccess = true;
            }
        }
        return updateEmailSuccess;
    }
}
