package Day08_testBase_JSalerts_iframe;

import Utlities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class c04_IFrame extends TestBase {

    // 1 ) https://the-internet.herokuapp.com/iframe adresine gidin.
    // 2 ) Bir metod olusturun: iframeTest
    //	- “An IFrame containing….” textinin erisilebilir oldugunu test edin
    //    ve  konsolda yazdirin.
    //	- Text Box’a “Merhaba Dunya!” yazin.
    //	- TextBox’in altinda bulunan “Elemental Selenium”
    //    linkini textinin gorunur oldugunu dogrulayin ve  konsolda yazdirin.

    @Test
    public void Test() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/iframe");
        WebElement iframetext=driver.findElement(By.tagName("h3"));
        Assert.assertTrue(iframetext.isDisplayed());
        System.out.println(iframetext.getText());


        WebElement iframeElementi=driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iframeElementi);

        WebElement textBoxElement=driver.findElement(By.tagName("p"));
        textBoxElement.clear();
        textBoxElement.sendKeys("Merhaba Dunya!");
        Thread.sleep(3000);

        driver.switchTo().defaultContent();
        WebElement elementelSelenium=driver.findElement(By.linkText("Elemental Selenium"));
        Assert.assertTrue(elementelSelenium.isDisplayed());
        System.out.println(elementelSelenium.getText());

    }



}
