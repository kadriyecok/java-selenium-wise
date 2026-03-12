package tests.K07_CheckBox_RadioButton_TestBase;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;

import javax.swing.*;
import java.time.Duration;

public class C01_CheckBoxTesti {

    WebDriver driver;

    @BeforeEach
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }
    @AfterEach
    public void teardown(){
        driver.quit();
    }
    @Test
    public void checkBoxTesti(){
        // a. Verilen web sayfasina gidin
        //      https://testotomasyonu.com/form
        driver.get("https://testotomasyonu.com/form");

       // Actions actions = new Actions(driver);
       // actions.sendKeys(Keys.PAGE_DOWN).perform();

        // b. Sirt Agiris ve Carpinti CheckBox'larini secin
        WebElement sirtAgrisiCheckBox = driver.findElement(By.id("gridCheck5"));
        WebElement carpintiCheckBox = driver.findElement(By.id("gridCheck4"));

        sirtAgrisiCheckBox.click();
        carpintiCheckBox.click();

        // c. Sirt Agiris ve Carpinti CheckBox'larinin secili oldugunu test edin

        Assertions.assertTrue(sirtAgrisiCheckBox.isSelected());
        Assertions.assertTrue(carpintiCheckBox.isSelected());

         Actions actions = new Actions(driver);
         ReusableMethods.bekle(1);
         actions.sendKeys(Keys.PAGE_DOWN).perform();
         ReusableMethods.bekle(1);


        // d. Seker ve epilepsi Checkbox'larinin secili olmadigini test edin

        WebElement sekerCheckBox = driver.findElement(By.id("hastalikCheck2"));
        WebElement epilepsiCheckBox = driver.findElement(By.id("hastalikCheck7"));

        Assertions.assertFalse(sekerCheckBox.isSelected());
        Assertions.assertFalse(epilepsiCheckBox.isSelected());





    }
}
