package Day09_switchingWindow_actionsClass;

import Utlities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Set;

public class c02_switchingWindow_actionsClass extends TestBase {


        @Test
        public void Test() throws InterruptedException {

            //● https://the-internet.herokuapp.com/windows adresine gidin.
            driver.get("https://the-internet.herokuapp.com/windows");
            String w1WHandle = driver.getWindowHandle();


            //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
            String expectedText="Opening a new window";
            String actualText=driver.findElement(By.tagName("h3")).getText();
            Assert.assertEquals(expectedText,actualText);

            //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
            String sayfabasligi=driver.getTitle();
            String expectedBaslik="The Internet";
            Assert.assertEquals(sayfabasligi,expectedBaslik);


            //● Click Here butonuna basın.
            driver.findElement(By.linkText("Click Here")).click();
            Thread.sleep(2000);
            
            // 34.satir itibariyle yeni window acildi
            // artik 2 window var
            Set<String> toplamWHandles = driver.getWindowHandles();
            String w2Whandle="";
            for (String eachWhandle:toplamWHandles
                 ) {if (!eachWhandle.contains(w1WHandle)){
                      w2Whandle=eachWhandle;
            }
                
            }
            System.out.println(w1WHandle);
            System.out.println(w2Whandle);
            // Artik acilan 2.window'un windowHandleDegerine sahibiz


            //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
            driver.switchTo().window(w2Whandle);

            String expectedBaslikw2="New Window";
            String actualBaslikw2=driver.getTitle();
            Assert.assertEquals(expectedBaslikw2,actualBaslikw2);

            
            //● Sayfadaki textin “New Window” olduğunu doğrulayın.

            String expectedTextw2="New Window";
            String actualTextw2=driver.findElement(By.tagName("h3")).getText();
            Assert.assertEquals(expectedTextw2,actualTextw2);


            //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.

            driver.switchTo().window(w1WHandle);
            String expectedBaslikw1="The Internet";
            String actualBaslikw1=driver.getTitle();
            Assert.assertEquals(expectedBaslikw1,actualBaslikw1);

        }





    }
