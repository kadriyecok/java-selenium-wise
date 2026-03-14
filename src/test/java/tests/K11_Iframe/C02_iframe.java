package tests.K11_Iframe;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C02_iframe extends TestBase_Each {

    @Test
    public void test01(){

        // 1- https://testotomasyonu.com/discount adresine gidin
        driver.get("https://testotomasyonu.com/discount");
        ReusableMethods.bekle(3);

        // 2- Electronics Products yazisinin gorunur oldugunu test edin
        WebElement electronicsIframe = driver.findElement(By.xpath("(//iframe)[1]"));
        driver.switchTo().frame(electronicsIframe);

        WebElement electronicsProducts = driver.findElement(By.xpath("//*[.='Electronics Products']"));
        Assertions.assertTrue(electronicsProducts.isDisplayed());

        // 3- Dell bilgisayar urun isminin 'DELL Core 13 11th Gen' oldugunu test edin
        String expectedUrunIsmi = "DELL Core 13 11th Gen";
        String actualUrunIsmi = driver.findElement(By.id("pictext1")).getText();

        Assertions.assertEquals(expectedUrunIsmi,actualUrunIsmi);
        ReusableMethods.bekle(3);

        // 4- Sale Up To 50% yazisinin gorunur oldugunu test edin
        //    bu yazi anasayfada oldugu icin
        //    once electronics iframe'den anasayfaya gecis yapmaliyiz
        driver.switchTo().parentFrame();

        WebElement baslikElementi = driver.findElement(By.tagName("h2"));
        System.out.println("Baslik yazisi : " + baslikElementi.getText());
        String expectedBaslikYazisi = "Sale Up To 50%";
        String actualBaslikYazisi = baslikElementi.getText();

        Assertions.assertEquals(expectedBaslikYazisi,actualBaslikYazisi);

        // 5- Fashion bolumundeki ilk urun ismini locate edin
        //    fashion bolumu ayri bir iframe icerisinde oldugundan, once o iframe'e gecis yapmaliyiz
        WebElement fashionIframe = driver.findElement(By.xpath("(//iframe)[2]"));

        driver.switchTo().frame(fashionIframe);

        // simdi ilk urunu locate edebiliriz
        WebElement ilkUrunısimElementi = driver.findElement(By.xpath("(//p)[1]"));

        // ve ilk urun isminde "Men Slim Fit" gecitigini test edin

        String expectedısimIcerigi = "Men Slim Fit";
        String actualIsimIcerigi = ilkUrunısimElementi.getText();

        Assertions.assertTrue(actualIsimIcerigi.contains(expectedısimIcerigi));



    }
}
