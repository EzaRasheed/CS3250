//package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;     // for Firefox 
import org.openqa.selenium.chrome.ChromeDriver;       // for chrome

// to handle alert popup window
import org.openqa.selenium.NoAlertPresentException;	
import org.openqa.selenium.Alert;

public class Assign5Testing
{
   private WebDriver driver;
   private String url = "https://cs.gmu.edu:8443/offutt/coverage/LogicCoverage";  // subject under test (sut)

   @BeforeEach
   public void setUp() 
   {
      System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\Selenium Setup\\chromedriver_win32\\chromedriver.exe");       // specify path to the driver
      driver = new ChromeDriver();    // open a web browser
	      
//      System.setProperty("webdriver.chrome.driver", "/path-to-your-driver/chromedriver");   // specify path to the driver
//      driver = new ChromeDriver();   // open a web browser
		   
      driver.get(url);                 // open the given url
   }

   @AfterEach
   public void teardown()
   {
      driver.quit();                   // close the browser
   }

   @Test
   public void test_openURL()
   {
      // check if we are on the right page
      assertEquals(driver.getTitle(), "Logic Coverage");	
   }
   
   @Test
   public void test_Base()     // test case #1
   {
      driver.findElement(By.name("expression")).sendKeys("q ^ p");
     
      driver.findElement(By.xpath("//input[@value='Truth Table']")).click();
      driver.findElement(By.xpath("//input[@value='GACC']")).click();
      
      // System.out.println(driver.getPageSource());            // let's see page source of the current page
      
      assertTrue(driver.getPageSource().contains("GACC"));
      assertTrue(driver.getPageSource().contains("(1,3)"));   // try manual test, realize that SUT outputs 2-digit format
      assertTrue(driver.getPageSource().contains("Row#"));
        
   }
   
   @Test
   public void test_Base_2() 
   {
	   driver.findElement(By.name("expression")).sendKeys("q ^ p");
	   
	   driver.findElement(By.xpath("//input[@value='Truth Table']")).click(); 		// click Truth Table button
	   driver.findElement(By.xpath("//input[@value='GACC']")).click();
	   driver.navigate().back(); 
	   
	   assertTrue(driver.getPageSource().contains("GACC"));
	   //assertTrue(driver.getPageSource().contains("(1,3)"));   // try manual test, realize that SUT outputs 2-digit format
	   assertTrue(driver.getPageSource().contains("Row#"));
   }
   
   @Test
   public void test_Base_3() 
   {
	   driver.findElement(By.name("expression")).sendKeys("q ^ p");
	   
	   driver.findElement(By.xpath("//input[@value='Truth Table']")).click(); 		// click Truth Table button
	   driver.findElement(By.xpath("//input[@value='GACC']")).click();
	   driver.findElement(By.xpath("//input[@value='New Expression']")).click();
	   
	   assertTrue(driver.getPageSource().contains("Logic Coverage Web Application"));
	   assertTrue(driver.getPageSource().contains("GACC"));   // try manual test, realize that SUT outputs 2-digit format
	   assertTrue(driver.getPageSource().contains("Test Requirements:"));
   }
   
   @Test
   public void test_Base_4() 
   {
	   driver.findElement(By.name("expression")).sendKeys("q ^ p");
	   
	   driver.findElement(By.xpath("//input[@value='Truth Table']")).click(); 		// click Truth Table button
	   driver.findElement(By.xpath("//input[@value='GACC']")).click();
	   driver.findElement(By.xpath("//input[@value='Graph Coverage']")).click();
	   
	   assertTrue(driver.getPageSource().contains("Graph Coverage Web Application"));
	   assertTrue(driver.getPageSource().contains("Algorithm 1"));   // try manual test, realize that SUT outputs 2-digit format
	   assertTrue(driver.getPageSource().contains("Other Tools"));
   }
   
   @Test
   public void test_Base_5() 
   {
	   driver.findElement(By.name("expression")).sendKeys("q ^ p");
	   
	   driver.findElement(By.xpath("//input[@value='Truth Table']")).click(); 		// click Truth Table button
	   driver.findElement(By.xpath("//input[@value='GACC']")).click();
	   driver.findElement(By.xpath("//input[@value='Data Flow Coverage']")).click();
	   
	   assertTrue(driver.getPageSource().contains("Data Flow Graph Coverage Web Application"));
	   assertTrue(driver.getPageSource().contains("Data Flow Information"));   // try manual test, realize that SUT outputs 2-digit format
	   assertTrue(driver.getPageSource().contains("defs"));
   }
   
