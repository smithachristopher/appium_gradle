package driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class BaseClass {

    public AppiumDriver<MobileElement> driver;
    public Properties properties;
    public final String propertyFilePath= "C:\\Users\\HP\\IdeaProjects\\AppiumProject\\src\\test\\resources\\config.properties";


    @BeforeTest
    public void setup()throws MalformedURLException ,IOException {


        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }
        DesiredCapabilities cap =new DesiredCapabilities();
        cap.setCapability("deviceName","Galaxy S7");
        cap.setCapability("platformName","Android");
        cap.setCapability("platformVersion","8.0");
        cap.setCapability("automationName","appium");
        cap.setCapability("noReset","true");

        //application activity - install apk
        cap.setCapability("app","C:\\Users\\HP\\Downloads\\APKPure_v3.18.14_apkpure.com.apk");
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(url , cap);
        System.out.println("Application started");

        String sessionId =driver.getSessionId().toString();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


    }

    @AfterSuite
    public void tearDown() throws IOException {
        String folder_name="screenshot";
        File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        DateFormat df=new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
        new File(folder_name).mkdir();
        String file_name=df.format(new Date())+".png";
        FileUtils.copyFile(f, new File(folder_name + "/" + file_name));

        driver.quit();
    }
}

