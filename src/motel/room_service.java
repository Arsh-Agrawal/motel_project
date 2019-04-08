package motel;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import connection.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class room_service extends JFrame {

	private JPanel contentPane;
	private JTextField id1;
	private JTextField id2;
	private JTextField id3;
	private JTextField id4;
	private JTextField uid;
	private JTextField id5;

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
		setVisible(true);
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
		
		JLabel msg = new JLabel("");
		msg.setBounds(243, 107, 178, 118);
		contentPane.add(msg);
		
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
		label_1.setBounds(30, 74, 68, 16);
		contentPane.add(label_1);
		
		uid = new JTextField();
		uid.setColumns(10);
		uid.setBounds(121, 69, 80, 26);
		contentPane.add(uid);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String text1 = id1.getText();
				String text2 = id2.getText();
				String text3 = id3.getText();
				String text4 = id4.getText();
				String text5 = id5.getText();
				String text6 = uid.getText();
				
				int qt1 = Integer.parseInt(text1);
				int qt2 = Integer.parseInt(text2);
				int qt3 = Integer.parseInt(text3);
				int qt4 = Integer.parseInt(text4);
				int qt5 = Integer.parseInt(text5);
				int user_id = Integer.parseInt(text6);
				
				String reply = "";
				
				//making database connection
				connect conn = new connect();
				try
				{
					if(text6 != null && !text6.isEmpty())
					{
						if(qt1 != 0)
						{
							String qry = "insert into orders values(?,?,?)";
							PreparedStatement stmt = conn.con.prepareStatement(qry);
							stmt.setInt(1,user_id);
							stmt.setInt(2,1);
							stmt.setInt(3,qt1);
							
							int i = stmt.executeUpdate();
							if(i!= 0)
							{						
								//update success
								reply = reply + "Fries ->" + qt1 +"\n";
							}
							else
							{
								reply = "database connection error";
							}
						}
						if(qt2 != 0)
						{
							String qry = "insert into orders values(?,?,?)";
							PreparedStatement stmt = conn.con.prepareStatement(qry);
							stmt.setInt(1,user_id);
							stmt.setInt(2,2);
							stmt.setInt(3,qt2);
							
							int i = stmt.executeUpdate();
							if(i!= 0)
							{
								//update success
								reply = reply + "Pav Bhaji ->" + qt2 +"\n";
							}
							else
							{
								reply = "database connection error";
							}
						}
						if(qt3 != 0)
						{
							String qry = "insert into orders values(?,?,?)";
							PreparedStatement stmt = conn.con.prepareStatement(qry);
							stmt.setInt(1,user_id);
							stmt.setInt(2,3);
							stmt.setInt(3,qt3);
							
							int i = stmt.executeUpdate();
							if(i!= 0)
							{
								//update success
								reply = reply + "Pizza ->" + qt3 +"\n";
							}
							else
							{
								reply= "databse connection error";
							}
						}
						if(qt4 != 0)
						{
							String qry = "insert into orders values(?,?,?)";
							PreparedStatement stmt = conn.con.prepareStatement(qry);
							stmt.setInt(1,user_id);
							stmt.setInt(2,3);
							stmt.setInt(3,qt4);
							
							int i = stmt.executeUpdate();
							if(i!= 0)
							{
								//update success
								reply = reply + "Pasta ->" + qt4 +"\n";
							}
							else
							{
								reply= "databse connection error";
							}
						}
						if(qt5 != 0)
						{
							String qry = "insert into orders values(?,?,?)";
							PreparedStatement stmt = conn.con.prepareStatement(qry);
							stmt.setInt(1,user_id);
							stmt.setInt(2,3);
							stmt.setInt(3,qt5);
							
							int i = stmt.executeUpdate();
							if(i!= 0)
							{
								//update success
								reply = reply + "Extra Bed ->" + qt5 +"\n";
							}
							else
							{
								reply= "databse connection error";
							}
						}
						if( qt1 == 0 && qt2 == 0 && qt3 == 0 && qt4 == 0 && qt5 == 0 )
						{
							reply = "Nothing updated";
						}
					}
					else
					{
						reply = "Please enter ur User ID";
					}
					
					msg.setText(reply);
					reply =""; //clearing for the next iteration of the work (being double sure)	
				}
				catch(Exception error)
				{
					System.out.print(error);
				}
				
			}
		});
		btnNewButton.setBounds(279, 233, 117, 26);
		contentPane.add(btnNewButton);
		
		JLabel lblExtraBed = new JLabel("Extra Bed");
		lblExtraBed.setBounds(243, 79, 83, 16);
		contentPane.add(lblExtraBed);
		
		id5 = new JTextField();
		id5.setText("0");
		id5.setColumns(10);
		id5.setBounds(340, 74, 66, 26);
		contentPane.add(id5);
		
		JLabel lblRoomItems = new JLabel("Room Items:");
		lblRoomItems.setBounds(243, 51, 83, 16);
		contentPane.add(lblRoomItems);
		
		JLabel label_2 = new JLabel("Quantity");
		label_2.setBounds(345, 51, 61, 16);
		contentPane.add(label_2);
		
		
		
		JButton back = new JButton("<- BACK");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new amenities();
			}
		});
		back.setBounds(8, 6, 83, 29);
		contentPane.add(back);
	}

}
