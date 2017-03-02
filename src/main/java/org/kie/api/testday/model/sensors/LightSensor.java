package org.kie.api.testday.model.sensors;

import java.util.Random;

public class LightSensor {


    private int value = 5;
    private int jitter = 10;             //how maximally can next value differ
    private Random rand = new Random(System.currentTimeMillis());

    /**
     * @return Percent value (0-100) of received light at the sensor
     */

    public int getValue() {
        return value;
    }

    /**
     * only for testing purposes
     * @param value
     */
    public void setValue(int value) {
        this.value = value;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("LightSensor{");
        sb.append("value=").append(value);
        sb.append('}');
        return sb.toString();
    }
}
