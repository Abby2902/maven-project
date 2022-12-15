package neostoxbasec;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

import neostoxpomclasses.Newutility;



public class Neobase {
protected static WebDriver driver;
public void launchbrowser() throws IOException {
	
	
	System.setProperty("webdriver.chrome.driver","D:\\\\chromedriver.exe");
	 driver=new ChromeDriver();
	driver.get(Newutility.readdatafrompropertyfile("url"));
	driver.manage().window().maximize();
	Newutility.wait(driver, 1000);
	
	Reporter.log("launching browser with url", true);
	
	
}
	
	
}
