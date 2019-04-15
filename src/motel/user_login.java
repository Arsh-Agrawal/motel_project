package motel;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class user_login extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					user_login frame = new user_login();
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
	public user_login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setVisible(true);
		contentPane.setLayout(null);
		
		JButton signin = new JButton("SIgn in");
		signin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new amenities();
			}
			
		});
		signin.setBounds(138, 72, 117, 56);
		contentPane.add(signin);
		
		JButton signup = new JButton("Sign up");
		signup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new customer_reg();
				dispose();
			}
		});
		signup.setBounds(138, 187, 117, 56);
		contentPane.add(signup);
		
		JLabel lblCustomerOptions = new JLabel("Customer Options");
		lblCustomerOptions.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustomerOptions.setBounds(110, 23, 178, 16);
		contentPane.add(lblCustomerOptions);
	}

}
