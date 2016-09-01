package v;

import java.awt.EventQueue;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

import c.Db;

import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Button;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class Tab {

	public static JFrame frame;
	private JTable table;
	private Connection con;
	private Statement st;
	private ResultSet rs;
	private String ids;
	private PreparedStatement pst;
	String[] columnNames = {"Nama", "No HP", "Alamat", "email", "email2", "email3"};
	protected String cel;
	private String jumlah;
	private JTextField textField;

	public Tab() {
		con = new Db().getConnection();
		initialize();
		
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.SOUTH);
		panel.setLayout(new GridLayout(0,1));
		
		JButton btnImputAnggotaBaru = new JButton("Tambah Data");
		btnImputAnggotaBaru.setForeground(Color.WHITE);
		btnImputAnggotaBaru.setBackground(Color.GRAY);
		btnImputAnggotaBaru.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ang) {
				InputUser in = new InputUser();
				in.frmInput.setVisible(true);
		        Tab.frame.setVisible(false);
			}
		});
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		
		textField = new JTextField();
		panel_1.add(textField);
		textField.setColumns(10);
		panel_1.add(new JLabel("Specify a word to match:"),
                BorderLayout.WEST);
		panel_1.add(textField, BorderLayout.CENTER);
	
		panel.add(btnImputAnggotaBaru);
		
		JScrollPane scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);
        
        table = new JTable(model);
        final TableRowSorter<TableModel> rowSorter
        = new TableRowSorter<>(table.getModel());
        table.setRowSorter(rowSorter);
        
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);

        String Nama = "";
        String Nohp= "";
        String Alamat = "";
        String Email = "";
        String Email2 = "";
        String Email3 = "";
   
        
		try {
            pst = con.prepareStatement("select * from user");
            ResultSet rs = pst.executeQuery();
            int i = 0;
            while (rs.next()) {
                Nama = rs.getString("Nama");
                Nohp= rs.getString("No_Hp");
                Alamat = rs.getString("Alamat");
                Email = rs.getString("Email");
                Email2 = rs.getString("Email2");
                Email3 = rs.getString("Email3");
                model.addRow(new Object[]{Nama, Nohp, Alamat, Email, Email2, Email3});
                i++;
                
                if (i < 1) {
                	JOptionPane.showMessageDialog(null, "No Record Found", "Error", JOptionPane.ERROR_MESSAGE);
                	}
                else if (i >= 1) {
	            	System.out.println(i + " Record Found"+ jumlah);
	                	} 
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
		
		
		textField.getDocument().addDocumentListener(new DocumentListener(){

			@Override
            public void insertUpdate(DocumentEvent e) {
                String text = textField.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

			@Override
            public void removeUpdate(DocumentEvent e) {
                String text = textField.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }
			
			 @Override
	            public void changedUpdate(DocumentEvent e) {
	                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	            }
			
		});
	}

}
