package tests.K12_SwitchingWindows.D01_KontrolluWindowGecisi;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.TestBase_Each;

public class C01_AyniWindowdaGezinme extends TestBase_Each {

    @Test
    public void test01(){

        // testotomasyonu sayfasina gidin
        driver.get("https://www.testotomasyonu.com");

        // windowhandle degerini ve url'i yazdirin

        System.out.println("test otomasyonu url : " + driver.getCurrentUrl());
        System.out.println("testotomasyonu window handle degeri : " + driver.getWindowHandle());

        //Electronics linkini tiklayin

        driver.findElement(By.xpath("(//a[.='Electronics'])[3]")).click();

        // windowhandle degerini ve url'i yazdirin

        System.out.println("Electronics url : " + driver.getCurrentUrl());
        System.out.println("Elctronics window handle degeri : " + driver.getWindowHandle());

        // ilk urunu tiklayin
        driver.findElement(By.xpath("(//*[@class='prod-img'])[1]")).click();

        // windowhandle degerini ve url'i yazdirin

        System.out.println("Ilk urun url : " + driver.getCurrentUrl());
        System.out.println("Ilk urun window handle degeri : " + driver.getWindowHandle());

        // account linkine tiklayin
        driver.findElement(By.xpath("(//span[.='Account'])[1]")).click();

        // windowhandle degerini ve url'i yazdirin

        System.out.println("Account url : " + driver.getCurrentUrl());
        System.out.println("Account window handle degeri : " + driver.getWindowHandle());


    }
}
