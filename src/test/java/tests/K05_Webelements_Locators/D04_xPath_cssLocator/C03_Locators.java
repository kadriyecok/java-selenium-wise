package tests.K05_Webelements_Locators.D04_xPath_cssLocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C03_Locators {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //1- https://www.testotomasyonu.com/ adresine gidin
        driver.get("https://www.testotomasyonu.com/");

        //2- Browser'i tam sayfa yapin
        driver.manage().window().maximize();

        //3- Sayfayi "refresh" yapin
        driver.navigate().refresh();

        //4- Sayfa basliginin "Test Otomasyonu" ifadesini icerdigini test edin
        String expectedTitleIcerik = "Test Otomasyonu";
        String actualTitleIcerik = driver.getTitle();

        if (actualTitleIcerik.contains(expectedTitleIcerik)){
            System.out.println("Title testi PASSED");
        } else System.out.println("Title testi FAILED");

        //5- Furniture linkine tiklayin
        driver.findElement(By.xpath("(//a[text()='Furniture'])[3]")).click();

        //6- price range filtresinde min degere 40, max degere 200 yazip filtreleyin
        WebElement minimumKutusu = driver.findElement(By.cssSelector("input[name='min']"));
        minimumKutusu.clear();
        minimumKutusu.sendKeys("40");

        WebElement maxKutusu = driver.findElement(By.cssSelector("input[name='max']"));
        maxKutusu.clear();
        maxKutusu.sendKeys("200");

        // filtrele butonuna tiklayalim
        driver.findElement(By.cssSelector("button[name='button']")).click();

        //7- filtreleme sonucunda urun bulunabildigini test edin
        List<WebElement> bulunanUrunElementleriList=driver.findElements(By.cssSelector("a[class='prod-img']"));

        if (bulunanUrunElementleriList.size() > 0){
            System.out.println("Urun listeleme testi PASSED");
        } else System.out.println("Urun listeleme testi FAILED");

        //8- ilk urunu tiklayin
        bulunanUrunElementleriList.get(0).click();

        //9- Urun fiyatanin 40 ile 200 arasinda oldugunu test edin
        WebElement urunFiyatElementi = driver.findElement(By.id("priceproduct"));

        System.out.println(urunFiyatElementi.getText());

        String urunFiyatiStr = urunFiyatElementi.getText(); // $50.00

        urunFiyatiStr = urunFiyatiStr.replaceAll("\\D",""); // 5000

        Double urunFiyatDbl = Double.parseDouble(urunFiyatiStr) / 100;

        if (urunFiyatDbl >= 40 && urunFiyatDbl <=200){
            System.out.println("Urun fiyat testi PASSED");
        } else System.out.println("Urun fiyat testi FAILED");


        //10- Sayfayi kapatin
        driver.quit();

    }
}
