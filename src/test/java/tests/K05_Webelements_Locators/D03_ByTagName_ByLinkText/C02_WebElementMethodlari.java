package tests.K05_Webelements_Locators.D03_ByTagName_ByLinkText;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_WebElementMethodlari {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // https://www.testotomasyonu.com/form adresine gidin
        driver.get("https://www.testotomasyonu.com/form");

        WebElement kadinRadioButton = driver.findElement(By.id("inlineRadio1"));
        WebElement erkekRadioButton = driver.findElement(By.id("inlineRadio2"));
        WebElement digerRadioButton = driver.findElement(By.id("inlineRadio3"));

        // Cinsiyet bolumunden size uygun radio button secin
        kadinRadioButton.click();

        // istediginiz radio buttonunun secili oldugunu test edin
        if (kadinRadioButton.isSelected()){
            System.out.println("Sectigimiz radio button testi PASSED");
        } else System.out.println("Sectigimiz radio button testi FAILED");

        // sizin isaretlediginiz disindaki butonlarin secili olmadigini test edin

        if (! erkekRadioButton.isSelected()){
            System.out.println("Secmedigimiz radio button testi PASSED");
        } else System.out.println("Secmedigimiz radio button testi FAILED");

        if (!digerRadioButton.isSelected()){
            System.out.println("Secmedigimiz radio button testi PASSED");
        } else System.out.println("Secmedigimiz radio button testi FAILED");

        // soyisim kutusunun boyutlarini ve konumunu yazdirin
        WebElement soyisimKutuElementi = driver.findElement(By.id("surname"));

        System.out.println("Soyisim kutusu boyut : " + soyisimKutuElementi.getSize());
        System.out.println("Soyisim kutusu konum : " + soyisimKutuElementi.getLocation());

        // soyisim kutusunun HTML kodundaki class attiribute degerinin
        // "form-control" oldugunu test edin

        String expectedAttributeDegeri = "form-control";
        String actualAttributeDegeri = soyisimKutuElementi.getAttribute("class");

        if (expectedAttributeDegeri.equals(actualAttributeDegeri)){
            System.out.println("Soyisim kutusu class attribute testi PASSED");
        } else System.out.println("Soyisim kutusu class attribute testi FAILED");


        // sayfayi kapatin
        Thread.sleep(2000);
        driver.quit();

    }
}
