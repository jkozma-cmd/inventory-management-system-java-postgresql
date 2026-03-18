package inventoryapp;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		// Initialize scanner and variables
				Scanner scnr = new Scanner(System.in);
				int choice = 0;
				ProductDAO productDAO = new ProductDAO();
				
				// Calls method to print the menu for user display and input
				printMenu();
				while(!scnr.hasNextInt()) {
					System.out.println("Please enter a number 1-4: ");
					scnr.next();
				}
				choice = scnr.nextInt();
				scnr.nextLine();
				
				// Implemented a while loop and switch structure in order to check correct user input for response
				while (choice != 4) {
					switch (choice) {
					case 1:
			
						System.out.print("Enter the product ID: ");
						String id = scnr.nextLine();
						
						System.out.print("Enter the product name: ");
						String name = scnr.nextLine();
						
						System.out.print("Enter the product price: ");
						double price = scnr.nextDouble();
						scnr.nextLine();
						// Creates a new product and stores it within the inventory ArrayList
						System.out.print("Enter the product quantity: ");
						int quantity = scnr.nextInt();
						scnr.nextLine();
						Product p = new Product(id, name, price, quantity);
						productDAO.addProduct(p);
						
						System.out.println("\nYour entries have been recorded, please press enter to return to the menu.");
						scnr.nextLine();
						break;
					case 2:
						// Implemented product removal from ArrayList inventory based on user input ID
						// If no ID is found then the user will receive a display message saying that there was no product with the entered ID found
						System.out.print("Enter the product ID to remove: ");
						String removeId = scnr.nextLine();
						
						productDAO.removeProduct(removeId);
						System.out.println("Press Enter to return to the menu.");
						scnr.nextLine();
						
						break;	
					case 3:
						// Determines if the inventory ArrayList is empty, if so then it displays a prompt to the user.
						// If inventory is not empty, it then displays the products in the inventory to the user. 
						productDAO.getProducts();
						System.out.println("\nOnce you are done viewing, please press enter to return to the menu.");
						break;
					default:
						System.out.println("Please enter a valid option");
					
						
					}
					
					// Calls the print menu method again 
					printMenu();
					while(!scnr.hasNextInt()) {
						System.out.println("Please enter a number 1-4: ");
						scnr.next();
					}
					choice = scnr.nextInt();
					scnr.nextLine();
				}
				// Once the user exits the program, there will be a goodbye message and the 
				// scanner will be closed to prevent resource leaks
				System.out.println("Thank you for using Inventory Manager!");
				scnr.close();
			}
			
			// Print menu method is created for user display
			public static void printMenu() {
				// Header
				System.out.println("\n------ Inventory Manager ------\n");
				
				// Menu text options for user
				System.out.println("Please select one of the following:\n"
						+ "1) Add Product\n"
						+ "2) Remove product\n"
						+ "3) View products\n"
						+ "4) Exit manager\n");
				
			}
		
		
		
	}


