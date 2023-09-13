package app.pages.ppoc;

import app.support.devices.Devices;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import report.Report;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;

public class Login {

    public Login() {

    }

    public void iniciarSession() throws URISyntaxException, IOException {
        try {
            System.out.println("Llegue al iniciar sesion");
            Thread.sleep(3500);
            if (Devices.getDriver() instanceof IOSDriver) {
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
            } else {
                long maxWaitTimeInSeconds = 30;
                long startTime = System.currentTimeMillis() / 1000;

                int cont = 0;
                Thread.sleep(4500);
                while ((System.currentTimeMillis() / 1000 - startTime) < maxWaitTimeInSeconds) {
                    try {
                        WebElement element = Objects.requireNonNull(Devices.getDriver())
                                .findElement(By.id("com.android.permissioncontroller:id/permission_allow_button"));
                        element.click();
                        Report.PASSED("Hicimos click a Allow");
                        break;
                    } catch (Exception e) {
                        Report.PASSED("Contador de boton Allow notification: "+cont);
                        if (cont == 4) {
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
                elementInput.sendKeys("13075516K");
                Report.PASSED("Rut ingresado - Flujo Android login perfe");
                ((AndroidDriver) Devices.getDriver()).hideKeyboard();

                Thread.sleep(800);
                WebElement element3 = Devices.getDriver()
                        .findElements(AppiumBy.accessibilityId("BtnLogin_Automation")).get(0);
                element3.click();
            } else {
                element2 = Objects.requireNonNull(Devices.getDriver())
                        .findElements(AppiumBy.accessibilityId("InputRutLogin_Automation")).get(0);
                element2.click();
                element2.sendKeys("13075516K");
                Thread.sleep(800);
                ((IOSDriver) Devices.getDriver()).hideKeyboard("Go");
                Report.PASSED("Rut ingresado - Flujo iOS login perfe");
                Thread.sleep(1800);
            }
        } catch (Exception e) {
            Report.FAILED("Falle en los elementos del ingresio rut. " + e.getMessage());
        }
    }

    public void ingresoDeRut(String rut) throws URISyntaxException, IOException {
        try {
            Report.PASSED("Flujo RUT");
            WebElement element2;

            if (Devices.getDriver() instanceof AndroidDriver) {
                Thread.sleep(3500);
                System.out.println("Flujo Android");

                WebElement el3 = Devices.getDriver().findElement(By.className("android.widget.EditText"));
                el3.click();
                el3.sendKeys(rut);

                Report.PASSED("Rut ingresado - Flujo Android login perfe");
                ((AndroidDriver) Devices.getDriver()).hideKeyboard();

                WebElement element3 = Devices.getDriver()
                        .findElements(AppiumBy.accessibilityId("BtnLogin_Automation")).get(0);
                element3.click();
            } else {
                element2 = Objects.requireNonNull(Devices.getDriver())
                        .findElements(AppiumBy.accessibilityId("InputRutLogin_Automation")).get(0);
                element2.click();
                element2.sendKeys(rut);
                ((IOSDriver) Devices.getDriver()).hideKeyboard("Go");
                Report.PASSED("Rut ingresado - Flujo iOS login perfe");
            }
        } catch (Exception e) {
            Report.FAILED("Falle en los elementos del ingresio rut. " + e.getMessage());
        }
    }

    public void ingresoCredenciales() throws InterruptedException, URISyntaxException, IOException {
        Thread.sleep(6000);

        if (Devices.getDriver() instanceof IOSDriver){
            System.out.println("Ingreso IOS");
            WebElement btn1 = Objects.requireNonNull(Devices.getDriver()).findElement(AppiumBy.accessibilityId("KeyDigit_1_Automation"));
            WebElement btn2 = Objects.requireNonNull(Devices.getDriver()).findElement(AppiumBy.accessibilityId("KeyDigit_2_Automation"));
            WebElement btn3 = Objects.requireNonNull(Devices.getDriver()).findElement(AppiumBy.accessibilityId("KeyDigit_3_Automation"));
            WebElement btn4 =  Objects.requireNonNull(Devices.getDriver()).findElement(AppiumBy.accessibilityId("KeyDigit_4_Automation"));

            btn1.click();
            Thread.sleep(200);
            btn2.click();
            Thread.sleep(200);
            btn3.click();
            Thread.sleep(200);
            btn4.click();

            Thread.sleep(10000);
            Report.PASSED("Clave Ingresada - Flujo IOS - Exitoso");
        }else{
            System.out.println("Ingreso Android");
            List<WebElement> btn1 = Objects.requireNonNull(Devices.getDriver()).findElements(AppiumBy.className("android.widget.TextView"));

            btn1.get(0).click();
            btn1.get(2).click();
            btn1.get(4).click();
            btn1.get(1).click();

            Report.PASSED("Clave Ingresada - Flujo Android - Exitoso");
            Thread.sleep(10000);
        }
    }
}
