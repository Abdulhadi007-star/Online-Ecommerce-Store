import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class manage_Products extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTable table;
	private JFormattedTextField prodid;
	private JFormattedTextField quantity;
	private JFormattedTextField name;
	private JFormattedTextField price;
	private JComboBox<String> role;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					manage_Products frame = new manage_Products();
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
	public manage_Products() {
		
		setTitle("Product");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 729, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblMana = new JLabel("Manage Products");
		lblMana.setForeground(Color.BLACK);
		lblMana.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblMana.setBounds(271, 23, 188, 22);
		contentPane.add(lblMana);

		JLabel lblNewLabel_1_2_1 = new JLabel("prodID");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2_1.setBounds(47, 87, 79, 22);
		contentPane.add(lblNewLabel_1_2_1);

		JLabel lblNewLabel_1_2_1_1 = new JLabel("Name");
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2_1_1.setBounds(47, 153, 79, 22);
		contentPane.add(lblNewLabel_1_2_1_1);

		JLabel lblNewLabel_1_2_1_1_1 = new JLabel("Quantity");
		lblNewLabel_1_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2_1_1_1.setBounds(398, 87, 79, 22);
		contentPane.add(lblNewLabel_1_2_1_1_1);

		JLabel lblNewLabel_1_2_1_1_1_1 = new JLabel("Price");
		lblNewLabel_1_2_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2_1_1_1_1.setBounds(398, 153, 79, 22);
		contentPane.add(lblNewLabel_1_2_1_1_1_1);

		JLabel lblNewLabel_1_2_1_1_1_1_1 = new JLabel("Category");
		lblNewLabel_1_2_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2_1_1_1_1_1.setBounds(47, 218, 79, 22);
		contentPane.add(lblNewLabel_1_2_1_1_1_1_1);

		prodid = new JFormattedTextField();
		prodid.setBounds(136, 87, 174, 27);
		contentPane.add(prodid);

		name = new JFormattedTextField();
		name.setBounds(136, 153, 174, 27);
		contentPane.add(name);

		quantity = new JFormattedTextField();
		quantity.setBounds(487, 87, 174, 27);
		contentPane.add(quantity);

		price = new JFormattedTextField();
		price.setBounds(487, 153, 174, 27);
		contentPane.add(price);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(57, 360, 604, 90);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setRowHeight(25);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"ID", "Name", "Quantity", "Price", "Category"
			}
		));

		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(this);
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAdd.setBounds(75, 270, 102, 33);
		contentPane.add(btnAdd);

		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(this);
		btnEdit.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEdit.setBounds(240, 270, 102, 33);
		contentPane.add(btnEdit);

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(this);
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDelete.setBounds(421, 270, 102, 33);
		contentPane.add(btnDelete);

		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(this);
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnClear.setBounds(582, 270, 102, 33);
		contentPane.add(btnClear);

		JLabel lblProductsList = new JLabel("Products List");
		lblProductsList.setForeground(Color.BLACK);
		lblProductsList.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblProductsList.setBounds(289, 322, 188, 22);
		contentPane.add(lblProductsList);
		
		role = new JComboBox();
		role.setModel(new DefaultComboBoxModel(new String[] {}));
		role.setFont(new Font("Tahoma", Font.BOLD, 12));
		role.setBounds(136, 217, 174, 27);
		contentPane.add(role);
		productList();
		CategoryName();
	}
	
	public void CategoryName() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			 conn = connection.Conn();
			 String query = "Select cat_name from category";
			 stmt = conn.createStatement();
			 rs = stmt.executeQuery(query);
			 while(rs.next()) {
				 String CatName = rs.getString("cat_name");
				 role.addItem(CatName);
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
	
	public void actionPerformed(ActionEvent e) {
		String k = e.getActionCommand();
		if(k.equals("Add")) {
			
			String prodID = prodid.getText();
			int ID = Integer.parseInt(prodID);
			String Name = name.getText();
			String Quantity = quantity.getText();
			int Q = Integer.parseInt(Quantity);
			String Price = price.getText();
			int P = Integer.parseInt(Price);
			String cat = role.getSelectedItem().toString();
			
			Connection conn = null;
			 PreparedStatement pstmt = null;
			try {
				 conn = connection.Conn();
				 String query = "insert into product(prod_id,prod_name,quantity,prod_price,category_cat_name) values (?,?,?,?,?)";
				 
				 pstmt = conn.prepareStatement(query);
				 pstmt.setInt(1, ID);
				 pstmt.setString(2, Name);
				 pstmt.setInt(3, Q);
				 pstmt.setInt(4, P);
				 pstmt.setString(5, cat);
				
				 pstmt.executeUpdate();
				 JOptionPane.showMessageDialog(this, "Product added Successfully...");
				 pstmt.close();
				 conn.close();
				 productList();
			} catch(Exception e1) {
				e1.printStackTrace();
			}
}
		else if(k.equals("Clear")) {
			prodid.setText("");
			name.setText("");
			quantity.setText("");
			price.setText("");
		}
		else if(k.equals("Delete")) {
			if (prodid.getText().isEmpty()) {
				JOptionPane.showMessageDialog(this, "Please Enter Product data to be deleted!");
			}
			else {
				Connection conn = null;
				 PreparedStatement pstmt = null;
				try {
					String prodID = prodid.getText();
					int ID = Integer.parseInt(prodID);
					 conn = connection.Conn();
					 String query = "Delete from product where prod_id ="+ID;
					 pstmt = conn.prepareStatement(query);
					 pstmt.executeUpdate();
					 JOptionPane.showMessageDialog(this, "Product Deleted!!!");
					 pstmt.close();
					 conn.close();
					 productList();		 
			}
				catch(Exception e1) {
					e1.printStackTrace();
				}
		}
	}
		else {
			Connection conn = null;
			 PreparedStatement pstmt = null;
			try {
				String Name = name.getText();
				
				String Quantity = quantity.getText();
				int Q = Integer.parseInt(Quantity);
				String Price = price.getText();
				int P = Integer.parseInt(Price);
				String ID = prodid.getText();
				int id = Integer.parseInt(ID);
				String Cat = role.getSelectedItem().toString();
				
				conn = connection.Conn();
				String query = "Update product set prod_name = '"+Name+"'"+",category_cat_name='"+Cat+"'"+",prod_price = "+P+",quantity = "+Q+"where prod_id="+id;
				pstmt = conn.prepareStatement(query);
				 pstmt.executeUpdate();
				 JOptionPane.showMessageDialog(this, "Product information Updated!!!");
				 pstmt.close();
				 conn.close();
				 productList();
			}
			catch(Exception e1) {
				e1.printStackTrace();
			}
		}
	}
}
