package motel;

import connection.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class customer_reg extends JFrame {

	private JPanel contentPane;
	private JTextField user_id;
	private JTextField first_name;
	private JTextField last_name;
	private JTextField address;
	private JTextField phone;
	private JLabel lblNewLabel;
	private JLabel return_id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					customer_reg frame = new customer_reg();
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
	public customer_reg() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUserId = new JLabel("User ID:");
		lblUserId.setBounds(6, 39, 61, 16);
		contentPane.add(lblUserId);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setBounds(6, 78, 80, 16);
		contentPane.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setBounds(6, 116, 80, 16);
		contentPane.add(lblLastName);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(6, 150, 80, 16);
		contentPane.add(lblAddress);
		
		JLabel lblPhone = new JLabel("Phone:");
		lblPhone.setBounds(6, 189, 80, 16);
		contentPane.add(lblPhone);
		
		first_name = new JTextField();
		first_name.setBounds(89, 73, 130, 26);
		contentPane.add(first_name);
		first_name.setColumns(10);
		
		last_name = new JTextField();
		last_name.setBounds(89, 111, 130, 26);
		contentPane.add(last_name);
		last_name.setColumns(10);
		
		address = new JTextField();
		address.setBounds(89, 145, 130, 26);
		contentPane.add(address);
		address.setColumns(10);
		
		phone = new JTextField();
		phone.setBounds(89, 184, 130, 26);
		contentPane.add(phone);
		phone.setColumns(10);

		JLabel msg = new JLabel("");
		msg.setHorizontalAlignment(SwingConstants.CENTER);
		msg.setBounds(263, 134, 144, 66);
		contentPane.add(msg);
		
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String f_name = first_name.getText();
				String l_name = last_name.getText();
				String addr = address.getText();
				String phn = phone.getText();

				int ph = 0;
				
				try
				{
					ph = Integer.parseInt(phn);
				}
				catch(Exception err)
				{
					String msg ="wrong Phone input";
					System.out.println(msg);
					return;
				}

				String reply = "";

				//making database connection
				connect conn = new connect();
				
				try
				{
					if((first_name != null || !f_name.isEmpty()) && (last_name != null || !l_name.isEmpty()) && (address != null || !addr.isEmpty()) && (phone != null || !phn.isEmpty()))
					{
						String qry = "insert into user_1 values(user_1_id_seq.nextval,?, ?, ?, ?)";
						PreparedStatement stmt = conn.con.prepareStatement(qry);
						stmt.setString(1,f_name);
						stmt.setString(2,l_name);
						stmt.setString(3,addr);
						stmt.setString(4, phn);
	
						int i = stmt.executeUpdate();
						if(i != 0)
						{
							reply = reply + "Updated records.";
	
							qry = "select id from user_1 where fname = ? and lname = ? and address = ? and phone = ?";
							stmt = conn.con.prepareStatement(qry);
							stmt.setString(1,f_name);
							stmt.setString(2,l_name);
							stmt.setString(3,addr);
							stmt.setString(4, phn);
							ResultSet rs =  stmt.executeQuery();
							rs.next(); //bringing it to point first row
							int id = rs.getInt(1);
							return_id.setText("User ID: " + id);
							
							JButton btnNewButton = new JButton("Proceed");
							btnNewButton.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									dispose();
									new booking();
								}
							});
							btnNewButton.setBounds(290, 243, 117, 29);
							contentPane.add(btnNewButton);
	
						}
						else
						{
							reply = "Database connection error.";
						}
					}
					else
					{
						reply = "Please enter details for all fields.";
					}
	         		msg.setText(reply);				
					reply = "";
				}
				catch(Exception error)
				{
					System.out.print(error);
				}
			}
		});
		btnSubmit.setBounds(89, 243, 117, 29);
		contentPane.add(btnSubmit);
		
		return_id = new JLabel("");
		return_id.setHorizontalAlignment(SwingConstants.CENTER);
		return_id.setBounds(90, 39, 129, 26);
		contentPane.add(return_id);
		
		JLabel lblNewLabel_1 = new JLabel("Customer Registeration");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(142, 11, 178, 16);
		contentPane.add(lblNewLabel_1);
		
		
	}

}
