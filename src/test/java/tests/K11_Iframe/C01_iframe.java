package tests.K11_Iframe;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase_Each;

import java.util.List;

public class C01_iframe extends TestBase_Each {

    @Test
    public void test01(){
        // 1- https://demoqa.com/frames sitesine gidin

        driver.get("https://demoqa.com/frames");

        // 2- This is a sample page yazisinin gorunur oldugunu test edin

        /*
            yaziyi unique olarak locate etmemize ragmen kullanamadik
            HTML kodlarini inceleyince kullanmak istedigimiz webelementin
            bir iframe (gomulu HTML sayfa)icerisinde oldugunu tespit ettik
            bir iframe icerisindeki elementi kullanabilmek icin
            once o iframe'e gecis yapmamiz gerekiyor
         */

        WebElement hedefIframeElementi = driver.findElement(By.id("frame1"));
        driver.switchTo().frame(hedefIframeElementi);

        WebElement yaziElementi = driver.findElement(By.xpath("(//h1[@id = 'sampleHeading'])[1]"));

        Assertions.assertTrue(yaziElementi.isDisplayed());

        // 3- TOOLSQA logosunun gorunur oldugunu test edin

        /*
            iframe icerisine gecis yapinca bir driver'i oradan cikarincaya kadar
            driver iframe'in icinde kalir
            driver'i icinde oldugu iframe'den cikarmak icin iki farkli method kullanabiliriz

            driver.swichTo().parentFrame();
            ic ice birden fazla katman olarak iframe'ler varsa
            bir ust katmana cikarir

            driver.switchTo().defaultContent();
            ic ice birden fazla katman olarak iframe'ler varsa
            direk anasayfaya cikartir
         */
        driver.switchTo().defaultContent();

        WebElement toolsQaLogo = driver.findElement(By.xpath("//*[@src ='/images/Toolsqa.jpg']"));

        Assertions.assertTrue(toolsQaLogo.isDisplayed());

        // 4- sayfadaki iframe sayisini yazdirin

        List<WebElement> iframeListesi = driver.findElements(By.tagName("iframe"));
        System.out.println("Sayfadaki iframe sayisi : " + iframeListesi.size());



    }
}
