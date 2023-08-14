package report;

import io.appium.java_client.AppiumDriver;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.openqa.selenium.remote.RemoteWebDriver;
import app.support.browsers.Browser;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;


public class ApiBrowserStack {

    //ejecuta la api de browserstack para cambiar el estado de la prueba
    public static void failed(String desc) throws URISyntaxException, IOException {
        String sessionsID = ((RemoteWebDriver) Browser.getDriver()).getSessionId().toString();
        URI uri = new URI("https://"+Browser.USERNAME+":"+Browser.AUTOMATE_KEY+"@api.browserstack.com/app-automate/sessions/" + sessionsID + ".json");
        HttpPut putRequest = new HttpPut(uri);

        ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
        nameValuePairs.add((new BasicNameValuePair("status", "failed")));
        nameValuePairs.add((new BasicNameValuePair("reason", desc)));
        putRequest.setEntity(new UrlEncodedFormEntity(nameValuePairs));

        HttpClientBuilder.create().build().execute(putRequest);
    }


    public static void passed(String desc) throws URISyntaxException, IOException {
        String sessionsID = Browser.getDriver().getSessionId().toString();
        URI uri = new URI("https://"+Browser.USERNAME+":"+Browser.AUTOMATE_KEY+"@api.browserstack.com/app-automate/sessions/" + sessionsID + ".json");
        HttpPut putRequest = new HttpPut(uri);

        ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
        nameValuePairs.add((new BasicNameValuePair("status", "passed")));
        nameValuePairs.add((new BasicNameValuePair("reason", desc)));
        putRequest.setEntity(new UrlEncodedFormEntity(nameValuePairs));

        HttpClientBuilder.create().build().execute(putRequest);
    }
}
