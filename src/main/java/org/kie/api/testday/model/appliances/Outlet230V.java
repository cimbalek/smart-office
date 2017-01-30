package org.kie.api.testday.model.appliances;

public class Outlet230V extends AbstractAppliance {

    public Outlet230V(String name, String description, boolean on) {
        super();
        this.name = name;
        this.description = description;
        this.on = on;
    }

    public Outlet230V(String name, String description) {
        this(name, description, true);
    }

    public Outlet230V(String name, boolean on) {
        this(name, null, on);
    }

    public Outlet230V(String name) {
        this(name, null, true);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Outlet230V{");
        sb.append(super.toString());
        sb.append('}');
        return sb.toString();
    }
}
