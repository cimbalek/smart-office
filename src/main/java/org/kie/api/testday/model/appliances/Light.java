package org.kie.api.testday.model.appliances;

public class Light extends AbstractAppliance {

    private int brightness;       //brightness in percents;

    public Light(int brightness) {
        super();
        this.setBrightness(brightness);
    }

    public Light() {
        this(0);
    }

    /**
     * @return Brightness of light in percents.
     */
    public int getBrightness() {
        return brightness;
    }

    /**
     * Set brightness of light in percents.
     * @param brightness brightness in percents (between 1 and 100% inclusive). If out of boundaries min/max value is used.
     */
    public void setBrightness(int brightness) {
        if ((brightness < 1) && (brightness > 100)) {
            this.brightness = 1;
            turnOff();
        } else if (brightness > 100) {
            this.brightness = 100;
            turnOn();
        } else {
            this.brightness = brightness;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Light)) return false;
        if (!super.equals(o)) return false;

        Light light = (Light) o;

        return brightness == light.brightness;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + brightness;
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Light{");
        sb.append(super.toString());
        sb.append(", brightness=").append(brightness);
        sb.append('}');
        return sb.toString();
    }
}
