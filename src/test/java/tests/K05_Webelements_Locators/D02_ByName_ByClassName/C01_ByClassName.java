package tests.K05_Webelements_Locators.D02_ByName_ByClassName;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_ByClassName {

    public static void main(String[] args) throws InterruptedException {

        //1. Bir test class'i olusturun ve ilgili ayarlari yapin
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //2. https://www.testotomasyonu.com adresine gidin
        driver.get("https://www.testotomasyonu.com");

        //3. urun arama kutusunu locate edin

        WebElement aramaKutusu= driver.findElement(By.name("search"));

        //4. arama kutusuna "shoe" yazdirin
        aramaKutusu.sendKeys("shoe");

        //5. arama islemini yapabilmek icin ENTER tusuna basin
        aramaKutusu.submit();

        //6. arama sonucunda urun bulunabildigini test edin

        WebElement aramaSonucElementi = driver.findElement(By.className("product-count-text"));

        //System.out.println(aramaSonucElementi);
        // Web elementi direk yazdiramiyoruz.

        System.out.println(aramaSonucElementi.getText()); // 4 products found

        String aramaSonucuStr= aramaSonucElementi.getText(); // "4 products found"
        // elementi Stringe cevirdik

        // sonuc yazisindaki sayi olmayan herseyi yok edelim
        aramaSonucuStr = aramaSonucuStr.replaceAll("\\D","");

        // string 4'u matematiksel islemde kullanamayiz
        // Integer'a cevirelim

        int aramaSonucSayisiInt = Integer.parseInt(aramaSonucuStr); //4

        if (aramaSonucSayisiInt > 0){
            System.out.println("Arama testi PASSED");
        }else System.out.println("Arama testi FAILED");



        Thread.sleep(3000);
        driver.quit();
    }
}
