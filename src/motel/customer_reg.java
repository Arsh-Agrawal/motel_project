package motel;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class customer_reg extends JFrame {

	private JPanel contentPane;
	private JTextField user_id;
	private JTextField first_name;
	private JTextField last_name;
	private JTextField address;
	private JTextField phone;

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
		
		user_id = new JTextField();
		user_id.setBounds(89, 34, 130, 26);
		contentPane.add(user_id);
		user_id.setColumns(10);
		
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
	}

}
