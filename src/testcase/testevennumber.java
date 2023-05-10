package testcase;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class testevennumber {
	
	// step 1
		DesiredCapabilities caps = new DesiredCapabilities();

		AndroidDriver driver;
	
	
	@BeforeTest
	public void beforetest() throws MalformedURLException {
		File app = new File("src/testcase/calculator.apk");
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android"); 
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "doaa");
		//caps.setCapability("chromdriverExecutable", "C:\\Users\\User\\Desktop\\chromewebdriver\\chromedriver.exe");
		//caps.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");
		caps.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());// for application
	
		
		}
	// ********this test for click on even number************
	@Test()
	public void clickonevennumber() throws MalformedURLException {
		AndroidDriver driver=new AndroidDriver (new URL("http://127.0.0.1:4723/wd/hub"),caps);
		//driver.get("https://www.google.com");
		String str="8";
		List<WebElement>myBottons=driver.findElements(By.className("android.widget.ImageButton"));
		
		String[] numberItems = { "8", "4", "6", "2", "0" };// list for even number
		int x=0;
		for (int i=0;i<myBottons.size();i++) {
			
			
			  if (myBottons.get(i).getAttribute("resource-id").contains(
			  "com.google.android.calculator:id/digit_"+str)) {
			  
			  myBottons.get(i).click(); 
			  x+=1;
			  if(x<5) {  // if for check number element in list numberItems
				  str=numberItems[x];}
				  
				  }
			  }
		Assertion myAssert = new Assertion();
		  
		  String ExpectedValue = "84620"; 
		  String Actual =
		  driver.findElement(By.id("com.google.android.calculator:id/formula")).getText
		  ();
		  myAssert.assertEquals(Actual, ExpectedValue);	
		}
		

	
	@AfterTest
	public void aftertest() {}

}
