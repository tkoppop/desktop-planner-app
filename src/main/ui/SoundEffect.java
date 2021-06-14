package ui;
import javax.sound.sampled.*;
import java.io.File;
public class SoundEffect {
    Clip clip;
    //MODIFIES: clip
    //EFFECTS: sets the file that is going to be played
    public void setFile(String soundfile) {
        try {
            File file = new File(soundfile);
            AudioInputStream sound = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(sound);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //REQUIRES: clip != null
    //EFFECTS: plays selected clip
    public void play() {
        clip.setFramePosition(0);
        clip.start();
    }
}
