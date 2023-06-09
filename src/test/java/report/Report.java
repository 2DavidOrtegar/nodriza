package report;

import consolecolor.ColorConsole;
import org.testng.Assert;
import app.support.browsers.Browser;

import java.io.IOException;
import java.net.URISyntaxException;

public class Report {

    public static void PASSED(String msj) throws URISyntaxException, IOException {
        ApiBrowserStack.passed(msj);
        System.out.println(ColorConsole.ANSI_GREEN+msj+ColorConsole.ANSI_RESET);
        /**
         * Metodo Asser queda en true fijo, ya que el valor booleano para esta condicion
         * Se encuentra en un metodo una capa mas arriba
         * */
        Assert.assertTrue(true, msj);
    }

    public static void FAILED(String msj) throws URISyntaxException, IOException {
        ApiBrowserStack.failed(msj);
        System.out.println(ColorConsole.ANSI_CYAN+msj+ColorConsole.ANSI_RESET);
        Assert.fail(msj);
        Browser.getDriver().quit();
    }

}
