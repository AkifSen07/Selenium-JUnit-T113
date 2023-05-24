package Day08_testBase_JSalerts_iframe;

import Utlities.TestBase;
import Utlities.TestBaseBeforeClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class c02_TestBaseBeforeClass extends TestBaseBeforeClass {

  /*
        Otomasyon yaparken iki tur alert ile karsilasabiliriz.
        Alert web sitelerinde çıkan uyarılardır. Bazıları locate edilebilir bazıları edilemez.
        1- HTML alerts :
           HTML kodlari ile olusturulmus alert'lerdir
           HTML ile olusturuldugu icin inspect edilebilir,
           locate edilebilir ve driver ile kullanilabilir
        2- JavaScript Alerts :
           Inspect yapilamaz, locate edilemez
           Testlerimiz sirasinda JS alert ile karsilasirsak
           driver.switchTo().alert() method'larini kullanarak
           alert'e gecis yapabilir ve alert uzerinde
           OK, Cancel, Alert yazisini alma getText()
           ve alert'e yazi yollama sendKeys()
           method'larini kullanabiliriz.
     */

    /*
            3 test method'u olusturup asagidaki gorevi tamamlayin
        1. Test
            -  https://the-internet.herokuapp.com/javascript_alerts adresine gidin
            - 1.alert'e tiklayin
            -  Alert'deki yazinin "I am a JS Alert" oldugunu test edin
            -  OK tusuna basip alert'i kapatin
        2.Test
            - https://the-internet.herokuapp.com/javascript_alerts adresine gidin
            - 2.alert'e tiklayalim
            - Cancel'a basip, cikan sonuc yazisinin "You clicked: Cancel" oldugunu test edin
        3.Test
            - https://the-internet.herokuapp.com/javascript_alerts adresine gidin
            - 3.alert'e tiklayalim
            - Cikan prompt ekranina "Abdullah" yazdiralim
            - OK tusuna basarak alert'i kapatalim
            - Cikan sonuc yazisinin Abdullah icerdigini test edelim
            */

    @Test
    public void Test01() throws InterruptedException {
        /*
         1. Test
            -  https://the-internet.herokuapp.com/javascript_alerts adresine gidin
            - 1.alert'e tiklayin
            -  Alert'deki yazinin "I am a JS Alert" oldugunu test edin
            -  OK tusuna basip alert'i kapatin
         */
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//button[@onclick=\"jsAlert()\"]")).click();
        Thread.sleep(3000);

        String expectedalert="I am a JS Alert";
        String actualalert=driver.switchTo().alert().getText();
        Assert.assertEquals(expectedalert,actualalert);
        driver.switchTo().alert().accept();

    }

    @Test
    public void Test02() throws InterruptedException {
        /*
        2.Test
            - https://the-internet.herokuapp.com/javascript_alerts adresine gidin
            - 2.alert'e tiklayalim
            - Cancel'a basip, cikan sonuc yazisinin "You clicked: Cancel" oldugunu test edin
         */

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//button[@onclick=\"jsConfirm()\"]")).click();
        Thread.sleep(3000);
        driver.switchTo().alert().dismiss();
        String expectedElement="You clicked: Cancel";
        String actualElement =driver.findElement(By.id("result")).getText();
        Assert.assertEquals(expectedElement,actualElement);

    }
    @Test
    public void Test03(){
        /*
        3.Test
            - https://the-internet.herokuapp.com/javascript_alerts adresine gidin
            - 3.alert'e tiklayalim
            - Cikan prompt ekranina "Abdullah" yazdiralim
            - OK tusuna basarak alert'i kapatalim
            - Cikan sonuc yazisinin Abdullah icerdigini test edelim
         */

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//button[@onclick=\"jsPrompt()\"]")).click();
        driver.switchTo().alert().sendKeys("Abdullah");
        driver.switchTo().alert().accept();
        String exxpectedIcerik="Abdullah";
        String actualIcerik =driver.findElement(By.id("result")).getText();
        Assert.assertTrue(actualIcerik.contains(exxpectedIcerik));




    }








            }
