package com.oms;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OMS_Login extends Dictionary {
	
	static WebDriver driver;
	
    @BeforeTest
    public static void before() {
    	
    	System.out.println("OMS Test started");
    	//System.err.println("test error");

    	System.setProperty("webdriver.firefox.marionette", "C:\\selenium\\geckodriver.exe");
    	driver =new FirefoxDriver();
    	driver.manage().window().maximize();
        driver.get(OMS_Test_URL); //URL to start the test                 
    }
    
    @Test(priority=0)
    public void TryLogin_BlankUserID_Login() throws InterruptedException {
    	try{
    	driver.findElement(By.xpath(xPath_UserNameTextBox)).clear();
    	driver.findElement(By.xpath(xPath_PasswordTextBox)).clear();
    	System.out.println("Cleaning User-Id and Password text fields. - PASS");}
    	
    	catch(NoSuchElementException  e){System.out.println(e + " Cleaning User-Id and Password text fields. - Fail");}

        driver.findElement(By.xpath(xPath_UserNameTextBox)).sendKeys("");
    	System.out.println("Entered User-ID with the blank input - PASS");

        driver.findElement(By.xpath(xPath_PasswordTextBox)).sendKeys("");
    	System.out.println("Entered Password with the blank input - PASS");

        Thread.sleep(1000);
        driver.findElement(By.xpath(xPath_LoginSubmitButton)).click();  

    }
	
    @Test(priority=1)
    public void TryLogin_Incorrect_Login() throws InterruptedException {
    	
    	driver.findElement(By.xpath(xPath_UserNameTextBox)).clear();
        driver.findElement(By.xpath(xPath_PasswordTextBox)).clear();
        
        driver.findElement(By.xpath(xPath_UserNameTextBox)).sendKeys("Incorrect_EmailID@gmail.com");
        driver.findElement(By.xpath(xPath_PasswordTextBox)).sendKeys("1234567890");

        Thread.sleep(3000);
        driver.findElement(By.xpath(xPath_LoginSubmitButton)).click();  
    }
    
    @Test(priority=2)
    public void TryLogin_Correct_Login() throws InterruptedException {
    	
    	driver.get("http://localhost/css/angular-inventory/#/login/");
    	
    	driver.findElement(By.xpath(xPath_UserNameTextBox)).clear();
        driver.findElement(By.xpath(xPath_PasswordTextBox)).clear();
        
        driver.findElement(By.xpath(xPath_UserNameTextBox)).sendKeys("mandkanw@gmail.com");
        driver.findElement(By.xpath(xPath_PasswordTextBox)).sendKeys("abcd");

        Thread.sleep(2000);
        driver.findElement(By.xpath(xPath_LoginSubmitButton)).click();  

    }
    
    @Test(priority=3)
    
    public void Try_ResetPassword() throws InterruptedException {
    	
    	driver.get("http://localhost/css/angular-inventory/#/login/");
    	
    	Thread.sleep(2000);
    	driver.findElement(By.linkText(LinkName_ForgrtPasswordLink)).click();
    	System.out.println("Clicked on Forget Password link.- PASS ");
    	driver.getPageSource().contains(PageText_ForgrtPasswordScreen);
    	System.out.println("Redirected on Forget Password screen. - PASS ");
        Thread.sleep(2000);
        driver.findElement(By.xpath(xPath_ResetPasswordTextBox)).sendKeys("Test@dsadsa.com");
    	System.out.println("Entered email id to reset password. - PASS");
        driver.findElement(By.xpath(xPath_ResetPasswordButton)).click();
    	System.out.println("Clicked on the password reset. - PASS");
    }
    
    @Test(priority=4)
    public void Try_RegisterNewUser() throws InterruptedException {
    	
    	driver.findElement(By.linkText(LinkName_RegisterNewUser)).click();
    	System.out.println("Clicked on the Register(Sign Up)link. -PASS");
    	//driver.getPageSource().contains(PageText_RegisterTitle);
    	System.out.println("Redirected on the Registeration screen -PASS");
        driver.findElement(By.xpath(xPath_UserNameTextBox)).sendKeys("RealLogicistics");
    	System.out.println("Filled company name in the text box - Pass");
        driver.findElement(By.xpath(xPath_RegisterEmailTextBox)).sendKeys("bhupendra@gmail.com");
        driver.findElement(By.xpath(xPath_RegisterMobileTextBox)).sendKeys("8512829296");
        driver.findElement(By.xpath(xPath_RegisterFirstNameTextBox)).sendKeys("Bhupendra");
        driver.findElement(By.xpath(xPath_RegisterLastNameTextBox)).sendKeys("Rautela");
        driver.findElement(By.xpath(xPath_RegisterPasswordTextBox)).sendKeys("Password123");
        driver.findElement(By.xpath(xPath_RegisterPassword2TextBox)).sendKeys("Password123");
       
        driver.findElement(By.xpath(xPath_RegisterCheckBox)).click();
        
        //By Actions:

        WebElement element = driver.findElement(By.xpath(xPath_RegisterCheckBox));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
        
        Actions actions1 = new Actions(driver);
        WebElement CheckBox = driver.findElement(By.xpath(xPath_RegisterCheckBox));
        actions1.moveToElement(CheckBox).click().build().perform(); 
        
       //By JavascriptExecutor:
        WebElement element2 = driver.findElement(By.xpath(xPath_RegisterCheckBox));
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].scrollIntoView()", element2); 
        driver.findElement(By.xpath(xPath_RegisterCheckBox)).click();
        System.out.println(driver.getCurrentUrl());
        
    }
    
    @Test(priority=5)
    public void Test_header() throws InterruptedException, IOException {
    	
 //  System.out.println("Header Link Text : - "+driver.findElement(By.xpath(xPath_Hedaer_Links)).getText());
    	
   java.util.List<WebElement> links = driver.findElements(By.xpath(xPath_Hedaer_Links));

	System.out.println(links.size());

	for (int i = 0; i<=links.size(); i=i+1)

	{
		System.out.println(links.get(i).getText());
		//links.get(i).click();
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("Add_New_Order")));
		driver.findElement(By.xpath(Add_New_Order)).click();
		
	}
	
   }
    
    @Test(priority=6)
    public void All_URL_API_TEST() throws InterruptedException, IOException {
    	String[] args = null;
		URL_API_Validater.main(args);
    
    }
    
    @Test(priority=10000)
   public void Close_Window()
    {
     
   driver.quit();
    	
    }
    
    
    }
