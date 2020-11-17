package org.gtStep;

import static org.gtStep.Contants.*;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StepTest extends SeleniumMethods {

  @Before
  public void setUp() {
    System.setProperty("webdriver.chrome.driver",
        "C:\\DEVEL\\workspace\\GT_STEP\\properties\\driver\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().deleteAllCookies();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    wait = new WebDriverWait(driver, 15);
  }

  @Test
  public void STEPKAPALIURUN() throws InterruptedException {
    driver.get(STEPURL);
    WebElement username;
    username = FindElement(By.id("windowsUserId"));
    username.clear();
    username.sendKeys("tsge");

    WebElement password;
    password = FindElement(By.id("windowsPassword"));
    password.clear();
    password.sendKeys("tsge");

    WebElement domain;
    domain = FindElement(By.id("windowsDomain"));
    domain.clear();
    domain.sendKeys("garanti");

    WebElement appuser;
    appuser = FindElement(By.id("clientUserId"));
    appuser.clear();
    appuser.sendKeys("tsge");

    WebElement appass;
    appass = FindElement(By.id("clientPassword"));
    appass.clear();
    appass.sendKeys("tsge");

    WebElement loginbuttn;
    loginbuttn = FindElement(By.id("doLogin"));
    String girisbutonutext;
    girisbutonutext = loginbuttn.getText();
    System.out.println("giriş butonu texti: " + girisbutonutext);
    loginbuttn.click();
    driver.switchTo().frame(driver.findElement(By.name("frame_0")));
    if (FindElement(By.id(Error)).isDisplayed()) {
      System.out.println(Errors);
      clickElement(By.id(Error));
      clickElement(By.id(ErrorDt));
    }
    clickElement(By.id(KafaIkonu));
    //kafa ikonu
    Sendkeys(By.id(MusteriNoAlani), "11859366");
    //müşteri no
    clickElement(By.id("customerFilterSearchButton"));
    clickElement(By.id("customerPhoto28971942"));
    //müşteri açılır
    clickElement(By.id("popupError_firstButton"));
    clickElement(By.id("errorPopupDetail_firstButton"));
    //hatalar kapatıldı.
    clickElement(By.id("customerSummaryRightSegmentAnchor"));
    //sağ kulakçık tıklanır
    Select select = new Select(FindElement(By.id("showClosedProductsFlag")));
    select.selectByValue("Y");
    //kapalı ürün seçilddi
    clickElement(By.xpath(
        "//button[@class='button success ajax button-block gt-buttonsuccess' and text()='Filtrele']"));
    //Fitrele yapılır
    clickElement(By.id("customerProduct"));
    //bireysel emeklilik yazan asansöre tıklandı
    String uruntext;
    uruntext = FindElement(
        By.xpath("//span[@class='text-field gt-text' and text()='Bireysel Emeklilik']")).getText();
    Assert.assertEquals(uruntext, "Bireysel Emeklilik");
    //bireysel emeklilk ürünü text kontrolü yapıldı
    clickElement(By.xpath("//td[@class='no-padding no-wrap']"));
    //büyüteç ikonun tıklandı.
    FindElement(By.id("investmentInfoButton")).isDisplayed();
    //yatırım bilgileri butonu verify edilir.
    FindElement(By.id("fundDistributionButton")).isDisplayed();
    //Fon dağılımı butonu verify edilir.
    FindElement(By.id("accountTransactionButton")).isDisplayed();
    //HEsap hareketleri butonu verifiy edilir.
    FindElement(By.id("earlyExitRequestButton")).isDisplayed();
    //Erken Çıkış butonu verify edilir.
    clickElement(By.id("investmentInfoButton"));
    //Yatırım bilgileri ekranı açılır
    FindElement(By.xpath("//h1[@class='title gt-title' and text()='Yatırım Bilgileri']"))
        .isDisplayed();
    if (FindElement(By.xpath("//h1[@class='title gt-title' and text()='Yatırım Bilgileri']"))
        .isDisplayed()) {
      System.out.println("Yatırım bilgileri Görüntülendi");
    } else {
      System.out.println("Fail yatırım bilgileri görüntülenmedi.");
    }
    clickElement(By.id("investmentInfoOkId"));
    //yatırımbilgileri ekranıdna tamama basılır

    clickElement(By.id("fundDistributionButton"));
    if (FindElement(By.xpath("//h1[@class='title gt-title' and text()='Fon Dağılımı']"))
        .isDisplayed()) {
      System.out.println("Fon Dağılımı bilgileri Görüntülendi");
    } else {
      System.out.println("Fon Dağılımı görüntülenmedi.");
    }
    clickElement(By.id("fundDistOkId"));
  }

  @After
  public void close() throws InterruptedException {
    driver.close();
    driver.quit();
  }
}