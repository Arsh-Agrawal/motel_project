package motel;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;

public class booking extends JFrame {

	private JPanel contentPane;
	private JTextField chckin;
	private JTextField chkout;
	private JTextField uid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					booking frame = new booking();
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
	public booking() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel heading = new JLabel("User Booking");
		heading.setHorizontalAlignment(SwingConstants.CENTER);
		heading.setBounds(153, 6, 127, 16);
		contentPane.add(heading);
		
		JLabel lblCheckin = new JLabel("Check-in:");
		lblCheckin.setBounds(19, 43, 68, 16);
		contentPane.add(lblCheckin);
		
		JLabel lblCheckout = new JLabel("Check-out:");
		lblCheckout.setBounds(19, 85, 79, 16);
		contentPane.add(lblCheckout);
		
		JLabel lblRoomType = new JLabel("Room Type:");
		lblRoomType.setBounds(19, 130, 88, 16);
		contentPane.add(lblRoomType);
		
		chckin = new JTextField();
		chckin.setBounds(105, 38, 130, 26);
		contentPane.add(chckin);
		chckin.setColumns(10);
		
		chkout = new JTextField();
		chkout.setBounds(105, 80, 130, 26);
		contentPane.add(chkout);
		chkout.setColumns(10);
		
		JCheckBox chckbxSingle = new JCheckBox("Single");
		chckbxSingle.setBounds(105, 126, 128, 23);
		contentPane.add(chckbxSingle);
		
		JCheckBox chckbxDouble = new JCheckBox("Double");
		chckbxDouble.setBounds(105, 158, 128, 23);
		contentPane.add(chckbxDouble);
		
		JCheckBox chckbxDeluxe = new JCheckBox("Deluxe");
		chckbxDeluxe.setBounds(105, 193, 128, 23);
		contentPane.add(chckbxDeluxe);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(105, 228, 117, 29);
		contentPane.add(btnSubmit);
		
		JLabel return_msg = new JLabel("");
		return_msg.setHorizontalAlignment(SwingConstants.CENTER);
		return_msg.setBounds(273, 193, 160, 79);
		contentPane.add(return_msg);
		
		JLabel lblCid = new JLabel("User ID:");
		lblCid.setBounds(255, 43, 68, 16);
		contentPane.add(lblCid);
		
		uid = new JTextField();
		uid.setBounds(321, 38, 80, 26);
		contentPane.add(uid);
		uid.setColumns(10);
	}
}
