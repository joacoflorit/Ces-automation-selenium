package tatf.systems.adminces.pom.crearCuenta;

import tatf.core.browser.IBrowser;

public class CrearCuentaAdminPO {


    private final IBrowser browser;
    private final String olvideMiContrasenia = "a[href='/adminces/forgot-password']";
    private final String yaTengoCuenta = "a[href='/adminces/login']";
    private final String volver = "return";
    private final String registrarse = "btnRegister";
    private final String pais = "inputCountry";
    private final String nombre = "inputFirstName";
    private final String apellido = "inputLastName";
    private final String emailInput = "inputEmail";
    private final String kontrasenia = "inputPassword";
    private final String repeKontrasenia = "inputRepeatPassword";

    public CrearCuentaAdminPO(IBrowser browser) {this.browser = browser;}


    public void ingresarNombre (String name) {
        this.browser.findName(nombre).sendKeys(name);
    }
    public void ingresarApellido (String lastname) {
        this.browser.findName(apellido).sendKeys(lastname);
    }
    public void ingresarEmail (String email) {
        this.browser.findName(emailInput).sendKeys(email);
    }
    public void ingresarContrasena (String passprueba) {
        this.browser.findName(kontrasenia).sendKeys(passprueba);
    }
    public void ingresarRepetirContrasena (String passprueba) {
        this.browser.findName(repeKontrasenia).sendKeys(passprueba);
    }
    public void ingresarPaisNacimiento (String country) {
        this.browser.findName(pais).sendKeys(country);
    }
    public void clicBtnRegistrarse () {
        this.browser.findId(registrarse).click();
    }
    public void clicBtnVolver () {
        this.browser.findId(volver).click();
    }
    public void clicBtnOMC () {
        this.browser.findCss(olvideMiContrasenia).click();
    }
    public void clicBtnYTC () {
        this.browser.findCss(yaTengoCuenta).click();
    }
}
