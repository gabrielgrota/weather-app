package weatherApp;

import java.util.List;

public class WeatherClass {
    private Main main;
    private List<Weather> weather;
    private String name;

    public double getTemp() {
        return main.getTemp();
    }

    public String getWeatherDescription() {
        return weather.get(0).getDescription();
    }

    public String getName() {
        return name;
    }

    class Main {
        private double temp;
        public double getTemp() {
            return temp;
        }
    }

    class Weather {
        private String description;
        public String getDescription() {
            return description;
        }
    }
}
