package tatf.systems.adminces.pom.login;

import tatf.core.browser.IBrowser;

public class IniciarSesionAdminPO {

    private final IBrowser browser;
    private final String ingresarEmail = "inputEmail";
    private final String contraseniaUser = "inputPassword";
    private final String btnIniciarSesion = "#formLogin > div.form-group > div.col-sm-6 > button";

    public IniciarSesionAdminPO(IBrowser browser) {this.browser = browser;}

    public void ingresarEmail (String usuarioCES) {

        this.browser.findName(ingresarEmail).sendKeys(usuarioCES);
    }

    public void ingresarContrasena (String passUsuarioCES) {

        this.browser.findName(contraseniaUser).sendKeys(passUsuarioCES);
    }

    public void clicBtnIS () {

        this.browser.findCss(btnIniciarSesion).click();
    }

}
