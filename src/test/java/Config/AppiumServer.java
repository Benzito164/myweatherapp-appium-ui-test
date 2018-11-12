package Config;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import java.io.File;
import java.net.URL;

public class AppiumServer {

    static  AppiumDriverLocalService service;
    static URL url;

    public static void Start(){
        service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
                .withAppiumJS(new File("appium/build/lib/main.js"))
                .withIPAddress("127.0.0.1")
                .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
                .withArgument(GeneralServerFlag.LOG_LEVEL,"error")
                .usingPort(4723));
        url = service.getUrl();
        service.start();
    }

    public static void Stop(){
    service.stop();
    }
}
