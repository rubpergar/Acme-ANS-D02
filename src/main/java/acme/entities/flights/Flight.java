
package acme.entities.flights;

import javax.persistence.Entity;

import acme.client.components.basis.AbstractEntity;
import acme.client.components.validation.Mandatory;
import acme.client.components.validation.Optional;
import acme.client.components.validation.ValidString;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Flight extends AbstractEntity {

	// Serialisation version --------------------------------------------------

	private static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	//a tag that highlights some feature of the flight such as "the fastest", "the cheapest" (up to 50 characters)
	@Mandatory
	@ValidString(max = 50)
	private String				tag;  //deberia tener formato de "The.."??

	//Con el formato
	/*
	 * @Mandatory
	 * 
	 * @ValidString(pattern = "^the\\s[a-zA-Z]+(\\s[a-zA-Z]+)*$", max = 50)
	 * private String tag;
	 */

	@Mandatory
	private boolean				indication;

	@Mandatory
	private double				cost;

	@Optional
	@ValidString(max = 255)
	private String				description;

	/*
	 * También almacena información que proviene de sus tramos, a saber: una salida programada y una llegada
	 * programada, que dependen del momento de salida programada del primer tramo y del momento de llegada
	 * programada del último tramo; las ciudades de origen y destino, que provienen de la ciudad de los
	 * aeropuertos a los que se refieren el primer y el último tramo, y, finalmente, el número de escalas.
	 */

	//Tienen que venir de la relacion con Leg?
	/*
	 * @Mandatory
	 * private LocalDateTime scheduledDeparture;
	 * 
	 * @Mandatory
	 * private LocalDateTime scheduledArrival;
	 */

	//Tienen que venir de uan relacion de Leg que a su vez tiene una relacion con Airport?
	/*
	 * @Mandatory
	 * 
	 * @ValidString(max = 50)
	 * private String originCity;
	 * 
	 * @Mandatory
	 * 
	 * @ValidString(max = 50)
	 * private String destinationCity;
	 */

	@Mandatory
	private int					numberOfLayovers;

	/*
	 * @Mandatory
	 * 
	 * @OneToMany(mappedBy = "flight")
	 * private List<Leg> legs;
	 */

}
