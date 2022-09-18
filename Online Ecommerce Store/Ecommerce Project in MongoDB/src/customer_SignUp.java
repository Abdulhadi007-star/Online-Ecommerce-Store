import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;

public class customer_SignUp extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JFormattedTextField customer_id;
	private JFormattedTextField name;
	private JFormattedTextField contact;
	private JFormattedTextField email;
	private JFormattedTextField password;
	private JFormattedTextField address;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					customer_SignUp frame = new customer_SignUp();
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
	public customer_SignUp() {
		setTitle("Sign Up");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 435, 602);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(30, 162, 79, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel = new JLabel("Customer Sign up");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(126, 109, 246, 31);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1_1 = new JLabel("Customer Name");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(30, 218, 112, 14);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("E-mail");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(30, 328, 69, 22);
		contentPane.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("Contact No");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_3.setBounds(30, 276, 79, 14);
		contentPane.add(lblNewLabel_1_3);

		JLabel lblNewLabel_1_3_1 = new JLabel("Address");
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_3_1.setBounds(30, 443, 79, 14);
		contentPane.add(lblNewLabel_1_3_1);

		JButton btnNewButton = new JButton("Sign Up");
		btnNewButton.addActionListener(this);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(182, 492, 119, 31);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel_2 = new JLabel("Already Registered? Sign In");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(152, 534, 174, 22);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_1_3_1_1 = new JLabel("Password");
		lblNewLabel_1_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_3_1_1.setBounds(30, 387, 79, 14);
		contentPane.add(lblNewLabel_1_3_1_1);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Abdulhadi\\Login-Registration-icon.png"));

		lblNewLabel_3.setBounds(163, -30, 148, 173);
		contentPane.add(lblNewLabel_3);

		customer_id = new JFormattedTextField();
		customer_id.setBounds(163, 158, 174, 27);
		contentPane.add(customer_id);

		name = new JFormattedTextField();
		name.setBounds(163, 214, 174, 27);
		contentPane.add(name);

		contact = new JFormattedTextField();
		contact.setBounds(163, 272, 174, 27);
		contentPane.add(contact);

		email = new JFormattedTextField();
		email.setBounds(163, 328, 174, 27);
		contentPane.add(email);

		password = new JFormattedTextField();
		password.setBounds(163, 383, 174, 27);
		contentPane.add(password);

		address = new JFormattedTextField();
		address.setBounds(163, 439, 174, 27);
		contentPane.add(address);
	}
	public void actionPerformed(ActionEvent e) {
		String k = e.getActionCommand();
		if(k.equals("Sign Up")) {
			String id = customer_id.getText();
			
			String Name = name.getText();
			
			String Email = email.getText();
			
			String ContactNo = contact.getText();
			
			String Address = address.getText();
			
			String Password = password.getText();
			int pass = Integer.parseInt(Password);
			
			
			try {
				
				Logger mongoLogger = Logger.getLogger( "org.mongodb.driver" );
				  mongoLogger.setLevel(Level.SEVERE);
				MongoClient mongoClient = new MongoClient("localhost",27017);
				  DB db = mongoClient.getDB("Ecommerce");
				  DBCollection mycollection = db.getCollection("Customer");
				  BasicDBObject document = new BasicDBObject();
				  document.append("customer_ID", id);
				  document.append("customer_name", Name);
				  document.append("contact", ContactNo);
				  document.append("Email", Email);
				  document.append("password", pass);
				  document.append("address", Address);
				  
				  mycollection.insert(document);
				  JOptionPane.showMessageDialog(this, "Document Inserted Successfully");
				
			}
			catch(Exception e1){ 
				   System.out.println(e1);
				  } 
			
		}
	}
}