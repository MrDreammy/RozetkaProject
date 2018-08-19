package ua.com.rozetka.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ua.com.rozetka.pages.MainPage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class ComparePageTest {
    private static WebDriver driver = new ChromeDriver();
    private static Properties config = new Properties();
    private MainPage mainPage = new MainPage();
    static String siteAddress = config.getProperty("site.address.rozetka");
    public String productType;
    private static Logger logger = Logger.getLogger(ComparePageTest.class);

    @BeforeClass
    public static void setUp() throws IOException {
        InputStream file = new FileInputStream("src/test/java/ua/com/rozetka/config/сonfig.properties");
        config.load(file);

        String driverType = config.getProperty("driver.type");
        String driverAddress = config.getProperty("driver.address");
        String siteAddress = config.getProperty("site.address.rozetka");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        System.setProperty(driverType, driverAddress);
        driver.get(siteAddress);
    }

    @Test


    @After
    public void tearDown(){
        driver.get(siteAddress);
    }


}
