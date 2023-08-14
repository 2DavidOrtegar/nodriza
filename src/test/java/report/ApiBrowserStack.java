package report;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.openqa.selenium.remote.RemoteWebDriver;
import app.support.devices.Devices;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;


public class ApiBrowserStack {

    //ejecuta la api de browserstack para cambiar el estado de la prueba
    public static void failed(String desc) throws URISyntaxException, IOException {
        String sessionsID = ((RemoteWebDriver) Devices.getDriver()).getSessionId().toString();
        URI uri = new URI("https://"+ Devices.USERNAME+":"+ Devices.AUTOMATE_KEY+"@api.browserstack.com/app-automate/sessions/" + sessionsID + ".json");
        HttpPut putRequest = new HttpPut(uri);

        ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
        nameValuePairs.add((new BasicNameValuePair("status", "failed")));
        nameValuePairs.add((new BasicNameValuePair("reason", desc)));
        putRequest.setEntity(new UrlEncodedFormEntity(nameValuePairs));

        HttpClientBuilder.create().build().execute(putRequest);
    }


    public static void passed(String desc) throws URISyntaxException, IOException {
        String sessionsID = Devices.getDriver().getSessionId().toString();
        URI uri = new URI("https://"+ Devices.USERNAME+":"+ Devices.AUTOMATE_KEY+"@api.browserstack.com/app-automate/sessions/" + sessionsID + ".json");
        HttpPut putRequest = new HttpPut(uri);

        ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
        nameValuePairs.add((new BasicNameValuePair("status", "passed")));
        nameValuePairs.add((new BasicNameValuePair("reason", desc)));
        putRequest.setEntity(new UrlEncodedFormEntity(nameValuePairs));

        HttpClientBuilder.create().build().execute(putRequest);
    }
}
