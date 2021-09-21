package assenment_3_;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class mouseactions_1 {
	
	   WebDriver driver;
       int implicitlyWait = 40;
       WebDriverWait wait;
       String DragText = "Dropped!";
       String BeforeDropInBoxText = "Drop here";
	   String url = "https://demoqa.com/droppable";

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
	public void test_0() throws InterruptedException 
	{
		wait.until(ExpectedConditions.urlToBe(url));
		WebElement  dragme = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement  dropHere = driver.findElement(By.xpath("//div[@id='droppable']"));

		Actions act = new Actions(driver);
//		act.clickAndHold(dragme).moveToElement(dropHere).build().perform();
//		Thread.sleep(2000);
        act.dragAndDrop(dragme, dropHere).build().perform();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Dropped!']")));

		String ActualTextOfDropBox = driver.findElement(By.xpath("//p[text()='Dropped!']")).getText();

		Assert.assertEquals("Dragme element is not drag", DragText, ActualTextOfDropBox);
		System.out.println("Test 0 ::> Element is successfully drag and test case passed.");
	}
	
	
	@Test
	public void test_1() throws InterruptedException 
	{
		wait.until(ExpectedConditions.urlToBe(url));

		WebElement  acceptOption = driver.findElement(By.xpath("//a[@id='droppableExample-tab-accept']"));
		acceptOption.click();

		WebElement notAcceptableDrag = driver.findElement(By.xpath("//div[@id='notAcceptable']"));
		WebElement DropHereBox = driver.findElement(By.xpath("(//div[@id='droppable'])[2]")); 

		Actions act = new Actions(driver);
		act.dragAndDrop(notAcceptableDrag, DropHereBox).build().perform();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div/p[text()='Drop here'])[2]")));
		String ActualTextOfDropBox = driver.findElement(By.xpath("(//div/p[text()='Drop here'])[2]")).getText();

		Assert.assertEquals("Not Accetable text case accpet something is wrong", BeforeDropInBoxText,ActualTextOfDropBox);
		Thread.sleep(5000);

		System.out.println("Test 1 ::> Not Accetable text case is successfully passed");  	
	}
	
	@Test
	public void test_2() throws InterruptedException 
	{
		wait.until(ExpectedConditions.urlToBe(url));
		try
		{
        	driver.findElement(By.xpath("//a[@id='close-fixedban']")).click();
		}
		catch (Exception e)
		{
			System.out.println("Add is not over the page ::> "+e.getMessage());
		}
		WebElement  PreventPropogation = driver.findElement(By.xpath("//a[@id=\"droppableExample-tab-preventPropogation\"]"));
		PreventPropogation.click();

		WebElement  dragme = driver.findElement(By.xpath("//div[@id='dragBox']")); 
		WebElement InnerDropableBox  = driver.findElement(By.xpath("//div[@id='greedyDropBoxInner']"));

		Actions action = new Actions(driver);
		action.clickAndHold(dragme).moveToElement(InnerDropableBox).build().perform();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='greedyDropBox']//p[text()='Dropped!']")));

		String ActualTextOfDropBox = driver.findElement(By.xpath("//div[@id='greedyDropBox']//p[text()='Dropped!']")).getText();

		Assert.assertEquals("Dragme not drop in inner Dropable Box", DragText, ActualTextOfDropBox);
		System.out.println("Test 2 ::> Element is successfully drag in inner box and test case passed.");
	}

	@Test
	public void test_3() throws InterruptedException
	{
		wait.until(ExpectedConditions.urlToBe(url));

		WebElement  RevertDraggable = driver.findElement(By.xpath("//a[@id=\"droppableExample-tab-revertable\"]"));
		RevertDraggable.click();

		WebElement WillRevertable = driver.findElement(By.xpath("//div[@id='revertable']"));
		WebElement dragHere = driver.findElement(By.xpath("(//div[@id='droppable'])[3]"));

		Actions act = new Actions(driver);
		act.dragAndDrop(WillRevertable, dragHere).build().perform();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Dropped!']")));
		String ActualTextOfDropBox = driver.findElement(By.xpath("//p[text()='Dropped!']")).getText();

		Assert.assertEquals("WillReverTable is not drop here.",DragText,ActualTextOfDropBox);
		System.out.println("Test 3 ::> Element is successfully drag in box and test case passed.");

	}
	
	@After
	public void closeBrowser() 
	{
	  driver.quit();
	}

}
