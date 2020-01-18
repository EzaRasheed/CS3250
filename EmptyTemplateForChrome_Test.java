

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.firefox.FirefoxDriver;     // for Firefox 
import org.openqa.selenium.chrome.ChromeDriver;       // for chrome

/**
 * 
 * Note: 
 *   Test environment: Chrome Version 76, selenium 3.14.0, Java 8, ChromeDriver 2.42, JUnit 5
 */

public class EmptyTemplateForChrome_Test 
{	
   private WebDriver driver;
   private String url = "http://www.cs.virginia.edu/~up3f/swtesting/sut/convert.php";

   @BeforeEach
   public void setUp() 
   {      	  
      System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\Selenium Setup\\chromedriver_win32\\chromedriver.exe");    // specify path the the driver
      driver = new ChromeDriver();    // create an instance of the web browser and open it
      driver.get(url);                // open the given url
   }

   @AfterEach
   public void teardown()
   {
      driver.quit();                  // close the browser
   }

   @Test
   public void test_openURL()
   {
      assertEquals(driver.getTitle(), "Measurement Conversion");	// check if we are on the right page
   }
   

}