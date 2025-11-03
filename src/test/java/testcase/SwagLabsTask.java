package testcase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

public class SwagLabsTask {

	public static WebDriver driver;
	JavascriptExecutor js=(JavascriptExecutor)driver;
	@BeforeClass
	public void openurl() throws InterruptedException{
		
		driver=new EdgeDriver();
		driver.get("https://www.saucedemo.com/");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		
	}
	@Test(priority=1)
	public void enusNpass() throws InterruptedException {
		Thread.sleep(2000);
         driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
         Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
		Thread.sleep(2000);
	}
	
	
	@Test(priority=2)
	public void loginbutton() throws InterruptedException {
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(2000);

	}
	
	
	@Test(priority=3)
	public void pricesofproducts() throws InterruptedException {
		JavascriptExecutor js=(JavascriptExecutor)driver;
     List<WebElement> prices=driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
		System.out.println(prices.size());
		int PL=prices.size();
		
		 for(int i=0;i<PL;i++) {
			String l=prices.get(i).getText();
			System.out.println(l);
			//double val= 10.00;
			Thread.sleep(2000);

			double pricevalue = Double.parseDouble(l.replace("$", ""));
			System.out.println(pricevalue);
			Thread.sleep(3000);

			if(pricevalue>40.00) {
				Thread.sleep(3000);
                  
				//prices.get(i).click();
				//WebElement addtocart1 =	driver.findElement(By.tagName("button"));
//				
				WebElement addtocart=driver.findElement(By.xpath("//button[text()='Add to cart']"));
				js.executeScript("arguments[0].click()", addtocart);
				//addtocart.click();
				//addtocart1.click();
				Thread.sleep(3000);

			}
			
			
			
		} 
		 
		}
	
	@Test(priority=4)
	public void clickoncart() {
		driver.findElement(By.xpath("//span[@class=\"shopping_cart_badge\"]")).click();
	}

	
	    @Test(priority=5)
		public void clickoncheckout() {
			driver.findElement(By.xpath("//button[@id='checkout']")).click();
		}
		
	@Test(priority=6)
	public void enterfslaNcode() throws InterruptedException {
		driver.findElement(By.xpath("//input[@id='first-name']")).sendKeys("rahul");
		driver.findElement(By.xpath("//input[@id='last-name']")).sendKeys("ch");
		driver.findElement(By.xpath("//input[@id='postal-code']")).sendKeys("517127");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(3000);
	}
	@Test(priority=7)
	public void clickonfinish() throws IOException, InterruptedException {
//		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(10));
//		
//		WebElement f=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='finish']")));
//		f.click();
//		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@id='finish']")).click();
		Thread.sleep(3000);
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		 String dest=  System.getProperty("user.dir")+"//ScreenShotsSL//"+"sl1.png";
		FileUtils.copyFile(src, new File(dest));
//		
//		
//		TakesScreenshot ts = (TakesScreenshot) driver;
//	    File src = ts.getScreenshotAs(OutputType.FILE);
//
//	   
//	    String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
//	    String dest = System.getProperty("user.dir") + "/ScreenShotsSL/" + timestamp + "sl1.png";
//
//	    FileUtils.copyFile(src, new File(dest));
//	    
	}
	
	
	
	
	@AfterClass
	public void closeurl() throws InterruptedException{
		Thread.sleep(3000);
		driver.close();
	}
	
	
	
}
