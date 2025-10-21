package tatf.systems.adminces.pom.verUsuarios;


import tatf.core.verification.IVerify;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import tatf.core.browser.IBrowser;

import java.util.List;

public class UsuarioRegistradosPO {

    private final IBrowser browser;
    private final IVerify verify = IVerify.create();
    private final String tablaID = "dataTable";

    public UsuarioRegistradosPO(IBrowser browser) {this.browser = browser;}

    public void validarUsuarioEnTabla(String emailBuscado){
        WebElement tabla = this.browser.findId(tablaID);

        List<WebElement> filas = tabla.findElements(By.xpath(".//tbody/tr"));

        boolean usuarioEncontrado = false;

        for (WebElement fila : filas){
            String emailActual = fila.findElement(By.xpath(".//td[3]")).getText();
            if (emailActual.equals(emailBuscado)){
                usuarioEncontrado = true;
                break;
            }
        }
        //Validar que el usuario fue encontrado
        verify.verifyTrue(usuarioEncontrado, "El usuario con email " + emailBuscado + "no se encontró en la tabla");
    }

    public void clicEliminarTester(String emailBorrar){
        this.browser.findId(emailBorrar).click();

    }

    public void validarUsuarioEliminado(String emailBuscado){
        WebElement tabla = this.browser.findId(tablaID);

        List<WebElement> filas = tabla.findElements(By.xpath(".//tbody/tr"));

        boolean usuarioEncontrado = false;

        for (WebElement fila : filas){
            String emailActual = fila.findElement(By.xpath(".//td[3]")).getText();
            if (emailActual.equals(emailBuscado)){
                usuarioEncontrado = true;
                break;
            }
        }
        //Validar que el usuario fue encontrado
        verify.verifyFalse(usuarioEncontrado, "El usuario con email " + emailBuscado + " se encontró en la tabla");
    }

}
