package base;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.io.File;
import java.time.Duration;

public class AppiumServer {

    private static AppiumDriverLocalService service;
    private static void buildAppiumService(){

        service = new AppiumServiceBuilder()
                .withAppiumJS(new File(System.getProperty("user.home") +
                        "\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .withTimeout(Duration.ofSeconds(30)).build();
    }

    private static AppiumDriverLocalService getAppiumService(){

        if (service == null){
            buildAppiumService();
        }

        return service;
    }


    protected static void initServer(){

        getAppiumService().start();
        System.out.println(service.getUrl());
        System.out.println("[i] Server Active Status: " + service.isRunning());
    }


    protected static void stopServer(){

        if (service != null){
            getAppiumService().stop();
        }

    }
}
