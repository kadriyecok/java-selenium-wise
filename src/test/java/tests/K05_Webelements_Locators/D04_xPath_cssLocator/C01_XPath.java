package tests.K05_Webelements_Locators.D04_xPath_cssLocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_XPath {

    public static void main(String[] args){

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //1- https://www.testotomasyonu.com/addremove/ adresine gidin
        driver.get("https://www.testotomasyonu.com/addremove");

        //2- Add element butonuna basin
        driver.findElement(By.xpath("//button[@id='sub-btn']")).click();

        //3- Remove butonunun gorunur oldugunu test edin
        WebElement removeButtonu = driver.findElement(By.xpath("//button[@class='remove-btn']"));

        if (removeButtonu.isDisplayed()){
            System.out.println("Remove button testi PASSED");
        } else System.out.println("Remove button testi FAILED");

        //4- Remove tusuna basin
        removeButtonu.click();

        //5- "Add/Remove Elements" yazisinin gorunur oldugunu test edin

        //WebElement addRemoveYaziElementi = driver.findElement(By.tagName("h2"));

        // xPath ile yazilisi
        WebElement addRemoveYaziElementi = driver.findElement(By.xpath("//h2"));

        if (addRemoveYaziElementi.isDisplayed()){
            System.out.println("Add remove yazi testi PASSED");
        } else System.out.println("Add remove yazi testi FAILED");

        //6- Sayfayi kapatin

        driver.quit();
    }
}
