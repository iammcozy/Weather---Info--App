import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Weather Information App");
        frame.setSize(400, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField cityField = new JTextField();
        JComboBox<String> unitBox = new JComboBox<>(new String[]{"Celsius", "Fahrenheit"});
        JButton searchButton = new JButton("Get Weather");
        JTextArea outputArea = new JTextArea();
        outputArea.setEditable(false);

        HistoryManager historyManager = new HistoryManager();
        WeatherService weatherService = new WeatherService();

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String city = cityField.getText().trim();
                if (city.isEmpty()) {
                    outputArea.setText("Please enter a city name.");
                    return;
                }

                try {
                    WeatherData data = weatherService.getCurrentWeather(city, (String) unitBox.getSelectedItem());
                    outputArea.setText(data.toDisplayString());
                    historyManager.addEntry(city);
                } catch (Exception ex) {
                    outputArea.setText("Error fetching weather data.");
                }
            }
        });

        frame.setLayout(new GridLayout(5, 1));
        frame.add(cityField);
        frame.add(unitBox);
        frame.add(searchButton);
        frame.add(new JScrollPane(outputArea));

        frame.setVisible(true);
    }
}