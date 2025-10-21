package tatf.systems.adminces.facade;

import tatf.core.browser.IBrowser;
import tatf.core.driver.manager_singlenton.DriverManagerSinglenton;
import tatf.core.verification.IVerify;
import tatf.systems.adminces.pom.barraSuperior.BarraSuperiorPO;
import tatf.systems.adminces.pom.login.IngresoSitioPO;
import tatf.systems.adminces.pom.login.IniciarSesionAdminPO;
import tatf.systems.adminces.pom.menuLateral.MenuLateralPO;
import tatf.systems.adminces.pom.alerta.AlertaPO;
import tatf.systems.adminces.pom.crearCuenta.CrearCuentaAdminPO;
import tatf.systems.adminces.pom.crearCuenta.CrearCuentaTesterPO;
import tatf.systems.adminces.pom.reiniciarContrasena.ReiniciarContrasenaPO;
import tatf.systems.adminces.pom.verUsuarios.UsuarioRegistradosPO;
import org.openqa.selenium.WebDriver;

public class Fachada {
    private final String tituloIncorrecto = "Título incorrecto.";
    private final int waitSeconds = 10;
    private final WebDriver driver = DriverManagerSinglenton.getInstance().getDriver();
    private final IVerify verify = IVerify.create();
    private final IBrowser browser;
    private final IngresoSitioPO ingresoSitio;
    private final MenuLateralPO menu;
    private final CrearCuentaAdminPO ingresarDatosAdmin;
    private final CrearCuentaTesterPO ingresarDatosTester;
    private final IniciarSesionAdminPO ingresarDatosIS;
    private final AlertaPO alertaPO;
    private final ReiniciarContrasenaPO ingresarDatosRC;
    private final UsuarioRegistradosPO verTablaUsuarios;
    private final BarraSuperiorPO barraSuperior;

    public Fachada() {
        browser = IBrowser.create(waitSeconds, driver);
        ingresoSitio = new IngresoSitioPO(browser);
        menu = new MenuLateralPO(browser);
        ingresarDatosAdmin = new CrearCuentaAdminPO(browser);
        ingresarDatosTester = new CrearCuentaTesterPO(browser);
        ingresarDatosIS = new IniciarSesionAdminPO(browser);
        alertaPO = new AlertaPO(browser);
        ingresarDatosRC = new ReiniciarContrasenaPO(browser);
        verTablaUsuarios = new UsuarioRegistradosPO(browser);
        barraSuperior = new BarraSuperiorPO(browser);
    }

    public Fachada entrarSitio(String url, String contrasenia) {
        browser.navigateTo(url);
        ingresoSitio.ingresarContrasenia(contrasenia);
        ingresoSitio.clickBotonIngresar();
        return this;
    }

    public Fachada validarTituloHome(String tituloEsperado) {
        String tituloActual = browser.findCss("nav>p").getText();
        verify.verify(tituloEsperado, tituloActual, tituloIncorrecto);
        return this;
    }

    public Fachada validarTitulos(String tituloEsperado) {
        this.browser.sleep(5);
        String tituloActual = this.browser.findTag("h5").getText();

        verify.verify(tituloEsperado, tituloActual, tituloIncorrecto);
        return this;
    }

    public Fachada entrarEnIniciarSesion() {
        this.browser.sleep(5);
        menu.clickEnIniciarSesion();

        String tituloEsperado = "INICIAR SESIÓN ADMINISTRADOR";
        String tituloActual = this.browser.findTag("h5").getText();

        verify.verify(tituloEsperado, tituloActual, tituloIncorrecto);
        return this;
    }

    public Fachada entrarEnRegistrarse() {
        this.browser.sleep(5);
        menu.clickEnRegistrarse();

        String tituloEsperado = "CREAR CUENTA ADMINISTRADOR";
        String tituloActual = this.browser.findTag("h5").getText();

        verify.verify(tituloEsperado, tituloActual, tituloIncorrecto);
        return this;
    }

