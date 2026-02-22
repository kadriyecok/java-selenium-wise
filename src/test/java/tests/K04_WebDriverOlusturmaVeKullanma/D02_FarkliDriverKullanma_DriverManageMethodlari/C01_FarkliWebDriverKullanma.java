package tests.K04_WebDriverOlusturmaVeKullanma.D02_FarkliDriverKullanma_DriverManageMethodlari;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_FarkliWebDriverKullanma {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://testotomasyonu.com");

        Thread.sleep(2000);
        driver.quit();
    }
}
