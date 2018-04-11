
package init;

import java.net.URL;
import java.util.LinkedHashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class initDriver {
	static initDriver c;
	public static final String dataProvider = null;

	public static AndroidDriver driver = null;

	 public static DesiredCapabilities dc = new DesiredCapabilities();
	
	public static AndroidDriver initDriver() throws Exception{
		
		

		 dc.setCapability(MobileCapabilityType.UDID, "a9c8e6c9");
	     dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.ebay.mobile");
	     dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".activities.MainActivity");
	     driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), dc);
		
		return driver;
		
	}

	
	
	public static void Login(String username, String password) throws Exception {

		driver = initDriver();
		 driver.findElement(By.xpath("//*[@text='Sign in']")).click();
		 Report.takeScreenShot(driver, "SigningPage");
		 driver.findElement(By.xpath("//*[@contentDescription='Continue']")).sendKeys(username);
	     driver.findElement(By.xpath("//*[@id='edit_text_password']")).sendKeys(password);
	     driver.findElement(By.xpath("//*[@id='button_sign_in']")).click();
	     Report.takeScreenShot(driver, "LoginSuccessfull");
	     try {
	    	  driver.findElement(By.xpath("//*[@text='No thanks']")).click();
	     }catch(Exception e) {
	    	 e.printStackTrace();
	     }
		
		
		
	}
	
	public static void search(String searchString) {
		
		  driver.findElement(By.xpath("//*[@text='Search for anything']")).sendKeys("samsung");
		     driver.findElement(By.xpath("//*[@id='suggestionList']")).click();
		     driver.findElement(By.xpath("//*[@text='Samsung Galaxy C9 Pro -VoLte | GOLD | 64GB | 6GB |16MP| MANUFACTURER REFURBISHED']")).click();
		     driver.findElement(By.xpath("//*[@text='Buy it now']")).click();
		     driver.findElement(By.xpath("//*[@text='Review']")).click();
		     driver.findElement(By.xpath("//*[@id='home']")).click();
		     driver.findElement(By.xpath("//*[@id='home']")).click();
		
	}
}
