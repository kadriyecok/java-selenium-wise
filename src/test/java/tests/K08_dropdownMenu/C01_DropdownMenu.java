package tests.K08_dropdownMenu;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

import java.util.List;

public class C01_DropdownMenu extends TestBase_Each {

    // https://the-internet.herokuapp.com/dropdown adresine gidin
    //1. index kullanarak secenek 1'i (Option 1) secin ve yazdirin
    //2. Value kullanarak secenek 2'yi (Option 2) secin ve yazdirin
    //3. Visible Text (Gorunen Metin) kullanarak secenek 1'i (Option 1) secin ve yazdirin
    //4. Tum dropdown degerleri (value) yazdirin
    //5. Dropdown'un boyutunun 4 oldugunu test edin


    @Test
    public void test01(){

        // https://the-internet.herokuapp.com/dropdown adresine gidin
        driver.get("https://the-internet.herokuapp.com/dropdown");

            // 1.adim dropdown menuyu locate edip kaydedelim
        WebElement ddm= driver.findElement(By.id("dropdown"));
            // 2.adim Select class'indan obje olusturup, parametre olarak ddm'yi girin
        Select select = new Select(ddm);
            // 3.adim olusturulan select objesi ile istenen islemleri yapin

        //1. index kullanarak secenek 1'i (Option 1) secin ve yazdirin

        select.selectByIndex(1);

        System.out.println(select.getFirstSelectedOption().getText());
        ReusableMethods.bekle(2);

        //2. Value kullanarak secenek 2'yi (Option 2) secin ve yazdirin

        select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption().getText());
        ReusableMethods.bekle(2);

        //3. Visible Text (Gorunen Metin) kullanarak secenek 1'i (Option 1) secin ve yazdirin

        select.selectByVisibleText("Option 1");

        System.out.println(select.getFirstSelectedOption().getText());
        ReusableMethods.bekle(2);

        //4. Tum dropdown degerleri (value) yazdirin

            // 1. alternatif tum listeyi text olarak yazdirma
        System.out.println(ddm.getText());

            // 2. alternatif, Reusable class'daki String listeye cevirme methodunu
        List<WebElement> tumOptionElementleriList = select.getOptions();

        //5. Dropdown'un boyutunun 4 oldugunu test edin

        int expectedDropdownBoyutu = 4;
        int actualDropdownBoyutu = tumOptionElementleriList.size();

        Assertions.assertEquals(expectedDropdownBoyutu,actualDropdownBoyutu);
    }




}
