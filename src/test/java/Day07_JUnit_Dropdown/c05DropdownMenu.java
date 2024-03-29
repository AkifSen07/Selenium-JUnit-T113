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
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class c05DropdownMenu {

    //● https://the-internet.herokuapp.com/dropdown adresine gidin.
    //	1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    //	2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
    //	3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    //	4.Tüm dropdown değerleri(value) yazdırın
    //	5. Dropdown’un boyutunun 4 olduğunu test edin

    static WebDriver driver;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/dropdown");
    }
    @AfterClass
    public static void teardown(){
        driver.close();
    }

    @Test
    public void Test01() throws InterruptedException {

        WebElement selectElementi =driver.findElement(By.id("dropdown"));
        Select select=new Select(selectElementi);


        // 1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        select.selectByIndex(1);
        Thread.sleep(2000);
        System.out.println(select.getFirstSelectedOption().getText());

        //2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        select.selectByValue("2");
        Thread.sleep(2000);
        System.out.println(select.getFirstSelectedOption().getText());


        //3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        select.selectByVisibleText("Option 1");
        Thread.sleep(2000);
        System.out.println(select.getFirstSelectedOption().getText());


        //4.Tüm dropdown değerleri(value) yazdırın
        List<WebElement> dropdownTumDegerler=select.getOptions();
        for (WebElement eachelement:dropdownTumDegerler
             ) {
            System.out.println(eachelement.getText());

        }
        //5. Dropdown’un boyutunun 4 olduğunu test edin

        int expectedSize=4;
        int actualSize=dropdownTumDegerler.size();
        Assert.assertEquals(expectedSize,actualSize);


    }
}
