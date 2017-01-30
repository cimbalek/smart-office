package org.kie.api.testday.model;

import java.util.List;
import java.util.UUID;

import org.kie.api.testday.model.appliances.Heating;
import org.kie.api.testday.model.appliances.Jalousie;
import org.kie.api.testday.model.appliances.Light;
import org.kie.api.testday.model.appliances.Outlet230V;
import org.kie.api.testday.model.sensors.LightSensor;
import org.kie.api.testday.model.sensors.MotionSensor;
import org.kie.api.testday.model.sensors.TempSensor;

public class Room {

    private String id = UUID.randomUUID().toString();
    private String name;
    private String description;
    private int capacity;

    private Light light;
    private List<Outlet230V> outlets;
    private Heating heating;
    private Jalousie jalousie;


    private LightSensor lightSensor;
    private TempSensor tempSensor;
    private MotionSensor motionSensor;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Light getLight() {
        return light;
    }

    public void setLight(Light light) {
        this.light = light;
    }

    public List<Outlet230V> getOutlets() {
        return outlets;
    }

    public void setOutlets(List<Outlet230V> outlets) {
        this.outlets = outlets;
    }

    public Heating getHeating() {
        return heating;
    }

    public void setHeating(Heating heating) {
        this.heating = heating;
    }

    public Jalousie getJalousie() {
        return jalousie;
    }

    public void setJalousie(Jalousie jalousie) {
        this.jalousie = jalousie;
    }

    public LightSensor getLightSensor() {
        return lightSensor;
    }

    public void setLightSensor(LightSensor lightSensor) {
        this.lightSensor = lightSensor;
    }

    public TempSensor getTempSensor() {
        return tempSensor;
    }

    public void setTempSensor(TempSensor tempSensor) {
        this.tempSensor = tempSensor;
    }

    public MotionSensor getMotionSensor() {
        return motionSensor;
    }

    public void setMotionSensor(MotionSensor motionSensor) {
        this.motionSensor = motionSensor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Room)) return false;

        Room room = (Room) o;

        if (capacity != room.capacity) return false;
        if (id != null ? !id.equals(room.id) : room.id != null) return false;
        if (name != null ? !name.equals(room.name) : room.name != null) return false;
        if (description != null ? !description.equals(room.description) : room.description != null) return false;
        if (light != null ? !light.equals(room.light) : room.light != null) return false;
        if (outlets != null ? !outlets.equals(room.outlets) : room.outlets != null) return false;
        if (heating != null ? !heating.equals(room.heating) : room.heating != null) return false;
        if (jalousie != null ? !jalousie.equals(room.jalousie) : room.jalousie != null) return false;
        if (lightSensor != null ? !lightSensor.equals(room.lightSensor) : room.lightSensor != null) return false;
        if (tempSensor != null ? !tempSensor.equals(room.tempSensor) : room.tempSensor != null) return false;
        return motionSensor != null ? motionSensor.equals(room.motionSensor) : room.motionSensor == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + capacity;
        result = 31 * result + (light != null ? light.hashCode() : 0);
        result = 31 * result + (outlets != null ? outlets.hashCode() : 0);
        result = 31 * result + (heating != null ? heating.hashCode() : 0);
        result = 31 * result + (jalousie != null ? jalousie.hashCode() : 0);
        result = 31 * result + (lightSensor != null ? lightSensor.hashCode() : 0);
        result = 31 * result + (tempSensor != null ? tempSensor.hashCode() : 0);
        result = 31 * result + (motionSensor != null ? motionSensor.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Room{");
        sb.append("id='").append(id).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", capacity=").append(capacity);
        sb.append(", light=").append(light);
        sb.append(", outlets=").append(outlets);
        sb.append(", heating=").append(heating);
        sb.append(", jalousie=").append(jalousie);
        sb.append(", lightSensor=").append(lightSensor);
        sb.append(", tempSensor=").append(tempSensor);
        sb.append(", motionSensor=").append(motionSensor);
        sb.append('}');
        return sb.toString();
    }
}
