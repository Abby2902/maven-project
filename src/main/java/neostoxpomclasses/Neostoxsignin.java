package neostoxpomclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;




public class Neostoxsignin 
{

@FindBy(id="MainContent_signinsignup_txt_mobilenumber")private WebElement sendmobno;
	

@FindBy(id="lnk_signup1")private WebElement signinbutton;
	
@FindBy(xpath="(//a[text()='Sign In'][1])")private WebElement signin;	


public Neostoxsignin(WebDriver driver) 
	{
		
		PageFactory.initElements(driver, this);
		
	}
	public void neostoxsigninpage(WebDriver driver,String mno) 
	{
		
		signin.click();
		Newutility.wait(driver,1000);
		
		sendmobno.sendKeys(mno);
		
		signinbutton.click();
		
		
	}
	
}
