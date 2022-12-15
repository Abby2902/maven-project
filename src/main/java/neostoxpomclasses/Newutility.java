package neostoxpomclasses;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

public class Newutility {

	public static void main(String[] args) throws IOException {

System.out.println(readdatafrompropertyfile("mobnum"));

	}
	
	public static String readdatafrompropertyfile(String key) throws IOException 
	{	//create an object of properties class
		Properties prop=new Properties();
		
		//create an object of fileinput stream
		
		FileInputStream  myfile=new FileInputStream("C:\\Users\\ABHAYSINH\\eclipse-workspace\\mavenneostoxproject\\Neostox.properties");
	
	prop.load(myfile);
	String value = prop.getProperty(key);
	Reporter.log("reading value of "+key+"from property file", true);
	return value;
	}
	public static void takeSceenshot(WebDriver driver, String fileName) throws
	IOException
	{
	File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	File dest= new File("D:\\screenshot\\"+fileName+".jpg");
	FileHandler.copy(src, dest);
	Reporter.log("taking screenshot ",true);
	}
	public static void scrollIntoView(WebDriver driver, WebElement element)
	{
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("arguments[0].scrollIntoView(true)",element );
	Reporter.log("scrolling into view "+element.getText(),true);
	}
	public static void wait(WebDriver driver, int waittime)
	{
	driver.manage().timeouts().implicitlyWait(Duration.ofMillis(waittime));
	Reporter.log("waiting for "+waittime+"milis",true);
	}

}
