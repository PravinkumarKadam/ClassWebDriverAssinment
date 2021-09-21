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

import java.util.concurrent.TimeUnit;

public class Double_Click {

    WebDriver driver;
    int implicitlyWait = 20;
    WebDriverWait wait;
    String alertText = "You double clicked me.. Thank You..";
    String url = "http://demo.guru99.com/test/simple_context_menu.html";

    @Before
    public void setBorwser()
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
    public void DoubleClickTest()
    {
        wait.until(ExpectedConditions.urlToBe(url));

       WebElement button =  driver.findElement(By.xpath("//button[text()='Double-Click Me To See Alert']"));

       Actions act = new Actions(driver);
       act.doubleClick(button).build().perform();

       Alert alert= driver.switchTo().alert();

       Assert.assertEquals("Double Click action not performed.",alertText,alert.getText());
       alert.accept();
       System.out.println("Test 1 ::> Double Click Test case passed.");
    }

    @After
    public void closeBrowser()
    {
        driver.quit();
    }
}
