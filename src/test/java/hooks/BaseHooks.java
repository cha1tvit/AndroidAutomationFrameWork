package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import tests.BaseTest;

public class BaseHooks {
    @Before
    public void before() {
        BaseTest.initDriver();
    }

    @After
    public void after() {
        BaseTest.closeDriver();
    }
}
