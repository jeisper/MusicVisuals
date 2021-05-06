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
    PVector v1, v2, v3, v4, v5, v6, v7, v8, v9, s1, s2, s3, s4, s6, s7, s8, s9;

    public void settings() {
        size(1600, 1600, P3D);

    }

    public void setup() {
        v1 = new PVector(175, 100);
        v2 = new PVector(-175, -100);
        v3 = new PVector(-175, -100);
        v4 = new PVector(175, 100);
        v5 = new PVector(0, 0);
        v6 = new PVector(-175, 100);
        v7 = new PVector(175, -100);
        v8 = new PVector(-175, 100);
        v9 = new PVector(175, -100);
        s1 = new PVector(0, 0);
        s2 = new PVector(0, 0);
        s3 = new PVector(0, 0);
        s4 = new PVector(0, 0);
        s6 = new PVector(0, 0);
        s7 = new PVector(0, 0);
        s8 = new PVector(0, 0);
        s9 = new PVector(0, 0);

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
            v1.y = (getAmplitude() * -(speed));
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

    public void rightUp() {
        makeCube(v8.x, v8.y);
        v8.add(s8);
        if (v8.x > (-175) && v8.y > (100)) {
            v8.x = (getAmplitude() * +(speed));
        }
        if (v8.x >= (175)) {
            s8.x = 0;
            s8.y = (getAmplitude() * -(speed));
            v8.x = 175;
        }
        if (v8.x >= 175 && v8.y <= -100) {
            s8.y = 0;
            v8.y = -100;
        }

    }

    public void leftDown() {
        makeCube(v9.x, v9.y);
        v9.add(s9);
        if (v9.x > (175) && v9.y > (-100)) {
            v9.x = (getAmplitude() * -(speed));
        }
        if (v9.x <= (-175)) {
            s9.x = 0;
            s9.y = (getAmplitude() * +(speed));
            v9.x = -175;
        }
        if (v9.x <= -175 && v9.y >= 100) {
            s9.y = 0;
            v9.y = 100;
        }

    }

    public void downRight() {
        makeCube(v2.x, v2.y);
        v2.add(s2);
        if (v2.x < (-175) && v2.y < (-100)) {
            v2.y = (getAmplitude() * +(speed));
        }
        if (v2.y >= (100)) {
            s2.y = 0;
            v2.y = 100;
            s2.x = (getAmplitude() * +(speed));

        }
        if (v2.x >= 175 && v2.y >= 100) {
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

    public void leftToRight() {
        makeCube(v6.x, v6.y);
        v6.add(s6);

        if (v6.x < (-175) && v6.y > (-100)) {
            v6.y = (getAmplitude() * -(speed));
            v6.x = (getAmplitude() * +(speed));

        }
        println(v6.y);
    }

    public void rightToLeft() {
        makeCube(v7.x, v7.y);
        v7.add(s7);
        if (v7.x > (175) && v7.y < (-100)) {
            v7.y = (getAmplitude() * +(speed));
            v7.x = (getAmplitude() * -(speed));
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
        s6.y = (getAmplitude() * -(speed));
        s6.x = (getAmplitude() * +(speed));
        s7.y = (getAmplitude() * +(speed));
        s7.x = (getAmplitude() * -(speed));
        s8.x = (getAmplitude() * +(speed));
        s9.x = (getAmplitude() * -(speed));

        calculateAverageAmplitude();
        background(0);
        noFill();
        lights();
        stroke(map(getSmoothedAmplitude(), 0, 1, 0, 255), 255, 255);
        camera(0, 0, 0, 0, 0, -1, 0, 1, 0);

        float boxSize = 50 + (getAmplitude() * 300);// map(average, 0, 1, 100, 400);
        smoothedBoxSize = lerp(smoothedBoxSize, boxSize, 0.2f);

        if (!step) {
            makeCube(v5.x, v5.y);
            upLeft();
            downRight();
            leftDown();
            rightUp();

        }
        if (step) {
            makeCube(v5.x, v5.y);
            diagoLeftRight();
            diagoRightLeft();
            leftToRight();
            rightToLeft();
        }

        angle += 0.01f;
    }

    float angle = 0;

}