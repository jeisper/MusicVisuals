package d19124603;

import ie.tudublin.*;

public class GivagoVisual extends Visual {
    WaveForm wf;
    AudioBandsVisual abv;

    public void settings() {
        size(800, 800, P3D);

    }

    public void setup() {
        startMinim();
        surface.setResizable(true);

        // Call loadAudio to load an audio file to process
        loadAudio("rise.mp3");

        // Call this instead to read audio from the microphone
        startListening();

        wf = new WaveForm(this);

    }

    public void keyPressed() {
        if (key == ' ') {
            getAudioPlayer().cue(0);
            getAudioPlayer().play();
        }
    }

    public void draw() {
        background(0);
        try {
            // Call this if you want to use FFT data
            calculateFFT();
        } catch (VisualException e) {
            e.printStackTrace();
        }
        // Call this is you want to use frequency bands
        calculateFrequencyBands();

        // Call this is you want to get the average amplitude
        calculateAverageAmplitude();
        wf.render();

    }
}