package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.Logger;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
public class BaseTest {
	
	public static  WebDriver driver;
	public static  Logger logger;
    public Properties p ;
	
	
	@BeforeTest
	@Parameters({"OS", "browser"})
	public void setUp(String OS , String br) throws IOException {
		
		 p = new Properties();
		 FileReader file = new FileReader("src/test/resources/config.properties");
		 p.load(file);

		
		logger = LogManager.getLogger(this.getClass());
		
		switch(br) {
			case "chrome": driver = new ChromeDriver();
				          break;
			case "edge" :driver= new EdgeDriver();
				         break;
			case "firefox":driver=new FirefoxDriver();
				           break;
			default: return ;
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("appUrl"));	
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
    
	
	 public String captureScreen(String testName) {
	        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
	        String screenshotDir = System.getProperty("user.dir") + File.separator + "screenshots";
	        new File(screenshotDir).mkdirs(); // Create folder if not exists

	        String screenshotPath = screenshotDir + File.separator + testName + "_" + timeStamp + ".png";

	        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        try {
	            FileUtils.copyFile(srcFile, new File(screenshotPath));
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        return screenshotPath;
	  }
	

}
