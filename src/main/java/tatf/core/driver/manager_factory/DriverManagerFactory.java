package tatf.core.driver.manager_factory;

import tatf.core.driver.manager.ChromeDriver;
import tatf.core.driver.manager.DriverManager;
import tatf.core.driver.manager_enum.DriverType;
import org.openqa.selenium.WebDriver;

import static tatf.core.driver.manager_enum.DriverType.CHROME;

public class DriverManagerFactory {
    private DriverManagerFactory() {
    }

    public static WebDriver getDriver(DriverType type) {
        WebDriver driver = null;

        if (type.equals(CHROME)) {
            DriverManager dm = new ChromeDriver();
            driver = dm.getDriver();
        }

        return driver;
    }

}
