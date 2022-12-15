package neostoxpomclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;



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
			Reporter.log("hanndling popup", true);
		}
		else 
		{
			Reporter.log("There is no popup ", true);
		}
		
	}
	
	public String validateuserid() throws InterruptedException {
		Thread.sleep(1000);
		String actual = actualuid.getText();
		Reporter.log("getting actual userid", true);
		return actual;
	}
	
	public String availablebalance() {
		Reporter.log("checking available balance", true);
		String availablefund = avaibalance.getText();
		return availablefund;
		
		
	}
	
	public void loggingout(WebDriver driver) 
	{
		Reporter.log("logging out of application", true);
		actualuid.click();
		Newutility.wait(driver, 1000);
		logout.click();
		
	}
	
}



