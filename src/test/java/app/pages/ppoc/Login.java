package app.pages.ppoc;

import app.support.devices.Devices;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import report.Report;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Objects;

public class Login {

    public Login() {

    }

    public void iniciarSession() throws URISyntaxException, IOException {
        try {
            System.out.println("Llegue al iniciar sesion");
            Thread.sleep(3500);
            if (Devices.getDriver() instanceof IOSDriver){
                WebElement ele = Objects.requireNonNull(Devices.getDriver())
                        .findElement(AppiumBy.accessibilityId("Allow"));
                if (ele != null) {
                    Devices.getDriver()
                            .findElement(AppiumBy.accessibilityId("Allow")).click();
                    Report.PASSED("Hicimos click a Allow");
                }
                Thread.sleep(1000);
                WebElement element = Objects.requireNonNull(Devices.getDriver())
                        .findElements(AppiumBy.accessibilityId("BtnEnter_Automation")).get(0);
                element.click();
            }else {
                Thread.sleep(3500);
                long maxWaitTimeInSeconds = 30;
                long startTime = System.currentTimeMillis() / 1000;

                int cont =0;
                while ((System.currentTimeMillis() / 1000 - startTime) < maxWaitTimeInSeconds) {
                    try {
                        WebElement element = Objects.requireNonNull(Devices.getDriver())
                                                .findElement(By.id("com.android.permissioncontroller:id/permission_allow_button"));
                        element.click();
                        Report.PASSED("Hicimos click a Allow");
                        break;
                    } catch (Exception e) {
                        System.out.println("Contador de boton Allow notification");
                        if (cont==4){
                            break;
                        }
                    }
                    cont++;
                }
                Thread.sleep(1500);
                WebElement element = Objects.requireNonNull(Devices.getDriver())
                        .findElements(AppiumBy.accessibilityId("BtnEnter_Automation")).get(0);
                element.click();
            }
            Report.PASSED("hizo click");
        } catch (Exception e) {
            Report.FAILED("Fallo al click inicar sesion: " + e.getMessage());
        }

    }

    public void ingresoDeRut() throws URISyntaxException, IOException {
        try {
            Report.PASSED("Flujo RUT");
            WebElement element2;
            WebElement elementInput;

            if (Devices.getDriver() instanceof AndroidDriver) {
                Thread.sleep(3500);
                System.out.println("Flujo Android");
                element2 = Objects.requireNonNull(Devices.getDriver())
                        .findElements(AppiumBy.accessibilityId("InputRutLogin_Automation")).get(0);

                elementInput = element2.findElement(AppiumBy.className("android.widget.EditText"));
                elementInput.click();
                Thread.sleep(800);
                elementInput.sendKeys("186129466");

                ((AndroidDriver) Devices.getDriver()).hideKeyboard();
            } else {
                element2 = Objects.requireNonNull(Devices.getDriver())
                        .findElements(AppiumBy.accessibilityId("InputRutLogin_Automation")).get(0);
                element2.click();
                Thread.sleep(800);
                element2.sendKeys("186129466");
            }

            Report.PASSED("Rut ingresado");
            Thread.sleep(1800);
            WebElement element3 = Devices.getDriver()
                    .findElements(AppiumBy.accessibilityId("BtnLogin_Automation")).get(0);
            element3.click();
            Report.PASSED("Flujo login perfe");

        } catch (Exception e) {
            Report.FAILED("Falle en los elementos del ingresio rut. " + e.getMessage());
        }


    }
}
