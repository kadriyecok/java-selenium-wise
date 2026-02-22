package tests.K04_WebDriverOlusturmaVeKullanma.D01_WebdriverOlusturma_GetveNavigateMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_DriverGetMethodlari {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        //driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
       // driver.get("https://www.testotomasyonu.com");

        driver.get("https://www.google.com");
        System.out.println(driver.getTitle());

        System.out.println(driver.getCurrentUrl());
        // gidilen sayfadaki actual url'i getirir.

        System.out.println(driver.getPageSource());

        System.out.println(driver.getWindowHandle());
        System.out.println(driver.getWindowHandles());

        /*
        WebDriver olusturulan her bir objeye
        benzersiz (unique) bir Windows Handle Degeri verir

        Eger bir class calistiginda birden fazla windows acilirsa
        herbirinin ayri bir Window Handle Degeri olur

        getWindowHandle() driver'in actigi son window'un Handle Degerini verir
        getWindowHandles() ise acilan tum windowlarin window Handle Degerlerini
        bir Set olarak verir

        driver'in acilan windowlar arasinda gecis yapabilmesi icin
        gidecegi window'un Window Handle Degeri'ni bilmesi gerekir

         */


        Thread.sleep(5000);
        //driver.close();

        driver.quit();

        /*
        actigimiz driver'i kapatir
        driver.close(); actigimiz driver'i kapatir
        aralarindaki fark : close() sadece 1 window kapatirken
        quit() ise test sirasinda birden fazla window acilsa da hepsini kapatir
         */

    }
}
