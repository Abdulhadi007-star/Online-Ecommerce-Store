import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.bson.Document;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.mongodb.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.TextField;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import java.awt.event.ActionListener;

import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;


public class admin_SignUp extends JFrame implements ActionListener{

	private JPanel contentPane;
	private TextField ID;
	private TextField firstName;
	private TextField lastName;
	private TextField Email;
	private TextField contactNo;
	private TextField address;
	private TextField password;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					admin_SignUp frame = new admin_SignUp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	

		
	
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public admin_SignUp() {
		setTitle("Sign Up");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 435, 602);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("First Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(51, 162, 79, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel = new JLabel("Admin Sign up");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(120, 28, 246, 31);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1_1 = new JLabel("Last Name");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(51, 218, 79, 14);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("E-mail");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(51, 272, 69, 22);
		contentPane.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("Contact No");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_3.setBounds(51, 332, 79, 14);
		contentPane.add(lblNewLabel_1_3);

		JLabel lblNewLabel_1_3_1 = new JLabel("Address");
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_3_1.setBounds(51, 387, 79, 14);
		contentPane.add(lblNewLabel_1_3_1);

		JButton btnNewButton = new JButton("Sign Up");
		btnNewButton.addActionListener(this);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(182, 492, 119, 31);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel_2 = new JLabel("Already Registered? Sign In");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(163, 534, 174, 22);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_1_3_1_1 = new JLabel("Password");
		lblNewLabel_1_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_3_1_1.setBounds(51, 443, 79, 14);
		contentPane.add(lblNewLabel_1_3_1_1);

		firstName = new TextField();
		firstName.setBounds(163, 158, 174, 27);
		contentPane.add(firstName);

		lastName = new TextField();
		lastName.setBounds(163, 214, 174, 27);
		contentPane.add(lastName);

		Email = new TextField();
		Email.setBounds(163, 272, 174, 27);
		contentPane.add(Email);

		contactNo = new TextField();
		contactNo.setBounds(163, 328, 174, 27);
		contentPane.add(contactNo);

		address = new TextField();
		address.setBounds(163, 383, 174, 27);
		contentPane.add(address);

		password = new TextField();
		password.setBounds(163, 439, 174, 27);
		contentPane.add(password);
		
		JLabel lblNewLabel_1_4 = new JLabel("ID");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_4.setBounds(51, 106, 79, 14);
		contentPane.add(lblNewLabel_1_4);
	
		
		ID = new TextField();
		ID.setBounds(163, 102, 174, 27);
		contentPane.add(ID);
	}
	public void actionPerformed(ActionEvent e) {
		String k = e.getActionCommand();
		if(k.equals("Sign Up")) {
			String id = ID.getText();
			String FirstName = firstName.getText();
			
			String LastName = lastName.getText();
			
			String email = Email.getText();
			
			String ContactNo = contactNo.getText();
			
			String Address = address.getText();
			
			String Password = password.getText();
			int pass = Integer.parseInt(Password);
			
			
			try {
				
				Logger mongoLogger = Logger.getLogger( "org.mongodb.driver" );
				  mongoLogger.setLevel(Level.SEVERE);
				MongoClient mongoClient = new MongoClient("localhost",27017);
				  DB db = mongoClient.getDB("Ecommerce");
				  DBCollection mycollection = db.getCollection("Admin");
				  BasicDBObject document = new BasicDBObject();
				  document.append("admin_ID", id);
				  document.append("admin_firstName", FirstName);
				  document.append("admin_lastName", LastName);
				  document.append("Email", email);
				  document.append("contact", ContactNo);
				  document.append("address", Address);
				  document.append("password", pass);
				  mycollection.insert(document);
				  JOptionPane.showMessageDialog(this, "Document Inserted Successfully");
				
			}
			catch(Exception e1){ 
				   System.out.println(e1);
				  } 
			
		}
	}
}