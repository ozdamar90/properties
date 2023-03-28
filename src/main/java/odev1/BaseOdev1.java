package odev1;

import Utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class BaseOdev1 {
    WebDriver driver;
    WebDriverWait wait;



    @BeforeTest
    public void beforeTest(){
    driver= Driver.getDriver();
    wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    driver.manage().window().maximize();

    }
    @AfterTest
    public void afterTest(){

        Driver.quitDriver();

    }
    public void sendKeys(By locator, String text){
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        senkeys(element,text);
    }
    public void senkeys(WebElement element,String text){
        wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(text);
    }
    public void click(By locator){
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
            click(element);
    }
    public void click(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element)).click();
    }
}
