package tatf.systems.adminces.pom.reiniciarContrasena;

import tatf.core.browser.IBrowser;

public class ReiniciarContrasenaPO {


    private final IBrowser browser;
    private final String ingresarEmail = "inputEmail";
    private final String kontrasenia = "inputPassword";
    private final String repeKontrasenia = "inputRepeatPassword";
    private final String btnReiniciarContrasenia = "btnReset";
    private final String yaTengoCuenta = "a[href='/adminces/login']";
    private final String volver = "return";
    private final String btnCrearCuenta = "a[href='/adminces/register']";

    public ReiniciarContrasenaPO(IBrowser browser) {
        this.browser = browser;
    }

    public void ingresarEmail (String email) {
        this.browser.findName(ingresarEmail).sendKeys(email);
    }
    public void ingresarContrasena (String passprueba) {
        this.browser.findName(kontrasenia).sendKeys(passprueba);
    }
    public void ingresarRepetirContrasena (String passprueba) {
        this.browser.findName(repeKontrasenia).sendKeys(passprueba);
    }
    public void clicBtnReiniciarContrasena () {
        this.browser.findId(btnReiniciarContrasenia).click();
    }
    public void clicBtnVolver () {
        this.browser.findId(volver).click();
    }
    public void clicBtnCC () {
        this.browser.findCss(btnCrearCuenta).click();
    }
    public void clicBtnYTC () {this.browser.findCss(yaTengoCuenta).click();
    }
}
