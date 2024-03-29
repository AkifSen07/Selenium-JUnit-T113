package Day06_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Driver;
import java.time.Duration;

public class c05_Assert {
    WebDriver driver;

    public void mahserin4Atlisi(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.bestbuy.com");
    }

    @Test
    public void test01(){
        // ○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
        mahserin4Atlisi();
        String expectedUrl="https://www.bestbuy.com/";
        String actualUrl= driver.getCurrentUrl(); // https://www.bestbuy.com/

        Assert.assertEquals(expectedUrl,actualUrl);
        driver.close();
    }
    @Test
    public void test02(){
        // ○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
        mahserin4Atlisi();
        String unExpectedIcerik = "Rest";
        String actualTitle= driver.getTitle();

        Assert.assertFalse(actualTitle.contains(unExpectedIcerik));
        driver.close();
    }


}
