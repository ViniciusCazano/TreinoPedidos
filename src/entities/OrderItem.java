package entities;

public class OrderItem {
	private Integer quantity;
	private Double price;
	
	private Product prod = new Product();
	
	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Product getProd() {
		return prod;
	}

	public Double subTotal() {
		return quantity*price;
	}
}
