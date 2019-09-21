package sample.customer.event;

public class CustomerAddEvent implements CustomerEvent {
	private String name;
	private String email;
	private String country;

	public CustomerAddEvent() {
	}

	public String getName() {
		return name;
	}

	public CustomerAddEvent(String name, String email, String country) {
		super();
		this.name = name;
		this.email = email;
		this.country = country;
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
