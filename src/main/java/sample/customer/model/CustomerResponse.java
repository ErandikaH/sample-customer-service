package sample.customer.model;


public class CustomerResponse {
  private Long customerId;

  public CustomerResponse() {
  }

  public CustomerResponse(Long customerId) {
    this.customerId = customerId;
  }

  public Long getCustomerId() {
    return customerId;
  }

  public void setCustomerId(Long customerId) {
    this.customerId = customerId;
  }
}
