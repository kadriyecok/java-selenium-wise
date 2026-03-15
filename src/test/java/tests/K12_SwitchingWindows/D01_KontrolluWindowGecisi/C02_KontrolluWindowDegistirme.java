package tests.K12_SwitchingWindows.D01_KontrolluWindowGecisi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase_Each;

public class C02_KontrolluWindowDegistirme extends TestBase_Each {

    @Test
    public void test01(){

        /*
            Eger bize verilen gorevde
            yeni bir Tab veya yeni bir window acilmasi isteniyorsa
            driver.switchTo().newWindow(WindowType.TAB);
            driver.switchTo().newWindow(WindowType.WINDOW);
            ile yeni bir Tab veya Window acip, driver'i yeni window'a otomatik olarak geciririz

            Eger testimiz sirasinda birden fazla window aciliyorsa
            driver'i istedigimiz window'a gecirmek icin
            hedef window'un WindowHandle degerini girmeliyiz
            driver.switchTo().window(wisequarterWhd);

            Eger birden fazla window aciyorsak ve geri donmemiz gerekecekse
            acilan her window'un window handle degerini kaydetmek
             faydali olacaktir
         */

        // testotomasyonu sayfasina gidin
        driver.get("https://www.testotomasyonu.com");

        // windowhandle degerini kaydedin ve yazdirin

        String testotomasyonuWhd = driver.getWindowHandle();
        System.out.println("test otomasyonu windowhandle degeri : " +testotomasyonuWhd);


        // yeni bir tab acip, yeni tab'da wisequarter sayfasina gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.wisequarter.com");

        // whd'ini kaydedin ve yazdirin

        String wisequarterWhd = driver.getWindowHandle();
        System.out.println("wisequarter windowhandle degeri : " + wisequarterWhd);


        // yeni bir window acarak arabam.com sayfasina gidin
        driver.switchTo().newWindow(WindowType.TAB).get("https://www.arabam.com");

        // whd'ini kaydedin ve yazdirin
        String arabamWhd = driver.getWindowHandle();
        System.out.println("arabam windowhandle degeri : " + arabamWhd);


        // wisequarter'in acik oldugu window'a donun
        // ve url'in wisequarter icerdigini test edin

        driver.switchTo().window(wisequarterWhd);
        String expectedUrlIcerik = "wisequarter";
        String actualUrlIcerik = driver.getCurrentUrl();

        Assertions.assertTrue(actualUrlIcerik.contains(expectedUrlIcerik));

        // testotomasyonu acik oldugu window'a donun
        // ve url'in testotomasyonu icerdigini test edin

        driver.switchTo().window(testotomasyonuWhd);
        String expectedUrlIcerik1= "testotomasyonu";
        String actualUrlIcerik1 = driver.getCurrentUrl();

        Assertions.assertTrue(actualUrlIcerik1.contains(expectedUrlIcerik1));




    }
}
