package structuralPattern.adapterPattern.basicImplementation.solution;

// Step 1: Create MediaPlayer interface
interface MediaPlayer {
    void play(String audioType, String fileName);
}

// Step 2: Create AdvancedMediaPlayer interface
interface AdvancedMediaPlayer {
    void playMp4(String fileName);

    void playVlc(String fileName);
}

// Step 3: Implement AdvancedMediaPlayer for MP4
class Mp4Player implements AdvancedMediaPlayer {
    public void playMp4(String fileName) {
        System.out.println("Playing MP4 file: " + fileName);
    }

    public void playVlc(String fileName) {
        // Do nothing
    }
}

// Step 4: Implement AdvancedMediaPlayer for VLC
class VlcPlayer implements AdvancedMediaPlayer {
    public void playMp4(String fileName) {
        // Do nothing
    }

    public void playVlc(String fileName) {
        System.out.println("Playing VLC file: " + fileName);
    }
}

// Step 5: Create Adapter to bridge MediaPlayer with AdvancedMediaPlayer
class MediaAdapter implements MediaPlayer {
    AdvancedMediaPlayer advancedMediaPlayer;

    public MediaAdapter(String audioType) {
        if (audioType.equalsIgnoreCase("mp4")) {
            advancedMediaPlayer = new Mp4Player();
        } else if (audioType.equalsIgnoreCase("vlc")) {
            advancedMediaPlayer = new VlcPlayer();
        }
    }

    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("mp4")) {
            advancedMediaPlayer.playMp4(fileName);
        } else if (audioType.equalsIgnoreCase("vlc")) {
            advancedMediaPlayer.playVlc(fileName);
        }
    }
}

// Step 6: Create the main AudioPlayer class that uses MediaAdapter when needed
class AudioPlayer implements MediaPlayer {
    MediaAdapter mediaAdapter;

    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("mp3")) {
            System.out.println("Playing MP3 file: " + fileName);
        } else if (audioType.equalsIgnoreCase("mp4") || audioType.equalsIgnoreCase("vlc")) {
            mediaAdapter = new MediaAdapter(audioType);
            mediaAdapter.play(audioType, fileName);
        } else {
            System.out.println("Invalid media format: " + audioType);
        }
    }
}

// Step 7: Test the implementation
public class solution {
    public static void main(String[] args) {
        AudioPlayer player = new AudioPlayer();
        player.play("mp3", "song.mp3");
        player.play("mp4", "movie.mp4");
        player.play("vlc", "video.vlc");
        player.play("avi", "random.avi");
    }
}