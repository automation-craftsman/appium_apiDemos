package base;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.time.Duration;

public class AppiumServer {

    public static AppiumDriverLocalService service;
    public static void buildAppiumService(){

        service = new AppiumServiceBuilder()
                .withAppiumJS(new File(System.getProperty("user.home") +
                        "\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .withTimeout(Duration.ofSeconds(30)).build();
    }

    public static AppiumDriverLocalService getAppiumService(){

        if (service == null){
            buildAppiumService();
        }

        return service;
    }

    @BeforeSuite
    public static void initServer(){

        getAppiumService().start();
        System.out.println(service.getUrl());
        System.out.println("[i] Server Active Status: " + service.isRunning());
    }

    @AfterSuite
    public static void stopServer(){

        if (service != null){
            getAppiumService().stop();
        }

    }
}
