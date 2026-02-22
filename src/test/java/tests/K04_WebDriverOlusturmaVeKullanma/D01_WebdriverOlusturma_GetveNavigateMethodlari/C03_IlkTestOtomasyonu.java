package tests.K04_WebDriverOlusturmaVeKullanma.D01_WebdriverOlusturma_GetveNavigateMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v142.layertree.model.StickyPositionConstraint;

public class C03_IlkTestOtomasyonu {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        //1. testotomasyonu sayfasina gidelim https://www.testotomasyonu.com

        driver.get("https://www.testotomasonu.com");

        //2. Sayfa basligini (title) yazdirin
        System.out.println(driver.getTitle());

        //3. Sayfa basliginin "Test Otomasyonu" icerdigini test edin
        String expectedTitleIcerik = "Test Otomasyonu";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedTitleIcerik)){
            System.out.println("Title testi passed");
        }else System.out.println("Title testi failed");

        //4. Sayfa adresini (url) yazdirin
        System.out.println(driver.getCurrentUrl());

        //5. Sayfa url'nin https://testotomasyonu.com/ oldugunu test edin

        String expectedUrl= "https://testotomasyonu.com/";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.equals(expectedUrl)){
            System.out.println("Url testi passed");
        }else System.out.println("Url testi failed");

        //6. Sayfa Handle degerini yazdirin
        System.out.println(driver.getWindowHandle());

        //7. Sayfa HTML kodlarinda "otomasyon" kelimesi gectigini test edin

        String expectedSayfaKaynakIcerik = "otomasyon";
        String actualSayfaKaynagi = driver.getPageSource();

        if (actualSayfaKaynagi.contains(expectedSayfaKaynakIcerik)){
            System.out.println("Sayfa kaynagi testi passed");
        } else System.out.println("Sayfa kaynagi testi failed");


        //8. Sayfayi kapatin
        Thread.sleep(3000);
        driver.quit();
    }
}
