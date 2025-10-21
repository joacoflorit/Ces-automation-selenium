package tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import tatf.core.properties.IPropertyReader;
import tatf.systems.adminces.facade.Fachada;

public class EliminarCuentaTesterParametrizado {

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
        @CsvFileSource(resources = "/datos_eliminarCuentaTester.csv", useHeadersInDisplayName = true)
        void crearCuentaTester (String userCES,
                                String userCESpass,
                                String msgSesionIniciada,
                                String msgError,
                                String msgErrorTabla,
                                String emailTester,
                                String nombrePerfil){
            sistema
                    .entrarEnIniciarSesion()
                    .ingresarDatosIS(userCES, userCESpass)
                    .validarMensajeAlerta(msgSesionIniciada, msgError)
                    .clickVerUsuarios()
                    .validarUsuarioTabla(emailTester)
                    .eliminarUsuarioTabla(emailTester)
                    .validarMensajeAlerta("¿Eliminar usuario: " + emailTester + "?",msgErrorTabla)
                    .validarMensajeAlerta("Usuario eliminado.",msgError)
                    .validarUsuarioEliminado(emailTester)
                    .cerrarSesion(nombrePerfil)
                    .validarMensajeAlerta("Te quieres ir?",msgError)
                    .validarMensajeAlerta("Sesión cerrada.", msgError);
        }
    }

