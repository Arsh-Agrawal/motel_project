package motel;

import connection.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class bill extends JFrame {

	private JPanel contentPane;
	private JTextField uid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bill frame = new bill();
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
	public bill() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblBill = new JLabel("Bill");
		lblBill.setHorizontalAlignment(SwingConstants.CENTER);
		lblBill.setBounds(197, 6, 61, 16);
		contentPane.add(lblBill);
		
		JLabel lblId = new JLabel("User ID:");
		lblId.setBounds(18, 55, 61, 16);
		contentPane.add(lblId);
		
		JLabel return_msg = new JLabel("");
		return_msg.setHorizontalAlignment(SwingConstants.CENTER);
		return_msg.setBounds(291, 110, 112, 66);
		contentPane.add(return_msg);
		
		uid = new JTextField();
		uid.setBounds(103, 50, 130, 26);
		contentPane.add(uid);
		uid.setColumns(10);
		
		JLabel bid = new JLabel("");
		bid.setBounds(197, 88, 61, 16);
		contentPane.add(bid);
		
		JLabel rservice = new JLabel("");
		rservice.setBounds(197, 160, 61, 16);
		contentPane.add(rservice);
		
		JLabel fcost = new JLabel("");
		fcost.setBounds(186, 132, 61, 16);
		contentPane.add(fcost);
		
		JLabel price = new JLabel("");
		price.setBounds(103, 234, 61, 16);
		contentPane.add(price);
		
		JLabel booking = new JLabel("");
		booking.setBounds(197, 188, 61, 16);
		contentPane.add(booking);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//submit
			
			//checking if user id is correct formate
			int user_id = 0;
			String us_id= "";
			try
			{
				us_id = uid.getText();
				user_id = Integer.parseInt(us_id);
			}
			catch(Exception err)
			{
				return_msg.setText("Please enter correct user id");
				return;
			}
			String reply = "";
			
			//making database connection
			connect conn = new connect();
			
			try
			{
				if(uid != null && !us_id.isEmpty())
				{
					
					//checking for existence of user_id
					String qry = "select count(*) from user_1 where id = ?";
					PreparedStatement stmt = conn.con.prepareStatement(qry);
					stmt.setInt(1, user_id);
					ResultSet rs1 = stmt.executeQuery();
					rs1.next();
					int count = rs1.getInt(1); //coloumn number
					if(count == 0)
					{
						return_msg.setText("Please enter valid user id");
						return;
					}
					
					
					//query for facilities cost
					qry = "select f_id,hours from uses where u_id = ?";
					stmt = conn.con.prepareStatement(qry);
					stmt.setInt(1, user_id);
					rs1 = stmt.executeQuery();
					
					PreparedStatement stmt2;
					int hours=0, f_id=0, cost_of_fac = 0, cost=0;
					ResultSet rs2;
					while(rs1.next())
					{
						f_id = rs1.getInt(1);
						
						qry = "select cost from facilities where id = ?";
						stmt2 = conn.con.prepareStatement(qry);
						stmt2.setInt(1,f_id);
						rs2 = stmt2.executeQuery();
						rs2.next();
						cost = rs2.getInt(1);
						hours = rs1.getInt(2);
						
						cost_of_fac += hours *  cost;

					}
					//cost_of_fac will now have the total value of after running through every tuple in the loop
					//convert cost_of_fac to string to put it in fcost.setText()
					String fc = Integer.toString(cost_of_fac);
					fcost.setText(fc);

					//do it similarly for room_service

					qry = "select r_id, quantity from orders where u_id = ?";
					stmt = conn.con.prepareStatement(qry);
					stmt.setInt(1, user_id);
					rs1 = stmt.executeQuery();

					int quantity=0, r_id=0, cost_of_serv=0, cost1=0;
					while(rs1.next())
					{
						r_id = rs1.getInt(1);
						
						qry = "select cost from room_service where id = ?";
						stmt2 = conn.con.prepareStatement(qry);
						stmt2.setInt(1, r_id);
						rs2 = stmt2.executeQuery();
						rs2.next();
						
						cost1 = rs2.getInt(1);
						quantity = rs2.getInt(2);

						cost_of_serv += quantity * cost1;


					}
					
					String rserv = Integer.toString(cost_of_serv);
					rservice.setText(rserv);
					
					//for the code of books table
					qry = "select room_no,check_in,check_out from books where u_id = ?";
					stmt = conn.con.prepareStatement(qry);
					stmt.setInt(1, user_id);
					rs1 = stmt.executeQuery();
					
					//only one tuple will be selected(only one row)

					int r_no = rs1.getInt(1); 

					Date check_in = rs1.getDate(2);
					Date check_out = rs1.getDate(3);

					long difference = check_out.getTime() - check_in.getTime();

					float nights = (difference / (1000*60*60*24)) - 1; //no of days - 1



					qry = "select cost_per_night from type_1, room where room_no = ? and id = type_id";
					stmt = conn.con.prepareStatement(qry);
					stmt.setInt(1, r_no);

					int c_p_n = rs1.getInt(1);

					float booking_cost = c_p_n * nights;
					
					String books = Float.toString(booking_cost);
					booking.setText(books);
					
					
					JButton btnNewButton = new JButton("Pay");
					btnNewButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							//pay
							String us_id = uid.getText();
							int user_id = Integer.parseInt(us_id);
							
							String reply = "";
							
							//making database connection
							connect conn = new connect();
							
							try
							{
								if(us_id!= null && !us_id.isEmpty())
								{
									String qry1 = "update room set status = 0 where room_no = (select room_no from books where u_id =?)";
									PreparedStatement stmt = conn.con.prepareStatement(qry1);
									stmt.setInt(1,user_id);
									int t1 = stmt.executeUpdate();
				
									String qry2 = "delete from books where u_id = ?";
									stmt = conn.con.prepareStatement(qry2);
									stmt.setInt(1,user_id);
									int t2 = stmt.executeUpdate();
									
									if(t1!=0  && t2!= 0)
									{
										dispose();
										new thankyou();
									}
									else
									{
										reply = "database connection problem";
										return_msg.setText(reply);
									}
									
				
								}
								else
								{
									reply = "Please enter ur User ID";
									return_msg.setText(reply);
								}
							}
							catch(Exception error)
							{
								System.out.print(error);
							}
							
						}
						
					});
					btnNewButton.setBounds(299, 229, 117, 29);
					contentPane.add(btnNewButton);
	
				}
				else
				{
					reply = "Please enter ur User ID";
					return_msg.setText(reply);
				}
			}
			catch(Exception error)
			{
				System.out.print(error);
			}
			
		}});
		btnSubmit.setBounds(245, 50, 117, 29);
		contentPane.add(btnSubmit);
		
		JLabel lblBillId = new JLabel("Bill ID:");
		lblBillId.setBounds(18, 88, 61, 16);
		contentPane.add(lblBillId);
		
		JLabel lbldiscount = new JLabel("Room Service Cost");
		lbldiscount.setBounds(18, 153, 124, 26);
		contentPane.add(lbldiscount);
		
		JLabel lblPricedue = new JLabel("Price Due:");
		lblPricedue.setBounds(18, 234, 69, 16);
		contentPane.add(lblPricedue);
				
		JLabel lblprice = new JLabel("Facilities Cost:");
		lblprice.setBounds(18, 125, 109, 16);
		contentPane.add(lblprice);
		
		
		
		
		
		
		JButton button = new JButton("<- BACK");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//back 
				new amenities();
				dispose();
			}
		});
		button.setBounds(4, 6, 83, 29);
		contentPane.add(button);
		
		JLabel lblNewLabel = new JLabel("Booking Cost:");
		lblNewLabel.setBounds(18, 191, 124, 16);
		contentPane.add(lblNewLabel);
		
		
		
	}
}
