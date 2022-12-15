package neostoxpomclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;



public class Neostoxpasswordpage {

	@FindBy(id="txt_accesspin")private WebElement enterpassword;
		
	@FindBy(xpath="//a[@id='lnk_submitaccesspin']")private WebElement submitbutton;	
		
		public Neostoxpasswordpage(WebDriver driver) 
		{
			
			PageFactory.initElements(driver, this);
			
			
		}
		
		public void enterpassword(WebDriver driver,String pwd) 
		
		{
			Newutility.wait(driver, 1000);
			Reporter.log("Entering password", true);
			enterpassword.sendKeys(pwd);
			
			
			
		}
		
		public void submitbuttonclick()
		{Reporter.log("clicking on submit button", true);
			submitbutton.click();
			
		}
		
	}


