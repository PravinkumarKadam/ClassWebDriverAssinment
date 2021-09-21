package assenment_2_;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Filldetails {

	public static void main(String[] args) throws InterruptedException {
		String url = "http://demo.automationtesting.in/Register.html";
		WebDriver driver;
	
		   driver = new ChromeDriver();
	    // driver = new FirefoxDriver();
		// driver = new EdgeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		driver.get(url);

		Thread.sleep(2000);
		WebElement firstName =	driver.findElement(By.xpath("//input[@placeholder='First Name']"));
		firstName.sendKeys("Thomas");
		System.out.println("Step 01 =>  First Name is :: Thomas");
		
		Thread.sleep(2000);
		WebElement lastName = driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
		lastName.sendKeys("Samsung");	
		System.out.println("Step 02 =>  Last Name is :: Samsung");
		
		Thread.sleep(2000);
		WebElement Address = driver.findElement(By.xpath("//textarea[@rows='3']"));
		Address.sendKeys("Thomas Samsung Ontario city California, United States");	
		System.out.println("Step 03 =>  Address :: Thomas Samsung Ontario city California, United States");	
	
		Thread.sleep(2000);
		WebElement EmailAdress = driver.findElement(By.xpath("//input[@ng-model=\"EmailAdress\"]"));
		EmailAdress.sendKeys("ThomasSanmsung@gmail.com");	
		System.out.println("Step 04 =>  Email Adress :: ThomasSanmsung@gmail.com");

		Thread.sleep(2000);
		WebElement Phone = driver.findElement(By.xpath("//input[@ng-model=\"Phone\"]"));
		Phone.sendKeys("9092012035");	
		System.out.println("Step 05 =>  phone : +1 909 201203");
		
		Thread.sleep(2000);
		WebElement selectMale = driver.findElement(By.xpath("//input[@value=\"Male\"]"));
		selectMale.click();	
		System.out.println("Step 06 =>  Select option :: Male");

		Thread.sleep(2000);
		WebElement selectHockey = driver.findElement(By.xpath("//input[@value=\"Hockey\"]"));
		selectHockey.click();	
		System.out.println("Step 07 =>  Select option :: Hockey");

		Thread.sleep(2000);
		WebElement selectLanguages = driver.findElement(By.xpath("//div[@id=\"msdd\"]"));
		selectLanguages.click();
		System.out.println("Step 08 =>  Click on Language Box");
		
		Thread.sleep(2000);
		try {
			WebElement selectEnglishLanguages = driver.findElement(By.xpath("//ul/li/a[text()=\"English\"]"));
			selectEnglishLanguages.click();
			System.out.println("Step 09 =>  select Languages option :: English");
		}
		catch(Exception e)
		{			
			System.out.println(e.getMessage());
			Thread.sleep(3000);
			WebElement selectEnglishLanguages = driver.findElement(By.xpath("//ul/li/a[text()=\"English\"]"));
			selectEnglishLanguages.click();
			System.out.println("Step 09 =>  select Languages option :: English");
		}
		
		Thread.sleep(2000);
		WebElement selectSkills = driver.findElement(By.xpath("//option[contains(text(),'Tech Support')]"));
		selectSkills.click();
		System.out.println("Step 10 =>  select Skills option :: Tech Support");

		Thread.sleep(2000);
		WebElement selectCountry = driver.findElement(By.xpath("//option[@value=\"United Kingdom\"]"));
		selectCountry.click();
		System.out.println("Step 11 =>  select Country option :: United States");
		
		Thread.sleep(2000);
		WebElement selectSelectCountryClick = driver.findElement(By.xpath("//span[@role='combobox']"));
		selectSelectCountryClick.click();
		System.out.println("Step 12 =>  Click on Select Country Box");
		
		Thread.sleep(1000);
		WebElement selectSelectCountry  = driver.findElement(By.xpath("//li[text()='United States of America']"));
		selectSelectCountry.click();
		System.out.println("Step 13 =>  select Select-Country option :: United States of America");
		
		Thread.sleep(1000);
		WebElement yearbox = driver.findElement(By.id("yearbox"));
		yearbox.click();
		System.out.println("Step 14 =>  Click on year Box");
		
		Thread.sleep(1000);
		WebElement selectYearOfBirth = driver.findElement(By.xpath("//div/select/option[@value='1994']"));
		selectYearOfBirth.click();
		System.out.println("Step 15 =>  select Year Of Birth option :: 1994");
		
		Thread.sleep(1000);
		WebElement monthbox = driver.findElement(By.xpath("//select[@placeholder='Month']"));
		monthbox.click();
		System.out.println("Step 16 =>  Click on Month Box");
		
		Thread.sleep(1000);
		WebElement selectMonthOfBirth = driver.findElement(By.xpath("//div/select/option[@value='October']"));
		selectMonthOfBirth.click();
		System.out.println("Step 17 =>  select Month Of Birth option :: October");
				
		Thread.sleep(1000);
		WebElement dayBox = driver.findElement(By.id("daybox"));
		dayBox.click();
		System.out.println("Step 18 =>  Click on Day Box");
		
		Thread.sleep(1000);
		WebElement selectDayOfBirth = driver.findElement(By.xpath("//div/select/option[@value='11']"));
		selectDayOfBirth.click();
		System.out.println("Step 19 =>  select Day Of Birth option :: 11");
		
		Thread.sleep(1000);		
		WebElement firstpassword = driver.findElement(By.id("firstpassword"));
		firstpassword.sendKeys("Thomas123456");
		System.out.println("Step 20 =>  First password :: Thomas123456");
		
		Thread.sleep(1000);
		WebElement secondpassword = driver.findElement(By.id("secondpassword"));
		secondpassword.sendKeys("Thomas123456");
		System.out.println("Step 21 =>  Second password :: Thomas123456");
	
		
	
    Thread.sleep(5000);
	driver.quit();
	}

}
