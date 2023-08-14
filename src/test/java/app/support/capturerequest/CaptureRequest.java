package app.support.capturerequest;

//import org.openqa.selenium.devtools.DevTools;
//import org.openqa.selenium.devtools.v84.network.Network;


public class CaptureRequest {
    /*
    * Para que funcione esta clase se debe actualizar a la verson de Selenium 4.0.0-alpha-7
    * Y descomentar el codigo de esta clase.
     */
/*
    DevTools devTools;

    public void capureHttpRequest(){

        if (Browser.getDriver() instanceof ChromeDriver){
            devTools = ((ChromeDriver)Browser.getDriver()).getDevTools();
        }else if(Browser.getDriver() instanceof EdgeDriver){
            devTools = ((EdgeDriver)Browser.getDriver()).getDevTools();
        }

        devTools.createSession();
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

        devTools.addListener(Network.requestWillBeSent(),
                entry ->{
                    System.out.println("Request URL is: "+entry.getRequest().getUrl());
                    System.out.println("Request type is: "+entry.getRequest().getMethod());
                });



    }*/

}
