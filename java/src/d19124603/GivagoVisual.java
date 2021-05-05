package d19124603;

import javax.lang.model.type.DeclaredType;

import ie.tudublin.*;
import processing.core.PVector;

public class GivagoVisual extends Visual {
    int speed = 50;
    boolean step = false;
    boolean twocubes = false;
    WaveForm wf;
    AudioBandsVisual abv;
    PVector v1, v2, v3, v4, v5, s1, s2, s3, s4;

    public void settings() {
        size(1600, 1600, P3D);

    }

    public void setup() {
        v1 = new PVector(175, 100);
        v2 = new PVector(-175, -100);
        v3 = new PVector(-175, -100);
        v4 = new PVector(175, 100);
        v5 = new PVector(0, 0);
        s1 = new PVector(0, 0);
        s2 = new PVector(0, 0);
        s3 = new PVector(0, 0);
        s4 = new PVector(0, 0);

        surface.setResizable(true);
        startMinim();

        // Call loadAudio to load an audio file to process
        loadAudio("rise.mp3");

        // Call this instead to read audio from the microphone
        startListening();

        wf = new WaveForm(this);

    }

    public void makeCube(float x, float y) {
        pushMatrix();
        translate(x, y, -250);
        cube();
        popMatrix();

    }

    public void cube() {
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

    public void upLeft() {
        makeCube(v1.x, v1.y);
        v1.add(s1);
        if (v1.x > (175) && v1.y > (100)) {
            v1.y = v1.y * (-1);
        }
        if (v1.y <= (-100)) {
            s1.y = 0;
            s1.x = (getAmplitude() * -(speed));
            v1.y = -100;
        }
        if (v1.x <= -175 && v1.y <= -100) {
            s1.x = 0;
            v1.x = -175;
        }

    }

    public void downRight() {
        makeCube(v2.x, v2.y);
        v2.add(s2);
        if (v2.x > (-175) && v2.y > (-100)) {
            v2.y = v2.y * (1);
        }
        if (v2.y >= (100)) {
            s2.y = 0;
            s2.x = (getAmplitude() * +(speed));
            v2.y = 100;
        }
        if (v2.x >= 175 && v2.y >= -100) {
            s2.x = 0;
            v2.x = 175;
        }

    }

    public void diagoLeftRight() {
        makeCube(v3.x, v3.y);
        v3.add(s3);

        if (v3.x < (-175) && v3.y < (-100)) {
            v3.y = (getAmplitude() * +(speed));
            v3.x = (getAmplitude() * +(speed));
        }
    }

    public void diagoRightLeft() {
        makeCube(v4.x, v4.y);
        v4.add(s4);

        if (v4.x > (175) && v4.y > (100)) {
            v4.y = (getAmplitude() * -(speed));
            v4.x = (getAmplitude() * -(speed));
        }
    }

    public void keyPressed() {
        if (key == ' ') {
            getAudioPlayer().cue(0);
            getAudioPlayer().play();
        }

        if (key == '1') {

            step = !step;
        }

    }

    float smoothedBoxSize = 0;

    public void draw() {
        s1.y = (getAmplitude() * -(speed));
        s2.y = (getAmplitude() * +(speed));
        s3.y = (getAmplitude() * +(speed));
        s4.y = (getAmplitude() * -(speed));
        s3.x = (getAmplitude() * +(speed));
        s4.x = (getAmplitude() * -(speed));

        calculateAverageAmplitude();
        background(0);
        noFill();
        lights();
        stroke(map(getSmoothedAmplitude(), 0, 1, 0, 255), 255, 255);
        camera(0, 0, 0, 0, 0, -1, 0, 1, 0);

        float boxSize = 50 + (getAmplitude() * 300);// map(average, 0, 1, 100, 400);
        smoothedBoxSize = lerp(smoothedBoxSize, boxSize, 0.2f);

        if (!step) {
            upLeft();
            downRight();

        }
        if (step) {
            makeCube(v5.x, v5.y);
            diagoLeftRight();
            diagoRightLeft();
        }

        angle += 0.01f;
    }

    float angle = 0;

}