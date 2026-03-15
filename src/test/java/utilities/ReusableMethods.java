package utilities;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Set;

public class ReusableMethods {

    public static void bekle(int saniye){

        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e){
            System.out.println("Thread.sleep komutu calismadi");
        }
    }

    public static void titleIleWindowGecisYap(WebDriver driver, String hedefWindowunTitle){
        // 1- Acik olan tum windowlarin whd'lerini alip kaydedelim

        Set<String> acikWindowlarinWhdleri = driver.getWindowHandles();


        for (String eachWhd:acikWindowlarinWhdleri) {
            driver.switchTo().window(eachWhd);
            // gectigimiz window'un title'ini alip
            // gecmek istedigimiz window'un title'ina esit mi diye kontrol edelim

            if (driver.getTitle().equals(hedefWindowunTitle)){
                // dogru windows'tayiz demektir, burada kalabiliriz
                break;
            }
        }
    }

    public static void urlIleWindowGecisYap(WebDriver driver , String hedefUrl){

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
    }

    }

