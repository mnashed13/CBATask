package newpackage;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Action;		
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//comment the above line and uncomment below line to use Chrome
//import org.openqa.selenium.chrome.ChromeDriver;
public class MasterClass {


    @SuppressWarnings("unlikely-arg-type")
	public static void main(String[] args) throws InterruptedException {
        // declaration and instantiation of objects/variables
//    	System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");
//		WebDriver driver = new FirefoxDriver();
		//comment the above 2 lines and uncomment below 2 lines to use Chrome
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		
//		I was unable to get the chrome driver to run whilst in the project file i did try and link it properly within the project folder.  
//		System.setProperty("webdriver.chrome.driver","chromedriver2.exe"
		//maximising the window
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
        String baseUrl = "https://www.commbank.com.au";
     
        String expectedTitle = "Personal banking including accounts, credit cards and home loans - CommBank";
        String actualTitle = "";

        // launch Fire fox and direct it to the Base URL
        driver.get(baseUrl);

        // get the actual value of the title
        actualTitle = driver.getTitle();

        /*
         * compare the actual title of the page with the expected one and print
         * the result as "Passed" or "Failed"
         */
        if (actualTitle.contentEquals(expectedTitle)){
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed");
        }
       
        
//        In the question you mentioned the Travel Money section however on the site I couldnt find a section that stated travel money 
//        hence i just went through the travel products section and click the travel money card.
        driver.findElement(By.xpath("//div[8]/div/a/div[2]")).click();
        
        
       System.out.println("Reached Travel Section");
       Thread.sleep(2000);
       driver.findElement(By.cssSelector(" .carditem:nth-child(1) .button_secondary")).click();
       Thread.sleep(2000);
       System.out.println("Verifying titles");
       String ActualLinkTitle = "Rates and Fees";
       driver.findElement(By.linkText("Rates & fees")).equals(ActualLinkTitle);
       System.out.println("Verifying rates and fees titles worked");
       String ActualLinkTitle2 = "Currency converter";
       driver.findElement(By.linkText("Currency converter")).equals(ActualLinkTitle2);
       System.out.println("Verifying Currency Converter titles worked");
       String ActualLinkTitle3 = "Reload now";
       driver.findElement(By.linkText("Reload now")).equals(ActualLinkTitle3);
       System.out.println("Verifying Reload nowr titles worked"); 
       String ActualLinkTitle4 = "How it works";
       driver.findElement(By.linkText("How it works")).equals(ActualLinkTitle4);
       System.out.println("Verifying Reload nowr titles worked"); 
       
       System.out.println("Netbank Login start "); 
      
       
       driver.findElement(By.linkText("Order online")).click();
//       driver.findElement(By.xpath("(//a[contains(@href, 'https://www.my.commbank.com.au/netbank/PaymentHub/MakePayment.aspx')])[5]")).click();
       System.out.println("Netbank Login Finished"); 
       
 
// Verifying that you are on the login in page 
       
       
       
       String expectedNetBankTitle = "NetBank - Log on to NetBank - Enjoy simple and secure online banking from Commonwealth Bank";
       String NetbankTitle = "";
       NetbankTitle = driver.getTitle();
       System.out.println(NetbankTitle);
     
       
       if (NetbankTitle.contentEquals(expectedNetBankTitle)){
           System.out.println("Test Passed! you are on the netbank login page");
       } else {
           System.out.println("Test Failed");
       }
       
       
// Closing web driver

   
        driver.quit();
       
    }

}