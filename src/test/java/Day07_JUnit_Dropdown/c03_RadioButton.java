package Day07_JUnit_Dropdown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class c03_RadioButton {

    //Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
    //	a. Verilen web sayfasına gidin.
    //	     https://facebook.com
    //	b. Cookies’i kabul edin
    //	c. Create an account buton’una basin
    //	d. Radio button elementlerini locate edin ve size uygun olani secin
    //	e. Sectiginiz radio button’un seçili, ötekilerin seçili olmadigini test edin
    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @After
    public void teardown(){
    driver.close();

    }

    @Test
    public void Test() throws InterruptedException {

        driver.get("https://www.facebook.com");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@data-testid=\"open-registration-form-button\"]")).click();
        Thread.sleep(3000);
        WebElement radioBKadin =driver.findElement(By.xpath("(//*[@class=\"_8esa\"])[1]"));
        WebElement radioBErkek =driver.findElement(By.xpath("(//*[@class=\"_8esa\"])[2]"));
        WebElement radioBEc =driver.findElement(By.xpath("(//*[@class=\"_8esa\"])[3]"));

        radioBErkek.click();

        Assert.assertFalse(radioBKadin.isSelected());
        Assert.assertTrue(radioBErkek.isSelected());
        Assert.assertFalse(radioBEc.isSelected());
    }

}
