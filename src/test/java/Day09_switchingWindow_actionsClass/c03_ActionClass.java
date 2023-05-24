package Day09_switchingWindow_actionsClass;

import Utlities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.util.Set;

public class c03_ActionClass extends TestBase {
    //2- https://the-internet.herokuapp.com/context_menu sitesine gidin
    //3- Cizili alan uzerinde sag click yapin


    //4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edin.

    //5- Tamam diyerek alert’i kapatalim
    //6- Elemental Selenium linkine tiklayalim
    //  linki tikladigimizda yeni window acildigindan
    //  tiklamadan once ilk window'un WHD almamiz gerekir

    // ikinci sayfa biz newWindow() demeden acildigindan
    // ikinciWindow'un WHD'ini Java kullanarak bulmaliyiz
   // icinde 2 tane WHD var
    // ilkWindowWHD'e esit olmayani ikinciWindowWHD olarak atayalim
    //7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim


    @Test
    public void Test(){
        driver.get("https://the-internet.herokuapp.com/context_menu");
        WebElement cizgiliAlan=driver.findElement(By.id("hot-spot"));
        Actions actions=new Actions(driver);
        actions.contextClick(cizgiliAlan).perform();

        String expectedAlertText="You selected a context menu";
        String actualAlertText=driver.switchTo().alert().getText();
        Assert.assertEquals(expectedAlertText,actualAlertText);


        driver.switchTo().alert().accept();
        String w1Whandle=driver.getWindowHandle();
        driver.findElement(By.linkText("Elemental Selenium")).click();

        String w2Whandle="";
        Set<String> toplamWHandles=driver.getWindowHandles();
        for (String eachwH:toplamWHandles
             ) {if (!eachwH.contains(w1Whandle)){
                 w2Whandle=eachwH;
        }

        }

        driver.switchTo().window(w2Whandle);

        String expectedIcerik="Elemental Selenium";
        String actualIcerik=driver.findElement(By.tagName("h1")).getText();
        Assert.assertEquals(expectedIcerik,actualIcerik);






    }


}
