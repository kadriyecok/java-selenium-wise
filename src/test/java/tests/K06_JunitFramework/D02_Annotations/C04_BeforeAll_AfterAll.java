package tests.K06_JunitFramework.D02_Annotations;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;
import java.util.List;

public class C04_BeforeAll_AfterAll {

    // 3 farkli test methodu olusturarak asagidaki testleri gerceklestirin
    //1- test otomasyonu anasayfaya gidin
    //   url'in test otomasyonu icerdigini test edin
    //2- phone icin arama yapin
    //   ve arama sonucunda urun bulunabildigini test edin
    //3- ilk urunu tiklayin
    //   ve acilan sayfadaki urun isminde case sensitive olmadan "phone" bulundugunu test edin

    static WebDriver driver;

    @BeforeAll // class'in basinda bir kere calisir
    public static void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @AfterAll// class'in en sonunda 1 kere calisir
    static void teardown(){

        driver.quit();
    }
    @Test
    public void test01(){
        // methodlari sirayla calistirmak icin 1-2 diye siralandirdik
        //1- test otomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");

        //   url'in test otomasyonu icerdigini test edin
        String expectedUrlIcerik = "testotomasyonu";
        String actualUrlIcerik = driver.getCurrentUrl();

        if (actualUrlIcerik.contains(expectedUrlIcerik)){
            System.out.println("Url test PASSED");
        } else System.out.println("Url testi FAILED");

        ReusableMethods.bekle(1);

    }

    @Test
    public void test02(){

        //2- phone icin arama yapin
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone" + Keys.ENTER);

        //   ve arama sonucunda urun bulunabildigini test edin
        List<WebElement> bulunanUrunElementleriList =
                driver.findElements(By.xpath("//*[@class='prod-img']"));

        int actualSonucSayisi = bulunanUrunElementleriList.size();

        if (actualSonucSayisi > 0){
            System.out.println("phone arama testi PASSED");
        }else System.out.println("phone arama testi FAILED");

        ReusableMethods.bekle(1);

    }

    @Test
    public void test03(){
        //3- ilk urunu tiklayin

        driver.findElement(By.xpath("(//*[@class='prod-img'])[1]"));
        //   ve acilan sayfadaki urun isminde case sensitive olmadan "phone" bulundugunu test edin

        WebElement ilkUrunIsimElementi = driver.findElement(By.xpath("//*[@class='heading-sm mb-4']"));

        String expectedIsimIcerik = "phone";
        String actualIsim = ilkUrunIsimElementi.getText()
                            .toLowerCase(); // case sensitive (buyuk-kucuk harf) olmamasi icin

        if (actualIsim.contains(expectedIsimIcerik)){
            System.out.println("Urun isim testi PASSED");
        }else System.out.println("Urun isim testi FAILED");
    }
}
