package tatf.systems.adminces.pom.login;

import tatf.core.browser.IBrowser;

public class IngresoSitioPO {
    private final IBrowser browser;
    private final String pass = "pass";
    private final String botonIngresar = "#loginForm > div.btns > button";

    public IngresoSitioPO(IBrowser browser) {
        this.browser = browser;
    }

    public void ingresarContrasenia(String contrsenia) {
        browser.findId(pass).sendKeys(contrsenia);
    }

    public void clickBotonIngresar() {
        browser.findCss(botonIngresar).click();
    }
}
