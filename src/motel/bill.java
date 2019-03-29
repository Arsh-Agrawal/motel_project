package motel;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

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
		
		uid = new JTextField();
		uid.setBounds(103, 50, 130, 26);
		contentPane.add(uid);
		uid.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
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
		
		JLabel bid = new JLabel("");
		bid.setBounds(103, 110, 61, 16);
		contentPane.add(bid);
		
		JLabel discount = new JLabel("");
		discount.setBounds(103, 188, 61, 16);
		contentPane.add(discount);
		
		JLabel price = new JLabel("");
		price.setBounds(103, 234, 61, 16);
		contentPane.add(price);
		
		JLabel lblprice = new JLabel("Price:");
		lblprice.setBounds(18, 150, 61, 16);
		contentPane.add(lblprice);
		
		JLabel amount = new JLabel("");
		amount.setBounds(103, 150, 61, 16);
		contentPane.add(amount);
	}

}
