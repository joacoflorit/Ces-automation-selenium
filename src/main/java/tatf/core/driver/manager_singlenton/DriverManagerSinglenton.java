package tatf.core.driver.manager_singlenton;

import tatf.core.driver.manager_factory.DriverManagerFactory;
import org.openqa.selenium.WebDriver;

import static tatf.core.driver.manager_enum.DriverType.CHROME;

public class DriverManagerSinglenton {
    private static DriverManagerSinglenton instance;
    private final WebDriver driver;

    private DriverManagerSinglenton() {
        driver = DriverManagerFactory.getDriver(CHROME);
    }

    public static DriverManagerSinglenton getInstance() {
        if (instance == null)
            instance = new DriverManagerSinglenton();

        return instance;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void quit() {
        instance = null;
    }
}
