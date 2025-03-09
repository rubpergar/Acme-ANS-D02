
package acme.entities.flights;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.Valid;

import acme.client.components.basis.AbstractEntity;
import acme.client.components.datatypes.Money;
import acme.client.components.mappings.Automapped;
import acme.client.components.validation.Mandatory;
import acme.client.components.validation.Optional;
import acme.client.components.validation.ValidMoney;
import acme.client.components.validation.ValidString;
import acme.entities.airlineManagers.Manager;
import acme.entities.legs.Leg;
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
	@Automapped
	private String				tag;  //deberia tener formato de "The.."??

	//Con el formato
	/*
	 * @Mandatory
	 * 
	 * @ValidString(pattern = "^the\\s[a-zA-Z]+(\\s[a-zA-Z]+)*$", max = 50)
	 * private String tag;
	 */

	@Mandatory
	@Valid
	@Automapped
	private Boolean				indication;

	@Mandatory
	@ValidMoney
	@Automapped
	private Money				cost;

	@Optional
	@ValidString(max = 255)
	@Automapped
	private String				description;

	@Mandatory
	@Valid
	@ManyToOne(optional = false)
	private Manager		airlineManager;

	@Mandatory
	@Valid
	@OneToMany(mappedBy = "flight")
	private List<Leg>			legs;

	// Atributos derivados ---------------------------------


	@Transient
	public Date getScheduledDeparture() {
		if (this.legs == null || this.legs.isEmpty())
			return null;
		return this.legs.get(0).getScheduledDeparture(); // Primer leg
	}

	@Transient
	public Date getScheduledArrival() {
		if (this.legs == null || this.legs.isEmpty())
			return null;
		return this.legs.get(this.legs.size() - 1).getScheduledArrival(); // Último leg
	}

	@Transient
	public String getOriginCity() {
		if (this.legs == null || this.legs.isEmpty())
			return null;
		return this.legs.get(0).getDepartureAirport().getCity(); // Ciudad del aeropuerto de origen
	}

	@Transient
	public String getDestinationCity() {
		if (this.legs == null || this.legs.isEmpty())
			return null;
		return this.legs.get(this.legs.size() - 1).getArrivalAirport().getCity(); // Ciudad del aeropuerto de destino
	}

	@Transient
	public int getNumberOfLayovers() {
		if (this.legs == null || this.legs.isEmpty())
			return 0;
		return this.legs.size() - 1; // Número de legs menos uno
	}

	/*
	 * POR SI NO ACEPTA ONETOMANY -> derivadas en el servicio?
	 * También almacena información que proviene de sus tramos, a saber: una salida programada y una llegada
	 * programada, que dependen del momento de salida programada del primer tramo y del momento de llegada
	 * programada del último tramo; las ciudades de origen y destino, que provienen de la ciudad de los
	 * aeropuertos a los que se refieren el primer y el último tramo, y, finalmente, el número de escalas.
	 */

	/*
	 * @Mandatory
	 * 
	 * @ValidMoment
	 * 
	 * @Temporal(TemporalType.TIMESTAMP)
	 * private Date scheduledDeparture;
	 * 
	 * @Mandatory
	 * 
	 * @ValidMoment
	 * 
	 * @Temporal(TemporalType.TIMESTAMP)
	 * private Date scheduledArrival;
	 */

	//Tienen que venir de uan relacion de Leg que a su vez tiene una relacion con Airport
	/*
	 * @Mandatory
	 * 
	 * @ValidString(max = 50)
	 * 
	 * @Automapped
	 * private String originCity;
	 * 
	 * @Mandatory
	 * 
	 * @ValidString(max = 50)
	 * 
	 * @Automapped
	 * private String destinationCity;
	 */

	/*
	 * @Mandatory
	 * 
	 * @ValidNumber
	 * 
	 * @Automapped
	 * private Integer numberOfLayovers;
	 */
}
