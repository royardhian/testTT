package v;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import c.InUser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class InputUser {

	public static JFrame frmInput;
	private JTextField nama, nohp, alamat, email, email2, email3;
	private JButton b2, b3, min1, min2;

	public InputUser() {
		initialize();
	}

	private void initialize() {
		frmInput = new JFrame();
		frmInput.setTitle("Login");
		frmInput.setBounds(100, 100, 265, 276);
		frmInput.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmInput.getContentPane().setLayout(null);
		
		
		Dimension frameSize = frmInput.getSize();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frmInput.setLocation((screenSize.width - frameSize.width)/2, 
			             (screenSize.height - frameSize.height)/2);
		
		JLabel lblNama = new JLabel("Nama");
		lblNama.setBounds(10, 11, 89, 14);
		frmInput.getContentPane().add(lblNama);
		
		nama = new JTextField();
		nama.setBounds(69, 8, 160, 20);
		frmInput.getContentPane().add(nama);
		nama.setColumns(10);
		
		JLabel lblNhp = new JLabel("No. Hp");
		lblNhp.setBounds(10, 42, 89, 14);
		frmInput.getContentPane().add(lblNhp);
		
		nohp = new JTextField();
		nohp.setColumns(10);
		nohp.setBounds(69, 39, 160, 20);
		frmInput.getContentPane().add(nohp);
		
		JLabel lblAlamat = new JLabel("Alamat");
		lblAlamat.setBounds(10, 73, 89, 14);
		frmInput.getContentPane().add(lblAlamat);
		
		alamat = new JTextField();
		alamat.setColumns(10);
		alamat.setBounds(69, 70, 160, 20);
		frmInput.getContentPane().add(alamat);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 104, 89, 14);
		frmInput.getContentPane().add(lblEmail);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(69, 101, 160, 20);
		frmInput.getContentPane().add(email);
		
		b2 = new JButton("tambah email");
		b2.setForeground(Color.WHITE);
		b2.setBackground(Color.GRAY);
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent u2) {
				if (u2.getSource() == b2){
					email2.setVisible(true);
					b3.setVisible(true);
					min1.setVisible(true);
					b2.setVisible(false);
				}
			}
		});
		b2.setBounds(109, 132, 120, 20);
		frmInput.getContentPane().add(b2);
		
		email2 = new JTextField();
		email2.setVisible(false);
		email2.setColumns(10);
		email2.setBounds(69, 132, 120, 20);
		frmInput.getContentPane().add(email2);
		
		b3 = new JButton("tambah email");
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent u3) {
				if (u3.getSource() == b3){
					email3.setVisible(true);
					min2.setVisible(true);
					b3.setVisible(false);
				}
			}
		});
		b3.setVisible(false);
		b3.setForeground(Color.WHITE);
		b3.setBackground(Color.GRAY);
		b3.setBounds(109, 166, 120, 20);
		frmInput.getContentPane().add(b3);
		
		email3 = new JTextField();
		email3.setVisible(false);
		email3.setColumns(10);
		email3.setBounds(69, 166, 120, 20);
		frmInput.getContentPane().add(email3);
		
		min1 = new JButton("-");
		min1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent mi1) {
				if (mi1.getSource() == min1){
					email2.setVisible(false);
					email2.setText("");
					b2.setVisible(true);
					min1.setVisible(false);
					b3.setVisible(false);
					email3.setVisible(false);
					email3.setText("");
					b3.setVisible(false);
					min2.setVisible(false);
					}
				}
			});
		min1.setBounds(186, 132, 43, 20);
		min1.setVisible(false);
		min1.setForeground(Color.WHITE);
		min1.setBackground(Color.GRAY);
		frmInput.getContentPane().add(min1);
		
		min2 = new JButton("-");
		min2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent mi2) {
			if (mi2.getSource() == min2){
				email3.setVisible(false);
				email3.setText("");
				b3.setVisible(true);
				min2.setVisible(false);
				b2.setVisible(false);
				}
			}
		});
		min2.setBounds(186, 166, 43, 20);
		min2.setVisible(false);
		min2.setForeground(Color.WHITE);
		min2.setBackground(Color.GRAY);
		frmInput.getContentPane().add(min2);
		
		final JButton masuk = new JButton("Submit");
		masuk.setForeground(Color.WHITE);
		masuk.setBackground(Color.GRAY);
		
		
		masuk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent m) {
				if (m.getSource() == masuk) {
					String Nama = nama.getText();
					String Nohp = nohp.getText();
					String Alamat = alamat.getText();
					String Email = email.getText();
					String Email2 = email2.getText();
					String Email3 = email3.getText();
					
					System.out.println("usernya "+Nama+Nohp+Email+Alamat);
					masuk.setBackground(Color.BLACK);
					
					String EMAIL_REGEX = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
					boolean bemail = Email.matches(EMAIL_REGEX);
					boolean bemail2 = Email2.matches(EMAIL_REGEX);
					boolean bemail3 = Email3.matches(EMAIL_REGEX);
					System.out.println("email"+bemail);
					System.out.println("email2"+bemail2);
					System.out.println("email3"+bemail3);
					
					String Nohp_REGEX = "[\\d+]{10,}$";
					boolean bnohp = Nohp.matches(Nohp_REGEX);
					System.out.println("nohp"+bnohp);

					
					if(bemail==false){
						JOptionPane.showMessageDialog(null, "format email salah!");
					}
					else if(!Email2.isEmpty()){
						if(bemail2==false){
							JOptionPane.showMessageDialog(null, "format email2 salah!");
						}
					}
					else if(!Email3.isEmpty()){
						if(bemail3==false){
							JOptionPane.showMessageDialog(null, "format email3 salah!");
						}
					}
					
					else if(bnohp==false){
						JOptionPane.showMessageDialog(null, "format nomor hp hanya boleh numeric atau masih dibawah 10 karakter");
					}
					else if(nama.getText().equals("")
							||alamat.getText().equals("")){
						 JOptionPane.showMessageDialog(null, "DATA TIDAK BOLEH KOSONG!");
						 }
					else{
						new InUser(Nama,Nohp,Alamat,Email, Email2, Email3);
						Tab update = new Tab();
			            update.frame.setVisible(true);
						InputUser.frmInput.setVisible(false);
					}
				
		        }
			}
		});
		masuk.setBounds(10, 197, 229, 29);
		frmInput.getContentPane().add(masuk);
		
		
		
		
	}
}
