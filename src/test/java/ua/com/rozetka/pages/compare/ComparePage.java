package ua.com.rozetka.pages.compare;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class ComparePage {

@FindBy (xpath = "//div[@class='comparison-t-row']")
private List<WebElement> rows;
//@FindBy(xpath = "//div[@class='comparison-chars-value']")
//private WebElement characteristicListValue;
private List<WebElement> compareProducts;


    public List<List<WebElement>> getRows(List<WebElement>, WebElement){
        List<List<WebElement>> rowsValues = new ArrayList<List<WebElement>>();
        for(WebElement row : rows) {
            List<WebElement> rowsValues = row.findElements(By.xpath("//div[@class='comparison-chars-value']"));
            rowsValues.add(rowsValues);
        }
return rowsValues;
    }
    private int getDifference(List<List<WebElement>>) {

        int counterDifferent = 0;

            int counter = 0;
            for (List<WebElement> compareProduct : compareProducts) {
                counter++;
            }

            if (!compareProducts.get(0).getText().equals(compareProducts.get(1).getText())) {
                counterDifferent++;
            }
        }

        return counterDifferent;
}
