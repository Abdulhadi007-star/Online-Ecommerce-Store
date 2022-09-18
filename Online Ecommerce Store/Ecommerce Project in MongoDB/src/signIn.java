import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFormattedTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import com.mongodb.client.MongoCursor;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.conversions.Bson;
import java.util.concurrent.TimeUnit;
import org.bson.Document;


public class signIn extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JFormattedTextField password;
	private JFormattedTextField email;
	private JComboBox role;
	private static String Email;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					signIn frame = new signIn();
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
	public signIn() {
		setTitle("Sign In");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 490);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel_1_2 = new JLabel("E-mail");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(49, 228, 69, 22);
		contentPane.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3_1_1 = new JLabel("Password");
		lblNewLabel_1_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_3_1_1.setBounds(49, 298, 79, 14);
		contentPane.add(lblNewLabel_1_3_1_1);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Abdulhadi\\Login-icon.png"));
		lblNewLabel.setBounds(158, 11, 148, 116);
		contentPane.add(lblNewLabel);

		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(this);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(174, 362, 102, 33);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel_2 = new JLabel("Already Registered? Sign In");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(148, 418, 186, 22);
		contentPane.add(lblNewLabel_2);

		role = new JComboBox();
		role.setFont(new Font("Tahoma", Font.BOLD, 12));
		role.setModel(new DefaultComboBoxModel(new String[] {"Admin", "Customer"}));
		role.setBounds(146, 157, 174, 27);
		contentPane.add(role);

		JLabel lblNewLabel_1_2_1 = new JLabel("Select User");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2_1.setBounds(49, 158, 79, 22);
		contentPane.add(lblNewLabel_1_2_1);

		email = new JFormattedTextField();
		email.setBounds(147, 228, 174, 27);
		contentPane.add(email);
		
		password = new JFormattedTextField();
		password.setBounds(146, 297, 174, 27);
		contentPane.add(password);
	}
	public void actionPerformed(ActionEvent e) {
		String k = e.getActionCommand();
		if(k.equals("Login")) {
			Email = email.getText();
			String Password = password.getText();
			
			try {
			Bson filter = and(eq("Email", Email), eq("password", Password));
			Bson project = eq("Email", 1L);

			MongoClient mongoClient = new MongoClient(
			    new MongoClientURI(
			        "mongodb://localhost:27017/?readPreference=primary&appname=MongoDB+Compass&ssl=false"
			    )
			);
			MongoDatabase database = mongoClient.getDatabase("Ecommerce");
			MongoCollection<Document> collection = database.getCollection("Admin");
			FindIterable<Document> result = collection.find(filter).projection(project);
			
			JOptionPane.showMessageDialog(this, "login Successful");
			
		}
			catch(Exception e1){ 
				   System.out.println(e1);
				  } 
	}
}
}