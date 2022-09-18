
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;


import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;



public class manage_Supplier extends JFrame implements ActionListener{
	
	
	private JPanel contentPane;
	private JTable table;
	private JFormattedTextField supid;
	private JFormattedTextField name;
	private JComboBox role;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					manage_Supplier frame = new manage_Supplier();
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


	
	public manage_Supplier() {
		
		setTitle("Supplier");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 729, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblMana = new JLabel("Manage Suppliers");
		lblMana.setForeground(Color.BLACK);
		lblMana.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblMana.setBounds(271, 23, 188, 22);
		contentPane.add(lblMana);

		JLabel lblNewLabel_1_2_1 = new JLabel("SupID");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2_1.setBounds(58, 87, 79, 22);
		contentPane.add(lblNewLabel_1_2_1);

		JLabel lblNewLabel_1_2_1_1 = new JLabel("Name");
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2_1_1.setBounds(398, 87, 79, 22);
		contentPane.add(lblNewLabel_1_2_1_1);

		JLabel lblNewLabel_1_2_1_1_1_1 = new JLabel("Gender");
		lblNewLabel_1_2_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2_1_1_1_1.setBounds(225, 153, 79, 22);
		contentPane.add(lblNewLabel_1_2_1_1_1_1);

		supid = new JFormattedTextField();
		supid.setBounds(136, 87, 174, 27);
		contentPane.add(supid);

		name = new JFormattedTextField();
		name.setBounds(487, 87, 174, 27);
		contentPane.add(name);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(58, 344, 604, 95);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setRowHeight(25);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"supplierID", "Name", "Gender"
			}
		));

		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(this);
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAdd.setBounds(74, 235, 102, 33);
		contentPane.add(btnAdd);

		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(this);
		btnEdit.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEdit.setBounds(238, 235, 102, 33);
		contentPane.add(btnEdit);

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(this);
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDelete.setBounds(419, 235, 102, 33);
		contentPane.add(btnDelete);

		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(this);
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnClear.setBounds(582, 235, 102, 33);
		contentPane.add(btnClear);

		JLabel lblProductsList = new JLabel("Suppliers List");
		lblProductsList.setForeground(Color.BLACK);
		lblProductsList.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblProductsList.setBounds(289, 295, 188, 22);
		contentPane.add(lblProductsList);
		
		role = new JComboBox();
		role.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		role.setFont(new Font("Tahoma", Font.BOLD, 12));
		role.setBounds(314, 152, 174, 27);
		contentPane.add(role);
		
		supplierList();
	}
	
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	public void supplierList() {
		try {
			conn = connection.Conn();
			stmt = conn.createStatement();
			String query = "Select * from supplier order by supplier_id";
			rs = stmt.executeQuery(query);
			table.setModel(DbUtils.resultSetToTableModel(rs));
			}
		catch(Exception e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String k = e.getActionCommand();
		if(k.equals("Add")) {
			String supID = supid.getText();
			int ID = Integer.parseInt(supID);
			String Name = name.getText();
			String Gender = role.getSelectedItem().toString();
			
			Connection conn = null;
			 PreparedStatement pstmt = null;
			try {
				 conn = connection.Conn();
				 String query = "insert into supplier(supplier_id,supplier_name,gender) values (?,?,?)";
				 
				 pstmt = conn.prepareStatement(query);
				 pstmt.setInt(1, ID);
				 
				 pstmt.setString(2, Name);
				 
				 pstmt.setString(3, Gender);
				
				 pstmt.executeUpdate();
				 JOptionPane.showMessageDialog(this, "Supplier added Successfully...");
				 pstmt.close();
				 conn.close();
				 supplierList();
			} catch(Exception e1) {
				e1.printStackTrace();
			}
}
		else if(k.equals("Clear")) {
			supid.setText("");
			name.setText("");
		}
		else if(k.equals("Delete")) {
			if (supid.getText().isEmpty()) {
				JOptionPane.showMessageDialog(this, "Please Enter supplier data to be deleted!");
			}
			else {
				Connection conn = null;
				 PreparedStatement pstmt = null;
				try {
					String supID = supid.getText();
					int ID = Integer.parseInt(supID);
					 conn = connection.Conn();
					 String query = "Delete from supplier where supplier_id ="+ID;
					 pstmt = conn.prepareStatement(query);
					 pstmt.executeUpdate();
					 JOptionPane.showMessageDialog(this, "Supplier Deleted!!!");
					 pstmt.close();
					 conn.close();
					 supplierList();
					 
						 
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
				
				String Role = role.getSelectedItem().toString();
				
				String ID = supid.getText();
				int id = Integer.parseInt(ID);
				
				conn = connection.Conn();
				String query = "Update supplier set supplier_name = '"+Name+"'"+",gender='"+Role+"'"+"where supplier_id="+id;
				pstmt = conn.prepareStatement(query);
				 pstmt.executeUpdate();
				 JOptionPane.showMessageDialog(this, "Supplier information Updated!!!");
				 pstmt.close();
				 conn.close();
				 supplierList();
			}
			catch(Exception e1) {
				e1.printStackTrace();
			}
		}
	}
	
}
