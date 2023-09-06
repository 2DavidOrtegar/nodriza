package app.pages.ppoc;

import app.support.devices.Devices;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import report.Report;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Objects;

public class Login {

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.widget.FrameLayout/android.view.ViewGroup")
    @iOSXCUITFindBy(accessibility = "id")
    private WebElement btnIniciarSesion;

    public Login() {

    }

    public void iniciarSession() {
        try {
            /**
            * Si el elemento que se utiliza posee accesibiliti id, es utilizable por ambas tecnologias
            * */
            System.out.println("Llegue al iniciar sesion");
            Thread.sleep(3500);
            if (Objects.requireNonNull(Devices.getDriver())
                    .findElement(AppiumBy.accessibilityId("Allow")) !=null){
                Devices.getDriver()
                        .findElement(AppiumBy.accessibilityId("Allow")).click();
                Report.PASSED("Hicimos click a Allow");
            }

            WebElement element = Objects.requireNonNull(Devices.getDriver())
                    .findElements(AppiumBy.accessibilityId("BtnEnter_Automation")).get(0);
            element.click();
            Report.PASSED("hizo click");
        } catch (Exception e) {
            System.out.printf("Fallo al click inicar sesion: " + e.getMessage());
        }

    }

    public void ingresoDeRut() throws InterruptedException, URISyntaxException, IOException {
        try {
            Report.PASSED("Flujo RUT");
            WebElement element2 = Objects.requireNonNull(Devices.getDriver())
                    .findElements(AppiumBy.accessibilityId("InputRutLogin_Automation")).get(0);
            element2.sendKeys("186129466");

            Report.PASSED("Rut ingresado");
            WebElement element3 = Devices.getDriver()
                    .findElements(AppiumBy.accessibilityId("BtnLogin_Automation")).get(0);
            element3.click();
            Report.PASSED("Flujo login perfe");

        } catch (Exception e) {
            Report.FAILED("Falle en los elementos del inicio sesion. " + e.getMessage());
        }


    }
}
