package tatf.core.browser;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Set;

/**
 * Interfaz que define operaciones comunes para la gestión del navegador y la espera de elementos en una página web.
 */
public interface IBrowser {
    static IBrowser create(int waitSeconds, WebDriver driver) {
        return new BrowserImpl(waitSeconds, driver);
    }

    /**
     * Busca un elemento por id dado un localizador.
     *
     * @param locator Identificador del elemento.
     * @return Elemento configurado.
     */
    WebElement findId(String locator);

    /**
     * Busca un elemento por name dado un localizador.
     *
     * @param locator Identificador del elemento.
     * @return Elemento configurado.
     */
    WebElement findName(String locator);

    /**
     * Busca un elemento por xpath dado un localizador.
     *
     * @param locator Identificador del elemento.
     * @return Elemento configurado.
     */
    WebElement findXpath(String locator);

    /**
     * Busca un elemento por css dado un localizador.
     *
     * @param locator Identificador del elemento.
     * @return Elemento configurado.
     */
    WebElement findCss(String locator);

    /**
     * Busca un elemento por class name dado un localizador.
     *
     * @param locator Identificador del elemento.
     * @return Elemento configurado.
     */
    WebElement findClassName(String locator);

    /**
     * Busca un elemento por link dado un localizador.
     *
     * @param locator Identificador del elemento.
     * @return Elemento configurado.
     */
    WebElement findLink(String locator);

    /**
     * Busca un elemento por link parcial dado un localizador.
     *
     * @param locator Identificador del elemento.
     * @return Elemento configurado.
     */
    WebElement findLinkPartial(String locator);

    /**
     * Busca un elemento por tag dado un localizador.
     *
     * @param locator Identificador del elemento.
     * @return Elemento configurado.
     */
    WebElement findTag(String locator);

    /**
     * Busca una lista de elementos por id dado un localizador.
     *
     * @param locator Identificador del elemento.
     * @return Lista de elementos configurados.
     */
    List<WebElement> findsId(String locator);

    /**
     * Busca una lista de elementos por name dado un localizador.
     *
     * @param locator Identificador del elemento.
     * @return Lista de elementos configurados.
     */
    List<WebElement> findsName(String locator);

    /**
     * Busca una lista de elementos por xpath dado un localizador.
     *
     * @param locator Identificador del elemento.
     * @return Lista de elementos configurados.
     */
    List<WebElement> findsXpath(String locator);

    /**
     * Busca una lista de elementos por css dado un localizador.
     *
     * @param locator Identificador del elemento.
     * @return Lista de elementos configurados.
     */
    List<WebElement> findsCss(String locator);

    /**
     * Busca una lista de elementos por class name dado un localizador.
     *
     * @param locator Identificador del elemento.
     * @return Lista de elementos configurados.
     */
    List<WebElement> findsClassName(String locator);

    /**
     * Busca una lista de elementos por link dado un localizador.
     *
     * @param locator Identificador del elemento.
     * @return Lista de elementos configurados.
     */
    List<WebElement> findsLink(String locator);

    /**
     * Busca una lista de elementos por link parcial dado un localizador.
     *
     * @param locator Identificador del elemento.
     * @return Lista de elementos configurados.
     */
    List<WebElement> findsLinkPartial(String locator);

    /**
     * Busca una lista de elementos por tag dado un localizador.
     *
     * @param locator Identificador del elemento.
     * @return Lista de elementos configurados.
     */
    List<WebElement> findsTag(String locator);

    /**
     * Cierra proceso de browser,
     */
    void quit();

    /**
     * Obtiene el titulo de la pagina.
     *
     * @return Título de la página actual
     */
    String getTitle();

    /**
     * Genera captura de pantalla.
     *
     * @return Captura de pantalla en base64.
     */
    String getScreenshot();

    /**
     * Navega a una determinada url.
     *
     * @param url URL de ambiente de trabajo.
     */
    void navigateTo(String url);

    /**
     * Se posiciona en una alerta.
     *
     * @return Alerta del sistema.
     */
    Alert switchToAlert();

    /**
     * Acepta alerta.
     *
     * @param alert Alerta existente.
     */
    void acceptAlert(Alert alert);

    /**
     * Se mueve a un frame.
     *
     * @param index Indice de frame.
     */
    void switchToFrame(int index);

    /**
     * Se mueve a un frame.
     *
     * @param nameOrId Name o Id de frame.
     */
    void switchToFrame(String nameOrId);

    /**
     * Se mueve a un frame.
     *
     * @param element Elemento de frame.
     */
    void switchToFrame(WebElement element);

    /**
     * Se mueve a frame origianl.
     */
    void switchToDefaultContent();

    /**
     * Obtiene ventana actual.
     *
     * @return Identificador de ventanas.
     */
    String getWindowHandle();

    /**
     * Conjunto de ventanas.
     *
     * @return Set de ventanas.
     */
    Set<String> getWindowHandles();

    /**
     * Cambia el DriverInstance.getInstance().browser() de pantalla, usualmente una segunda pantalla tiene como indexWindows=1.
     *
     * @param indexWindows Indice de pantalla, usualmente indexWindows=1
     */
    void switchToWindow(int indexWindows);

    /**
     * Ejecuta código JavaScript.
     *
     * @param script Código JavaScript.
     */
    void javaScriptExecutor(String script);

    /**
     * Ejecuta código JavaScript sobre un objeto.
     *
     * @param script  Código JavaScript.
     * @param element Objecto para aplicar código JavaScript.
     */
    void javaScriptExecutor(String script, Object element);

    /**
     * Espera 1 segundo.
     */
    void sleep();

    /**
     * Espera los segundo indicados.
     *
     * @param seconds Segundos a esperar.
     */
    void sleep(int seconds);

    /**
     * Espera hasta que el elemento identificado por el locator esté presente en la página.
     *
     * @param locator El locator que identifica el elemento.
     */
    void waitId(String locator);

    /**
     * Espera hasta que el elemento identificado por el locator esté presente en la página.
     *
     * @param locator El locator que identifica el elemento.
     */
    void waitName(String locator);

    /**
     * Espera hasta que el elemento identificado por el locator esté presente en la página.
     *
     * @param locator El locator que identifica el elemento.
     */
    void waitCss(String locator);

    /**
     * Espera hasta que el elemento identificado por el locator esté presente en la página.
     *
     * @param locator El locator que identifica el elemento.
     */
    void waitXpath(String locator);

    /**
     * Espera hasta que el elemento identificado por el locator esté presente en la página.
     *
     * @param locator El locator que identifica el elemento.
     */
    void waitLink(String locator);

    /**
     * Espera hasta que el elemento identificado por el locator esté presente en la página.
     *
     * @param locator El locator que identifica el elemento.
     */
    void waitPartialLink(String locator);

    /**
     * Espera hasta que el elemento identificado por el locator esté presente en la página.
     *
     * @param locator El locator que identifica el elemento.
     */
    void waitClassName(String locator);

    /**
     * Espera hasta que el elemento identificado por el locator esté presente en la página.
     *
     * @param locator El locator que identifica el elemento.
     */
    void waitTag(String locator);
}