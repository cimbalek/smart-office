package org.kie.api.testday.app;

import java.util.List;

import org.kie.api.KieServices;
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
        session = KieServices.Factory.get().getKieClasspathContainer().newKieSession();
    }

    public StatelessKieSession getStatelessSession() {
        return KieServices.Factory.get().getKieClasspathContainer().newStatelessKieSession();

    }

    /**
     * Evaluates light conditions in the kitchen and takes an stable action.
     * @param kitchen with populated necessary fields.
     * @return number of fired rules.
     */
    public int optimizeLightConditionsInKitchen(Room kitchen) {

        prepareKieSession();

        session.insert(kitchen);
        session.insert(kitchen.getLight());
        session.insert(kitchen.getLightSensor());
        session.insert(kitchen.getJalousie());

        int rulesFired = session.fireAllRules();

        session.dispose();
        return rulesFired;
    }

    public EntryPoint watchActivity(Room room) throws InterruptedException {

        prepareKieSession();

        EntryPoint motionEP = session.getEntryPoint("motion");
        motionEP.insert(room);
        motionEP.insert(room.getLight());
        motionFactHandle = motionEP.insert(room.getMotionSensor());

        new Thread(new Runnable() {
            public void run() {
                session.fireUntilHalt();
                session.dispose();
            }
        }).start();

        return motionEP;
    }

    public void emergency(List<Room> rooms) {
        StatelessKieSession sSession = getStatelessSession();
        sSession.execute(rooms);
    }


    public KieSession getSession() {
        return session;
    }
}
