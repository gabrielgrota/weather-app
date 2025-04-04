const apiKey = '54e20fe35cf1f5ba66daadf0fb547a77';

async function searchWeather() {
    const city = document.getElementById("city").value;
    const result = document.getElementById("result");

    result.textContent = `Searching weather for ${city}...`;

    try {

        const response = await fetch(`https://api.openweathermap.org/data/2.5/weather?q=${city}&appid=${apiKey}&units=metric`);
        const data = await response.json();

        if (response.ok) {
            result.textContent = `Weather in ${data.name}: ${data.main.temp}°C, Humidity: ${data.main.humidity}%, ${data.weather[0].description}, Wind: ${data.wind.speed} m/s`;
        } else {
            result.textContent = `Erro na resposta: ${data.message}`;
        }

    } catch (error) {
        result.textContent = "Erro ao buscar URL.";
    }
}