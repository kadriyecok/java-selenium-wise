package tests.K12_SwitchingWindows.D02_MethodIleKontrolsuzAcilanWindowGecisi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.TestBase_Each;

import java.util.Set;

public class C02_HedefUrlIleWindowDegistirme extends TestBase_Each {

    @Test
    public void test01(){

        // https://the-internet.herokuapp.com/windows adresine gidin
        driver.get("https://the-internet.herokuapp.com/windows");

        // Sayfadaki "Elemental Selenium" linkini tiklayin
        driver.findElement(By.xpath("//*[.='Elemental Selenium']"))
                .click();

        // acilan yeni window'a gecin
        // url ile gecis yapalim

        String hedefUrl = "https://elementalselenium.com/";

        // 1.adim acik tum window'lari whd'leri alip kaydedelim
        Set<String> acikTumWindowWhdSeti = driver.getWindowHandles();

        for (String eachWhd : acikTumWindowWhdSeti){
            driver.switchTo().window(eachWhd);

            if (driver.getCurrentUrl().equals(hedefUrl)){
                // actual url hedef url'e esit ise
                // dogru yerdeyiz demektir, orada kalalim

                break;
            }
        }
        // buyuk basligin "Elemental Selenium" ldugunu test edin

        String expectedYazi = "Elemental Selenium";
        String actualYazi = driver.findElement(By.tagName("h1")).getText();

        Assertions.assertEquals(expectedYazi,actualYazi);
    }
}
