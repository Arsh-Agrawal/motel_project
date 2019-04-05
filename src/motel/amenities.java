package motel;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class amenities extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					amenities frame = new amenities();
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
	public amenities() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("User Amenities ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(163, 16, 118, 16);
		contentPane.add(lblNewLabel);
		
		JButton btnFacilities = new JButton("Facilities");
		btnFacilities.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//redirect to facilities jframe
				dispose();
			}
		});
		btnFacilities.setBounds(50, 68, 117, 53);
		contentPane.add(btnFacilities);
		
		JButton btnRoomService = new JButton("Room Service");
		btnRoomService.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//redirect to room service jframe
				dispose();
			}
		});
		btnRoomService.setBounds(274, 68, 117, 53);
		contentPane.add(btnRoomService);
		
		JButton bill = new JButton("Check Bill");
		bill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				//redirect to bill.java
			}
		});
		bill.setBounds(164, 173, 117, 53);
		contentPane.add(bill);
	}

}
