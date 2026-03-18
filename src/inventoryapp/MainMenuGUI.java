package inventoryapp;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class MainMenuGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenuGUI frame = new MainMenuGUI();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainMenuGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAddProduct = new JButton("Add Products");
		btnAddProduct.setBounds(140, 58, 140, 23);
		btnAddProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddProductGUI addScreen = new AddProductGUI();
				addScreen.setVisible(true);
				MainMenuGUI.this.dispose();
			}
		});
		contentPane.add(btnAddProduct);
		
		JButton btnViewProduct = new JButton("View Products");
		btnViewProduct.setBounds(140, 92, 140, 23);
		
		btnViewProduct.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {

		        ViewProductsGUI viewScreen = new ViewProductsGUI();
		        viewScreen.setVisible(true);
		        MainMenuGUI.this.dispose();

		    }
		});
		contentPane.add(btnViewProduct);
		
		JButton btnRemoveProduct = new JButton("Remove Products");
		btnRemoveProduct.setBounds(140, 126, 140, 23);
		btnRemoveProduct.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {

		        RemoveProductGUI removeScreen = new RemoveProductGUI();
		        removeScreen.setVisible(true);
		        MainMenuGUI.this.dispose();

		    }
		});
		contentPane.add(btnRemoveProduct);
	}
}