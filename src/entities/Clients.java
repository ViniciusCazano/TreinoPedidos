package entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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

	public void setBirthDate(String birthDate) throws ParseException {
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
		Date date = sdf1.parse(birthDate);
		this.birthDate = date;
	}
	
	public Order getReqauest(String search) {
		int enumSearch=requests.indexOf(search);
		return requests.get(enumSearch);
	}
	
	public void addRequests(Order order) {
		requests.add(order);
	}

	@Override
	public String toString() {
		return "Clients [name=" + name + ", email=" + email + ", birthDate=" + birthDate + "]";
	}
	
}
