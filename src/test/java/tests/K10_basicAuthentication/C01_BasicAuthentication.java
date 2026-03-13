package tests.K10_basicAuthentication;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C01_BasicAuthentication extends TestBase_Each {

    @Test
    public void test01(){

        // 1- Bir class olusturun : BasicAuthentication
        // 2- https://testotomasyonu.com/basicauth sayfasina gidin
        // 3- asagidaki yontem ve test datalarini kullanarak authentication'i yapin

        // Html komutu : https:username:password@URL
        // Username     : membername
        // Password     : sunflower

        driver.get("https://membername:sunflower@testotomasyonu.com/basicauth");
        ReusableMethods.bekle(2);

        // 4- Basarili bir sekilde giris yapildigini test edin

        String expectedYazi = "Basic Auth";
        String actualYazi = driver.findElement(By.tagName("h1")).getText();

        Assertions.assertEquals(expectedYazi,actualYazi);
    }
}
