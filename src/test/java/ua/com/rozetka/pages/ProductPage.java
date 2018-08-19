package ua.com.rozetka.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ua.com.rozetka.pages.compare.ComparePage;

import java.util.List;

public class ProductPage {

    private static WebDriver driver = new ChromeDriver();

    @FindBy (xpath = "//span[@class='sprite g-compare-icon']")
    private List<WebElement> notebookSsdList;
    @FindBy (xpath = "//div[@name='splash-button']")
    private WebElement checkproductLink;
    @FindBy (xpath = "//div[@class='btn-link-to-compare']")
    private WebElement comparePageButton;

    public void addProductInCombineList() {
        notebookSsdList.get(0).click();
        notebookSsdList.get(1).click();
            }

    public void goToComparePage(){
        checkproductLink.click();
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfAllElements(comparePageButton));
        comparePageButton.click();
    }
}

