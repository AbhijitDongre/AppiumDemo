
package init;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;


public class Report {
	public static String LOG_FILE = null;
	public static String RESULT_FILE = null;
	public static String REPORT_FILE = null;
	public static String lstFolder = null;
	public static String screenShotFolder = null;
	public static LinkedHashMap<String, String> testCaseTime = new LinkedHashMap<String, String>();

	static boolean LOG_FOLDER = false;
	static boolean REPORT_FOLDER = false;
	private static FileInputStream fs;
	private static FileOutputStream fso;
	static FileWriter fstream;
	static BufferedWriter out;
	public static datatable finalData = null;;
	public static String APP_URL = null;
    public static String filepath  = System.getProperty("user.dir") + "\\data\\SuiteTest.xlsx";
	public static void Report() {
		try{
			finalData = new datatable(filepath);
		}catch(Exception e) {
			e.printStackTrace();
		}	
		
	}

	

	public static void takeScreenShot(WebDriver driver, String screenshotName) {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String filePath = System.getProperty("user.dir") + "\\Report\\" + screenshotName + ".jpg";
		try {
			FileUtils.copyFile(scrFile, new File(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}



	public static LinkedHashMap<String, String> impParameter() {
        finalData = new datatable(filepath);
		int rowC = finalData.getRowCount("PARAMETER");
		System.out.println(rowC);
		Object c[][] = new Object[1][1];

		LinkedHashMap<String, String> table = new LinkedHashMap<String, String>();

		for (int i = 1; i <= rowC; i++) {
			String parameter = finalData.getCellData("PARAMETER", 0, i).trim();
			String paramValue = finalData.getCellData("PARAMETER", 1, i).trim();
			table.put(parameter, paramValue);
		}

		return table;

	}

	public static Object[][] getData(String testCaseName) {
		 finalData = new datatable(filepath);
		int testCaseRowNum = 1;
		while (!finalData.getCellData("FORMS", 0, testCaseRowNum).trim().toLowerCase().equalsIgnoreCase(testCaseName)) {
			testCaseRowNum++;
		}

		int colStartRowNum = testCaseRowNum + 1;
		int dataStartRowNum = testCaseRowNum + 2;
		int rows = 0;
		while (!finalData.getCellData("FORMS", 0, dataStartRowNum + rows).trim().equals("")) {
			rows++;
		}

		int cols = 0;
		while (!finalData.getCellData("FORMS", cols, colStartRowNum).trim().equals("")) {
			cols++;
		}

		Object testData[][] = new Object[rows][1];
		int i = 0;
		for (int rNum = dataStartRowNum; rNum < dataStartRowNum + rows; rNum++) {

			LinkedHashMap<String, String> table = new LinkedHashMap<String, String>();

			for (int cNum = 0; cNum < cols; cNum++) {
				String data = finalData.getCellData("FORMS", cNum, rNum);
				String colName = finalData.getCellData("FORMS", cNum, colStartRowNum);
				table.put(colName, data);
			}

			testData[i][0] = table;
			i++;

		}
		return testData;
	}

	

	

	
	

}
