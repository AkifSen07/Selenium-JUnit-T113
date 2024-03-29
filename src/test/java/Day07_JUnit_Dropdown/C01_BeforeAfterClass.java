package Day07_JUnit_Dropdown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_BeforeAfterClass {

    //2) https://www.youtube.com adresine gidin
    //3) Aşağıdaki adları kullanarak 4 test metodu oluşturun ve gerekli testleri yapin
    //	○ titleTest 	=> Sayfa başlığının “YouTube” oldugunu test edin
    //	○ imageTest 	=> YouTube resminin görüntülendiğini (isDisplayed()) test edin
    //	○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
    //	○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin


    static WebDriver driver;

    @BeforeClass

    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.youtube.com");

    }

    @AfterClass
        public static void teardown(){
            driver.close();
        }
        @Test
        public void Test01(){
        String expectedIcerik="YouTube";
        String actualIcerik=driver.getTitle();
        Assert.assertTrue(actualIcerik.contains(expectedIcerik));
        }

        @Test
        public void Test02(){

      Assert.assertTrue(driver.findElement(By.xpath("//div[@id=\"end\"]")).isDisplayed());


        }
        @Test
    public void Test03(){

            WebElement searchBoxElementi=driver.findElement(By.xpath("//input[@id=\"search\"]"));
            Assert.assertTrue(searchBoxElementi.isEnabled());
        }

        @Test
    public void Test04(){

        String baslikelementi=driver.getTitle();
        String istenmeyenelement="YouTube";
        Assert.assertNotEquals(istenmeyenelement,baslikelementi);


        }

}
