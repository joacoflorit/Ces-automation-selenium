package tatf.core.driver.manager;

public class FirefoxDriver extends DriverManager {
    public FirefoxDriver() {
        this.driver = new org.openqa.selenium.firefox.FirefoxDriver();
    }
}
