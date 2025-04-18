package structuralPattern.facadePattern.basicFacadeImplementation.solution;

class Amplifier {
    private int volume;

    void amplify() {
        System.out.println("Amplifying the music");
    }
}

class DVDPlayer {
    boolean turnOn() {
        System.out.println("Switching on DVD player");
        return true;
    }

    boolean turnOff() {
        System.out.println("Switching off DVD player");
        return true;
    }
}

class Projector {
    boolean turnOn() {
        System.out.println("Switching on projector");
        return true;
    }

    boolean turnOff() {
        System.out.println("Switching off projector");
        return true;
    }
}

class Lights {
    boolean turnOn() {
        System.out.println("Switching on lights");
        return true;
    }

    boolean turnOff() {
        System.out.println("Switching off lights");
        return true;
    }
}

class HomeTheaterFacade {
    private final Amplifier amplifier;
    private final DVDPlayer dvdPlayer;
    private final Projector projector;
    private final Lights lights;

    public HomeTheaterFacade() {
        this.amplifier = new Amplifier();
        this.dvdPlayer = new DVDPlayer();
        this.projector = new Projector();
        this.lights = new Lights();
    }

    public void watchMovie(String movie) {
        System.out.println("Getting ready to watch: " + movie);
        dvdPlayer.turnOn();
        amplifier.amplify();
        projector.turnOn();
        lights.turnOn();
        System.out.println("Movie is starting...\n");
    }

    public void endMovie() {
        System.out.println("Shutting movie theater down...");
        dvdPlayer.turnOff();
        projector.turnOff();
        lights.turnOff();
    }
}

public class Main {
    public static void main(String[] args) {
        HomeTheaterFacade homeTheaterFacade = new HomeTheaterFacade();
        homeTheaterFacade.watchMovie("Inception");
        homeTheaterFacade.endMovie();
    }
}
