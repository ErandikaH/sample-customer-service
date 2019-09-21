package sample.customer.model;

import static java.util.Collections.singletonList;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.eventuate.tram.events.publisher.ResultWithEvents;
import sample.customer.event.CustomerAddEvent;

@Entity
@Table(name = "Customer")
@Access(AccessType.FIELD)
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;
	private String country;

	public Customer() {
	}

	public Customer(String name, String email, String country) {
		super();
		this.name = name;
		this.email = email;
		this.country = country;
	}

	public static ResultWithEvents<Customer> add(String name, String email, String country) {
		Customer customer = new Customer(name, email, country);
		return new ResultWithEvents<>(customer,
				singletonList(new CustomerAddEvent(customer.getName(), customer.getEmail(), customer.getCountry())));
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getCountry() {
		return country;
	}
	
}
