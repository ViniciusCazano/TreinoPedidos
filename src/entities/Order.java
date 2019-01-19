package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import enums.OrderStatus;

public class Order {
	private String id;
	private Date moment;
	private OrderStatus status;
	
	private List <OrderItem> orderProducts = new ArrayList<>();

	public Order() {
		setMoment();
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getMoment() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		return sdf.format(this.moment);
	}

	public void setMoment() {
		this.moment =new Date();
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = OrderStatus.valueOf(status);
	}

	public OrderItem getOrderProducts(String Search) {
		int aux = orderProducts.indexOf(Search);
		return orderProducts.get(aux);
	}

	public void addOrderProducts(OrderItem orderProducts) {
		this.orderProducts.add(orderProducts);
	}
	
	public String toString() {
		Double sum=0.0;
		StringBuilder sb = new StringBuilder();
		sb.append(getId()+"\n");
		sb.append(", Moment: "+getMoment()+"\n");
		sb.append(", Stats:"+getStatus()+"\n");
		for(OrderItem obj : orderProducts) {
			sb.append(obj.toString()+"\n");
			sum+=obj.subTotal();
		}
		sb.append("Total price: "+sum);
		return sb.toString();
	}
	
}
