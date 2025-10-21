package tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import tatf.core.properties.IPropertyReader;
import tatf.systems.adminces.facade.Fachada;

public class CrearCuentaAdminParametrizado {

    private static Fachada sistema;

    private static String sitioWeb;

    @BeforeAll
    public static void setUp (){

        sistema = new Fachada();

        String filePath = "src/test/resources/";
        String fileValues = "valores.pruebas.properties";
        IPropertyReader valores = IPropertyReader.create(filePath, fileValues);
        sitioWeb = valores.getValue("ambiente.url");

        sistema
                .entrarSitio(valores.getValue("ambiente.url"), valores.getValue("ambiente.contrasenia"))
                .validarTituloHome(valores.getValue("test_aceso_sitio.test_aceso_sitio.titulo.home"));
    }

    @AfterAll
    public static void tearDown () { sistema.cerrarNavegador(); }

    @ParameterizedTest(name = "{arguments}")
    @CsvFileSource(resources = "/datos_crearUserAdmin.csv", useHeadersInDisplayName = true)
    void crearCuentaAdministrador (String msgCuentaCreada,
                                   String msgError,
                                   String msgSesionIniciada,
                                   String userCES,
                                   String userCESpass,
                                   String nombre,
                                   String apellido,
                                   String pais){
        sistema
                .entrarEnRegistrarse()
                .crearCuentaAdmin(nombre, apellido,userCES, userCESpass, pais)
                .validarMensajeAlerta(msgCuentaCreada, msgError)
                .entrarEnIniciarSesion()
                .ingresarDatosIS(userCES, userCESpass)
                .validarMensajeAlerta(msgSesionIniciada, msgError)
                .cerrarSesion(nombre +" "+ apellido)
                .validarMensajeAlerta("Te quieres ir?",msgError)
                .validarMensajeAlerta("Sesión cerrada.", msgError);
    }
}
