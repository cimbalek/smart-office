package org.kie.api.testday.model.sensors;

import java.util.Random;

public class MotionSensor {

    private Random rand = new Random(System.currentTimeMillis());

    public boolean isMotionDetected() {
        return rand.nextBoolean();
    }
}
