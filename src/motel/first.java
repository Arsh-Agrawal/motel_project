package motel;
import java.sql.*;
import java.awt.BorderLayout;
import java.io.*;
import java.util.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class first extends JFrame {

	private JPanel contentPane;
	private JTextField uname;
	private JTextField pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					first frame = new first();
					frame.setVisible(true);
					try
					{
						Class.forName("oracle.jdbc.driver.OracleDriver");
						Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");  
					}
					catch(Exception e){ System.out.println(e);}  
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public first() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(50, 41, 178, 27);
		contentPane.add(lblUsername);
		
		uname = new JTextField();
		uname.setBounds(50, 80, 166, 19);
		contentPane.add(uname);
		uname.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(50, 137, 178, 27);
		contentPane.add(lblPassword);
		
		pass = new JTextField();
		pass.setBounds(50, 184, 164, 19);
		contentPane.add(pass);
		pass.setColumns(10);
		
		JButton login = new JButton("Login");
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pswd = pass.toString();
				String unm = uname.toString();
				if((pswd != null || !pswd.isEmpty()) && (unm != null || !unm.isEmpty()))
				{
					String qry = "select count(*) where username =? and password = ?";
					PreparedStatement stmt = con.prepareStatement(qry);
					stmt.setString(1,unm);
					stmt.setString(2,pswd);
					
					ResultSet rs = stmt.executeQuery();
					
					
				}
				
			}
		});
		login.setBounds(50, 243, 117, 29);
		contentPane.add(login);
		
	}
}
