package tatf.core.driver.manager;

import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class ChromeDriver extends DriverManager {
    public ChromeDriver() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        chromeOptions.addArguments("--ignore-certificate-errors");
        //chromeOptions.addArguments("--headless");
        this.driver = new org.openqa.selenium.chrome.ChromeDriver(chromeOptions);
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        this.driver.manage().deleteAllCookies();
    }
}
