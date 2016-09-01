package v;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TabEmp {

	public static JFrame frame;

	public TabEmp() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Dimension frameSize = frame.getSize();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation((screenSize.width - frameSize.width)/2, 
			             (screenSize.height - frameSize.height)/2);
		
		JLabel lblMohonMaafData = new JLabel("<html><div style='text-align: center;'>Mohon maaf data yang anda minta kosong" +
				"<br>silahkan klik tombol di bawah untuk menambahkan data</html>", SwingConstants.CENTER);
		frame.getContentPane().add(lblMohonMaafData, BorderLayout.CENTER);
		
		JButton btnTambahData = new JButton("Tambah Data");
		btnTambahData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				InputUser in = new InputUser();
	            in.frmInput.setVisible(true);
				TabEmp.frame.setVisible(false);
			}
		});
		frame.getContentPane().add(btnTambahData, BorderLayout.SOUTH);
	}

}