    public Fachada entrarEnReiniciarContrasenia() {
        this.browser.sleep(5);
        menu.clickReiniciarContrasenia();

        String tituloEsperado = "REINICIAR CONTRASEÑA";
        String tituloActual = this.browser.findTag("h5").getText();

        verify.verify(tituloEsperado, tituloActual, tituloIncorrecto);
        return this;
    }

    public Fachada entrarEnCrearUsuario() {
        this.browser.sleep(5);
        menu.clickCrearUsuario();

        String tituloEsperado = "ALTA DE CUENTA PARA TESTER";
        String tituloActual = this.browser.findTag("h5").getText();

        verify.verify(tituloEsperado, tituloActual, tituloIncorrecto);
        return this;
    }

    public Fachada clickVerUsuarios() {
        this.browser.sleep(5);
        menu.clickVerUsuarios();

        String tituloEsperado = "USUARIOS REGISTRADOS EN EL SISTEMA";
        String tituloActual = this.browser.findTag("h4").getText();

        verify.verify(tituloEsperado, tituloActual, tituloIncorrecto);
        return this;
    }

    public Fachada crearCuentaAdmin(String nombre,
                                    String apellido,
                                    String email,
                                    String contrasena,
                                    String pais) {
        ingresarDatosAdmin.ingresarNombre(nombre);
        ingresarDatosAdmin.ingresarApellido(apellido);
        ingresarDatosAdmin.ingresarEmail(email);
        ingresarDatosAdmin.ingresarContrasena(contrasena);
        ingresarDatosAdmin.ingresarRepetirContrasena(contrasena);
        ingresarDatosAdmin.ingresarPaisNacimiento(pais);
        ingresarDatosAdmin.clicBtnRegistrarse();

        return this;
    }

    public Fachada validarMensajeAlerta(String mensajeEsperado,String mensajeError) {
        alertaPO.validarMensaje(mensajeEsperado,mensajeError);
        return this;
    }

    public Fachada crearCuentaTester(String nombre,
                                     String apellido,
                                     String email,
                                     String contrapass) {
        ingresarDatosTester.ingresarNombre(nombre);
        ingresarDatosTester.ingresarApellido(apellido);
        ingresarDatosTester.ingresarEmail(email);
        ingresarDatosTester.ingresarContrasena(contrapass);
        ingresarDatosTester.ingresarPaisNacimiento();
        ingresarDatosTester.clicTipoTester();
        ingresarDatosTester.clicBtnCrearCuenta();

        return this;
    }

    public Fachada ingresarDatosIS(String userCES, String userCESpass) {
        ingresarDatosIS.ingresarEmail(userCES);
        ingresarDatosIS.ingresarContrasena(userCESpass);
        ingresarDatosIS.clicBtnIS();

        return this;
    }

    public Fachada ingresarDatosRC(String email,
                                   String contrasena) {
        ingresarDatosRC.ingresarEmail(email);
        ingresarDatosRC.ingresarContrasena(contrasena);
        ingresarDatosRC.ingresarRepetirContrasena(contrasena);
        ingresarDatosRC.clicBtnReiniciarContrasena();
        return this;
    }
    public Fachada validarUsuarioTabla(String email){
            verTablaUsuarios.validarUsuarioEnTabla(email);
        return this;
    }

    public Fachada validarUsuarioEliminado(String email){
        verTablaUsuarios.validarUsuarioEliminado(email);
        return this;
    }

    public Fachada eliminarUsuarioTabla (String emailBorrar){
        verTablaUsuarios.clicEliminarTester(emailBorrar);
        return this;
    }

    public Fachada cerrarNavegador() {
        browser.quit();
        return this;
    }

    public Fachada cerrarSesion (String nombrePerfil){
        barraSuperior.menuPerfil(nombrePerfil);
        barraSuperior.btnCerrarSesion();
        return this;
    }
}
