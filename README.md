# Sample-Customer-Service
This application is implemented using Spring Boot, JPA and the Eventuate Tram framework.

# How it works with Eventuate Tram

When inserts the customer to the database, the flow publishes a domain event using Eventuate Tram. Eventuate tram inserts events into the MESSAGE table in `eventuate` database. Then tram cdc service tracks records in MESSAGE table using the MySQL binlog and publishes messages to Kafka topic.

#### Sample Customer Service
The Sample Customer Service implements a REST API for adding customers to the `customer` database. It publishes Customer domain events using Eventuate Tram.

#### Using the application
Once the application has started, you can use following curl to interact with the service.

$ curl -X POST "content-type: application/json" -d '{
 "name": "demo user",
 "email": "demo_user@gmail.com",
 "country": "SL"
}' http://localhost:8085/customer_service/add_customer

HTTP/1.1 200
Content-Type: application/json;charset=UTF-8
{
  "customerId": 1
}

