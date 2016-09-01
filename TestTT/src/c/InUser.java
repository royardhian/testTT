package c;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class InUser {

	private Connection con;
	
	public InUser(String a, String b, String c,
			String d, String e, String f){
		con = new Db().getConnection();

        try
        {
        
          String query = "INSERT INTO `user` (`Nama`, `No_Hp`, `Alamat`, `Email`, `Email2`, `Email3`)"
            + " values (?, ?, ?, ?, ?, ?)";
     
          PreparedStatement preparedStmt = con.prepareStatement(query);
          preparedStmt.setString (1, a);
          preparedStmt.setString (2, b);
          preparedStmt.setString (3, c);
          preparedStmt.setString (4, d);
          preparedStmt.setString (5, e);
          preparedStmt.setString (6, f);
  
          preparedStmt.execute();
           
          con.close();
        }
        catch (Exception ex)
        {
          System.err.println("Got an exception!");
          System.err.println(ex.getMessage());
        }
	
	}
}
