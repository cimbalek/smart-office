package org.kie.api.testday.model.sensors;

import java.util.Random;

public class LightSensor {


    private int value = 75;
    private int jitter = 10;             //how maximally can next value differ
    private Random rand = new Random(System.currentTimeMillis());

    /**
     * @return Percent value (0-100) of received light at the sensor
     */

    public int getValue() {
        value = value + (rand.nextInt(jitter * 2) - jitter);
        if (value < 0) {
            value = 0;
        } else if (value > 100) {
            value = 100;
        }
        return value;
    }

}
