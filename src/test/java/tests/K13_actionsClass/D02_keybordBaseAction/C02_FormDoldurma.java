package tests.K13_actionsClass.D02_keybordBaseAction;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C02_FormDoldurma extends TestBase_Each {

    private static final Logger log = LoggerFactory.getLogger(C02_FormDoldurma.class);

    @Test
    public void test01(){

        // 1- https://www.testotomasyonu.com adresine gidin
        driver.get("https://www.testotomasyonu.com");

        // 2- Account linkine tiklayin
        driver.findElement(By.xpath("(//span[.='Account'])[1]")).click();

        // 3- Sign Up linkine basalim
        driver.findElement(By.xpath("//*[.=' Sign Up']")).click();

        // 4- Ad,soyad,mail ve sifre kutularina deger yazalim

        /*
            Formdaki tum kutulari tek tek locate etmek yerine
            firstName kutusuna click yapip, isim gonderelim
            sonraki kutulara gecisi de TAB tusu ile yapabiliriz
         */
        Actions actions = new Actions(driver);
        ReusableMethods.bekle(2);
        WebElement firstnameKutusu = driver.findElement(By.id("firstName"));
        ReusableMethods.bekle(4);
        actions.click(firstnameKutusu)
                .sendKeys("Ali")
                .sendKeys(Keys.TAB)
                .sendKeys("Can")
                .sendKeys(Keys.TAB)
                .sendKeys("alican@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("12345")
                .sendKeys(Keys.TAB)
                .sendKeys("12345")
                .sendKeys(Keys.PAGE_UP).perform();

        ReusableMethods.bekle(4);

        //    ve Sign Up butonuna basalim
        driver.findElement(By.xpath("//*[@class='submitbtn btn-lg']")).click();


        // 5- Kaydin olusturuldugunu test edin
        ReusableMethods.bekle(3);

        WebElement emailKutusu = driver.findElement(By.xpath("//input[@id ='email']"));
        emailKutusu.sendKeys("alican@gmail.com");

        WebElement passwordKutusu = driver.findElement(By.xpath("//input[@id ='password']"));
        passwordKutusu.sendKeys("12345");

        driver.findElement(By.id("submitlogin")).click();

        WebElement logoutButonu = driver.findElement(By.xpath("//span[.='Logout']"));
        Assertions.assertTrue(logoutButonu.isEnabled());

        logoutButonu.click();

        ReusableMethods.bekle(2);


    }
}
