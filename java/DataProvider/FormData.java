
package DataProvider;

import java.lang.reflect.Method;
import java.util.LinkedHashMap;

import org.testng.annotations.DataProvider;

import init.Report;

public class FormData {

	@DataProvider(name = "MethodName")
	public static Object[][] getBData(Method m) {
		String testCaseName = m.getName();
		return Report.getData(testCaseName);
	}

	@DataProvider(name = "ParameterData")
	public static LinkedHashMap<String, String> importParameters() {
		return Report.impParameter();
	}



}
