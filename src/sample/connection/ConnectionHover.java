/**
 * hover-academic
 * @author hover
 * Connection Class to connect to the  MySQL Server
 */
package sample.connection;

import sample.model.bean.ServerSession;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionHover {
    
    
    
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static String url;
    private static String user;
    private static String password;
    
    //Connection
    public static Connection getConnection() throws SQLException, ClassNotFoundException {

        user = ServerSession.getUser();
        password = ServerSession.getPassword();
        url = "jdbc:mysql://"+ServerSession.getServer()+":"+ServerSession.getPort()+"/hover_academic?useTimezone=true&serverTimezone=UTC";
        //url = "jdbc:mysql://localhost:3306/hover_academic?useTimezone=true&serverTimezone=UTC";
        Class.forName(DRIVER);

        return DriverManager.getConnection(url, user, password);

    }
    
    //Close Connection 1
    public static void closeConnection(Connection connection) {
        
        try {
            
            if(connection!=null) {
                connection.close();
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionHover.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    //Close Connection 2
    public static void closeConnection(Connection connection, PreparedStatement statement) {
        
        closeConnection(connection);
        
        try {
            
            if(statement!=null) {
                statement.close();
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionHover.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    //Close Connection 3
    public static void closeConnection(Connection connection, PreparedStatement statement, ResultSet result) {
        
        closeConnection(connection, statement);
        
        try {
            
            if(result!=null) {
                result.close();
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionHover.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
   
}
