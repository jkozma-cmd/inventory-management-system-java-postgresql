package inventoryapp;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;

public class ViewProductsGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tableProducts;
	private ProductDAO productDAO = new ProductDAO();

	
	//Launches the application
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewProductsGUI frame = new ViewProductsGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	// Loads products from PostgreSQL into JTable
	
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

	
	//Create the frame
	
	public ViewProductsGUI() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 350);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// ScrollPane for table
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 564, 200);
		contentPane.add(scrollPane);

		// Table
		tableProducts = new JTable();
		scrollPane.setViewportView(tableProducts);

		// Refresh button
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.setBounds(240, 222, 100, 25);
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadProducts();
			}
		});
		contentPane.add(btnRefresh);

		// Back button
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(240, 255, 100, 25);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				MainMenuGUI menu = new MainMenuGUI();
				menu.setLocationRelativeTo(null);
				menu.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnBack);

		// Load products automatically when screen opens
		loadProducts();
	}
}