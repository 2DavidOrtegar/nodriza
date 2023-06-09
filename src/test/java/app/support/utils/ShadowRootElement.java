package app.support.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ShadowRootElement {

    /**
     * Shadow-root
     */


    public static WebElement shadowRootElementForID(WebElement ele, String idLocator) {
        SearchContext sc = ele.getShadowRoot();
        WebElement el = sc.findElement(By.id(idLocator));
        return el;
    }
    public static List<WebElement> shadowRootElementsForID(WebElement ele, String idLocator) {
        SearchContext sc = ele.getShadowRoot();
        List<WebElement> el = sc.findElements(By.id(idLocator));
        return el;
    }

    public static WebElement shadowRootElementForTAGNAME(WebElement ele, String tagNameLocator) {
        SearchContext sc = ele.getShadowRoot();
        WebElement el = sc.findElement(By.tagName(tagNameLocator));
        return el;
    }

    public static WebElement shadowRootElementForTAGNAMEAndId(WebElement ele, String idLocator) {
        SearchContext sc = ele.getShadowRoot();
        WebElement el = sc.findElement(By.id(idLocator));
        return el;
    }

    public static WebElement shadowRootElementForXPATH(WebElement ele, String xpathLocator) {
        SearchContext sc = ele.getShadowRoot();
        WebElement el = sc.findElement(By.xpath(xpathLocator));
        return el;
    }
    public static WebElement shadowRootElementForXPATHAndId(WebElement ele, String idLocator) {
        SearchContext sc = ele.getShadowRoot();
        WebElement el = sc.findElement(By.id(idLocator));
        return el;
    }

    public static WebElement shadowRootElementForCLASSNAME(WebElement ele, String classNameLocator) {
        SearchContext sc = ele.getShadowRoot();
        WebElement el = sc.findElement(By.className(classNameLocator));
        return el;
    }
    public static List<WebElement> shadowRootElementsForCLASSNAME(WebElement ele, String classNameLocator) {
        SearchContext sc = ele.getShadowRoot();
        List<WebElement> el = sc.findElements(By.className(classNameLocator));
        return el;
    }

}
