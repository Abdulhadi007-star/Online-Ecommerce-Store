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

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;


import javax.swing.JButton;

import java.awt.event.ActionListener;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;

import org.bson.Document;





public class manage_Products extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JFormattedTextField prodid;
	private JFormattedTextField quantity;
	private JFormattedTextField name;
	private JFormattedTextField price;
	private JFormattedTextField category;
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

		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(this);
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAdd.setBounds(69, 312, 131, 44);
		contentPane.add(btnAdd);

		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(this);
		btnEdit.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEdit.setBounds(293, 312, 131, 44);
		contentPane.add(btnEdit);

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(this);
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDelete.setBounds(530, 312, 131, 44);
		contentPane.add(btnDelete);
		
		category = new JFormattedTextField();
	    category.setBounds(136, 221, 174, 27);
		contentPane.add(category);
	}
	
	public void actionPerformed(ActionEvent e) {
		String k = e.getActionCommand();
		if(k.equals("Add")) {
			String ID = prodid.getText();
			
			String Name = name.getText();
			
			String Quantity = quantity.getText();
			
			String Price = price.getText();
			
			String Category = category.getText();
			
			try {
				
				Logger mongoLogger = Logger.getLogger( "org.mongodb.driver" );
				  mongoLogger.setLevel(Level.SEVERE);
				MongoClient mongoClient = new MongoClient("localhost",27017);
				  DB db = mongoClient.getDB("Ecommerce");
				  DBCollection mycollection = db.getCollection("product");
				  BasicDBObject document = new BasicDBObject();
				  document.append("PROD_ID", ID);
				  document.append("PROD_NAME", Name);
				  document.append("QUANTITY", Quantity);
				  document.append("PROD_PRICE", Price);
				  document.append("CATEGORY_CAT_NAME", Category);
				  
				  mycollection.insert(document);
				  JOptionPane.showMessageDialog(this, "Product Addded Successfully!!!");
	}
			catch(Exception e1){ 
				   System.out.println(e1);
				  } 
}
		/*else if(k.equals("Edit")) {
			String ID = prodid.getText();
			
			String Name = name.getText();
			
			String Quantity = quantity.getText();
			
			String Price = price.getText();
			
			String Category = category.getText();
			try {
				
				Logger mongoLogger = Logger.getLogger( "org.mongodb.driver" );
				  mongoLogger.setLevel(Level.SEVERE);
				MongoClient mongoClient = new MongoClient("localhost",27017);
				  DB db = mongoClient.getDB("Ecommerce");
				  DBCollection coll = db.getCollection("product");
				  coll.update(newBasicDBObject("admin_ID",ID), newBasicDBObject("$push",newBasicDBObject("PROD_NAME",Name)));
		}
			catch(Exception e1){ 
				   System.out.println(e1);
				  }
	} 
		else {
			String ID = prodid.getText();
			try {
				
				Logger mongoLogger = Logger.getLogger( "org.mongodb.driver" );
				  mongoLogger.setLevel(Level.SEVERE);
				MongoClient mongoClient = new MongoClient("localhost",27017);
				  DB db = mongoClient.getDB("Ecommerce");
		}
} */
}
}

