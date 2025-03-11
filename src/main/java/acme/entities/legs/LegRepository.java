
package acme.entities.legs;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.client.repositories.AbstractRepository;

@Repository
public interface LegRepository extends AbstractRepository {

	@Query("select l from Leg l where l.flight.id = ?1 order by l.scheduledArrival")
	Leg getFirstLegByFlight(Integer flightId);

	@Query("select l from Leg l where l.flight.id = ?1 order by l.scheduledArrival desc")
	Leg getLastLegByFlight(Integer flightId);

	@Query("select count(l) from Leg l where l.flight.id = ?1")
	Integer getNumberLegsByFlight(Integer flightId);

	@Query("select l from Leg l where l.flight.id = ?1 order by l.scheduledArrival")
	List<Leg> getLegsByFlight(Integer flightId);

}
