package sample.customer.service;

import org.springframework.beans.factory.annotation.Autowired;

import io.eventuate.tram.events.publisher.DomainEventPublisher;
import io.eventuate.tram.events.publisher.ResultWithEvents;
import sample.customer.model.Customer;
import sample.customer.model.CustomerRepository;

public class CustomerService {

  @Autowired
  private CustomerRepository customerRepository;

  @Autowired
  private DomainEventPublisher domainEventPublisher;

  public Customer addCustomer(String name, String email, String country) {
    ResultWithEvents<Customer> customerWithAddEvents = Customer.add(name, email, country);
    Customer customer = customerRepository.save(customerWithAddEvents.result);
    domainEventPublisher.publish(Customer.class, customer.getId(), customerWithAddEvents.events);
    return customer;
  }
}
