package VM;




import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class executionClass {
	
	 private static final String dataProvider = null;

	protected static AndroidDriver<AndroidElement> driver = null;

	 public static DesiredCapabilities dc = new DesiredCapabilities();

@Test()
public static void testRun(String searchname) throws Exception{
	
	 dc.setCapability(MobileCapabilityType.UDID, "a9c8e6c9");
     dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.ebay.mobile");
     dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".activities.MainActivity");
     driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), dc);
  
     driver.findElement(By.xpath("//*[@text='Sign in']")).click();
    
   /*  driver.findElement(By.xpath("//*[@id='firstname']")).sendKeys("Abhijit");
     driver.findElement(By.xpath("//*[@id='lastname']")).sendKeys("Dongre");
     driver.findElement(By.xpath("//*[@id='email']")).sendKeys("abhijit.dongre@yahoo.co.in");
     driver.findElement(By.xpath("//*[@id='PASSWORD']")).sendKeys("India@50");
     driver.findElement(By.xpath("//*[@id='ppaFormSbtBtn']")).click();
     driver.findElement(By.xpath("//*[@id='phoneFlagComp1']")).sendKeys("9890559751");
     driver.findElement(By.xpath("//*[@contentDescription='Provide contact info']")).click();
     driver.findElement(By.xpath("//*[@id='sbtBtn']")).click();
     driver.findElement(By.xpath("//*[@id='address1']")).sendKeys("Lalit-- C");
     driver.findElement(By.xpath("//*[@id='first_interation_shim_overlay']")).click();
     driver.findElement(By.xpath("//*[@id='first_interation_shim_overlay']")).click();
     driver.findElement(By.xpath("//*[@id='first_interation_shim_overlay']")).click();
     driver.findElement(By.xpath("//*[@id='first_interation_shim_overlay']")).click();
     driver.findElement(By.xpath("//*[@contentDescription='Provide contact info']")).click();
     driver.findElement(By.xpath("//*[@id='city']")).sendKeys("Pune");
     driver.findElement(By.xpath("//*[@id='state']")).click();
     driver.findElement(By.xpath("//*[@id='zip']")).sendKeys("411068");
     driver.findElement(By.xpath("//*[@contentDescription='Text me now']")).sendKeys("1371");*/
     
     
     driver.findElement(By.xpath("//*[@contentDescription='Continue']")).sendKeys("abhijit.dongre@yahoo.co.in");
     driver.findElement(By.xpath("//*[@id='edit_text_password']")).sendKeys("India@50");
     driver.findElement(By.xpath("//*[@id='button_sign_in']")).click();
     driver.findElement(By.xpath("//*[@text='No thanks']")).click();
     driver.findElement(By.xpath("//*[@text='Search for anything']")).sendKeys("samsung");
     driver.findElement(By.xpath("//*[@id='suggestionList']")).click();
     driver.findElement(By.xpath("//*[@text='Samsung Galaxy C9 Pro -VoLte | GOLD | 64GB | 6GB |16MP| MANUFACTURER REFURBISHED']")).click();
     driver.findElement(By.xpath("//*[@text='Buy it now']")).click();
     driver.findElement(By.xpath("//*[@text='Review']")).click();
     driver.findElement(By.xpath("//*[@id='home']")).click();
     driver.findElement(By.xpath("//*[@id='home']")).click();
}
 
}


