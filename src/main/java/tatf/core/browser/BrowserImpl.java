package tatf.core.browser;


import tatf.core.driver.manager_singlenton.DriverManagerSinglenton;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


/**
 * DriverManager se encarga de manipular WebDriver.
 */
public class BrowserImpl implements IBrowser {
    private final int waitSeconds;
    private final WebDriver driver;

    public BrowserImpl(int waitSeconds, WebDriver driver) {
        this.waitSeconds = waitSeconds;
        this.driver = driver;
    }

    //#region Find
    private WebElement find(By by) {
        return this.driver.findElement(by);
    }

    private List<WebElement> finds(By by) {
        return this.driver.findElements(by);
    }
    //#endregion

    //#region FindBy
    public WebElement findId(String id) {
        return find(By.id(id));
    }

    public WebElement findName(String name) {
        return find(By.name(name));
    }

    public WebElement findClassName(String className) {
        return find(By.className(className));
    }

    public WebElement findCss(String cssSelector) {
        return find(By.cssSelector(cssSelector));
    }

    public WebElement findLink(String linkText) {
        return find(By.linkText(linkText));
    }

    public WebElement findLinkPartial(String partialLinkText) {
        return find(By.partialLinkText(partialLinkText));
    }

    public WebElement findTag(String tagName) {
        return find(By.tagName(tagName));
    }

    public WebElement findXpath(String xpath) {
        return find(By.xpath(xpath));
    }

    public List<WebElement> findsClassName(String className) {
        return finds(By.className(className));
    }

    public List<WebElement> findsCssSelector(String cssSelector) {
        return finds(By.cssSelector(cssSelector));
    }

    public List<WebElement> findsId(String id) {
        return finds(By.id(id));
    }

    public List<WebElement> findsName(String name) {
        return finds(By.name(name));
    }

    public List<WebElement> findsLink(String linkText) {
        return finds(By.linkText(linkText));
    }

    public List<WebElement> findsLinkPartial(String partialLinkText) {
        return finds(By.partialLinkText(partialLinkText));
    }

    public List<WebElement> findsTag(String tagName) {
        return finds(By.tagName(tagName));
    }

    public List<WebElement> findsXpath(String xpath) {
        return finds(By.xpath(xpath));
    }

    @Override
    public List<WebElement> findsCss(String locator) {
        return finds(By.cssSelector(locator));
    }
    //#endregion

    //#region Utilidades
    @Override
    public void quit() {
        this.driver.quit();
        DriverManagerSinglenton.getInstance().quit();
    }

    @Override
    public String getTitle() {
        return this.driver.getTitle();
    }

    @Override
    public String getScreenshot() {
        TakesScreenshot screenshot = (TakesScreenshot) this.driver;
        return screenshot.getScreenshotAs(OutputType.BASE64);
    }


    @Override
    public void navigateTo(String url) {
        this.driver.navigate().to(url);
        this.driver.navigate().refresh();
    }

    @Override
    public Alert switchToAlert() {
        return this.driver.switchTo().alert();
    }

    @Override
    public void acceptAlert(Alert alert) {
        alert.accept();
    }

    @Override
    public void switchToFrame(int index) {
        this.driver.switchTo().frame(index);
    }

    @Override
    public void switchToFrame(String nameOrId) {
        this.driver.switchTo().frame(nameOrId);
    }

    @Override
    public void switchToFrame(WebElement element) {
        this.driver.switchTo().frame(element);
    }

    @Override
    public void switchToDefaultContent() {
        this.driver.switchTo().defaultContent();
    }

    @Override
    public String getWindowHandle() {
        return this.driver.getWindowHandle();
    }

    @Override
    public Set<String> getWindowHandles() {
        return this.driver.getWindowHandles();
    }

    @Override
    public void switchToWindow(int indexWindows) {
        assert getWindowHandles().size() > 1;
        List<String> list = new ArrayList<>(getWindowHandles());
        this.driver.switchTo().window(list.get(indexWindows));
    }

    @Override
    public void javaScriptExecutor(String script) {
        JavascriptExecutor js = (JavascriptExecutor) this.driver;
        js.executeScript(script);
    }

    @Override
    public void javaScriptExecutor(String script, Object element) {
        JavascriptExecutor js = (JavascriptExecutor) this.driver;
        js.executeScript(script, element);
    }
    //#endregion

    //#region Wait
    @Override
    public void sleep() {
        this.sleep(1);
    }

    @Override
    public void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void waitId(String locator) {
        wait(By.id(locator), this.waitSeconds);
    }

    @Override
    public void waitName(String locator) {
        wait(By.name(locator), this.waitSeconds);
    }

    @Override
    public void waitCss(String locator) {
        wait(By.cssSelector(locator), this.waitSeconds);
    }

    @Override
    public void waitXpath(String locator) {
        wait(By.xpath(locator), this.waitSeconds);
    }

    @Override
    public void waitLink(String locator) {
        wait(By.linkText(locator), this.waitSeconds);
    }

    @Override
    public void waitPartialLink(String locator) {
        wait(By.partialLinkText(locator), this.waitSeconds);
    }

    @Override
    public void waitClassName(String locator) {
        wait(By.className(locator), this.waitSeconds);
    }

    @Override
    public void waitTag(String locator) {
        wait(By.tagName(locator), this.waitSeconds);
    }

    private void wait(By locator, int waitSeconds) {
        Wait<WebDriver> wait = new WebDriverWait(this.driver, Duration.ofSeconds(waitSeconds));
        wait.until(d -> {
            List<WebElement> elements = this.driver.findElements(locator);
            return !elements.isEmpty();
        });
    }
    //#endregion
}