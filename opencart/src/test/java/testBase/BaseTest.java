package testBase;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
public class BaseTest {
	
	public WebDriver driver;
	public Logger logger;
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

}
