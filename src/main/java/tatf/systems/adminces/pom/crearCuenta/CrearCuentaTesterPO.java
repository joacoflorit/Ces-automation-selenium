package tatf.systems.adminces.pom.crearCuenta;

import tatf.core.browser.IBrowser;

public class CrearCuentaTesterPO {

    private final IBrowser browser;
    private final String olvideMiContrasenia = "a[href='/adminces/forgot-password']";
    private final String yaTengoCuenta = "a[href='/adminces/login']";
    private final String volver = "return";
    private final String registrarse = "btnRegister";
    private final String pais = "inputCountry";
    private final String testerNombre = "inputFirstName";
    private final String testerApellido = "inputLastName";
    private final String emailInput = "inputEmail";
    private final String kontrasenia = "inputPassword";
    private final String repeKontrasenia = "inputRepeatPassword";
    private final String tipoTester = "testerJunior"; // Posible testerSenior - testerLead

    public CrearCuentaTesterPO(IBrowser browser) {
        this.browser = browser;
    }


    public void ingresarNombre (String nombreTester) {
        this.browser.findName(testerNombre).sendKeys(nombreTester);
    }
    public void ingresarApellido (String apellidoTester) {
        this.browser.findName(testerApellido).sendKeys(apellidoTester);
    }
    public void ingresarEmail (String emailTester) {
        this.browser.findName(emailInput).sendKeys(emailTester);
    }
    public void ingresarContrasena (String passTester) {
        this.browser.findName(kontrasenia).sendKeys(passTester);
    }
    public void ingresarPaisNacimiento() {
        this.browser.findName(pais);
        this.browser.findCss("option[value='Uruguay']").click();
    }
    public void clicTipoTester () {
        this.browser.findId(tipoTester).click();
    }
    public void clicBtnCrearCuenta () {
        this.browser.findId(registrarse).click();
    }
    public void clicBtnVolver () {
        this.browser.findId(volver).click();
    }
}
