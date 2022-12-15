package neostoxutilitymavenclass;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;


import neostoxbasec.Neobase;
import neostoxpomclasses.Newutility;


public class Listener extends Neobase  implements ITestListener
{

	public void onTestSuccess(ITestResult result) 
	{
		Reporter.log("TC"+result.getName()+" is completed successfully", true);
	}
	
	public void onTestFailure(ITestResult result)
	{
		Reporter.log("TC "+result.getName()+"is Failed", true);	
		
		try {
			Newutility.takeSceenshot(driver, result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
		e.printStackTrace();
		}
	}
	public void onTestSkipped(ITestResult result) 
	{
		Reporter.log("TC"+result.getName()+" is Skipped", true);
	}
	
	
}
