package app.support.utils;

import consolecolor.ColorConsole;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import app.support.devices.Devices;
import app.support.loadproperties.LoadProperty;
import report.Report;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class WaitUtils {

    private final int explicitWait = Integer.parseInt(LoadProperty.CONFIGURATION.getProperty("expliciWait"));

    /**
     * This method is for static wait
     *
     * @param millis
     */
    public void staticWait(final long millis) {
        try {
            TimeUnit.MILLISECONDS.sleep(millis);
            System.out.println(ColorConsole.ANSI_WHITE + "Tiempo de espera: " + millis + ColorConsole.ANSI_RESET);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * To wait for element to be invisible
     *
     * @param ele -> WebElement
     */
    /*
    public boolean waitForElementInvisible(final WebElement ele) {
        boolean a = new WebDriverWait(Devices.getDriver(), explicitWait)
                .until(ExpectedConditions.invisibilityOf(ele));
        if (a) {
            System.out.println(ColorConsole.ANSI_RED + "Se visualiza elemento: " + ele.toString() + ColorConsole.ANSI_RESET);
        } else {
            System.out.println(ColorConsole.ANSI_GREEN + "No se visualiza elemento: " + ele.toString() + ColorConsole.ANSI_RESET);
        }
        return a;
    }*/

    /**
     * To wait for given element to be present
     *
     * @param ele -> WebElement
     */
    /*
    public boolean waitForElementPresent(final WebElement ele) {

        WebElement el = new WebDriverWait(Devices.getDriver(), explicitWait)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(ele.toString())));

        if (el != null) {
            System.out.println(ColorConsole.ANSI_GREEN + "Se elemento presente: " + ele.toString() + ColorConsole.ANSI_RESET);
            return true;
        } else {
            System.out.println(ColorConsole.ANSI_RED + "No se presenta elemento: " + ele.toString() + ColorConsole.ANSI_RESET);
            return false;
        }
    }*/

    /**
     * To wait for element to be visible
     *
     * @param ele -> WebElement
     */
    /*
    public boolean waitForElementVisible(WebElement ele) {

        try {
            WebElement el = new WebDriverWait(Devices.getDriver(), explicitWait)
                    .until(ExpectedConditions.visibilityOf(ele));
            if (el != null) {
                System.out.println(ColorConsole.ANSI_GREEN + "Se visualiza elemento: " + ele.toString() + "."+ ColorConsole.ANSI_RESET);
                return true;
            } else {
                System.out.println(ColorConsole.ANSI_RED + "No se visualiza elemento: " + ele.toString() + ColorConsole.ANSI_RESET);
                return false;
            }
        }catch (Exception e){
            return false;
        }
    }
*/
    /**
     * Get only number for String
     */
    public Integer getNumber(String text) {
        char[] cade = text.toCharArray();
        String n = "";
        for (Integer i = 0; i < cade.length; i++) {
            if (Character.isDigit(cade[i])) {
                n += cade[i];
            }
        }
        return Integer.parseInt(n);
    }

    /**
     * Scroll down
     */
    public void scrollDown(WebElement element) throws Exception {
        try {
            Thread.sleep(1000);
            JavascriptExecutor js = (JavascriptExecutor) Devices.getDriver();

            js.executeScript("window.scrollBy(0," + (element.getSize().height) + ")");
        } catch (Exception e) {
            Report.FAILED("No se logro realizar el scroll.");
        }
    }

    /**
     * Se realiza mas de un scroll por la medida del elemento seleccionado
     * */
    public void scrollDown(WebElement element, int cant) throws Exception {
        try {
            Thread.sleep(1000);
            JavascriptExecutor js = Devices.getDriver();
            for (int i=0; i<=cant;i++){
                assert js != null;
                js.executeScript("window.scrollBy(0," + (element.getSize().height) + ")");
            }
        } catch (Exception e) {
            Report.FAILED("No se logro realizar el scroll.");
        }
    }

    /**
     * Validar si string es numero
     * @param s
     * @return boolean
     */
    public boolean isNumeric(String s)
    {

        try {
            Integer.parseInt(s);
        } catch (NumberFormatException ex) {
            return false;
        }
        return true;
    }


}
