package tatf.systems.adminces.pom.barraSuperior;

import tatf.core.browser.IBrowser;

public class BarraSuperiorPO {

    private final IBrowser browser;
    private final String menuIS = "a[href='/adminces']";
    private final String btnIS = "a[href='/adminces/login']";
    private final String btnPerfil = "a[href='/adminces/profile']";
    private final String btnCS = "Cerrar sesión";


    public BarraSuperiorPO(IBrowser browser) {
        this.browser = browser;
    }


    public void menuIniciarSesion () {
        this.browser.findCss(menuIS);
    }

    public void btnIniciarSesion () {
        this.browser.findCss(btnIS);
    }

    public void menuPerfil (String nombre) {
        this.browser.findLink(nombre).click();
    }

    public void btnPerfil () {this.browser.findCss(btnPerfil);}

    public void btnCerrarSesion () {this.browser.findLink(btnCS).click();}

}
