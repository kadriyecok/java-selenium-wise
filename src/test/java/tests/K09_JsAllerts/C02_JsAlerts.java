package tests.K09_JsAllerts;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C02_JsAlerts extends TestBase_Each {

    // 3 test methodu olusturup asagidaki gorevi tamamlayin

    @Test
    public void jsAlertsTest(){
        // 1.Test
        // - https://testotomasyonu.com/javascriptAlert adresine gidin
        driver.get("https://testotomasyonu.com/javascriptAlert");
        ReusableMethods.bekle(2);

        // - 1.Alert'e tiklayin
        driver.findElement(By.xpath("//*[@onclick = 'jsAlert()']"))
                .click();

        // - Alert'teki yazinin "I am a JS Alert" oldugunu test edin
        String expectedAlertYazi = "I am a JS Alert";
        String actualAlertYazi = driver.switchTo()
                                .alert()
                                .getText();

        Assertions.assertEquals(expectedAlertYazi,actualAlertYazi);
        ReusableMethods.bekle(2);
        // - OK tusuna basip alert'i kapatin

        driver.switchTo()
                .alert()
                .accept();
        ReusableMethods.bekle(2);
    }

    @Test
    public void jsConfirmTest(){

        // 2.Test

        // - https://testotomasyonu.com/javascriptAlert adresine gidin
        driver.get("https://testotomasyonu.com/javascriptAlert");
        ReusableMethods.bekle(2);


        // - 2.Alert'e tiklayin
        driver.findElement(By.xpath("//*[@onclick = 'jsConfirm()']"))
                .click();
        ReusableMethods.bekle(2);

        // - Cancel'a basip,
        driver.switchTo().alert().dismiss();

        // cikan sonuc yazisinin "You clicked: Cancel" oldugunu test edin
        String expectedSonucYazi= "You clicked: Cancel";
        String actualSonucYazi = driver.findElement(By.id("result")).getText();

        Assertions.assertEquals(expectedSonucYazi,actualSonucYazi);

    }

    @Test
    public void jsPrompTest(){

        // 3.Test

        // - https://testotomasyonu.com/javascriptAlert adresine gidin
        driver.get("https://testotomasyonu.com/javascriptAlert");


        // - 3.Alert'e tiklayalim
        driver.findElement(By.xpath("//*[@onclick = 'jsPrompt()']"))
                .click();


        // Cikan prompt ekranina "Cansu" yazdiralim
        driver.switchTo().alert().sendKeys("Cansu");

        // - OK tusuna basarak alert'i kapatalim
        driver.switchTo().alert().accept();



        // - Cikan sonuc yazisinin Cansu icerdigini test edelim

        String expectedSonucYaziIcerigi= "Cansu";
        String actualSonucYazi = driver.findElement(By.id("result")).getText();

        Assertions.assertEquals(actualSonucYazi,expectedSonucYaziIcerigi);
    }
}
