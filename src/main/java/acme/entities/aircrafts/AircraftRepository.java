
package acme.entities.aircrafts;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import acme.client.repositories.AbstractRepository;

public interface AircraftRepository extends AbstractRepository {

	@Query("select a from Aircraft a where a.registrationNumber = :registrationNumber")
	Aircraft findByRegistrationNumber(String registrationNumber);

	@Query("SELECT COUNT(a) > 0 FROM Aircraft a WHERE a.registrationNumber = :registrationNumber AND a.id <> :id")
	boolean existsByRegistrationNumberAndNotId(@Param("registrationNumber") String registrationNumber, @Param("id") Integer id);

}
