package sample.customer.model;

public class CustomerRequest {
	private String name;
	private String email;
	private String country;

	public CustomerRequest() {
	}

	public CustomerRequest(String name, String email, String country) {
		super();
		this.name = name;
		this.email = email;
		this.country = country;
	}

	public String getEmail() {
		return email;
	}

	public String getCountry() {
		return country;
	}

	public String getName() {
		return name;
	}

}
