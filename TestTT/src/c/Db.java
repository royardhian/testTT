package c;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Db {
	Connection conn = null;

    public Connection getConnection() {
        if(conn == null){
            try {
            	conn =DriverManager.getConnection("jdbc:mysql://localhost/test?user=root&password=123456");
            	System.out.println("berhasil");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error when try connect to mysql server, "
                        + "check your configuration");
                e.printStackTrace();
            }
        }
        return conn;
    }

}