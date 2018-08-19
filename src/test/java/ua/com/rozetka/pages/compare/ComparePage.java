package ua.com.rozetka.pages.compare;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class ComparePage {
    private static WebDriver driver = new ChromeDriver();

    @FindBy(xpath = "//div[@class='comparison-t-row']")
    private List<WebElement> rows;
    //@FindBy(xpath = "//div[@class='comparison-chars-value']")
//private WebElement characteristicListValue;
    private List<WebElement> compareProducts;
    @FindBy(xpath = "//div[@class='comparison-t']/div[@class='comparison-t-row']/div[2]")
    private List<WebElement> column1;
    @FindBy(xpath = "//div[@class='comparison-t']/div[@class='comparison-t-row']/div[3]")
    private List<WebElement> column2;
    @FindBy (xpath = "//span[@class='m-tabs-link novisited active']")
    private WebElement onlyDifferenceButton;


//    public List<List<WebElement>> getRows(List<WebElement> compareProducts, WebElement){
//        List<List<WebElement>> rowsValues = new ArrayList<List<WebElement>>();
//        for(WebElement row : rows) {
//            List<WebElement> rowsValues = row.findElements(By.xpath("//div[@class='comparison-chars-value']"));
//            rowsValues.add(rowsValues);
//        }
//return rowsValues;
//    }

    //    private int getDifference(List<List<WebElement>>) {
//
//        int counterDifferent = 0;
//
//            int counter = 0;
//            for (List<WebElement> compareProduct : compareProducts) {
//                counter++;
//            }
//
//            if (!compareProducts.get(0).getText().equals(compareProducts.get(1).getText())) {
//                counterDifferent++;
//            }
//        }
//
//        return counterDifferent;
//}
    public int getDiferenceOfTwoColumns() {
        int result = 0;
        for (int i = 1; i < column1.size(); i++) {
                if (!column1.get(i).getText().equals(column2.get(i).getText())) {
                    result++;
                }
        }
        return result;
    }
    public int getOnlyDifference (){
        onlyDifferenceButton.click();
    (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfAllElements(column1));
        return column1.size();
    }
}
