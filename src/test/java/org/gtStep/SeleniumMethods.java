package org.gtStep;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumMethods {
  public WebDriver driver;
  public WebDriverWait wait;
  public WebElement FindElement(By by) {
    wait.until(ExpectedConditions.presenceOfElementLocated(by));
    return driver.findElement(by);
  }
  public void Sendkeys(By by,String text){
    FindElement(by).sendKeys(text);
  }
  public void clickElement(By by){
    //görünür olması
    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    //clickable olması
    wait.until(ExpectedConditions.elementToBeClickable(by));
    FindElement(by).click();
  }
  public void untilElementAppear(By by){
    wait.until(ExpectedConditions.presenceOfElementLocated(by));
  }
  public void untilElementDisplayed(By by){
    wait.until(ExpectedConditions.visibilityOfElementLocated(by));
  }
  public void untilElementClickable(By by){
    wait.until(ExpectedConditions.visibilityOfElementLocated(by));
  }
  public void untilElementDisappear(By by){
    wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
  }
  public String gettext(By by){
    return FindElement(by).getText();
  }
  public String getAttribute(By by,String attrbname){
    return FindElement(by).getAttribute(attrbname);
  }
  @After
  public void close() throws InterruptedException {
    driver.close();
    driver.quit();
  }
}
