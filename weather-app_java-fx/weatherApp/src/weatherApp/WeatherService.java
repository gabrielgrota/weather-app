package weatherApp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import com.google.gson.Gson;

public class WeatherService {

    private static final String API_KEY = "54e20fe35cf1f5ba66daadf0fb547a77";

    public static WeatherClass getWeather(String city) throws Exception {
        String cityFormated = URLEncoder.encode(city, StandardCharsets.UTF_8.toString());
        String urlString = "https://api.openweathermap.org/data/2.5/weather?q=" + cityFormated + "&appid=" + API_KEY + "&units=metric&lang=pt_br";
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();
        if (responseCode == 200) {
            // ler a resposta
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            // converter JSON para objeto Java
            Gson gson = new Gson();
            return gson.fromJson(response.toString(), WeatherClass.class);

        } else {
            throw new Exception("Erro ao buscar clima! Código: " + responseCode);
        }
    }
}