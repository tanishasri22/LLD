package behaviouralPattern.statePattern.mediaPlayerApplication.solution;

 interface MediaPlayerState {
    void play(MediaPlayerContext context);

    void pause(MediaPlayerContext context);

    void stop(MediaPlayerContext context);
}

class PlayingState implements MediaPlayerState {
    public void play(MediaPlayerContext context) {
        System.out.println("Already playing.");
    }

    public void pause(MediaPlayerContext context) {
        System.out.println("Pausing the media.");
        context.setState(new PausedState());
    }

    public void stop(MediaPlayerContext context) {
        System.out.println("Stopping the media.");
        context.setState(new StoppedState());
    }
}

class PausedState implements MediaPlayerState {
    public void play(MediaPlayerContext context) {
        System.out.println("Resuming the media.");
        context.setState(new PlayingState());
    }

    public void pause(MediaPlayerContext context) {
        System.out.println("Already paused.");
    }

    public void stop(MediaPlayerContext context) {
        System.out.println("Stopping from paused.");
        context.setState(new StoppedState());
    }
}

class StoppedState implements MediaPlayerState {
    public void play(MediaPlayerContext context) {
        System.out.println("Starting playback.");
        context.setState(new PlayingState());
    }

    public void pause(MediaPlayerContext context) {
        System.out.println("Can't pause. Media is stopped.");
    }

    public void stop(MediaPlayerContext context) {
        System.out.println("Already stopped.");
    }
}

 class MediaPlayerContext {
    private MediaPlayerState currentState;

    public MediaPlayerContext() {
        currentState = new StoppedState(); // default state
    }

    public void setState(MediaPlayerState state) {
        this.currentState = state;
    }

    public void play() {
        currentState.play(this);
    }

    public void pause() {
        currentState.pause(this);
    }

    public void stop() {
        currentState.stop(this);
    }
}

public class MediaPlayerTest {
    public static void main(String[] args) {
        MediaPlayerContext player = new MediaPlayerContext();

        player.play(); // Starting playback.
        player.play(); // Already playing.
        player.pause(); // Pausing the media.
        player.stop(); // Stopping from paused.
        player.pause(); // Can't pause. Media is stopped.
    }
}
