package motel;

import java.awt.BorderLayout;
import java.text.SimpleDateFormat;
import java.util.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.sql.Date;

public class booking extends JFrame {

	private JPanel contentPane;
	private JTextField chckin;
	private JTextField chkout;
	private JTextField userid;

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
		
		JLabel return_msg = new JLabel("");
		return_msg.setHorizontalAlignment(SwingConstants.CENTER);
		return_msg.setBounds(273, 193, 160, 79);
		contentPane.add(return_msg);
		
		JRadioButton rb1 = new JRadioButton("Single");
		rb1.setBounds(105, 130, 141, 23);
		contentPane.add(rb1);
		
		JRadioButton rb2 = new JRadioButton("Double");
		rb2.setBounds(105, 165, 141, 23);
		contentPane.add(rb2);
		
		JRadioButton rb3 = new JRadioButton("Deluxe");
		rb3.setBounds(105, 200, 141, 23);
		contentPane.add(rb3);
		
		ButtonGroup bgroup = new ButtonGroup();
		bgroup.add(rb1);
		bgroup.add(rb2);
		bgroup.add(rb3);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String checkin = chckin.getText();
				String checkout = chkout.getText();
				String user_id = userid.getText();
				
				if(( userid != null || !user_id.isEmpty()) && (checkin != null || !checkin.isEmpty()) && (chkout != null || !checkout.isEmpty()))
				{
					int uid = Integer.parseInt(user_id); 
					java.sql.Date chin = new java.sql.Date();
					java.sql.Date chout = new java.sql.Date();
					SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");
					try 
					{
						chin = format.parse(checkin);
						chout = format.parse(checkout);
					}
					catch(Exception error)
					{
						String msg = "not a date fromat";
						return_msg.setText(msg);
					}
					
					int room_type;
					
					if(rb1.isSelected())
					{
						room_type = 1;
					}
					else if(rb2.isSelected())
					{
						room_type = 2;
					}
					else if(rb3.isSelected())
					{
						room_type = 3;
					}
					else
					{
						room_type = 0;
						return_msg.setText("Please choose type of room");
					}
					
					String qry = "Select count(*) as count from room where status = 0 and type_id = ? ";
					PreparedStatement stmt = con.prepareStatement(qry);
					stmt.setInt(1,room_type);
					ResultSet rs = stmt.executeQuery();
					
					int count = rs.getInt("count");
					
					if(count == 0 )
					{
						return_msg.setText("Sorry, Particular room type is unavailable at the moment");						
					}
					else
					{
						qry = "Select room_no, floor from room where status = 0 and type_id = ?";
						stmt = con.prepareStatement(qry);
						stmt.setInt(1,room_type);
						rs = stmt.executeQuery();
						
						//retrieving the first row(tuple)
						
						int room_no = rs.getInt("room_no");
						int floor = rs.getInt("floor");
						
						qry = "insert into books values (?,?,?,?)";
						stmt = con.prepareStatement(qry);
						stmt.setInt(1,uid);
						stmt.setInt(2, room_type);
						stmt.setDate(3, chin);
						
						rs = stmt.executeQuery();
//						String msg = "";
						
						
					}
					
				}
				
				
			}
		});
		btnSubmit.setBounds(105, 228, 117, 29);
		contentPane.add(btnSubmit);		
		
		JLabel lblCid = new JLabel("User ID:");
		lblCid.setBounds(255, 43, 68, 16);
		contentPane.add(lblCid);
		
		userid = new JTextField();
		userid.setBounds(321, 38, 80, 26);
		contentPane.add(userid);
		userid.setColumns(10);
		
		
		
		
	}
}
