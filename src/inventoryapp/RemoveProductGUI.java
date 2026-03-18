package inventoryapp;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class RemoveProductGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private ProductDAO productDAO = new ProductDAO();
	private JTable tableProducts;

	
	//Launches application
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RemoveProductGUI frame = new RemoveProductGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	// Loads PostgreSQL data into JTable
	private void loadProducts() {

		DefaultTableModel model = new DefaultTableModel(
			new String[]{"ID", "Name", "Price", "Quantity"}, 0) {

			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		try {

			ResultSet rs = productDAO.getProducts();

			while (rs.next()) {
				model.addRow(new Object[]{
					rs.getString("id"),
					rs.getString("name"),
					rs.getDouble("price"),
					rs.getInt("quantity")
				});
			}

			tableProducts.setModel(model);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//Creates the frame
	
	public RemoveProductGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Product ID: ");
		lblNewLabel.setBounds(10, 171, 69, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(81, 168, 130, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Remove");
		btnNewButton.setBounds(221, 167, 95, 23);
		btnNewButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {

		        try {

		            String id = textField.getText().trim();

		            boolean removed = productDAO.removeProduct(id);

		            if (removed) {
		                JOptionPane.showMessageDialog(null, "Product removed successfully.");
		            } else {
		                JOptionPane.showMessageDialog(null, "Product ID not found.");
		            }

		        } catch (Exception ex) {
		            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
		        }

		    }
		});
		
		
		
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setBounds(10, 227, 89, 23);
		
		btnNewButton_1.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	
		        MainMenuGUI menu = new MainMenuGUI();
		        menu.setVisible(true);
		        menu.setLocationRelativeTo(null);
		        dispose();

		    }
		});
		contentPane.add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 414, 144);
		contentPane.add(scrollPane);
		tableProducts = new JTable();
		scrollPane.setViewportView(tableProducts);
		loadProducts();
		
	}
}
