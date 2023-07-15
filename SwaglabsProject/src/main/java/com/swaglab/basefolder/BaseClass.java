package com.swaglab.basefolder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.time.*;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseClass {

	public static Properties prop;
	public static String browser = "chrome";
	
	public WebDriver driver;
    static Logger log = Logger.getLogger(BaseClass.class);


////	Call from the properties files
//	static {
//
//		try {
//			FileInputStream fin = new FileInputStream(new File(System.getProperty("/Users/ashishkumar/Work/Work/Java_WorkSpace/SwaglabsProject/Configuration/Config.properties")));
//			prop = new Properties();
//			prop.load(fin);
//			browser = prop.getProperty("app.test.browser");
//
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}

	// Method to open and maximize the browser
	public void getDriver() {
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"/Users/ashishkumar/Work/Work/selenium_resource/chromedriver_mac64/chromedriver");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
//			ChromeDriver driver = new ChromeDriver(options);
			driver = new ChromeDriver(options);
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.firefox.driver",
					"user.dir" + "/sourcetracking_automation/src/main/resources/drivers/geckodriver.exe");
			// driver = new FirefoxFilter();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com");
	
	}

}
