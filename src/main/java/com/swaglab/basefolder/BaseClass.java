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
import org.openqa.selenium.firefox.FirefoxDriver;
import com.swaglab.utilitycomponent.TestTimeUtil;

public class BaseClass {

	public static Properties prop;
	public static String browser = "chrome";
	
	public static WebDriver driver;
    static Logger log = Logger.getLogger(BaseClass.class);

    
    public BaseClass()
    {
    	prop = new Properties();
		try {
			FileInputStream fin = new FileInputStream("/Users/ashishkumar/git/Swaglabs/SwaglabsProject/src/main/java/com/swaglab/configcomponent/Config.properties");
			prop.load(fin);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    	
    }

    
    //initlize the browser
    public static void initilization() {
    	
    	String browserName  = prop.getProperty("app.test.browser");
    	/* Chrome driver*/
    	if(browserName.equals("chrome")) {
    		System.setProperty("webdriver.chrome.driver",
					"/Users/ashishkumar/Work/Work/selenium_resource/chromedriver_mac64/chromedriver");
    		driver  = new ChromeDriver();
    		
    	}
//    	firefox driver
    	else if (browser.equalsIgnoreCase("firefox"))
    	{
    		System.setProperty("webdriver.firefox.driver",
					"user.dir" + "/sourcetracking_automation/src/main/resources/drivers/geckodriver.exe");
    		
    		driver = new FirefoxDriver();
    	}
    	
    	driver.manage().window().maximize();
    	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestTimeUtil.page_load_timeout));
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestTimeUtil.implicitWait));
    	driver.get(prop.getProperty("url"));
    }
    
    
	

}
