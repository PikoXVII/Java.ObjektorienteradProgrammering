package Beverage;

public class Beverage {
	private String Name;
	private double Price;
	private int Stock;
	private int TimesSelected;

	public Beverage(String name, double price, int stock) {
		this.Name = name;
		this.Price = price;
		this.Stock = stock;
		this.TimesSelected = 0;
	}
	
	public void setName(String name) {
		this.Name = name;
	}
	public void setPrice(double price) {
		this.Price = price;
	}
	public void setStock(int stock) {
		this.Stock = stock;
	}
	public void setTimesSelected(int timeSelected) {
		this.TimesSelected = timeSelected;
	}

	public String getName() { 
		return Name;
	}
	public double getPrice() { 
		return Price; 
	}
	public int getStock() { 
		return Stock; 
	}
	public int getTimesSelected() { 
		return TimesSelected; 
	}
	
	public boolean decreaseStock() {
		if (Stock > 0) {
			Stock--;
			TimesSelected++;
			return true;
		}
		return false;
	}
}