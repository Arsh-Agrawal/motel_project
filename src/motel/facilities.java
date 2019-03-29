package motel;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JTextField;

public class facilities extends JFrame {

	private JPanel contentPane;
	private JTextField id1;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField uid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					facilities frame = new facilities();
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
	public facilities() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFacilities = new JLabel("Facilities");
		lblFacilities.setBounds(195, 6, 61, 16);
		contentPane.add(lblFacilities);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(22, 221, 117, 39);
		contentPane.add(btnSubmit);
		
		JLabel lblType = new JLabel("Type:");
		lblType.setBounds(22, 51, 61, 16);
		contentPane.add(lblType);
		
		JLabel lblHours = new JLabel("Hours");
		lblHours.setBounds(133, 51, 61, 16);
		contentPane.add(lblHours);
		
		id1 = new JTextField();
		id1.setBounds(133, 82, 41, 26);
		contentPane.add(id1);
		id1.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(133, 130, 41, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(133, 174, 41, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblGym = new JLabel("Gym");
		lblGym.setBounds(22, 87, 61, 16);
		contentPane.add(lblGym);
		
		JLabel lblPool = new JLabel("Pool");
		lblPool.setBounds(22, 134, 61, 16);
		contentPane.add(lblPool);
		
		JLabel lblShuttle = new JLabel("Shuttle");
		lblShuttle.setBounds(22, 179, 61, 16);
		contentPane.add(lblShuttle);
		
		JLabel label = new JLabel("User ID:");
		label.setBounds(263, 51, 68, 16);
		contentPane.add(label);
		
		uid = new JTextField();
		uid.setColumns(10);
		uid.setBounds(327, 46, 80, 26);
		contentPane.add(uid);
	}

}
