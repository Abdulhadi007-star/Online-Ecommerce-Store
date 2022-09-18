import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

public class manage_Supplier extends JFrame {

	private JPanel contentPane;
	private JTable table;

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
		lblNewLabel_1_2_1_1.setBounds(58, 153, 79, 22);
		contentPane.add(lblNewLabel_1_2_1_1);

		JLabel lblNewLabel_1_2_1_1_1 = new JLabel("Password");
		lblNewLabel_1_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2_1_1_1.setBounds(398, 87, 79, 22);
		contentPane.add(lblNewLabel_1_2_1_1_1);

		JLabel lblNewLabel_1_2_1_1_1_1 = new JLabel("Gender");
		lblNewLabel_1_2_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2_1_1_1_1.setBounds(398, 153, 79, 22);
		contentPane.add(lblNewLabel_1_2_1_1_1_1);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Male", "Female" }));
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 12));
		comboBox.setBounds(487, 152, 174, 27);
		contentPane.add(comboBox);

		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(136, 87, 174, 27);
		contentPane.add(formattedTextField);

		JFormattedTextField formattedTextField_1 = new JFormattedTextField();
		formattedTextField_1.setBounds(136, 153, 174, 27);
		contentPane.add(formattedTextField_1);

		JFormattedTextField formattedTextField_1_1 = new JFormattedTextField();
		formattedTextField_1_1.setBounds(487, 87, 174, 27);
		contentPane.add(formattedTextField_1_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(58, 344, 604, 95);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setRowHeight(25);
		table.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null }, { null, null, null, null }, { null, null, null, null },
						{ null, null, null, null }, { null, null, null, null }, },
				new String[] { "supplierID", "Name", "Password", "Gender" }));

		JButton btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAdd.setBounds(74, 235, 102, 33);
		contentPane.add(btnAdd);

		JButton btnEdit = new JButton("Edit");
		btnEdit.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEdit.setBounds(238, 235, 102, 33);
		contentPane.add(btnEdit);

		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDelete.setBounds(419, 235, 102, 33);
		contentPane.add(btnDelete);

		JButton btnClear = new JButton("Clear");
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnClear.setBounds(582, 235, 102, 33);
		contentPane.add(btnClear);

		JLabel lblProductsList = new JLabel("Suppliers List");
		lblProductsList.setForeground(Color.BLACK);
		lblProductsList.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblProductsList.setBounds(289, 295, 188, 22);
		contentPane.add(lblProductsList);
	}
}
