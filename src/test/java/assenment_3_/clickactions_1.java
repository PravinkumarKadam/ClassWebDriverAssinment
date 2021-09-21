package assenment_3_;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class clickactions_1 {

    WebDriver driver;
    int implicitlyWait = 20;
    WebDriverWait wait;
    String DragText = "Dropped!";
    String BeforeDropInBoxText = "Drop here";
    String url = "http://demo.guru99.com/test/simple_context_menu.html";
    String alertText = "clicked: copy";


    @Before
    public void setBrowser()
    {
        driver = new ChromeDriver();
        //	driver = new FirefoxDriver();
        //	driver = new EdgeDriver();

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(implicitlyWait, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, implicitlyWait);
        driver.get(url);
    }

    @Test
    public void RightClickMe_Test()
    {
        wait.until(ExpectedConditions.urlToBe(url));
        WebElement rightClickMeButton = driver.findElement(By.xpath("//span[text()='right click me']"));

        Actions act = new Actions(driver);
        act.contextClick(rightClickMeButton).build().perform();

        List<WebElement> ListOfRightButtonClick = driver.findElements(By.xpath("//ul[@class='context-menu-list context-menu-root']/li/span"));
        int flag = 0;
        for (int i = 0; i<ListOfRightButtonClick.size();i++)
        {
            System.out.println(ListOfRightButtonClick.get(i).getText());
            if(ListOfRightButtonClick.get(i).getText().equalsIgnoreCase("copy"))
            {
                flag = i;
            }
        }

        ListOfRightButtonClick.get(flag).click();

        Alert alert = driver.switchTo().alert();

        Assert.assertEquals("Copy option is not selected with right click.",alertText, alert.getText());
        alert.accept();
        System.out.println("Test 1 ::> Right Click on button and salect copy option and test case passed.");
    }

    @After
    public void closeBrowser()
    { 
        driver.quit();
    }
}
