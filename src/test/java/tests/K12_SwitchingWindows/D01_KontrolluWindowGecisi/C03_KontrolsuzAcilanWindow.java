package tests.K12_SwitchingWindows.D01_KontrolluWindowGecisi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase_Each;

import java.util.Set;

public class C03_KontrolsuzAcilanWindow extends TestBase_Each {

    @Test
    public void test01(){

        // https://the-internet.herokuapp.com/windows adresine gidin
        driver.get("https://the-internet.herokuapp.com/windows");

        // Sayfadaki text'in "Opening a new window" oldugunu dogrulayin
        WebElement yaziElementi = driver.findElement(By.tagName("h3"));
        String expectedYazi= "Opening a new window";
        String actualYazi = yaziElementi.getText();

        Assertions.assertEquals(expectedYazi,actualYazi);

        // Sayfa basliginin "The Internet" oldugunu test edin

        String expectedTitle = "The Internet";
        String actualTitle = driver.getTitle();

        Assertions.assertEquals(expectedTitle,actualTitle);

        String ilkWindowWhd = driver.getWindowHandle();

        // Click Here butonuna basin
        driver.findElement(By.xpath("//*[.='Click Here']")).click();

         /*
            driver.getWindowHandle();
            method'u icerisinde oldugu window'un window handle degerini bize getirir
            ve biz de kaydedebiliriz

            bir window'un whd'ni kaydettikten sonra
            nerede olursak olalim
            driver.switchTo().window(hedefWindowunWHDi); ile bu window'a gecis yapabiliriz

            Kontrolsuz window acildiginda
            driver beklemedigi bir durum oldugundan
            yeni window'a gecmez, eski window'da kalir

            yeni window'a gecemedigimiz icin
            yeni window'un whd'ni alamayiz.
         */

        System.out.println("Ilk window whd : " + ilkWindowWhd);
        System.out.println("Click'e bastiktan sonra driver'in oldugu window'un whd: " + driver.getWindowHandle());

        Set<String> acilanTumWindowlarinWhdSeti= driver.getWindowHandles();
        System.out.println(acilanTumWindowlarinWhdSeti);

        String ikinciWindowWhd ="";
        for (String eachWhd:acilanTumWindowlarinWhdSeti){
            if (! eachWhd.equals(ilkWindowWhd)){
                ikinciWindowWhd = eachWhd;
            }
        }

        /*
            Yeni window'un whd'ni bulmak icin mini bir bulmaca cozmeliyiz
            Baslangicta alip kaydettigimiz
            ilk window whd'ni biliyoruz

            Acik olan tum windowlarin whd'lerini
            getWindowHandles() ile alip bir Set'e kaydedebiliriz

            Set'i bir for each loop ile gozden gecirip
            ilk window'un whd'ne esit olmayan elemani
            ikinci window'Un whd'i olarak atayabiliriz

         */

        // Acilan yeni pencerenin sayfa basliginin (title) new window oldugunu test edin

        // yeni window kontrolsuz olarak acildigi icin
        // driver hala eski window'da
        // yeni window ile ilgili islem yapmadan once
        // driver'i yeni window'a gecirmeliyiz

        driver.switchTo().window(ikinciWindowWhd);
        expectedTitle = "New Window";
        actualTitle = driver.getTitle();

        Assertions.assertEquals(expectedTitle,actualTitle);

        // Sayfadaki text'in "New Window" oldugunu dogrulayin

        yaziElementi =driver.findElement(By.tagName("h3"));
        expectedYazi = "New Window";
        actualYazi = yaziElementi.getText();

        Assertions.assertEquals(expectedYazi,actualYazi);

        // Bir onceki pencereye geri donun

        driver.switchTo().window(ilkWindowWhd);

        // ve sayfa basliginin "The Internet" oldugunu test edin
        expectedTitle = "The Internet";
        actualTitle= driver.getTitle();

        Assertions.assertEquals(expectedTitle,actualTitle);

    }
}
