package tests.K13_actionsClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C02_Actions_DragAndDrop extends TestBase_Each {

    @Test
    public void test01(){
        // 1- https://testotomasyonu.com/droppable sitesine gidin
        driver.get("https://testotomasyonu.com/droppable");

        // 2- Accept bolumunde "Acceptable" butonunu tutup "Drop Here" kutusunun ustune birakin
        WebElement draggableElementi =  driver.findElement(By.id("draggable2"));
        WebElement dropHereKutusuElementi = driver.findElement(By.id("droppable2"));

        //System.out.println("Tasinmadan once yazi : " + dropHereKutusuElementi.getText());

        Actions actions = new Actions(driver);
        ReusableMethods.bekle(1);

        actions.dragAndDrop(draggableElementi, dropHereKutusuElementi)
                .perform();

        //System.out.println("Tasinmadan sonra yazi : " + dropHereKutusuElementi.getText());

        // 3- "Drop Here" yazisi yerine "Dropped!" oldugunu test edin

        String expectedYazi = "Dropped!";
        String actualYazi = dropHereKutusuElementi.getText();

        Assertions.assertEquals(expectedYazi,actualYazi);

        // 4- Sayfayi yenileyin
        driver.navigate().refresh();

        // 5- "Not Acceptable" butonunu tutup "Drop Here" kutusunun ustune birakin
        WebElement notAcceptableButonu= driver.findElement(By.id("draggable-nonvalid2"));
        driver.findElement(By.id("droppable2"));

        actions.dragAndDrop(notAcceptableButonu,dropHereKutusuElementi)
                .perform();

        // 6- "Drop Here" yazisinin degismedigini test edin
        expectedYazi = "Drop Here";
        actualYazi = dropHereKutusuElementi.getText();

        Assertions.assertEquals(expectedYazi,actualYazi);

    }
}
