package app.support.loadproperties;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoadProperty {

    public static Properties BROWSER;
    public static Properties BROWSERSTACK;
    public static Properties BUILD;
    public static Properties OS;
    public static Properties URLs;
    public static Properties DATA;
    public static Properties CONFIGURATION;

    public static Properties TEXT_VALIDATION;

    public static Properties IMAGES_DIRECTIONS;
    public static Properties USER_CAMPANA;

    public static Properties PATHS;


    public static void runProperties() {
        try {
            InputStream browser = new FileInputStream("src/test/resources/browser.properties");
            BROWSER = new Properties();
            BROWSER.load(browser);
        } catch (IOException io) {
            System.out.println(io.getMessage());
        }

        try {
            InputStream browserStack = new FileInputStream("src/test/resources/browserstack.properties");
            BROWSERSTACK = new Properties();
            BROWSERSTACK.load(browserStack);
        } catch (IOException io) {
            System.out.println(io.getMessage());
        }

        try {
            InputStream build = new FileInputStream("src/test/resources/build.properties");
            BUILD = new Properties();
            BUILD.load(build);
        } catch (IOException io) {
            System.out.println(io.getMessage());
        }

        try {
            InputStream os = new FileInputStream("src/test/resources/os.properties");
            OS = new Properties();
            OS.load(os);
        } catch (IOException io) {
            System.out.println(io.getMessage());
        }

        try {
            InputStream urls = new FileInputStream("src/test/resources/urls.properties");
            URLs = new Properties();
            URLs.load(urls);
        } catch (IOException io) {
            System.out.println(io.getMessage());
        }

        try {
            InputStream paths = new FileInputStream("src/test/resources/paths.properties");
            PATHS = new Properties();
            PATHS.load(paths);
        } catch (IOException io) {
            System.out.println(io.getMessage());
        }

        try {
            InputStream data = new FileInputStream("src/test/resources/data.properties");
            DATA = new Properties();
            DATA.load(data);
        } catch (IOException io) {
            System.out.println(io.getMessage());
        }

        try {
            InputStream data = new FileInputStream("src/test/resources/configuration.properties");
            CONFIGURATION = new Properties();
            CONFIGURATION.load(data);
        } catch (IOException io) {
            System.out.println(io.getMessage());
        }

        try {
            InputStream data = new FileInputStream("src/test/resources/textvalidations.properties");
            TEXT_VALIDATION = new Properties();
            TEXT_VALIDATION.load(data);
        } catch (IOException io) {
            System.out.println(io.getMessage());
        }

        try {
            InputStream imagesDirections = new FileInputStream("src/test/resources/imagesdirections.properties");
            IMAGES_DIRECTIONS = new Properties();
            IMAGES_DIRECTIONS.load(imagesDirections);
        } catch (IOException io) {
            System.out.println(io.getMessage());
        }

        try {
            InputStream userCampana = new FileInputStream("src/test/resources/usercampana.properties");
            USER_CAMPANA = new Properties();
            USER_CAMPANA.load(userCampana);
        } catch (IOException io) {
            System.out.println(io.getMessage());
        }

    }

}
