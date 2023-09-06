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
    public void iniciarSession(){
        try {
            System.out.println("Llegue al iniciar sesion");

            if (Devices.getDriver() instanceof AndroidDriver){
                System.out.println("Flujo Android");
                Thread.sleep(3000);
                WebElement element = Devices.getDriver()
                        .findElements(AppiumBy.accessibilityId("BtnEnter_Automation")).get(0);
                element.click();

                System.out.println("Le hice click");
                Report.PASSED("hizo click Android");
            }
            if (Devices.getDriver() instanceof IOSDriver){
                System.out.println("Flujo iOS");
                WebElement element = Devices.getDriver()
                        .findElements(AppiumBy.accessibilityId("BtnEnter_Automation")).get(0);
                element.click();
                System.out.println("Le hice click");
                Report.PASSED("hizo click Android");
            }


        }catch (Exception e){
            System.out.printf("Fallo al click inicar sesion: "+e.getMessage());
        }

    }

    public void ingresoDeRut() throws InterruptedException, URISyntaxException, IOException {
        try {
            System.out.println("Llegamos a ingreso rut");

            WebElement element2 = Objects.requireNonNull(Devices.getDriver())
                    .findElements(AppiumBy.className("android.widget.EditText")).get(0);
            element2.sendKeys("186129466");
            System.out.println("Segundo elemento OK");


            WebElement element3 = Devices.getDriver()
                    .findElements(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.widget.FrameLayout/android.view.ViewGroup")).get(0);
            element3.click();
            System.out.println("Tercer elemento OK");
            Report.PASSED("Flujo login perfe");
        }catch (Exception e){
            Report.FAILED("Falle en los elementos del inicio sesion. "+e.getMessage());
        }



    }
}
