package org.kie.api.testday.app;

import java.util.List;

import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.StatelessKieSession;
import org.kie.api.runtime.rule.EntryPoint;
import org.kie.api.runtime.rule.FactHandle;
import org.kie.api.testday.model.Room;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Logic {

    private static Logger LOG = LoggerFactory.getLogger(Logic.class);

    KieSession session;
    FactHandle motionFactHandle;


    public void prepareKieSession() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public StatelessKieSession getStatelessSession() {
        throw new UnsupportedOperationException("Not implemented yet");

    }

    /**
     * Evaluates light conditions in the kitchen and takes an stable action.
     * @param kitchen with populated necessary fields.
     * @return number of fired rules.
     */
    public int optimizeLightConditionsInKitchen(Room kitchen) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public EntryPoint watchActivity(Room room) throws InterruptedException {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public void emergency(List<Room> rooms) {
        throw new UnsupportedOperationException("Not implemented yet");
    }


    public KieSession getSession() {
        return session;
    }
}
