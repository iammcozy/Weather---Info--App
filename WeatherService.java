import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class WeatherService {

    private static final String API_KEY = "YOUR_API_KEY_HERE";

    public WeatherData getCurrentWeather(String city, String unit) throws Exception {

        String units = unit.equals("Celsius") ? "metric" : "imperial";
        String urlString = "https://api.openweathermap.org/data/2.5/weather?q="
                + city + "&units=" + units + "&appid=" + API_KEY;

        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(conn.getInputStream()));

        StringBuilder json = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            json.append(line);
        }

        JSONObject obj = new JSONObject(json.toString());

        double temp = obj.getJSONObject("main").getDouble("temp");
        int humidity = obj.getJSONObject("main").getInt("humidity");
        double wind = obj.getJSONObject("wind").getDouble("speed");
        String condition = obj.getJSONArray("weather")
                .getJSONObject(0).getString("description");

        return new WeatherData(city, temp, humidity, wind, condition, unit);
    }
}