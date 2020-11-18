package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Common {
    WebDriver driver;
    WebDriverWait webDriverWait;

    public Common(WebDriver driver) {
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void waitForTheElementTobeDisplayed(WebElement element) {
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForTheElementTobeClickable(WebElement element) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForThePresenceElement(By element) {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(element));
    }

    public void waitForTheElementToBeDismissed(WebElement element) {
        webDriverWait.until(ExpectedConditions.invisibilityOf(element));
    }

    public void switchToIFrame() {
        driver.switchTo().frame(driver.findElement(By.id("frameMain")));
    }

    public void switchToDefaultFrame(){
        driver.switchTo().defaultContent();
    }

    public boolean checkIfElementDisplayed(WebElement element) {
        boolean isDisplayed;
        try {
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            element.isDisplayed();
            isDisplayed = true;
        } catch (WebDriverException exception) {
            isDisplayed = false;
        } finally {
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }
        return isDisplayed;
    }

    public void waitForTheLoadingProgressTobeDismissed(){
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='frameLoader'][contains(@style, 'display: none')]")));
    }

}
