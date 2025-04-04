package weatherApp;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private TextField txtCity;
    @FXML
    private Label lblResult;

    public void searchWeather() {
        String city = txtCity.getText();
        if (city.isEmpty()) {
            lblResult.setText("Type a city.");
            return;
        }

        lblResult.setText("Searching weather for " + city + "...");

        // chamar a classe de requisição (executando em uma thread separada)
        new Thread(() -> {
            try {
                WeatherClass weather = WeatherService.getWeather(city);
                String weatherInfo = String.format("Weather in %s: %s, %.1f°C", weather.getName(), weather.getWeatherDescription(), weather.getTemp());

                javafx.application.Platform.runLater(() -> lblResult.setText(weatherInfo));
            } catch (Exception e) {
                javafx.application.Platform.runLater(() -> lblResult.setText("Error fetching weather data."));
            }
        }).start();
    }
}