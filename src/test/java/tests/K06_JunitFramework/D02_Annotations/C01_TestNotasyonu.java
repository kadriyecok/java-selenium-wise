package tests.K06_JunitFramework.D02_Annotations;

import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;

// Testleri sirali calistirmak istersek

//1. yol
// @TestMethodOrder(MethodOrderer.class)

//2. yol
@TestMethodOrder(MethodOrderer.MethodName.OrderAnnotation.class)
public class C01_TestNotasyonu {

    /*
        @Test notasyonu siradan bir method'u
        tek basina Run edilebilir hale getirir

        @Test notasyonu sayesinde
        er bir testi bagimsiz olarak calistirabilecegimiz gibi
        class isminin yanindaki Run tusu ile
        class'daki TUM test methodlarini toplu olarak da calistirabiliriz
     */

    /*
        JUnit @Test methodlarin calisma sirasini
        kendine gore duzenler
        belirlenmis bir siralama duzeni yoktur
        siralamayi ongoremeyiz ve kontrol edemeyiz

        eger sirali calismaini istedigimiz
        test meyhod'lari olursa
        @TestMethodOrder kullanmamiz gerekir
     */


    @Test @Order(1)
    public void testOtomasyonuTest() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 1.method testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");
        //          title'in Test Otomasyonu icerdigini test edin

        String expectedTitleIcerik = "Test Otomasyonu";
        String actualTitleIcerik = driver.getTitle();

        if (actualTitleIcerik.contains(expectedTitleIcerik)){
            System.out.println("Test otomasyonu testi PASSED");
        } else System.out.println("Test otomasyonu testi FAILED");

        ReusableMethods.bekle(1);
        driver.quit();
    }

    @Test @Order(2)
    public void wisequarterTesti(){

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 2.method wisequarter anasayfaya gidin
        driver.get("https://www.wisequarter.com");
        //          url'in wisequarter icerdigini test edin


        String expectedUrlIcerik = "wisequarter";
        String actualUrlIcerik = driver.getCurrentUrl();

        if (actualUrlIcerik.contains(expectedUrlIcerik)){
            System.out.println("Wisequarter testi PASSED");
        } else System.out.println("Wisequarter testi FAILED");


        ReusableMethods.bekle(1);
        driver.quit();
    }

    @Test @Order(3)
    public void junitTesti() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 3.method junit.org sayfasina gidin
        driver.get("https://www.junit.org");

        //          url'in "https://junit.org/junit5/" oldugunu test edin

        String expectedUrl = "https://junit.org/junit5/";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrl)){
            System.out.println("Junit testi PASSED");
        } else System.out.println("Junit testi FAILED");

        ReusableMethods.bekle(1);
        driver.quit();
    }

}
