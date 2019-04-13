package motel;
import java.sql.*;
import java.awt.BorderLayout;
import java.io.*;
import java.util.*;
import java.awt.EventQueue;

import connection.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class first extends JFrame {

	private JPanel contentPane;
	private JTextField uname;
	private JLabel err_msg;
	private JPasswordField pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					first frame = new first();
					frame.setVisible(true);
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
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setBounds(24, 20, 160, 27);
		contentPane.add(lblUsername);
		
		uname = new JTextField();
		uname.setBounds(18, 59, 166, 19);
		contentPane.add(uname);
		uname.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setBounds(255, 20, 178, 27);
		contentPane.add(lblPassword);
		
		JLabel err_msg = new JLabel("");
		err_msg.setBounds(99, 194, 279, 27);
		contentPane.add(err_msg);
		
		
		
		JButton login = new JButton("Login");
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String pswd = new String(pass.getPassword());
				String unm = uname.getText();
				connect conn = new connect();
				
				if((pass != null && !pswd.isEmpty()) && (uname != null && !unm.isEmpty()))
				{
					String qry = "select count(*) from admin where username =? and password = ?";
					try 
					{
						PreparedStatement stmt = conn.con.prepareStatement(qry);
						stmt.setString(1,unm);
						stmt.setString(2,pswd);
						
						ResultSet rs = stmt.executeQuery();
						rs.next(); //bringing it to point first row
						int count = rs.getInt(1);
						if(count == 1)
						{
							//open the customer_reg frame
							dispose();
							new customer_reg();
						}
					}
					catch(Exception error) {System.out.println(error);}
					
				}
				else
				{
					err_msg.setText("wrong Username or Password!!");
				}
					
				
			}
		});
		
		login.setBounds(162, 123, 117, 29);
		contentPane.add(login);
		
		
		
		pass = new JPasswordField();
		pass.setBounds(265, 56, 168, 26);
		contentPane.add(pass);
		
	}
}
