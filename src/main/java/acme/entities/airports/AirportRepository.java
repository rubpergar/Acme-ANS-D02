
package acme.entities.airports;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.client.repositories.AbstractRepository;

@Repository
public interface AirportRepository extends AbstractRepository {

	@Query("SELECT a.code FROM Airport a")
	public List<String> airportCodesIATAs();

}
