package baseSL;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.*;

public class BaseSL1 {

	
	public static WebDriver driver;
	@BeforeSuite
	public void open_swaglabs_url() {
		driver= new ChromeDriver();
		 System.setProperty("webdriver.chrome.driver", "C:\\path\\to\\chromedriver.exe");
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		
		
	}
	@AfterSuite
	public void close_swaglabs_url() {
		
		
		driver.close();
	}
	
public String screenshotssl(String tname) {
		
		String timestamp1=new SimpleDateFormat("yyyy.mm.dd.hh.mm.ss"). format(new Date());
		TakesScreenshot ss= (TakesScreenshot) driver;
	    File source1=	ss.getScreenshotAs(OutputType.FILE);
	    String destination1=System.getProperty("user.dir")+"\\ScreenShotsSL\\"+timestamp1+tname+"sl1.png";
	    try {
	    	 FileUtils.copyFile(source1,new File(destination1));
		} catch (Exception e) {
			e.getMessage();
		}
	   
	  return destination1;
	  
	}

	
	
	
	
}
