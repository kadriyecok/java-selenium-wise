package tests.K05_Webelements_Locators.D03_ByTagName_ByLinkText;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01_ByTagName_ByLinkText {

    public static void main(String[] args) throws InterruptedException {

        //1. Bir test class'i olusturun ilgili ayarlari yapin
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //2. https://www.automationxercise.com/ adresine gidin
        driver.get("https://www.automationexercise.com/");

        // cikan cookies kabul edin
       // Thread.sleep(1000);
        //driver.findElement(By.className("fc-button-label")).click();
        //Thread.sleep(1000);

        //3. sayfada 147 adet link bulundugunu test edin
        List<WebElement> linkElementlerList = driver.findElements(By.tagName("a"));

        int expectedlinkSayisi =147;
        int actualLinkSayisi = linkElementlerList.size();

        if (expectedlinkSayisi == actualLinkSayisi){
            System.out.println("Link sayisi testi PASSED");
        } else System.out.println("Link sayisi testi FAILED");

        //4. Products linkine tiklayin
        // driver.findElement(By.linkText("Products")).click();

        driver.findElement(By.partialLinkText("Products")).click();
        // partialLinkText ile yazinin tamamini yazmasak bile arama yapar sonucu getirir.


        //5. special offer yazisinin gorundugunu test edin
        WebElement specialOfferYaziElementi = driver.findElement(By.id("sale_image"));

        if (specialOfferYaziElementi.isDisplayed()){
            System.out.println("Special offer yazi testi PASSED");
        } else System.out.println("Special offer yazi testi FAILED");

        //6.sayfayi kapatin
        Thread.sleep(1000);
        driver.quit();

    }
}
