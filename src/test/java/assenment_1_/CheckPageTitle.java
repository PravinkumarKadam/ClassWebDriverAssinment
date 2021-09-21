package assenment_1_;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class CheckPageTitle {
	public static void main(String[] args) {
		WebDriver driver;
		// driver = new ChromeDriver();
		driver = new FirefoxDriver();
		// driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");

		String GivenTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		String CurrentTitle = driver.getTitle();
		System.out.println("Fetching current title :" + CurrentTitle);
		
		if (GivenTitle.equals(CurrentTitle)) 
		{
			System.out.println("Title is matched successfully");
		}
		else {
			System.out.println("Title is not matched");
		}

		driver.quit();
	}
}
