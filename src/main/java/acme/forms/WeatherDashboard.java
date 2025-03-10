
package acme.forms;

import java.util.List;

import acme.client.components.basis.AbstractForm;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WeatherDashboard extends AbstractForm {

	//API-> OPENWEATHER

	// Serialisation version --------------------------------------------------

	private static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	//la api almacena toda esta info -> ya veremos cuales son necesarios

	String						city;
	Double						currentTemperature;
	int							humidity;
	String						weatherDescription;
	Double						minTemperature;
	Double						maxTemperature;
	Double						pressure;
	Double						windSpeed;
	Double						windDegree;
	int							cloudiness;
	Double						rainVolume;
	Double						snowVolume;
	Long						sunrise;
	Long						sunset;
	int							weatherCode;

	//pronosticos de varios dias -> mi api -> pronóstico de 5 días con 3 horas de intervalo (con la version gratuita)

	List<Double>				forecastMinTemperatures;
	List<Double>				forecastMaxTemperatures;
	List<String>				forecastWeatherDescriptions;
	List<Integer>				forecastHumidity;
	List<Double>				forecastWindSpeed;
	List<Double>				forecastWindDegree;
	List<Double>				forecastRainVolume;
	List<Double>				forecastSnowVolume;
	List<String>				forecastDates;

	// Relationships ----------------------------------------------------------

	// Derived attributes -----------------------------------------------------

}
