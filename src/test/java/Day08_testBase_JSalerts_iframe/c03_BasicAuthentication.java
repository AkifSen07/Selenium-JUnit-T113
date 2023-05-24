package Day08_testBase_JSalerts_iframe;

import Utlities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class c03_BasicAuthentication extends TestBase {
    //1- Bir class olusturun : BasicAuthentication
    //2- https://the-internet.herokuapp.com/basic_auth sayfasina gidin
    //3- asagidaki yontem ve test datalarini kullanarak authentication’i yapin
    //
    //Html komutu : https://username:password@URL
    //	Username     : admin
    // 	password      : admin
    //
    //4- Basarili sekilde sayfaya girildigini dogrulayin

    @Test
    public void Test(){
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

        WebElement congratyaziElementi = driver.findElement(By.tagName("p"));

        Assert.assertTrue(congratyaziElementi.isDisplayed());



    }


}
