package d19124603;

import ie.tudublin.*;

public class GivagoVisual extends Visual {
    boolean twocubes = false;
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

        if (key == '1') {
            twocubes = !twocubes;

        }

    }

    float smoothedBoxSize = 0;

    public void draw() {
        calculateAverageAmplitude();
        background(0);
        noFill();
        lights();
        stroke(map(getSmoothedAmplitude(), 0, 1, 0, 255), 255, 255);
        camera(0, 0, 0, 0, 0, -1, 0, 1, 0);
        translate(0, 0, -250);

        float boxSize = 50 + (getAmplitude() * 300);// map(average, 0, 1, 100, 400);
        smoothedBoxSize = lerp(smoothedBoxSize, boxSize, 0.2f);
        if (twocubes) {
            pushMatrix();
            translate(-100, 0, 0);
            rotateY(angle);
            rotateX(angle);
            strokeWeight(1);
            sphere(smoothedBoxSize / 8);
            strokeWeight(5);
            box(smoothedBoxSize / 2);
            rotateY(angle);
            rotateX(angle);
            strokeWeight(5);
            box(smoothedBoxSize / 3);
            popMatrix();
            pushMatrix();
            translate(100, 0, 0);
            rotateY(angle);
            rotateX(angle);
            strokeWeight(1);
            sphere(smoothedBoxSize / 8);
            strokeWeight(5);
            box(smoothedBoxSize / 2);
            rotateY(angle);
            rotateX(angle);
            strokeWeight(5);
            box(smoothedBoxSize / 3);
            popMatrix();
        } else {
            rotateY(angle);
            rotateX(angle);
            strokeWeight(1);
            sphere(smoothedBoxSize / 8);
            strokeWeight(2);
            box(smoothedBoxSize / 2);
            rotateX(angle);
            rotateY(angle);
            strokeWeight(2);
            box(smoothedBoxSize / 3);

        }
        angle += 0.01f;
    }

    float angle = 0;

}