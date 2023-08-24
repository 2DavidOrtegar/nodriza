package app.pages.ppoc;

import app.support.devices.Devices;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.Objects;

public class Login {

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.widget.FrameLayout/android.view.ViewGroup")
    @iOSXCUITFindBy(accessibility = "id")
    private WebElement btnIniciarSesion;




    public Login() {
        PageFactory.initElements(Devices.getDriver(), this);
    }
    public void iniciarSession(){
        try {
            System.out.println("Llegue al iniciar sesion");

            if (Devices.getDriver() instanceof AndroidDriver){
                System.out.println("Flujo Android");
                MobileElement el1 = (MobileElement) Devices.getDriver().findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.widget.FrameLayout/android.view.ViewGroup");
                el1.click();
                MobileElement el2 = (MobileElement) Devices.getDriver().findElementByClassName("android.widget.EditText");
                el2.sendKeys("186129466");
                MobileElement el3 = (MobileElement) Devices.getDriver().findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.widget.FrameLayout/android.view.ViewGroup");
                el3.click();
            }
            if (Devices.getDriver() instanceof IOSDriver){
                System.out.println("Flujo iOS");
                MobileElement el2 = (MobileElement) Devices.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name='Iniciar sesión']");
                el2.click();
                MobileElement el3 = (MobileElement) Devices.getDriver().findElementByClassName("XCUIElementTypeTextField");
                el3.sendKeys("186129466");
                MobileElement el5 = (MobileElement) Devices.getDriver().findElementByXPath("//XCUIElementTypeApplication[@name=\"Tapp Desa\"]/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[4]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther");
                el5.click();

            }


        }catch (Exception e){
            System.out.printf("Fallo al click inicar sesion: "+e.getMessage());
        }

    }
}
