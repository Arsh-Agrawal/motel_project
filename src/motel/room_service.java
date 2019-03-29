package motel;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JButton;

public class room_service extends JFrame {

	private JPanel contentPane;
	private JTextField id1;
	private JTextField id2;
	private JTextField id3;
	private JTextField id4;
	private JTextField uid;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					room_service frame = new room_service();
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
	public room_service() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRoomservice = new JLabel("Room Service");
		lblRoomservice.setBounds(181, 6, 93, 16);
		contentPane.add(lblRoomservice);
		
		JLabel lblSnacks = new JLabel("Snacks:");
		lblSnacks.setBounds(30, 97, 61, 16);
		contentPane.add(lblSnacks);
		
		JLabel lblFrenchFries = new JLabel("French Fries");
		lblFrenchFries.setBounds(30, 125, 83, 16);
		contentPane.add(lblFrenchFries);
		
		JLabel lblPavBaji = new JLabel("Pav Baji");
		lblPavBaji.setBounds(30, 153, 61, 16);
		contentPane.add(lblPavBaji);
		
		id1 = new JTextField();
		id1.setText("0");
		id1.setBounds(135, 120, 66, 26);
		contentPane.add(id1);
		id1.setColumns(10);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setBounds(140, 97, 61, 16);
		contentPane.add(lblQuantity);
		
		id2 = new JTextField();
		id2.setText("0");
		id2.setBounds(135, 148, 66, 26);
		contentPane.add(id2);
		id2.setColumns(10);
		
		JLabel lblLunch = new JLabel("Lunch/Dinner:");
		lblLunch.setBounds(30, 181, 93, 16);
		contentPane.add(lblLunch);
		
		JLabel lblPizza = new JLabel("Pizza");
		lblPizza.setBounds(30, 209, 61, 16);
		contentPane.add(lblPizza);
		
		JLabel lblPasta = new JLabel("Pasta");
		lblPasta.setBounds(30, 237, 61, 16);
		contentPane.add(lblPasta);
		
		id3 = new JTextField();
		id3.setText("0");
		id3.setBounds(135, 204, 66, 26);
		contentPane.add(id3);
		id3.setColumns(10);
		
		id4 = new JTextField();
		id4.setText("0");
		id4.setBounds(135, 232, 66, 26);
		contentPane.add(id4);
		id4.setColumns(10);
		
		JLabel label = new JLabel("Quantity");
		label.setBounds(140, 181, 61, 16);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("User ID:");
		label_1.setBounds(30, 51, 68, 16);
		contentPane.add(label_1);
		
		uid = new JTextField();
		uid.setColumns(10);
		uid.setBounds(121, 46, 80, 26);
		contentPane.add(uid);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setBounds(270, 194, 117, 58);
		contentPane.add(btnNewButton);
		
		JLabel lblExtraBed = new JLabel("Extra Bed");
		lblExtraBed.setBounds(243, 125, 83, 16);
		contentPane.add(lblExtraBed);
		
		textField = new JTextField();
		textField.setText("0");
		textField.setColumns(10);
		textField.setBounds(345, 120, 66, 26);
		contentPane.add(textField);
		
		JLabel lblRoomItems = new JLabel("Room Items:");
		lblRoomItems.setBounds(243, 97, 83, 16);
		contentPane.add(lblRoomItems);
		
		JLabel label_2 = new JLabel("Quantity");
		label_2.setBounds(345, 97, 61, 16);
		contentPane.add(label_2);
	}

}