   @Test
   public void test_Base_6() 
   {
	   driver.findElement(By.name("expression")).sendKeys("q ^ p");
	   
	   driver.findElement(By.xpath("//input[@value='Truth Table']")).click(); 		// click Truth Table button
	   driver.findElement(By.xpath("//input[@value='GACC']")).click();
	   driver.findElement(By.xpath("//input[@value='Minimal-MUMCUT Coverage']")).click();
	   
	   assertTrue(driver.getPageSource().contains("MUTP Heuristic"));
	   assertTrue(driver.getPageSource().contains("MNFP Minimization"));   // try manual test, realize that SUT outputs 2-digit format
	   assertTrue(driver.getPageSource().contains("Minimal MUMCUT Coverage Web Application"));
	   
   }
   
   @Test
   public void test_Base_7() 
   {
	   driver.findElement(By.name("expression")).sendKeys("q ^ p");
	   
	   driver.findElement(By.xpath("//input[@value='Truth Table']")).click();		// click Truth Table button
	   driver.findElement(By.xpath("//input[@value='CACC']")).click();
	   
	   assertTrue(driver.getPageSource().contains("CACC"));
	   assertTrue(driver.getPageSource().contains("Row#"));   // try manual test, realize that SUT outputs 2-digit format
	   assertTrue(driver.getPageSource().contains("(1,2)"));
   }
   
   
   @Test
   public void test_case8() {
	   driver.findElement(By.name("expression")).sendKeys("q ^ p"); 
	   
       driver.findElement(By.xpath("//input[@value='Truth Table']")).click();
	   driver.findElement(By.xpath("//input[@value='RACC']")).click();
	   
	   assertTrue(driver.getPageSource().contains("RACC"));
	   assertTrue(driver.getPageSource().contains("(1,3)"));   
	   assertTrue(driver.getPageSource().contains("Row#"));
   }
   
   @Test
   public void test_case9() {
	   driver.findElement(By.name("expression")).sendKeys("q ^ p");
	   
       driver.findElement(By.xpath("//input[@value='Truth Table']")).click();
	   driver.findElement(By.xpath("//input[@value='GICC']")).click();
	   
	   assertTrue(driver.getPageSource().contains("GICC"));
	   assertTrue(driver.getPageSource().contains("Major Clause"));   
	   assertTrue(driver.getPageSource().contains("Row#"));
   }
   
   @Test
   public void test_case10() {
	   driver.findElement(By.name("expression")).sendKeys("q ^ p");
	   
       driver.findElement(By.xpath("//input[@value='Truth Table']")).click();
	   driver.findElement(By.xpath("//input[@value='RICC']")).click();
	   
	   assertTrue(driver.getPageSource().contains("RICC"));
	   assertTrue(driver.getPageSource().contains("Major Clause"));   
	   assertTrue(driver.getPageSource().contains("Row#"));
   }
   
   @Test
   public void test_case11() {
	   driver.findElement(By.name("expression")).sendKeys("q ^ p");
	   
       driver.findElement(By.xpath("//input[@value='Truth Table']")).click();


	   assertTrue(driver.getPageSource().contains("Row#"));
   }
   
   @Test
   public void test_case12() {
	   	driver.findElement(By.name("expression")).sendKeys("q ^ p");
	   
	   	driver.findElement(By.xpath("//input[@value='GACC']")).click();
	   
	    assertTrue(driver.getPageSource().contains("GACC"));
	    assertTrue(driver.getPageSource().contains("Major Clause"));   
	    assertTrue(driver.getPageSource().contains("Tests"));
   }
   
   @Test
   public void test_case13() {
	   driver.findElement(By.name("expression")).sendKeys("67");
	   
       driver.findElement(By.xpath("//input[@value='Truth Table']")).click();
	   driver.findElement(By.xpath("//input[@value='GACC']")).click();
	   
	   assertTrue(driver.getPageSource().contains("unexpected"));
   }
}