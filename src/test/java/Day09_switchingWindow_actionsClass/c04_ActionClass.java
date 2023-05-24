package Day09_switchingWindow_actionsClass;

import Utlities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class c04_ActionClass extends TestBase {


    @Test
    public void Test() throws InterruptedException {




    //1- https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");
    //2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
    WebElement dragMeElementi = driver.findElement(By.xpath("//*[@id='draggable']"));
    WebElement dropHereElementi= driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));

    Actions actions = new Actions(driver);
        actions.dragAndDrop(dragMeElementi,dropHereElementi).perform();

        Thread.sleep(4000);
    //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        WebElement droppedYaziElementi = driver.findElement(By.xpath("//p[text()='Dropped!']"));
        String expectedyazi = "Dropped!";
        String actualYazi = droppedYaziElementi.getText();

        Assert.assertEquals(expectedyazi,actualYazi);
}
}