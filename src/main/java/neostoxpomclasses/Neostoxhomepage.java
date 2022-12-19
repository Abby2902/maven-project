package neostoxpomclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;




public class Neostoxhomepage {

	@FindBy(xpath="(//a[text()='OK'])[2]")private WebElement okbutton;
	
	@FindBy(xpath="(//a[text()='Close'])[5]")private WebElement closebutton;
	
	@FindBy(id="lbl_username")private WebElement actualuid;
	
@FindBy(id="lbl_curbalancetop")private WebElement avaibalance;

@FindBy(xpath="//span[text()='Logout']")private WebElement logout;

	
	public Neostoxhomepage(WebDriver driver) {
		
		
		PageFactory.initElements(driver, this);
	}
	
	public void popuphandle(WebDriver driver) throws InterruptedException {
		
		if(okbutton.isDisplayed()) 
		{
Thread.sleep(3000);
			okbutton.click();
			Newutility.wait(driver, 3000);
			closebutton.click();
			
		}
		else 
		{
			
		}
		
	}
	
	public String validateuserid() throws InterruptedException {
		Thread.sleep(1000);
		String actual = actualuid.getText();
	
		return actual;
	}
	
	public String availablebalance() {
		
		String availablefund = avaibalance.getText();
		return availablefund;
		
		
	}
	
	public void loggingout(WebDriver driver) 
	{
		
		actualuid.click();
		Newutility.wait(driver, 1000);
		logout.click();
		
	}
	
}



