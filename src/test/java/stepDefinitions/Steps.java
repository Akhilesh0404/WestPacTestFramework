package stepDefinitions;

import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.And;
import org.junit.Assert;
import helper.CommonUtility;
import org.apache.log4j.Logger;

/**
 * This class contains step definition for Calculator page
 * @author akhilesh
 */

public class Steps extends CommonUtility{
	
	
	
    private static Logger log = Logger.getLogger(Steps.class);
	
	String exePath = "src/main/resources/Drivers/chromedriver.exe";
	
	

	@Before
	public void setUp() throws InterruptedException {
		log.info("The intiatlization started: ");
		System.setProperty("webdriver.chrome.driver",exePath);
		 driver = new ChromeDriver();
		 /******** Clean Cookies, maximize  the Driver *******/
	      driver.manage().deleteAllCookies();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
	}
	@After
	public void tearDown() {
		driver.quit();	
		log.info("The Completion of test  ");
	}
	
	
	
	
    @Given("^User is on the KiwiSaver Retirement Calculator Page$")
    public void user_is_on_the_kiwisaver_retirement_calculator_page() throws Throwable {
    	driver.get("https://www.westpac.co.nz/kiwisaver/calculators/kiwisaver-calculator/");
		Thread.sleep(2000);
    	driver.switchTo().frame(0);
    }
    
    

	@And("^User \"([^\"]*)\" is \"([^\"]*)\"$")
    public void user_something_is_something(String textName, String textValue) throws Throwable {
		sendText(textName, textValue);
    }

	@And("^User select \"([^\"]*)\" from dropdown \"([^\"]*)\"$")
    public void user_select_something_from_dropdown_something(String dropDownOption, String dropDown) throws Throwable {
		selectDropdown(dropDown, dropDownOption);
    }

	@And("^User choose \"([^\"]*)\" from radio \"([^\"]*)\"$")
    public void user_choose_something_from_radio_something(String radioValue, String radio) throws Throwable {
		chooseRadio(radio, radioValue);
    }

	@And("^User \"([^\"]*)\" is \"([^\"]*)\" and select \"([^\"]*)\"$")
    public void user_something_is_something_and_select_something(String textName, String textValue, String dropDownOption) throws Throwable {
		sendTextDropdown(textName,textValue,dropDownOption);	
    }
	
	 @And("^User click on button \"([^\"]*)\"$")
	    public void user_click_on_button_something(String buttonName) throws Throwable {
		 clickButton(buttonName);     
	    }

	@And("^User can see  \"([^\"]*)\"  ican and message \"([^\"]*)\"$")
    public void user_can_see_something_ican_and_message_something(String textName, String strArg2) throws Throwable {
		textClick(textName);
		Assert.assertTrue(verifyTextPresent(strArg2));	
    } 

	 @And("^User can see their  Projected  balance$")
	    public void user_can_see_their_projected_balance() throws Throwable {
		 String ExpectedResult="At age 65, your KiwiSaver balance is estimated to be:";
		 verifyTextWithAcutal(ExpectedResult); 
	    }
	
}
