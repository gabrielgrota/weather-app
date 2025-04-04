import tkinter as tk

from Tools.scripts.fixdiv import report

window = tk.Tk()
window.title("WeatherApp")
window.iconphoto(False, tk.PhotoImage(file='C:\\Users\Gabriel\Desktop\weather-app-tkinter\icon.png'))
window.geometry("500x300")

print("running...")

def click():
    label2.config(text="Button is clicked")
    print("button clicked")

placeholder_entry1 = "type a city"

label1 = tk.Label(window, text="Hello, Tkinter!")
button = tk.Button(window, text="This is a button", command=click)
label2 = tk.Label(window, text="Waiting the click...")
label3 = tk.Label(window, text=placeholder_entry1)
entry1 = tk.Entry(window, textvariable=placeholder_entry1)

# precisa fazer uma função para submit e get, para pegar os dados do entry
# https://www.geeksforgeeks.org/python-tkinter-entry-widget/

label1.pack(pady=10)
button.pack(pady=10)
label2.pack(pady=10)
label3.pack(pady=10)
entry1.pack(pady=10)
window.mainloop()


# weather api

import requests

api_key="54e20fe35cf1f5ba66daadf0fb547a77"
typed_city = input("type a city: ")

url = "https://api.openweathermap.org/data/2.5/weather?q=" + typed_city + "&appid=" + api_key + "&units=metric&lang=pt_br"
print(url)

response = requests.get(url)
print(response.status_code)
print(response.json())

weather_data = response.json()

def show_weather_data():
    city = weather_data['name']
    country = weather_data['sys']['country']

    label_city.config(text=f"{city}, {country}", font=("Arial", 20, "bold"), fg="blue")

root = tk.Tk()
root.title("Weather now")
root.geometry("400x300")

label_city = tk.Label(root, bg="#e0f7fa")
label_city.pack(pady=10)

# botão para atualizar e exibir dados
button2 = tk.Button(root, text="search weather", command=show_weather_data())
button2.pack(pady=20)

root.mainloop()