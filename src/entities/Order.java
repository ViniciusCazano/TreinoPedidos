package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import enums.OrderStatus;

public class Order {
	private Date moment;
	private OrderStatus status;
	
	private List <OrderItem> orderProducts = new ArrayList<>();
}
