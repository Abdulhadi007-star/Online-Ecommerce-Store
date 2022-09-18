import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
import java.awt.event.ActionEvent;

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
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\imtah\\Downloads\\AppIcons\\android\\mipmap-hdpi\\ic_launcher.png"));
		lblNewLabel.setBounds(185, -9, 215, 155);
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

	@Override
	public void actionPerformed(ActionEvent e) {
		String k = e.getActionCommand();
		if(k.equals("Login")) {
			Email = email.getText();
			String Password = password.getText();
			if(role.getSelectedItem().toString().equals("Admin")) {
				
		 Connection conn = null;
		 PreparedStatement pstmt = null;
		
		try {
			 conn = connection.Conn();
			 String query = "Select Email,Password from admin where email = ? and password = ?";
			 pstmt = conn.prepareStatement(query);
			 pstmt.setString(1, Email);
			 pstmt.setString(2, Password);
			 ResultSet rs = pstmt.executeQuery();
			 if(rs.next()) {
				 Email = rs.getString("Email");
				 String password = rs.getString("Password");
				 JOptionPane.showMessageDialog(this, "Login Successful!!!");
				 dispose();
			 manage_Products mp = new manage_Products();
			 mp.setVisible(true);
			 
		}
			 else {
				 JOptionPane.showMessageDialog(this, "Invalid Email and Password");
			 }
		}
			 catch(Exception e1) {
					e1.printStackTrace();
				}
		}
			else {
				Connection conn = null;
				 PreparedStatement pstmt = null;
				try {
					 conn = connection.Conn();
					 String query = "Select Email,Password from customer where email = ? and password = ?";
					 pstmt = conn.prepareStatement(query);
					 pstmt.setString(1, Email);
					 pstmt.setString(2, Password);
					 ResultSet rs = pstmt.executeQuery();
					 if(rs.next()) {
						 Email = rs.getString("Email");
						 setEmail(Email);
						 String password = rs.getString("Password");
						 
						 JOptionPane.showMessageDialog(this, "Login Successful!!!");
						 dispose();
					 view_Products mp = new view_Products();
					 mp.setVisible(true);
					 
					 
					 		 
				}
					 else {
						 JOptionPane.showMessageDialog(this, "Invalid Email and Password");
					 }
				}
					 catch(Exception e1) {
							e1.printStackTrace();
						}
			}

		}
	}
	public static void setEmail(String a) {
		Email = a;
	}
	public static String getEmail() {
	return Email;
	
	}
	
}
			

