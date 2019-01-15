package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Clients {
	private String name;
	private String email;
	private Date birthDate;

	private List<Order> requests = new ArrayList<>();
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	public Order getReqauest(String search) {
		Integer enumSearch=requests.indexOf(search);
		
		return requests.get(enumSearch);
	}
	
	public void setRequests(Order order) {
		requests.add(order);
	}
	
}
