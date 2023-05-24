package A.Pratik01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.A;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class c02 {


    static WebDriver driver;

    @BeforeClass

    public static void setup(){

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    }
    @AfterClass

    public static void teardown(){
        driver.close();
    }

    @Test
    public void  Test() throws InterruptedException {
        driver.get("https://www.hepsiburada.com");
        Thread.sleep(3000);
        Actions action=new Actions(driver);
        WebElement menuElementi=driver.findElement(By.xpath("(//li[@class=\"sf-MenuItems-WulWXvlfIAwNiOUGY7FP\"])[1]"));
        action.moveToElement(menuElementi).perform();
        Thread.sleep(2000);


        WebElement bilgisayarMenuElement=driver.findElement(By.xpath("(//a[@href=\"https://www.hepsiburada.com/bilgisayarlar-c-2147483646\"])[1]"));
        action.moveToElement(bilgisayarMenuElement).perform();

        Thread.sleep(2000);

        WebElement laptopElementi= driver.findElement(By.xpath("(//a[@href=\"https://www.hepsiburada.com/laptop-notebook-dizustu-bilgisayarlar-c-98\"])[1]"));
        laptopElementi.click();

        Thread.sleep(1500);




    }
}
