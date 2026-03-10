package tests.K06_JunitFramework.D03_Assertions;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;
import java.util.List;

public class C04_BeforeVeAfterSartMi {

    // tek test methodu olusturarak asagidaki testleri gerceklestirin
    // 1- Test Otomasyonu anasayfasina gidin
    //     Url'in testotomasyonu icerdigini test edin
    // 2- phone icin arama yapin
    //     ve arama sonucunda urun bulunabildigini test edin
    // 3- ilk urunu tiklayin
    //     ve acilan sayfadaki urun isminde case sensitive olmadan "phone" bulundugunu test edin

    @Test
    public void urunAramaTesti(){

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //1- test otomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");

        //   url'in test otomasyonu icerdigini test edin
        String expectedUrlIcerik = "testotomasyonu";
        String actualUrlIcerik = driver.getCurrentUrl();

        Assertions.assertTrue(actualUrlIcerik.contains(expectedUrlIcerik),"url expected kelimesini icermiyor");

        ReusableMethods.bekle(1);

        //2- phone icin arama yapin
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone" + Keys.ENTER);

        //   ve arama sonucunda urun bulunabildigini test edin
        List<WebElement> bulunanUrunElementleriList =
                driver.findElements(By.xpath("//*[@class='prod-img']"));

        int actualSonucSayisi = bulunanUrunElementleriList.size();

        Assertions.assertTrue(actualSonucSayisi>0);

        ReusableMethods.bekle(1);

        //3- ilk urunu tiklayin

        driver.findElement(By.xpath("(//*[@class='prod-img'])[1]"));
        //   ve acilan sayfadaki urun isminde case sensitive olmadan "phone" bulundugunu test edin

        WebElement ilkUrunIsimElementi = driver.findElement(By.xpath("//*[@class='heading-sm mb-4']"));

        String expectedIsimIcerik = "phone";
        String actualIsim = ilkUrunIsimElementi.getText()
                .toLowerCase(); // case sensitive (buyuk-kucuk harf) olmamasi icin

        Assertions.assertTrue(actualIsim.contains(expectedIsimIcerik));

        ReusableMethods.bekle(1);

        driver.quit();
    }
}
