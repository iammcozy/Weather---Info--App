public class WeatherData {

    private String city;
    private double temperature;
    private int humidity;
    private double windSpeed;
    private String condition;
    private String unit;

    public WeatherData(String city, double temperature, int humidity,
                       double windSpeed, String condition, String unit) {
        this.city = city;
        this.temperature = temperature;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
        this.condition = condition;
        this.unit = unit;
    }

    public String toDisplayString() {
        return "City: " + city +
                "\nTemperature: " + temperature +
                (unit.equals("Celsius") ? " °C" : " °F") +
                "\nHumidity: " + humidity + "%" +
                "\nWind Speed: " + windSpeed +
                "\nCondition: " + condition;
    }
}