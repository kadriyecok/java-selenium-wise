package tests.K04_WebDriverOlusturmaVeKullanma.D01_WebdriverOlusturma_GetveNavigateMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C05_NavigateMethodlariTest {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        //1. Youtube anasayfasina gidin https://www.youtube.com/
        driver.get("https:www.youtube.com/");

        //2. url'in "youtube" icerdigini test edin

        String expectedUrl = "youtube";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrl)){
            System.out.println("Url testi passed");
        } else System.out.println("Url testi failed");

        //3. Testotomasyonu sayfasina gidin. https://www.testotomasyonu.com/
        driver.get("https://www.testotomasyonu.com/");

        //4. Title'in "Test Otomasyonu" icerdigini test edin

        String expectedTitleIcerik = "Test Otomasyonu";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedTitleIcerik)){
            System.out.println("Title testi passed");
        } else System.out.println("Title testi failed");

        //5. Tekrar Youtube sayfasina donun
        driver.navigate().back();

        //6. Title'in "YouTube" oldugunu test edin

        String expectedTitle = "YouTube";
        actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedTitle)){
            System.out.println("YouTube Title testi passed");
        } else System.out.println("YouTube Title testi failed");

        //7. Sayfayi refresh (yenile) yapin
        driver.navigate().refresh();

        //8. Tum sayfalari kapatin
        Thread.sleep(3000);
        driver.quit();

    }
}
