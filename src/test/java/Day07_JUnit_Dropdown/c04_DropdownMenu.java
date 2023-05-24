package Day07_JUnit_Dropdown;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.asm.Advice;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class c04_DropdownMenu {

    //● https://www.amazon.com/ adresine gidin.
    //- Test 1
    //	Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin
    //-Test 2
    //	1. Kategori menusunden Books secenegini  secin
    //	2. Arama kutusuna Java yazin ve aratin
    //	3. Bulunan sonuc sayisini yazdirin
    //	4. Sonucun Java kelimesini icerdigini test edin


    static  WebDriver driver;

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com/");

    }
    @AfterClass

    public static void teardown(){
        driver.close();
    }

    @Test
    public void Test01(){

        WebElement kategoriElement=driver.findElement(By.xpath("//select[@id=\"searchDropdownBox\"]"));
        Select select=new Select(kategoriElement);
        int expectedKategoriSayi=45;
        int actualKategoriSayi=select.getOptions().size();

        Assert.assertEquals(expectedKategoriSayi,actualKategoriSayi);

    }
    @Test
    public void Test02() throws InterruptedException {

        WebElement kategoriElement=driver.findElement(By.xpath("//select[@id=\"searchDropdownBox\"]"));
        Select select=new Select(kategoriElement);
        select.selectByVisibleText("Books");
        Thread.sleep(3000);
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Java"+ Keys.ENTER);
        Thread.sleep(3000);
        WebElement sonucSayisi=driver.findElement(By.xpath("(//div[@class=\"sg-col-inner\"])[1]"));
        System.out.println(sonucSayisi.getText());

        String expectedIcerik="Java";
        String actualIcerik=sonucSayisi.getText();
        Assert.assertTrue(actualIcerik.contains(expectedIcerik));

    }
}
