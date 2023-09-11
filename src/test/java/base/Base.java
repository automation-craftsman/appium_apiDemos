package base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

public class Base extends AppiumServer {
    public static AppiumDriver driver;

    @BeforeSuite
    public static void setUp() throws MalformedURLException, URISyntaxException {

        initServer();

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("pixel");
        options.setPlatformName("Android");
        options.setApp(System.getProperty("user.dir") + "\\src\\test\\resources\\app\\API_Demos.apk");
//        options.setAppPackage("com.touchboarder.android.api.demos");
//        options.setAppActivity();

        driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterSuite
    public static void cleanUp(){
        driver.quit();
        stopServer();
    }


}
