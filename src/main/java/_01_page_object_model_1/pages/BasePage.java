package _01_page_object_model_1.pages;

import _01_page_object_model_1.GlobalParameters;
import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

import static _01_page_object_model_1.GlobalParameters.SELENIUM_TIMEOUT_SECONDS;
import static org.assertj.core.api.Assertions.assertThat;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage (WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, SELENIUM_TIMEOUT_SECONDS);
    }

    public WebElement findElement(By by){
        WebElement element = driver.findElement(by);

        if (!Boolean.getBoolean("disableHighlight")) {
            ((JavascriptExecutor) driver).executeScript("var elem = arguments[0];\n" +
                    "var border = elem.style.border;\n" +
                    "elem.style.border='3px solid red';\n" +
                    "setTimeout(function (){elem.style.border=border},1000);", element);
            Uninterruptibles.sleepUninterruptibly(100, TimeUnit.MILLISECONDS);
        }
        return element;
    }
    //Wait Wrapper Method
    public void waitVisibility(By elementBy) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
    }

    //Click Method
    public void click (By elementBy) {
        waitVisibility(elementBy);
        findElement(elementBy).click();
    }

    //Write Text
    public void writeText (By elementBy, String text) {
        waitVisibility(elementBy);
        findElement(elementBy).sendKeys(text);
    }

    //Read Text
    public String readText (By elementBy) {
        waitVisibility(elementBy);
        return driver.findElement(elementBy).getText();
    }

    //Assert
    public void assertTextFound (String expectedText) {
        String bodyText = driver.findElement(By.tagName("body")).getText();
        assertThat(bodyText).as("Page contains text").contains(expectedText);
    }
}
