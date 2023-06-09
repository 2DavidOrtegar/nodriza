package app.support.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchElementInList {

    public static Boolean elementInListForXpathLocatorAndAttribute(List<WebElement> listEle, String xpathLocator, String identifyAttribute, String textValue){
        return listEle.stream().anyMatch(x -> x.findElement(By.xpath(xpathLocator)).getAttribute(identifyAttribute).equals(textValue));
    }

    public static Boolean elementInListForClassNameLocatorAndText(List<WebElement> listEle, String classNameLocator, String textValue){
        return listEle.stream().anyMatch(x -> x.findElement(By.className(classNameLocator)).getText().equals(textValue));
    }

    public static Boolean elementInListForIdLocatorAndText(List<WebElement> listEle, String idLocator, String textValue){
        return listEle.stream().anyMatch(x -> x.findElement(By.id(idLocator)).getText().equals(textValue));
    }


}
