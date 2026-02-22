package tests.K05_Webelements_Locators.D02_ByName_ByClassName;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02_FindElements {

    public static void main(String[] args) {

        //1. Bir test class'i olusturun ilgili ayarlari yapin
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //2. https://www.testotomasyonu.com/ adresine gidin
        driver.get("https://www.testotomasyonu.com/");

        //3. arama kutusuna phone yazip aratin
        WebElement aramaKutusu= driver.findElement(By.name("search"));
        aramaKutusu.sendKeys("phone" + Keys.ENTER);


        //4. Category bolumunde 8 element oldugunu test edin
        List<WebElement> categoryElementleriList = driver.findElements(By.className("panel-list"));

        int expectedCategoryElementSayisi =8;
        int actualCategoryElementSayisi = categoryElementleriList.size();

        if (actualCategoryElementSayisi == expectedCategoryElementSayisi){
            System.out.println("Category sayisi testi PASSED");
        }else System.out.println("Category sayisi testi FAILED");

        //5. Category isimlerini yazdirin

        /*
            Normalde List direkt yazdirilabilir
            AMMMAAAAA bizim listemiz WebElement'lerden olusuyor
            ve WebElement'ler direkt yazdirilamaz
         */

        for (int i = 0; i < categoryElementleriList.size(); i++) {
            System.out.println(categoryElementleriList.get(i).getText());

        }

       /*
            Grocery
            Travel
            Furniture
            Shoes
            Men Fashion
            Women Fashion
            Electronics
        */
        //6. Sayfayi kapatin
        driver.quit();
    }
}
