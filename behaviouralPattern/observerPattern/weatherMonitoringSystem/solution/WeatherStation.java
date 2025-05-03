package behaviouralPattern.observerPattern.weatherMonitoringSystem.solution;

import java.util.ArrayList;
import java.util.List;

interface WeatherData {
    void addObserver(DisplayObserver displayObserver);

    void removeObserver(DisplayObserver displayObserver);

    void notifyAllObservers();

    void setData(int temp, int humidity, String location);

    int getTemperature();

    int getHumidity();

    String getLocation();
}

class WeatherDataImpl implements WeatherData {
    private int temp;
    private int humidity;
    private String location;
    private final List<DisplayObserver> observers;

    WeatherDataImpl() {
        observers = new ArrayList<>();
    }

    public void addObserver(DisplayObserver displayObserver) {
        observers.add(displayObserver);
    }

    public void removeObserver(DisplayObserver displayObserver) {
        observers.remove(displayObserver);
    }

    public void notifyAllObservers() {
        for (DisplayObserver observer : observers) {
            observer.update(this);
        }
    }

    public void setData(int temp, int humidity, String location) {
        this.temp = temp;
        this.humidity = humidity;
        this.location = location;
        notifyAllObservers();
    }

    public int getTemperature() {
        return temp;
    }

    public int getHumidity() {
        return humidity;
    }

    public String getLocation() {
        return location;
    }
}

interface DisplayObserver {
    void update(WeatherData weatherData);
}

class MobileDisplay implements DisplayObserver {
    public void update(WeatherData weatherData) {
        System.out.println("Mobile Display -> Temp: " + weatherData.getTemperature() +
                ", Humidity: " + weatherData.getHumidity() +
                ", Location: " + weatherData.getLocation());
    }
}

class DesktopDisplay implements DisplayObserver {
    public void update(WeatherData weatherData) {
        System.out.println("Desktop Display -> Temp: " + weatherData.getTemperature() +
                ", Humidity: " + weatherData.getHumidity() +
                ", Location: " + weatherData.getLocation());
    }
}

public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherDataImpl();

        DisplayObserver mobileDisplay = new MobileDisplay();
        DisplayObserver desktopDisplay1 = new DesktopDisplay();
        DisplayObserver desktopDisplay2 = new DesktopDisplay();

        weatherData.addObserver(mobileDisplay);
        weatherData.addObserver(desktopDisplay1);
        weatherData.setData(12, 23, "Delhi");

        System.out.println();

        weatherData.addObserver(desktopDisplay2);
        weatherData.setData(30, 40, "Mumbai");
    }
}
