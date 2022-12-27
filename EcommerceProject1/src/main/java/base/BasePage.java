package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;


public class BasePage {
	private String url;
	private Properties prop;
	public static String screenShotDestinationPath;

	public BasePage() throws IOException {
		prop = new Properties();
		FileInputStream data = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\resources\\config.properties");

		prop.load(data);
	}

	public static WebDriver getDriver() throws IOException, InterruptedException {

		return WebDriverInstance.getDriver();
	}

	public String getUrl() throws IOException {

		url = prop.getProperty("url");
		return url;
	}

	public static String takeScreenShot(String name) throws IOException, WebDriverException, InterruptedException {

		File srcFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		String destFile = System.getProperty("user.dir") + "\\target\\screenshots\\" + timeStamp() + ".png";
		
		screenShotDestinationPath=destFile;

	try {
		FileUtils.copyFile(srcFile,new File(destFile));
	}catch(IOException e) {
		e.printStackTrace();
	}
return name;
	}

	public static String timeStamp() {

		return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
	}
	public static String getScreenshotDestinationPath() {
		return screenShotDestinationPath;
	}

}
