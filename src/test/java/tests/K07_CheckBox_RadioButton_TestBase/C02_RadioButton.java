package tests.K07_CheckBox_RadioButton_TestBase;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_RadioButton {

    // a. Verilen web sayfasina gidin
    //      https://testotomasyonu.com/form
    // b. Cinsiyet Radio button elementlerini locate edin
    // c. Iki farkli test methodu olusturup yazidan veya buton'dan size uygun olani secin
    // d. Sectigini radio button'un seciliiotekilerin secili olmadigini test edin
    WebDriver driver;

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @AfterEach
    public void teardown() {
        driver.quit();

    }


    @Test
    public void yazidanSecimTesti() {
        // a. Verilen web sayfasina gidin
        //      https://testotomasyonu.com/form

        driver.get("https://testotomasyonu.com/form");

        // b. Cinsiyet Radio button elementlerini locate edin
        WebElement kadinRadioButton = driver.findElement(By.id("inlineRadio1"));
        WebElement erkekRadioButton = driver.findElement(By.id("inlineRadio2"));
        WebElement digerRadioButton = driver.findElement(By.id("inlineRadio3"));

        // c. Iki farkli test methodu olusturup yazidan size uygun olani secin

        driver.findElement(By.xpath("//*[@for='inlineRadio1']"))
                .click();

        // d. Sectigini radio button'un secili otekilerin secili olmadigini test edin

        Assertions.assertTrue(kadinRadioButton.isSelected());
        Assertions.assertFalse(erkekRadioButton.isSelected());
        Assertions.assertFalse(digerRadioButton.isSelected());


    }

    @Test
    public void butondanSecimTesti() {
        // a. Verilen web sayfasina gidin
        //      https://testotomasyonu.com/form

        driver.get("https://testotomasyonu.com/form");

        // b. Cinsiyet Radio button elementlerini locate edin
        WebElement kadinRadioButton = driver.findElement(By.id("inlineRadio1"));
        WebElement erkekRadioButton = driver.findElement(By.id("inlineRadio2"));
        WebElement digerRadioButton = driver.findElement(By.id("inlineRadio3"));

        // c. Iki farkli test methodu olusturup buton'dan size uygun olani secin
        kadinRadioButton.click();
        // d. Sectigini radio button'un seciliiotekilerin secili olmadigini test edin

        Assertions.assertTrue(kadinRadioButton.isSelected());
        Assertions.assertFalse(erkekRadioButton.isSelected());
        Assertions.assertFalse(digerRadioButton.isSelected());

    }

}