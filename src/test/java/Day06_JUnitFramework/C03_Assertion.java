package Day06_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_Assertion {

      /*
        Bir Assertion failed olursa
        Assertion'in oldugu satirda exception olusur
        ve assertion satirindan sonraki kodlar CALISMAZ
     */



    WebDriver driver;

    // 1- google anasayfaya gidip, url'in google icerdigini test edin
    @Test

    public void GoogleTest(){

        mahserin4Atlisi();

        driver.get("https://www.google.com.tr");

        String expectedElement ="google";
        String actualElement  = driver.getCurrentUrl();
        Assert.assertTrue(actualElement.contains(expectedElement));
        driver.close();

    }

    // 2- wisequarter anasayfaya gidip url'in wisequarter icerdigini test edin

    @Test

    public void WiseTest(){

        mahserin4Atlisi();

        driver.get("https://www.wisequarter.com");

        String expectedwiseElement ="wisequarter";
        String actualwiseElement  = driver.getCurrentUrl();
        Assert.assertTrue(actualwiseElement.contains(expectedwiseElement));
        driver.close();
    }




    public void mahserin4Atlisi() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
}


