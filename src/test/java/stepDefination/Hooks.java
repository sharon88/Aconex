package stepDefination;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.Base;

import java.io.IOException;

public class Hooks extends Base {

    @Before
    public void setUp() throws IOException {
        startDriver();
    }

    @After
    public void tearDown(Scenario scenario) throws IOException {
        closeDriver(scenario);
    }


}
