package tests.K12_SwitchingWindows.D02_MethodIleKontrolsuzAcilanWindowGecisi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v142.runtime.model.StackTraceId;
import utilities.TestBase_Each;

import java.util.Set;

public class C01_KontrolsuzAcilanWindow extends TestBase_Each {

    @Test
    public void test01(){

        // https://the-internet.herokuapp.com/windows adresine gidin
        driver.get("https://the-internet.herokuapp.com/windows");

        // Sayfadaki "Elemental Selenium" linkini tiklayin
        driver.findElement(By.xpath("//*[.='Elemental Selenium']"))
                .click();

        // acilan yeni window'a gecip
        // gecisi yeni window'un title'ini kullanarak yapin

        // 1- Acik olan tum windowlarin whd'lerini alip kaydedelim

        Set<String> acikWindowlarinWhdleri = driver.getWindowHandles();
        String hedefWindowunTitle= "Home | Elemental Selenium";

        for (String eachWhd:acikWindowlarinWhdleri) {
            driver.switchTo().window(eachWhd);
            // gectigimiz window'un title'ini alip
            // gecmek istedigimiz window'un title'ina esit mi diye kontrol edelim

            if (driver.getTitle().equals(hedefWindowunTitle)){
                // dogru windows'tayiz demektir, burada kalabiliriz
                break;
            }
        }

        // buyuk basligin "Elemental Selenium" ldugunu test edin

        String expectedYazi = "Elemental Selenium";
        String actualYazi = driver.findElement(By.tagName("h1")).getText();

        Assertions.assertEquals(expectedYazi,actualYazi);
    }
}
