package inventoryapp;

public class Product {
	// Instance variables declared
	private String id ="";
	private String name = "";
	private double price = 0.0;
	private int quantity = 0;
	
	// Constructor
	public Product (String id,String name, double price,int quantity){
		
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		
	}
	
	// getters
	public String getId(){
		
		return id;
	}
	
	public String getName(){
		
		return name;
	}

	public double getPrice(){
	
		return price;
	}
	
	public int getQuantity(){
		
		return quantity;
	}
	
}