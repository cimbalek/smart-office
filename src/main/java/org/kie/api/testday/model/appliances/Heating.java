package org.kie.api.testday.model.appliances;

import java.util.UUID;

public class Heating {

    private String id = UUID.randomUUID().toString();
    private int currentOutput;
    private int desiredTemp;

    public String getId() {
        return id;
    }

    public int getCurrentOutput() {
        return currentOutput;
    }

    public void setCurrentOutput(int currentOutput) {
        this.currentOutput = currentOutput;
    }

    public int getDesiredTemp() {
        return desiredTemp;
    }

    public void setDesiredTemp(int desiredTemp) {
        this.desiredTemp = desiredTemp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Heating)) return false;

        Heating heating = (Heating) o;

        if (currentOutput != heating.currentOutput) return false;
        if (desiredTemp != heating.desiredTemp) return false;
        return id != null ? id.equals(heating.id) : heating.id == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + currentOutput;
        result = 31 * result + desiredTemp;
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Heating{");
        sb.append("id='").append(id).append('\'');
        sb.append(", currentOutput=").append(currentOutput);
        sb.append(", desiredTemp=").append(desiredTemp);
        sb.append('}');
        return sb.toString();
    }
}
