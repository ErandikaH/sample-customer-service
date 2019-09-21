package sample.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import sample.customer.model.Customer;
import sample.customer.model.CustomerRequest;
import sample.customer.model.CustomerResponse;
import sample.customer.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@Autowired
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}

	@RequestMapping(value = "/customer_service/add_customer", method = RequestMethod.POST)
	public CustomerResponse createCustomer(@RequestBody CustomerRequest createCustomerRequest) {
		Customer customer = customerService.addCustomer(createCustomerRequest.getName(),
				createCustomerRequest.getEmail(), createCustomerRequest.getCountry());
		return new CustomerResponse(customer.getId());
	}
}
