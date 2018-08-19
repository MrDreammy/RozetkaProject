package ua.com.rozetka.tests;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ua.com.rozetka.pages.CombinedCharacteristicsProductPage;
import ua.com.rozetka.pages.MainPage;
import ua.com.rozetka.pages.ProductPage;
import ua.com.rozetka.pages.compare.ComparePage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class ComparePageTest {
    private static WebDriver driver = new ChromeDriver();
    private static Properties config = new Properties();
    static String siteAddress = config.getProperty("site.address.rozetka");
    public String productType;
MainPage mainPage = new MainPage();
ProductPage productPage = new ProductPage();
ComparePage comparePage = new ComparePage();
CombinedCharacteristicsProductPage combinedCharProductPage = new CombinedCharacteristicsProductPage();
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
       public void comparePageTest(){
        mainPage.getProductListLinks();
        mainPage.clickOnProductTypeInSecondMenu();
        combinedCharProductPage.getNotebookSsdPage();
        productPage.addProductInCombineList();
        productPage.goToComparePage();
        int countDifference = comparePage.getDiferenceOfTwoColumns();
        int rozetkaDifference = comparePage.getOnlyDifference();
        Assert.assertTrue("Разные данные на странице с характеристикам и на странице отличий",countDifference==rozetkaDifference);
    }


    @After
    public void tearDown(){
        driver.get(siteAddress);
    }


}
