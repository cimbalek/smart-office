package org.kie.api.testday.model.sensors;

import java.util.Random;

public class TempSensor {

    private double value = 20.5;
    private int jitter = 2;             //how maximally can next value differ
    private Random rand = new Random(System.currentTimeMillis());

    /**
     * @return Actual temperature (sensor range: -20°C to 50°C)
     */
    public double getValue() {
        value = value + ((rand.nextInt(jitter * 20) / 10.0) - jitter);
        if (value < -20.0) {
            value = -20.0;
        } else if (value > 50.0) {
            value = 50.0;
        }
        return value;
    }
}
