package org.kie.api.testday.model.appliances;

import java.util.UUID;

public class Jalousie {

    private String id = UUID.randomUUID().toString();
    private int shading = 0;

    public String getId() {
        return id;
    }

    /**
     * Get sun shading in percents
     * @return current sun shading in percents (0 = not shading at all, 100 = fully closed)
     */
    public int getShading() {
        return shading;
    }

    /**
     * Set sun shading in percents (0 = not shading at all, 100 = fully closed)
     * @param shading percentage of sun shading between 0 and 100 inclusive
     */
    public void setShading(int shading) {
        if ((shading >= 0) && (shading <= 100)) {
            this.shading = shading;
        } else if (shading > 100) {
            this.shading = 100;
        } else if (shading < 0) {
            this.shading = 0;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Jalousie)) return false;

        Jalousie jalousie = (Jalousie) o;

        if (shading != jalousie.shading) return false;
        return id != null ? id.equals(jalousie.id) : jalousie.id == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + shading;
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Jalousie{");
        sb.append("id='").append(id).append('\'');
        sb.append(", shading=").append(shading);
        sb.append('}');
        return sb.toString();
    }
}
