package app.support.utils;

import app.support.devices.Devices;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class SupportJsEvent {

    public static void clickElement(WebElement e){
        JavascriptExecutor executor = (JavascriptExecutor) Devices.getDriver();
        executor.executeScript("arguments[0].click();", e);
    }
}
