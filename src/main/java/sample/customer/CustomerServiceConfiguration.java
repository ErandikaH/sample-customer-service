package sample.customer;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import io.eventuate.tram.events.publisher.TramEventsPublisherConfiguration;
import io.eventuate.tram.events.subscriber.TramEventSubscriberConfiguration;
import io.eventuate.tram.jdbckafka.TramJdbcKafkaConfiguration;
import sample.customer.service.CustomerService;

@Configuration
@Import({ TramJdbcKafkaConfiguration.class, TramEventsPublisherConfiguration.class,
		TramEventSubscriberConfiguration.class })
@EnableJpaRepositories
@EnableAutoConfiguration
public class CustomerServiceConfiguration {

	@Bean
	public CustomerService customerService() {
		return new CustomerService();
	}
}
