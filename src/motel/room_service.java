package motel;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JTextField;

public class room_service extends JFrame {

	private JPanel contentPane;
	private JTextField id1;
	private JTextField id2;
	private JTextField id3;
	private JTextField id4;
	private JTextField uid;

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
		lblSnacks.setBounds(30, 56, 61, 16);
		contentPane.add(lblSnacks);
		
		JLabel lblFrenchFries = new JLabel("French Fries");
		lblFrenchFries.setBounds(30, 87, 83, 16);
		contentPane.add(lblFrenchFries);
		
		JLabel lblPavBaji = new JLabel("Pav Baji");
		lblPavBaji.setBounds(30, 115, 61, 16);
		contentPane.add(lblPavBaji);
		
		id1 = new JTextField();
		id1.setBounds(135, 82, 66, 26);
		contentPane.add(id1);
		id1.setColumns(10);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setBounds(135, 56, 61, 16);
		contentPane.add(lblQuantity);
		
		id2 = new JTextField();
		id2.setBounds(135, 110, 66, 26);
		contentPane.add(id2);
		id2.setColumns(10);
		
		JLabel lblLunch = new JLabel("Lunch/Dinner:");
		lblLunch.setBounds(30, 153, 93, 16);
		contentPane.add(lblLunch);
		
		JLabel lblPizza = new JLabel("Pizza");
		lblPizza.setBounds(30, 186, 61, 16);
		contentPane.add(lblPizza);
		
		JLabel lblPasta = new JLabel("Pasta");
		lblPasta.setBounds(30, 214, 61, 16);
		contentPane.add(lblPasta);
		
		id3 = new JTextField();
		id3.setBounds(135, 181, 66, 26);
		contentPane.add(id3);
		id3.setColumns(10);
		
		id4 = new JTextField();
		id4.setBounds(135, 209, 66, 26);
		contentPane.add(id4);
		id4.setColumns(10);
		
		JLabel label = new JLabel("Quantity");
		label.setBounds(135, 153, 61, 16);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("User ID:");
		label_1.setBounds(276, 56, 68, 16);
		contentPane.add(label_1);
		
		uid = new JTextField();
		uid.setColumns(10);
		uid.setBounds(342, 51, 80, 26);
		contentPane.add(uid);
	}

}
