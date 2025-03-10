
package acme.features.weather;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.json.JSONException;
import org.json.JSONObject;

public class WeatherService {

	private static final String	API_KEY		= "d2b13b6b918528e3027a1d04917cb8b7";
	private static final String	BASE_URL	= "https://api.openweathermap.org/data/2.5/weather";


	public static JSONObject getWeather(final double lat, final double lon) throws JSONException {
		if (WeatherService.API_KEY == null || WeatherService.API_KEY.isEmpty())
			throw new IllegalStateException("API key is missing. Set OPENWEATHER_API_KEY environment variable.");

		String url = String.format("%s?lat=%.4f&lon=%.4f&appid=%s&units=metric", WeatherService.BASE_URL, lat, lon, WeatherService.API_KEY);

		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();

		try {
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
			if (response.statusCode() == 200)
				return new JSONObject(response.body());
			else
				throw new RuntimeException("Error en API: " + response.statusCode() + " - " + response.body());
		} catch (IOException | InterruptedException e) {
			throw new RuntimeException("Error al obtener datos meteorológicos", e);
		}
	}

	public static void main(final String[] args) throws JSONException {
		double lat = 37.3886;
		double lon = -5.9823;

		JSONObject weatherData = WeatherService.getWeather(lat, lon);
		if (weatherData != null) {
			System.out.println("Clima en Sevilla:");

			JSONObject mainData = weatherData.getJSONObject("main");
			System.out.println("Temperatura actual: " + mainData.getDouble("temp") + "°C");
			System.out.println("Humedad: " + mainData.getInt("humidity") + "%");

			String description = weatherData.getJSONArray("weather").getJSONObject(0).getString("description");
			System.out.println("Descripción: " + description);
		}
	}
}
