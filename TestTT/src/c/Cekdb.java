package c;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import v.Tab;
import v.TabEmp;

public class Cekdb {
	Connection con;
    PreparedStatement pst;
    
    public Cekdb(){
    	con = new Db().getConnection();
    	
    }
    
    public void Cek(){
    	int status;
    	int i = 0;
    	try {
            pst = con.prepareStatement("select count(*) as RowCnt from user");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                status = rs.getInt("RowCnt");
                i=status;
                
                if (i < 1) {
                	TabEmp window = new TabEmp();
            		window.frame.setVisible(true);
                	}
                else if (i >= 1) {
                	System.out.println( status + " Record Found");
                	Tab window = new Tab();
            		window.frame.setVisible(true);
                	} 
            }
            }
    	catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error nih", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
    	
    }
}
