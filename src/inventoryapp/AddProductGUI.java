package inventoryapp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddProductGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtName;
	private JTextField txtPrice;
	private JTextField txtQuantity;
	private ProductDAO productDAO = new ProductDAO();

	
	//Launches the application
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddProductGUI frame = new AddProductGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//Creates the frame
	
	public AddProductGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		
		JPanel contentPane_3 = new JPanel();
		contentPane_3.setLayout(null);
		contentPane_3.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_3.setBounds(0, 0, 434, 261);
		contentPane.add(contentPane_3);
		
		JLabel lblNewLabel_5 = new JLabel("Product ID:");
		lblNewLabel_5.setBounds(10, 63, 75, 14);
		contentPane_3.add(lblNewLabel_5);
		
		JLabel lblNewLabel_1_2 = new JLabel("Name:");
		lblNewLabel_1_2.setBounds(10, 88, 63, 14);
		contentPane_3.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_2_2 = new JLabel("Price:");
		lblNewLabel_2_2.setBounds(10, 113, 63, 14);
		contentPane_3.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_3_2 = new JLabel("Quantity:");
		lblNewLabel_3_2.setBounds(10, 138, 63, 14);
		contentPane_3.add(lblNewLabel_3_2);
		
		txtId = new JTextField();
		txtId.setColumns(10);
		txtId.setBounds(94, 60, 132, 20);
		contentPane_3.add(txtId);
		
		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(94, 85, 132, 20);
		contentPane_3.add(txtName);
		
		txtPrice = new JTextField();
		txtPrice.setColumns(10);
		txtPrice.setBounds(94, 110, 132, 20);
		contentPane_3.add(txtPrice);
		
		txtQuantity = new JTextField();
		txtQuantity.setColumns(10);
		txtQuantity.setBounds(94, 138, 132, 20);
		contentPane_3.add(txtQuantity);
		
		JButton btnSaveProduct = new JButton("Save Product");

		btnSaveProduct.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {

		        try {

		            String id = txtId.getText();
		            String name = txtName.getText();
		            double price = Double.parseDouble(txtPrice.getText());
		            int quantity = Integer.parseInt(txtQuantity.getText());

		            Product product = new Product(id, name, price, quantity);
		            productDAO.addProduct(product);

		            JOptionPane.showMessageDialog(null, "Product added successfully.");

		            txtId.setText("");
		            txtName.setText("");
		            txtPrice.setText("");
		            txtQuantity.setText("");

		        } catch (Exception ex) {

		            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());

		        }

		    }
		});

		btnSaveProduct.setBounds(94, 163, 132, 23);
		contentPane_3.add(btnSaveProduct);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(10, 227, 97, 23);

		btnBack.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {

		        MainMenuGUI menu = new MainMenuGUI();
		        menu.setVisible(true);
		        menu.setLocationRelativeTo(null);
		        dispose();

		    }
		});

		contentPane_3.add(btnBack);

	}

}
