package ua.com.rozetka.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CombinedCharacteristicsProductPage {

    private static WebDriver driver = new ChromeDriver();
    Actions actions = new Actions(driver);
    private WebElement element;

    @FindBy(xpath = "//img[@title='Ноутбуки с SSD']")
    private WebElement notebookSsd;

    public void getNotebookSsdPage (){
        notebookSsd.click();
    }
}
