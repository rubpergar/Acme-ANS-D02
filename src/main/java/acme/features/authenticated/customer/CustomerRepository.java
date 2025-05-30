
package acme.features.authenticated.customer;

import java.util.List;

import org.springframework.stereotype.Repository;

import acme.client.repositories.AbstractRepository;
import acme.realms.Customer;

@Repository
public interface CustomerRepository extends AbstractRepository {

	Customer findByIdentifier(String identifier);

	List<Customer> findManyCustomersByIdentifier(String identifier);
}
