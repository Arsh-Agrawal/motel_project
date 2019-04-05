package motel;

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

		PreparedStatement stmt;
		ResultSet rs;

		JLabel lblBill = new JLabel("Bill");
		lblBill.setHorizontalAlignment(SwingConstants.CENTER);
		lblBill.setBounds(197, 6, 61, 16);
		contentPane.add(lblBill);
		
		JLabel lblId = new JLabel("User ID:");
		lblId.setBounds(18, 55, 61, 16);
		contentPane.add(lblId);
		
		uid = new JTextField();
		uid.setBounds(103, 50, 130, 26);
		contentPane.add(uid);
		uid.setColumns(10);
		
		JLabel bid = new JLabel("");
		bid.setBounds(103, 110, 61, 16);
		contentPane.add(bid);
		
		JLabel discount = new JLabel("");
		discount.setBounds(103, 188, 61, 16);
		contentPane.add(discount);
		
		JLabel amount = new JLabel("");
		amount.setBounds(103, 150, 61, 16);
		contentPane.add(amount);
		
		JLabel price = new JLabel("");
		price.setBounds(103, 234, 61, 16);
		contentPane.add(price);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//submit
			String us_id = uid.getText();

			int user_id = Integer.parseInt(us_id);

			String replay = "";

			if(us_id != null || !us_id.isEmpty())
			{

				String qry = "select id, discount, price from bill where u_id = user_id ";
				rs = stmt.executeQuery(qry);  

				int b = rs.getInt(1);
				int d = rs.getInt(2);
				int p = rs.getInt(3);
					
				String strb = Integer.toString(b);
				String strd = Integer.toString(d);
				String strp = Integer.toString(p);

				bid.setText(strb);
				discount.setText(strd);
				amount.setText(strp);

				int pricedue = p - ((p*d)/100);

				String strpricedue = Integer.toString(pricedue);
					
				price.setText(strpricedue);

			}
			else
			{
				reply = "Please enter ur User ID";
			}
			
		}});
		btnSubmit.setBounds(245, 50, 117, 29);
		contentPane.add(btnSubmit);
		
		JLabel lblBillId = new JLabel("Bill ID:");
		lblBillId.setBounds(18, 110, 61, 16);
		contentPane.add(lblBillId);
		
		JLabel lbldiscount = new JLabel("Discount:");
		lbldiscount.setBounds(18, 188, 61, 16);
		contentPane.add(lbldiscount);
		
		JLabel lblPricedue = new JLabel("Price Due:");
		lblPricedue.setBounds(18, 234, 69, 16);
		contentPane.add(lblPricedue);
				
		JLabel lblprice = new JLabel("Price:");
		lblprice.setBounds(18, 150, 61, 16);
		contentPane.add(lblprice);
		
		
		
		JButton btnNewButton = new JButton("Pay");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//pay
				String qry1 = "update room set status = 0 from room, books where u_id = user_id and books.room_no = room.room_no";
				rs = stmt.executeQuery(qry1); 

				String qry2 = "delete from books where u_id = user_id";
				rs = stmt.executeQuery(qry2); 

			}
		});
		btnNewButton.setBounds(299, 229, 117, 29);
		contentPane.add(btnNewButton);
		
		JButton button = new JButton("<- BACK");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//back 
				dispose();
			}
		});
		button.setBounds(4, 6, 83, 29);
		contentPane.add(button);
	}

}
