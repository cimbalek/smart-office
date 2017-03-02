package org.kie.api.testday.model.sensors;

public class MotionSensor {

    boolean motionDetected = false;

    public boolean isMotionDetected() {
        return motionDetected;
    }

    public void setMotionDetected(boolean motionDetected) {
        this.motionDetected = motionDetected;
    }
}
