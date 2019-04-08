package motel;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import connection.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class facilities extends JFrame {

	private JPanel contentPane;
	private JTextField id1;
	private JTextField id2;
	private JTextField id3;
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
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel msg = new JLabel("");
		msg.setHorizontalAlignment(SwingConstants.CENTER);
		msg.setBounds(263, 134, 144, 66);
		contentPane.add(msg);
		
		JLabel lblFacilities = new JLabel("Facilities");
		lblFacilities.setBounds(195, 6, 61, 16);
		contentPane.add(lblFacilities);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ghrs = id1.getText();
				String phrs = id2.getText();
				String shhrs = id3.getText();
				String u_id = uid.getText();
				
				int gym_hours = Integer.parseInt(ghrs);
				int pool_hours = Integer.parseInt(phrs);
				int shuttle = Integer.parseInt(shhrs);
				int user_id = Integer.parseInt(u_id);
				
				String reply = "";
				
				//making db connection
				 connect conn = new connect();
				 
				try 
				{
					
					
					if(uid != null || !u_id.isEmpty())
					{
								
						if(gym_hours != 0)
						{
							String qry = "insert into uses values(?,?,?)";
							PreparedStatement stmt = conn.con.prepareStatement(qry);
							stmt.setInt(1,user_id);
							stmt.setInt(2,1);
							stmt.setInt(3,gym_hours);
							
							int i = stmt.executeUpdate();
							if(i!= 0)
							{						
								//update success
								reply = reply + "Used gym for " + gym_hours+"\n";
							}
							else
							{
								reply = "database connection error";
							}
						}
						if(pool_hours != 0)
						{
							String qry = "insert into uses values(?,?,?)";
							PreparedStatement stmt = conn.con.prepareStatement(qry);
							stmt.setInt(1,user_id);
							stmt.setInt(2,2);
							stmt.setInt(3,pool_hours);
							
							int i = stmt.executeUpdate();
							if(i!= 0)
							{
								//update success
								reply = reply + "Used pool for " + pool_hours+"\n";
							}
							else
							{
								reply = "database connection error";
							}
						}
						if(shuttle != 0)
						{
							String qry = "insert into uses values(?,?,?)";
							PreparedStatement stmt = conn.con.prepareStatement(qry);
							stmt.setInt(1,user_id);
							stmt.setInt(2,3);
							stmt.setInt(3,shuttle);
							
							int i = stmt.executeUpdate();
							if(i!= 0)
							{
								//update success
								reply = reply + "Used pool for " + pool_hours+"\n";
							}
							else
							{
								reply= "databse connection error";
							}
						}
						if(shuttle == 0 && gym_hours == 0 && pool_hours == 0)
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
				catch(Exception error) {
					System.out.print(error);
				}
			}
		});
		btnSubmit.setBounds(242, 222, 117, 39);
		contentPane.add(btnSubmit);
		
		JLabel lblType = new JLabel("Type:");
		lblType.setBounds(22, 51, 61, 16);
		contentPane.add(lblType);
		
		JLabel lblHours = new JLabel("Hours");
		lblHours.setBounds(133, 51, 61, 16);
		contentPane.add(lblHours);
		
		id1 = new JTextField();
		id1.setText("0");
		id1.setBounds(133, 82, 41, 26);
		contentPane.add(id1);
		id1.setColumns(10);
		
		id2 = new JTextField();
		id2.setText("0");
		id2.setBounds(133, 130, 41, 24);
		contentPane.add(id2);
		id2.setColumns(10);
		
		id3 = new JTextField();
		id3.setText("0");
		id3.setBounds(133, 174, 41, 26);
		contentPane.add(id3);
		id3.setColumns(10);
		
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
		
		JButton button = new JButton("<- BACK");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new amenities();
			}
		});
		button.setBounds(6, 6, 83, 29);
		contentPane.add(button);
		
		
	}

}
