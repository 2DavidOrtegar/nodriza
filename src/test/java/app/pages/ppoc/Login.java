package app.pages.ppoc;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class Login {

    @AndroidFindBy(id = "id")
    @iOSXCUITFindBy(accessibility = "id")
    private WebElement element;
}
