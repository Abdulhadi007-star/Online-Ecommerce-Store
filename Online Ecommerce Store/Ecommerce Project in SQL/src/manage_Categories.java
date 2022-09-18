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

public class manage_Categories extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTable table;
	private JFormattedTextField catid;
	private JFormattedTextField catname;
	private JFormattedTextField catdes;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					manage_Categories frame = new manage_Categories();
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
	public manage_Categories() {
		
		setTitle("Category");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 729, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblMana = new JLabel("Manage Categories");
		lblMana.setForeground(Color.BLACK);
		lblMana.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblMana.setBounds(271, 23, 206, 22);
		contentPane.add(lblMana);

		JLabel lblNewLabel_1_2_1 = new JLabel("CatID");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2_1.setBounds(44, 87, 90, 22);
		contentPane.add(lblNewLabel_1_2_1);

		JLabel lblNewLabel_1_2_1_1 = new JLabel("Description");
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2_1_1.setBounds(181, 163, 79, 22);
		contentPane.add(lblNewLabel_1_2_1_1);

		JLabel lblNewLabel_1_2_1_1_1 = new JLabel("Name");
		lblNewLabel_1_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2_1_1_1.setBounds(398, 87, 79, 22);
		contentPane.add(lblNewLabel_1_2_1_1_1);

		catid = new JFormattedTextField();
		catid.setBounds(136, 87, 174, 27);
		contentPane.add(catid);

		catdes = new JFormattedTextField();
		catdes.setBounds(310, 163, 174, 27);
		contentPane.add(catdes);

		catname = new JFormattedTextField();
		catname.setBounds(487, 87, 174, 27);
		contentPane.add(catname);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(58, 344, 604, 95);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setRowHeight(25);
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"CatID", "Name", "Description"
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

		JLabel lblProductsList = new JLabel("Categories List");
		lblProductsList.setForeground(Color.BLACK);
		lblProductsList.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblProductsList.setBounds(289, 295, 188, 22);
		contentPane.add(lblProductsList);
		
		categoryList();
	}
	
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	public void categoryList() {
		try {
			conn = connection.Conn();
			stmt = conn.createStatement();
			String query = "Select * from category order by cat_id";
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
			String catID = catid.getText();
			int ID = Integer.parseInt(catID);
			String Name = catname.getText();
			String Des = catdes.getText();
			
			Connection conn = null;
			 PreparedStatement pstmt = null;
			try {
				 conn = connection.Conn();
				 String query = "insert into category(cat_id,cat_name,cat_description) values (?,?,?)";
				 
				 pstmt = conn.prepareStatement(query);
				 pstmt.setInt(1, ID);
				 
				 pstmt.setString(2, Name);
				 
				 pstmt.setString(3, Des);
				
				 pstmt.executeUpdate();
				 JOptionPane.showMessageDialog(this, "Category added Successfully...");
				 pstmt.close();
				 conn.close();
				 categoryList();
			} catch(Exception e1) {
				e1.printStackTrace();
			}
}
		else if(k.equals("Clear")) {
			catid.setText("");
			catname.setText("");
			catdes.setText("");
		}
		else if(k.equals("Delete")) {
			if (catid.getText().isEmpty()) {
				JOptionPane.showMessageDialog(this, "Please Enter category data to be deleted!");
			}
			else {
				Connection conn = null;
				 PreparedStatement pstmt = null;
				try {
					String catID = catid.getText();
					int ID = Integer.parseInt(catID);
					 conn = connection.Conn();
					 String query = "Delete from category where cat_id ="+ID;
					 pstmt = conn.prepareStatement(query);
					 pstmt.executeUpdate();
					 JOptionPane.showMessageDialog(this, "Category Deleted!!!");
					 pstmt.close();
					 conn.close();
					 categoryList();
					 
						 
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
				String Name = catname.getText();
				
				String des = catdes.getText();
				
				String ID = catid.getText();
				int id = Integer.parseInt(ID);
				
				conn = connection.Conn();
				String query = "Update category set cat_name = '"+Name+"'"+",cat_description='"+des+"'"+"where cat_id="+id;
				pstmt = conn.prepareStatement(query);
				 pstmt.executeUpdate();
				 JOptionPane.showMessageDialog(this, "Category information Updated!!!");
				 pstmt.close();
				 conn.close();
				 categoryList();
			}
			catch(Exception e1) {
				e1.printStackTrace();
			}
		}
	}
	
}
