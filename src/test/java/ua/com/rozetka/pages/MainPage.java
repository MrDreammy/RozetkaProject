package ua.com.rozetka.pages;


        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.openqa.selenium.interactions.Actions;
        import org.openqa.selenium.support.FindBy;
        import org.openqa.selenium.support.ui.ExpectedCondition;
        import org.openqa.selenium.support.ui.ExpectedConditions;
        import org.openqa.selenium.support.ui.Select;
        import org.openqa.selenium.support.ui.WebDriverWait;

        import javax.swing.*;
        import java.util.List;
        import java.util.Properties;

public class MainPage {

    private static WebDriver driver = new ChromeDriver();

    Actions actions = new Actions(driver);
    private static Properties config = new Properties();
    private static String productType = "Ноутбуки";

    @FindBy(xpath = "//a[@data-title='Ноутбуки и компьютеры']")
    private WebElement navigationLinkNotebook;

    @FindBy(xpath = "//a[@class='f-menu-sub-title-link novisited']")
    private List<WebElement> mainPageSecondMenuList;


    public List<WebElement> getProductListLinks(WebElement) {
        actions.moveToElement(navigationLinkNotebook);
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfAllElements(mainPageSecondMenuList));
        return mainPageSecondMenuList;
    }


    public WebElement clickOnProductTypeInSecondMenu(List<WebElement>, String) {
        for (WebElement iterator : mainPageSecondMenuList) {
            if (iterator.getText().contains(productType)) {
                iterator.click();
                break;
            }
        }
        return new CombinedCharacteristicsProductPage;

    }
}


