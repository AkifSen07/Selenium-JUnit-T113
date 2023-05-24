package A.Pratik01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class c01 {


   @Test

    public void test01(){
       WebDriverManager.chromedriver().setup();
       WebDriver driver=new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofDays(15));



       driver.get("https://automationexercise.com/");

       WebElement anasayfaElementi = driver.findElement(By.xpath("(//a[@href=\"/\"])[2]"));

       String expextedElement="Home";
       String actualElement=anasayfaElementi.getText();

       Assert.assertEquals(expextedElement,actualElement);



       driver.close();



    }

}
