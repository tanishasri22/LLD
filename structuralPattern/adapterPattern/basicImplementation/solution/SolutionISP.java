package structuralPattern.adapterPattern.basicImplementation.solution;

import java.util.InputMismatchException;

// Segregated interfaces for specific media types
interface MediaPlayer {
    void play(String type, String file);
}

interface MP4Player {
    void playMP4(String file);
}

interface VLCPlayer {
    void playVLC(String file);
}

class MP4 implements MP4Player {
    public void playMP4(String file){
        System.out.println("Playing " + file + " using " + this.getClass().getSimpleName());
    }
}

class VLC implements VLCPlayer {
    public void playVLC(String file) {
        System.out.println("Playing " + file + " using " + this.getClass().getSimpleName());
    }
}

class MediaPlayerAdapter implements MediaPlayer {
    private MP4Player mp4Player;
    private VLCPlayer vlcPlayer;
    
    public MediaPlayerAdapter(String type) {
        if (type.equalsIgnoreCase("MP4")) {
            mp4Player = new MP4();
        } else if (type.equalsIgnoreCase("VLC")) {
            vlcPlayer = new VLC();
        }
    }
    
    public void play(String type, String file) {
        if (type.equalsIgnoreCase("MP4") && mp4Player != null) {
            mp4Player.playMP4(file);
        } else if (type.equalsIgnoreCase("VLC") && vlcPlayer != null) {
            vlcPlayer.playVLC(file);
        } else {
            throw new InputMismatchException("Unsupported format: " + type);
        }
    }
}

class AudioPlayer implements MediaPlayer {
    public void play(String type, String file) {
        if (type.equalsIgnoreCase("MP3")) {
            System.out.println("Playing MP3 song: " + file);
        } else if (type.equalsIgnoreCase("MP4") || type.equalsIgnoreCase("VLC")) {
            MediaPlayerAdapter adapter = new MediaPlayerAdapter(type);
            adapter.play(type, file);
        } else {
            throw new InputMismatchException("Unsupported format: " + type);
        }
    }
}

public class SolutionISP {
    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();
        audioPlayer.play("MP3", "SONG1");
        audioPlayer.play("MP4", "SONG2");
        audioPlayer.play("VLC", "SONG3");
    }
}
