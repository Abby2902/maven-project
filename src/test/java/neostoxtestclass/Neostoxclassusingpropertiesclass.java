package neostoxtestclass;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import neostoxbasec.Neobase;
import neostoxpomclasses.Neostoxhomepage;
import neostoxpomclasses.Neostoxpasswordpage;
import neostoxpomclasses.Neostoxsignin;
import neostoxpomclasses.Newutility;

@Listeners(neostoxutilitymavenclass.Listener.class)

public class Neostoxclassusingpropertiesclass extends Neobase{
	 
		Neostoxsignin signin;
		Neostoxpasswordpage password;
		Neostoxhomepage home;
		
		
		@BeforeClass
		public void launchneostox() throws IOException 
		{
		
		launchbrowser();
			signin=new Neostoxsignin(driver);
			password=new Neostoxpasswordpage(driver);
			home=new Neostoxhomepage(driver);
		}
		
		
		@BeforeMethod
		
		public void logintoneostox() throws EncryptedDocumentException, IOException, InterruptedException {
			
			signin.neostoxsigninpage(driver, Newutility.readdatafrompropertyfile("mobnum"));
			
			Thread.sleep(3000);
			password.enterpassword(driver, Newutility.readdatafrompropertyfile("password"));
			password.submitbuttonclick();
			Thread.sleep(2000);
			home.popuphandle(driver);
			
		
		
		}
		
		
		
		@Test
	  public void validateusername() throws EncryptedDocumentException, IOException, InterruptedException 
		{
			Thread.sleep(2000);
			
		Assert.assertEquals(home.validateuserid(), Newutility.readdatafrompropertyfile("username"),"tc is failed as results are not matching");
			
			Newutility.takeSceenshot(driver, home.validateuserid());
			Reporter.log("actual and expected userid is matching tc is passed", true);
			
	  }
		@Test
		public void validateAcbalance() 
		{
			Newutility.wait(driver,1000);
			home.availablebalance();
			Reporter.log("account balnce is"+home.availablebalance(), true);
			
		}
		
		
		@AfterMethod
		public void closingbrowser() 
		{
			
			home.loggingout(driver);
			
			
			
		}
		

		
}
