package tests.K12_SwitchingWindows.D02_MethodIleKontrolsuzAcilanWindowGecisi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C03_WindowDegistirme extends TestBase_Each {

    @Test
    public void test01() {

        // https://the-internet.herokuapp.com/windows adresine gidin
        driver.get("https://the-internet.herokuapp.com/windows");

        // Sayfadaki "Elemental Selenium" linkini tiklayin
        driver.findElement(By.xpath("//*[.='Elemental Selenium']"))
                .click();

        // Acilan yeni window'da buyuk basligin "Elemental Selenium" ldugunu test edin
        // once title kullanarak yeni window'a gecelim

        ReusableMethods.titleIleWindowGecisYap(driver,"Home | Elemental Selenium");

        String expectedYazi = "Elemental Selenium";
        String actualYazi = driver.findElement(By.tagName("h1")).getText();

        Assertions.assertEquals(expectedYazi,actualYazi);

        // ilk window'a geri donun
        ReusableMethods.urlIleWindowGecisYap(driver,"https://the-internet.herokuapp.com/windows");

        // "Opening a new window" yazisinin gorunur oldugunu test edin
        WebElement openingWindowEleemnti = driver.findElement(By.tagName("h3"));

        Assertions.assertTrue(openingWindowEleemnti.isDisplayed());

        // Click Here linkine tiklayin
        driver.findElement(By.xpath("//*[.='Click Here']")).click();

        // Acilan yeni window'a gecin
        ReusableMethods.titleIleWindowGecisYap(driver,"New Window");

        // oradaki yazinin "New Window" oldugunu test edin
        expectedYazi = "New Window";
        actualYazi = driver.findElement(By.tagName("h3")).getText();

        Assertions.assertEquals(expectedYazi,actualYazi);

        // Elemental Selenium'un acik oldugu window'a donun
        ReusableMethods.urlIleWindowGecisYap(driver,"https://elementalselenium.com/");

        // Tips linkinin erisilebilir oldugunu test edin
        WebElement tipsElementi = driver.findElement(By.xpath("//*[.='Tips']"));

        Assertions.assertTrue(tipsElementi.isEnabled());
        ReusableMethods.bekle(1);

    }

}