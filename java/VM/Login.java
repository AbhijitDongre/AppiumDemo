package VM;import java.util.LinkedHashMap;import org.testng.annotations.Test;import DataProvider.FormData;import init.initDriver;public class Login {		@Test(priority = 1, dataProviderClass = FormData.class, dataProvider = "MethodName")	public void LoginToApplication(LinkedHashMap<String, String> data) throws Exception {				initDriver.Login(data.get("USER_ID"),data.get("PASSWORD"));	}		}