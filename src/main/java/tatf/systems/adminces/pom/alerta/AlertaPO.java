package tatf.systems.adminces.pom.alerta;

import tatf.core.browser.IBrowser;
import tatf.core.verification.IVerify;

public class AlertaPO {
    private final IVerify verify = IVerify.create();
    private final IBrowser browser;
    private final int waitSecond = 5;
    private final String msgEmergente = "#swal2-html-container";
    private final String btnOK = "/html/body/div[2]/div/div[6]/button[1]";

    public AlertaPO(IBrowser browser) {
        this.browser = browser;
    }

    public void validarMensaje(String msgEsperado, String msgError){
        this.browser.sleep(this.waitSecond);
        this.verify.verify(msgEsperado, this.browser.findCss(msgEmergente).getText(), msgError);
        this.browser.findXpath(btnOK).click();
    }

}