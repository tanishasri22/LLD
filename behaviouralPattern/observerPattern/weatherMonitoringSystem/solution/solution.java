package behaviouralPattern.observerPattern.weatherMonitoringSystem.solution;

import java.util.ArrayList;
import java.util.List;

// pull-based Observer Pattern.

interface WeatherSubject{
    void addObserver(DisplayObserver observer);
    void removeObserver(DisplayObserver observer);
    void notifyObservers();
}

class WeatherMonitoringSystem implements WeatherSubject{
    List<DisplayObserver> observerList = new ArrayList<>();
    private int temperature;
    private int humidity;

    public int getHumidity() {
        return humidity;
    }

    public int getTemperature() {
        return temperature;
    }

    public void addObserver(DisplayObserver observer){
        observerList.add(observer);
    }

    public void removeObserver(DisplayObserver observer){
                observerList.remove(observer);
    }

    public void setData(int humidity, int temperature){
        this.temperature = temperature;
        this.humidity = humidity;
        notifyObservers();
    }

    public void notifyObservers(){
        for(DisplayObserver observer : observerList){
            observer.update();
        }
    }
}

interface DisplayObserver {
    void update();
}

class IPhoneDisplay implements DisplayObserver {
    WeatherMonitoringSystem weatherMonitoringSystem;

    IPhoneDisplay(WeatherMonitoringSystem weatherSystem){
        this.weatherMonitoringSystem = weatherSystem;
    }

    public void update(){
     System.out.println("Updation on "+ this.getClass().getSimpleName() + " :\nHumidity:" + weatherMonitoringSystem.getHumidity() 
     + "\nTemperature: "+ weatherMonitoringSystem.getTemperature());   
    }
}

class AndroidDisplay implements DisplayObserver {
    WeatherMonitoringSystem weatherMonitoringSystem;

    AndroidDisplay(WeatherMonitoringSystem weatherSystem) {
        this.weatherMonitoringSystem = weatherSystem;
    }

    public void update() {
        System.out.println("Updation on " + this.getClass().getSimpleName() + " :\nHumidity:"
                + weatherMonitoringSystem.getHumidity()
                + "\nTemperature: " + weatherMonitoringSystem.getTemperature());
    }
}

public class solution {
    public static void main(String[] args) {
        WeatherMonitoringSystem weatherMonitoringSystem = new WeatherMonitoringSystem();

        DisplayObserver iphonDisplayObserver = new IPhoneDisplay(weatherMonitoringSystem);
        DisplayObserver anDisplayObserver = new AndroidDisplay(weatherMonitoringSystem);

        weatherMonitoringSystem.addObserver(anDisplayObserver);
        weatherMonitoringSystem.addObserver(iphonDisplayObserver);

        weatherMonitoringSystem.setData(60,56);
    }
}
