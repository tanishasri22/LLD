package behaviouralPattern.statePattern.fanWorking;

interface State {
    void pressButton(Fan fan);
}

class OffState implements State {
    @Override
    public void pressButton(Fan fan) {
        System.out.println("Fan is turning to LOW speed.");
        fan.setState(new LowState());
    }
}

class LowState implements State {
    @Override
    public void pressButton(Fan fan) {
        System.out.println("Fan is turning to MEDIUM speed.");
        fan.setState(new MediumState());
    }
}

class MediumState implements State {
    @Override
    public void pressButton(Fan fan) {
        System.out.println("Fan is turning to HIGH speed.");
        fan.setState(new HighState());
    }
}

class HighState implements State {
    @Override
    public void pressButton(Fan fan) {
        System.out.println("Fan is turning OFF.");
        fan.setState(new OffState());
    }
}

class Fan {
    private State state;

    public Fan() {
        // Fan starts in Off state
        this.state = new OffState();
    }

    public void setState(State state) {
        this.state = state;
    }

    public void pressButton() {
        state.pressButton(this);
    }
}

public class StatePatternDemo {
    public static void main(String[] args) {
        Fan fan = new Fan();

        fan.pressButton(); // Off → Low
        
        fan.pressButton(); // Low → Medium
        fan.pressButton(); // Medium → High
        fan.pressButton(); // High → Off
        fan.pressButton(); // Off → Low
    }
}
