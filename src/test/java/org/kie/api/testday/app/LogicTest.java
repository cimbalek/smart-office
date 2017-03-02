package org.kie.api.testday.app;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.kie.api.runtime.rule.EntryPoint;
import org.kie.api.testday.model.Room;
import org.kie.api.testday.model.appliances.Jalousie;
import org.kie.api.testday.model.appliances.Light;
import org.kie.api.testday.model.appliances.Outlet230V;
import org.kie.api.testday.model.sensors.LightSensor;
import org.kie.api.testday.model.sensors.MotionSensor;

import static org.assertj.core.api.Assertions.*;

public class LogicTest {

    private Logic logic;

    @Before
    public void setUp() {
        logic = new Logic();
    }

    @Test
    public void prepareKieSession() throws Exception {
        assertThat(logic.getSession()).isNull();

        logic.prepareKieSession();

        assertThat(logic.getSession()).isNotNull();
    }

    @Test
    public void optimizeLightConditionsInKitchenSunny() throws Exception {
        Room kitchen = prepareKitchen();

        kitchen.getLightSensor().setValue(95);
        int rulesFired = logic.optimizeLightConditionsInKitchen(kitchen);

        assertThat(rulesFired).isEqualTo(1);
        assertThat(kitchen.getJalousie().getShading()).isEqualTo(85);
        assertThat(kitchen.getLight().getBrightness()).isEqualTo(0);
        assertThat(kitchen.getLight().isOn()).isFalse();

    }

    @Test
    public void optimizeLightConditionsInKitchenFair() throws Exception {
        Room kitchen = prepareKitchen();

        kitchen.getLightSensor().setValue(60);

        int rulesFired = logic.optimizeLightConditionsInKitchen(kitchen);

        assertThat(rulesFired).isEqualTo(1);
        assertThat(kitchen.getJalousie().getShading()).isEqualTo(0);
        assertThat(kitchen.getLight().getBrightness()).isEqualTo(0);
        assertThat(kitchen.getLight().isOn()).isFalse();
    }


    @Test
    public void optimizeLightConditionsInKitchenDusk() throws Exception {
        Room kitchen = prepareKitchen();

        kitchen.getLightSensor().setValue(30);

        int rulesFired = logic.optimizeLightConditionsInKitchen(kitchen);

        assertThat(rulesFired).isEqualTo(1);
        assertThat(kitchen.getJalousie().getShading()).isEqualTo(0);
        assertThat(kitchen.getLight().getBrightness()).isEqualTo(100);
        assertThat(kitchen.getLight().isOn()).isTrue();
    }

    @Test
    public void optimizeLightConditionsInKitchenDark() throws Exception {
        Room kitchen = prepareKitchen();

        kitchen.getLightSensor().setValue(9);

        int rulesFired = logic.optimizeLightConditionsInKitchen(kitchen);

        assertThat(rulesFired).isEqualTo(1);
        assertThat(kitchen.getJalousie().getShading()).isEqualTo(0);
        assertThat(kitchen.getLight().getBrightness()).isEqualTo(78);
        assertThat(kitchen.getLight().isOn()).isTrue();
    }

    @Test(expected = NullPointerException.class)
    public void optimizeLightConditionsInKitchenNull() throws Exception {
        logic.optimizeLightConditionsInKitchen(null);
    }

    @Test
    public void optimizeLightConditionsInKitchenNullLightSensor() throws Exception {
        Room kitchen = new Room();
        kitchen.setJalousie(new Jalousie());
        kitchen.setLight(new Light(0));

        int rulesFired = logic.optimizeLightConditionsInKitchen(kitchen);

        assertThat(rulesFired).isEqualTo(0);
        assertThat(kitchen.getJalousie().getShading()).isEqualTo(0);
        assertThat(kitchen.getLight().getBrightness()).isEqualTo(0);
        assertThat(kitchen.getLight().isOn()).isFalse();

    }

    @Test
    public void optimizeLightConditionsInKitchenNullJalousie() throws Exception {
        Room kitchen = new Room();
        kitchen.setLightSensor(new LightSensor());
        kitchen.setLight(new Light(0));

        int rulesFired = logic.optimizeLightConditionsInKitchen(kitchen);

        assertThat(rulesFired).isEqualTo(0);
        assertThat(kitchen.getLight().getBrightness()).isEqualTo(0);
        assertThat(kitchen.getLight().isOn()).isFalse();
    }

    @Test
    public void optimizeLightConditionsInKitchenNullLight() throws Exception {
        Room kitchen = new Room();
        kitchen.setJalousie(new Jalousie());
        kitchen.setLightSensor(new LightSensor());

        int rulesFired = logic.optimizeLightConditionsInKitchen(kitchen);

        assertThat(rulesFired).isEqualTo(0);
        assertThat(kitchen.getJalousie().getShading()).isEqualTo(0);
    }

    @Test(timeout = 5000)
    public void detectMotion() throws Exception {
        Room tantalum = new Room();
        tantalum.setMotionSensor(new MotionSensor());
        tantalum.setLight(new Light(0));

        EntryPoint motionEP = logic.watchActivity(tantalum);


        try {
            Thread.sleep(500);
            assertThat(tantalum.getLight().getBrightness()).isEqualTo(0);
            assertThat(tantalum.getLight().isOn()).isFalse();

            tantalum.getMotionSensor().setMotionDetected(true);
            motionEP.update(logic.motionFactHandle, tantalum.getMotionSensor());

            while (tantalum.getLight().getBrightness() == 0) {
                Thread.sleep(200);
            }
            assertThat(tantalum.getLight().getBrightness()).isEqualTo(100);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            logic.session.halt();
            logic.session.dispose();
        }
    }

    private Room prepareKitchen() {
        Room kitchen = new Room();
        kitchen.setLightSensor(new LightSensor());
        kitchen.setJalousie(new Jalousie());
        kitchen.setLight(new Light(0));

        return kitchen;
    }

    private Room prepareRoomWithApplianceOnly(int lightBrightness, boolean... outletsOn) {
        Room room = new Room();
        room.setLight(new Light(lightBrightness));
        List<Outlet230V> outlets = new ArrayList<>();
        int i = 0;
        for (boolean outletOn : outletsOn) {
            i++;
            outlets.add(new Outlet230V("Outlet " + i, outletOn));
        }
        room.setLight(new Light(0));

        return room;
    }
}