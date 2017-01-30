package org.kie.api.testday.model.appliances;

import java.util.UUID;

/**
 * Abstract class parent for classes representing electrical appliances such as outlets or lighting.
 */
@SuppressWarnings("ALL")
public abstract class AbstractAppliance {

    protected String name;
    protected String description;
    boolean on;
    private String id = UUID.randomUUID().toString();

    protected AbstractAppliance() {
    }

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

    public boolean isOn() {
        return on;
    }

    public void turnOn() {
        this.on = true;
    }

    public void turnOff() {
        this.on = false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractAppliance)) return false;

        AbstractAppliance that = (AbstractAppliance) o;

        if (on != that.on) return false;
        if (!id.equals(that.id)) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return description != null ? description.equals(that.description) : that.description == null;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (on ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AbstractAppliance{");
        sb.append("id='").append(id).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", on=").append(on);
        sb.append('}');
        return sb.toString();
    }
}
