package entities;

public class OrderItem {
	private String id;
	private Integer quantity;
	private Double price;
	
	private Product prod = new Product();
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
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

	public void setProd(Product prod) {
		this.prod=prod;
	}

	public Double subTotal() {
		return quantity*price;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("("+this.getId()+"), ");
		sb.append(prod.getName()+", ");
		sb.append(prod.getPrice()+", ");
		sb.append("Quantity: "+getQuantity());
		sb.append(", Subtotal:"+subTotal());
		return sb.toString();
	}
}
