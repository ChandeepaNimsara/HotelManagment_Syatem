package hotelmanagment;

import com.mysql.cj.jdbc.MysqlDataSource;
import com.sun.istack.internal.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;

/**
 *
 * @author Gayan Jayarathne
 */
public class MyConnection {

//    static Object getConnection() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    
    public Connection createConnection(){
        Connection connection = null;
        
        MysqlDataSource mds = new MysqlDataSource();
        
        mds.setServerName("localhost");
        mds.setPortNumber(3306);
        mds.setUser("root");
        mds.setPassword("");
        mds.setDatabaseName("java_hotel_db");
        
        try {
            connection = mds.getConnection();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(MyConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

        return connection;
    }
    
    public static Connection getConnection(){
        
        Connection con = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/java_hotel_db", "root", "");
            
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        
        return con;
        
    }
    
}
