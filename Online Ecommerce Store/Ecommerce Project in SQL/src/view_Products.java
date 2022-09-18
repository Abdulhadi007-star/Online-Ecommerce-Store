import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFormattedTextField;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.DropMode;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class view_Products extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JTable table_3;
	private JFormattedTextField cart;
	private JFormattedTextField cart1;
	private JFormattedTextField c;
	private JFormattedTextField prodname;
	private JFormattedTextField sale;
	private JTextArea desc;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					view_Products frame = new view_Products();
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
	public view_Products() {
		
		
		setTitle("E-commerce Portal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 786, 494);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(33, 23, 706, 396);
		contentPane.add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Products", null, panel_1, null);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 665, 321);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.setRowHeight(25);
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"Prod ID", "Product Name", "Category", "Quantity", "Price"
			}
		));
		
		JButton btnAddToCart = new JButton("Add to Cart");
		btnAddToCart.addActionListener(this);
		btnAddToCart.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAddToCart.setBounds(398, 332, 119, 27);
		panel_1.add(btnAddToCart);
		
		JLabel lblNewLabel_1_2_1_1_1_1 = new JLabel("Prod ID");
		lblNewLabel_1_2_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2_1_1_1_1.setBounds(40, 334, 79, 22);
		panel_1.add(lblNewLabel_1_2_1_1_1_1);
		
		cart = new JFormattedTextField();
		cart.setBounds(147, 332, 174, 27);
		panel_1.add(cart);
		table.getColumnModel().getColumn(1).setPreferredWidth(79);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("My Cart", null, panel_2, null);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 680, 301);
		panel_2.add(scrollPane_1);
		
		
		
		table_1 = new JTable();
		table_1.setRowHeight(25);
		scrollPane_1.setViewportView(table_1);
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"Prod ID", "Product Name", "Category", "Price", "Quantity"
			}
		));
		
		JLabel lblNewLabel_1_2_1_1_1_1_1 = new JLabel("Prod ID");
		lblNewLabel_1_2_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2_1_1_1_1_1.setBounds(46, 327, 79, 22);
		panel_2.add(lblNewLabel_1_2_1_1_1_1_1);
		
		cart1 = new JFormattedTextField();
		cart1.setBounds(136, 327, 174, 27);
		panel_2.add(cart1);
		
		JButton btnAddToCart_1 = new JButton("Del from Cart");
		btnAddToCart_1.addActionListener(this);
		btnAddToCart_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAddToCart_1.setBounds(345, 325, 125, 27);
		panel_2.add(btnAddToCart_1);
		
		JLabel lblNewLabel_1_2_1_1_1_1_1_2 = new JLabel("Category Sale");
		lblNewLabel_1_2_1_1_1_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2_1_1_1_1_1_2.setBounds(548, 305, 103, 22);
		panel_2.add(lblNewLabel_1_2_1_1_1_1_1_2);
		
		sale = new JFormattedTextField();
		sale.setBounds(506, 330, 174, 27);
		panel_2.add(sale);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Order Details", null, panel_3, null);
		panel_3.setLayout(null);
		
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(0, 0, 680, 298);
		panel_3.add(scrollPane_2);
		
		
		
		table_2 = new JTable();
		table_2.setRowHeight(25);
		scrollPane_2.setViewportView(table_2);
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"Customer Name", "Address", "Prod ID", "Product Name", "Category", "Price", "Quantity"
			}
		));
		table_2.getColumnModel().getColumn(0).setPreferredWidth(92);
		table_2.getColumnModel().getColumn(3).setPreferredWidth(83);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Billing Info", null, panel_4, null);
		panel_4.setLayout(null);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(0, 0, 680, 251);
		panel_4.add(scrollPane_3);
		
		table_3 = new JTable();
		table_3.setRowHeight(25);
		scrollPane_3.setViewportView(table_3);
		table_3.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"Customer Name", "Prod ID", "Product Name", "Category", "Quantity", "Price"
			}
		));
		table_3.getColumnModel().getColumn(0).setPreferredWidth(94);
		table_3.getColumnModel().getColumn(2).setPreferredWidth(81);
		
		JLabel lblNewLabel_1_2_1_1_1_1_1_1 = new JLabel("Total Amount");
		lblNewLabel_1_2_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2_1_1_1_1_1_1.setBounds(403, 272, 120, 22);
		panel_4.add(lblNewLabel_1_2_1_1_1_1_1_1);
		
		c = new JFormattedTextField();
		c.setBounds(560, 272, 120, 27);
		panel_4.add(c);
		
		JButton btnConfirmOrder = new JButton("Confirm Order");
		btnConfirmOrder.addActionListener(this);
		btnConfirmOrder.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnConfirmOrder.setBounds(267, 319, 172, 38);
		panel_4.add(btnConfirmOrder);
		
		JPanel panel_5 = new JPanel();
		tabbedPane.addTab("Review", null, panel_5, null);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Prodcut Name");
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2_1_1.setBounds(109, 29, 105, 22);
		panel_5.add(lblNewLabel_1_2_1_1);
		
		prodname = new JFormattedTextField();
		prodname.setBounds(319, 29, 174, 27);
		panel_5.add(prodname);
		
		JLabel lblNewLabel_1_2_1_1_1 = new JLabel("Enter Text");
		lblNewLabel_1_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2_1_1_1.setBounds(109, 95, 105, 22);
		panel_5.add(lblNewLabel_1_2_1_1_1);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(this);
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSubmit.setBounds(391, 283, 102, 33);
		panel_5.add(btnSubmit);
		
		desc = new JTextArea();
		desc.setDropMode(DropMode.INSERT);
		desc.setWrapStyleWord(true);
		desc.setBounds(280, 96, 337, 129);
		panel_5.add(desc);
		
		productList();
		cartList();
		totalAmount();
		catSale();
		
		 ChangeListener changeListener = new ChangeListener() {
		      public void stateChanged(ChangeEvent changeEvent) {
		        JTabbedPane sourceTabbedPane = (JTabbedPane) changeEvent.getSource();
		        int index = sourceTabbedPane.getSelectedIndex();
		        if(sourceTabbedPane.getTitleAt(index).equals("Order Details"))
		        {
		        	orderList();
		        }
		        else if(sourceTabbedPane.getTitleAt(index).equals("Billing Info")) {
		        	billingInfo();	
		        }
		      }
		    };
		tabbedPane.addChangeListener(changeListener);
		
	}
	public void catSale(){
		Connection conn = null;
		 PreparedStatement pstmt = null;
		try {
			conn = connection.Conn();
			String query = "Select cat_name, sum(prod_price) as Cat_Sale From product natural join category natural join cart where cat_name = category_cat_name and prod_id = product_prod_id group by cat_name";
			 pstmt = conn.prepareStatement(query);
			 ResultSet rs = pstmt.executeQuery();
			 while(rs.next()) {
				 String d = rs.getString("Cat_Sale");
				sale.setText(d);
			 }
			 
			}
		catch(Exception e1) {
			e1.printStackTrace();
		}
	}
	

	
	
	public void productList() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = connection.Conn();
			stmt = conn.createStatement();
			String query = "Select * from product order by prod_id";
			rs = stmt.executeQuery(query);
			table.setModel(DbUtils.resultSetToTableModel(rs));
			}
		catch(Exception e1) {
			e1.printStackTrace();
		}
	}
	
	public void cartList() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = connection.Conn();
			stmt = conn.createStatement();
			String query = "Select prod_id,prod_name,quantity,prod_price,category_cat_name as category_name from product natural join cart where prod_id = product_prod_id and customer_customer_id = "+ getid();
			rs = stmt.executeQuery(query);
			table_1.setModel(DbUtils.resultSetToTableModel(rs));
			}
		catch(Exception e1) {
			e1.printStackTrace();
		}
	}
	
	public void orderList() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = connection.Conn();
			stmt = conn.createStatement();
			String query = "Select customer_name,Address,prod_id,prod_name,quantity,prod_price,Category_cat_Name as CategoryName from customer Natural join cart Natural join product where customer_id = customer_customer_id and prod_id = Product_prod_id and customer_customer_id ="+getid();
			rs = stmt.executeQuery(query);
			table_2.setModel(DbUtils.resultSetToTableModel(rs));
			}
		catch(Exception e1) {
			e1.printStackTrace();
		}
	}
	
	public void totalAmount() {
		Connection conn = null;
		 PreparedStatement pstmt = null;
		try {
			conn = connection.Conn();
			String query = "Select Sum(prod_price) as TotalAmount from product Natural join cart where prod_id = Product_prod_id and customer_customer_id = "+getid();
			 pstmt = conn.prepareStatement(query);
			 ResultSet rs = pstmt.executeQuery();
			 while(rs.next()) {
				 String d = rs.getString("TotalAmount");
				c.setText(d);
			 }
			 
			}
		catch(Exception e1) {
			e1.printStackTrace();
		}
	}
			
	
	public void billingInfo() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = connection.Conn();
			stmt = conn.createStatement();
			String query = "Select customer_name,Address,prod_id,prod_name,quantity,prod_price,Category_cat_Name as CategoryName from customer Natural join cart Natural join product where customer_id = customer_customer_id and prod_id = Product_prod_id and customer_customer_id ="+getid();
			rs = stmt.executeQuery(query);
			table_3.setModel(DbUtils.resultSetToTableModel(rs));
			}
		catch(Exception e1) {
			e1.printStackTrace();
		}
	}
	
	public int getid() {
		Connection conn = null;
		 PreparedStatement pstmt = null;
		String email = signIn.getEmail();
		try {
			conn = connection.Conn();
			 String query = "select customer_id from customer where email = '"+email+"'";
			 pstmt = conn.prepareStatement(query);
			 ResultSet rs = pstmt.executeQuery();
			 if(rs.next()) {
				 int ID = rs.getInt("customer_id");
				 System.out.print(ID);
				 return ID;
			 }
		}
		catch(Exception e1) {
			e1.printStackTrace();
		}
		return 0;
		
	}
	
	
	public void actionPerformed(ActionEvent e) {
		String k = e.getActionCommand();
		if(k.equals("Add to Cart")) {	
			Connection conn = null;
			 PreparedStatement pstmt = null;
			try {
				if (cart.getText().isEmpty()) {
					JOptionPane.showMessageDialog(this, "Please Enter Product ID which you want to add in cart!");
				}
				else { 
					String prodid = cart.getText();
					int id  = Integer.parseInt(prodid);
					int cusid = getid();
				 conn = connection.Conn();
				 String query = "insert into cart(cart_id,product_prod_id,customer_customer_id) values (cart_id.nextval,?,?)";
				 pstmt = conn.prepareStatement(query);
				 pstmt.setInt(1, id);
				 pstmt.setInt(2, cusid);
				 pstmt.executeUpdate();
				 JOptionPane.showMessageDialog(this, "Product added in cart Successfully...");
				 pstmt.close();
				 conn.close();
				 productList();
				 cartList();
				 totalAmount();
			} 
			}catch(Exception e1) {
				e1.printStackTrace();
			}
}
	else if(k.equals("Del from Cart")) {
			if (cart1.getText().isEmpty()) {
				JOptionPane.showMessageDialog(this, "Please Enter Product ID which you want to delete in cart!");
			}
			else {
				Connection conn = null;
				 PreparedStatement pstmt = null;
				try {
					String Cart = cart1.getText();
					int c = Integer.parseInt(Cart);
					 conn = connection.Conn();
					 String query = "Delete from cart where product_prod_id ="+c;
					 pstmt = conn.prepareStatement(query);
					 pstmt.executeUpdate();
					 JOptionPane.showMessageDialog(this, "Product Deleted from cart!!!");
					 pstmt.close();
					 conn.close();
					 cartList();	
			}
				catch(Exception e1) {
					e1.printStackTrace();
				}
			}
	}
		

		
	else if(k.equals("Confirm Order")) {
		Connection conn = null;
		 PreparedStatement pstmt = null;
		try {
			int id = getid();
			conn = connection.Conn();
			 String query = "BEGIN LOOP DELETE FROM (SELECT * FROM CART WHERE customer_customer_id ="+id+")WHERE ROWNUM < 100;EXIT WHEN sql%ROWCOUNT = 0;commit;END LOOP;COMMIT;END;";
			 pstmt = conn.prepareStatement(query);
			 pstmt.executeUpdate();
			 JOptionPane.showMessageDialog(this, "Order Confirmed! Billing info printed...");
			 
			 pstmt.close();
			 conn.close();
			 cartList();
		}
		catch(Exception e1) {
			e1.printStackTrace();
		}
		
	}
	else if(k.equals("Submit")){
		Connection conn = null;
		 PreparedStatement pstmt = null;
		try {
			String Desc = desc.getText();
			int Cid = getid();
			System.out.print("ID is: "+c);
			conn = connection.Conn();
			 String query = "insert into reviews(review_id,review_text,customer_customer_id) values (review_id.nextval,?,?)";
			 pstmt = conn.prepareStatement(query);
			 pstmt.setString(1, Desc);
			 pstmt.setInt(2, Cid);
			 pstmt.executeUpdate();
			 JOptionPane.showMessageDialog(this, "Thanks for your Feedback...");
			 
			 pstmt.close();
			 conn.close();
		}
		catch(Exception e1) {
			e1.printStackTrace();
		}
	}
	}
	}

		


