package common;
import java.sql.*;
public class MyConnection {
    public static Connection connectTo(){
        try{
        	Class.forName("com.mysql.jdbc.Driver");  
            Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ores","user","user");
            if (conn != null)
            {
                return conn;
            }
            else
            {
                System.err.println("connected unsuccessfully");
            }
            
            System.err.println("dijhfkjf");
        }
        catch(ClassNotFoundException ce)
        {
            System.err.println(ce);
        }
        catch(SQLException e){
        	
        	System.err.println(e);
        }
        catch(Exception e) {
        	System.err.println(e);
        	}
        
        return null;
    }
    
    public static void main(String[] args){
        MyConnection.connectTo();
    }
}
