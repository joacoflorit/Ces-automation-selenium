package tatf.systems.adminces.pom.menuLateral;


import tatf.core.browser.IBrowser;

public class MenuLateralPO {
    private final IBrowser browser;
    private final String iniciarSesion = "a[href=\"/adminces/login\"].menu-effect-ces";
    private final String registrarse = "a[href=\"/adminces/register\"].menu-effect-ces";
    private final String reiniciarContrasenia = "a[href=\"/adminces/forgot-password\"].menu-effect-ces";
    private final String crearUsuario = "a[href=\"/adminces/create-user\"].menu-effect-ces";
    private final String verUsuarios = "a[href=\"/adminces/view-users\"].menu-effect-ces";


    public MenuLateralPO(IBrowser browser) {
        this.browser = browser;
    }

    private void clickMenu(String menu) {
        browser.findCss(menu).click();
    }

    public void clickEnIniciarSesion() {
        clickMenu(iniciarSesion);
    }

    public void clickEnRegistrarse() {
        clickMenu(registrarse);
    }

    public void clickReiniciarContrasenia() {
        clickMenu(reiniciarContrasenia);
    }

    public void clickCrearUsuario() {
        clickMenu(crearUsuario);
    }

    public void clickVerUsuarios() {
        clickMenu(verUsuarios);
    }



}