package helper;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


/**
 * This class contains common methods only require field name and field Value. 
 * @author akhilesh
 */

public class CommonUtility {
	public static WebDriver driver; 
	
	/******** Log Attribute ********/
    private static Logger log = Logger.getLogger(CommonUtility.class);
	
	
	/**
	 * sendText  methods for sending value in text field 
	 * Dynamic xpath only require field name and field Value
	 */
	 
	public void sendText(String name, String value) throws Throwable {
		
		log.info("The text field: " + value +" is set");
		
     	WebElement element = driver.findElement(By.xpath("//label[contains(text(),'"+name+"')]//following::input[1]"));
		element.sendKeys(value);
	}
	
	/**
	 * selectDropdown  methods for selecting value from dropdown field 
	 * Dynamic xpath only require field name and field Value
	 */
	public void selectDropdown(String name, String value) throws Throwable {
		log.info("The dropdown: " + value +" is set");
		
		WebElement element=driver.findElement(By.xpath("//label[contains(text(),'"+name+"')]/following::div[7]"));
		element.click();
		WebElement element2=driver.findElement(By.xpath("//label[contains(text(),'"+name+"')]/following::div[1]//li//span[contains(text(),'"+value+"')]"));
		element2.click();
    }
	
	/**
	 * chooseRadio  methods for selecting value from dropdown and set value in text  field 
	 * Dynamic xpath only require field name and field Value
	 */
	 public void chooseRadio(String name, String value) throws Throwable {
			WebElement element=driver.findElement(By.xpath("//label[contains(text(),'"+name+"')]//following::span/span[contains(text(),'"+value+"')]/preceding::input[1]"));
			element.click();		
	    }
	 
	 /**
		 * sendTextDropdown  methods for selecting value from radio field 
		 * Dynamic xpath only require field name and field Value
		 */
	    public void sendTextDropdown(String name, String value, String dropDownValue) throws Throwable {
			sendText(name,value);
			
			WebElement element=driver.findElement(By.xpath("//label[contains(text(),'"+name+"')]/following::div[13]"));
			element.click();
			
			WebElement element2=driver.findElement(By.xpath("//label[contains(text(),'"+name+"')]/following::div[1]//li//span[contains(text(),'"+dropDownValue+"')]"));
			element2.click();
			
	    }
	    /**
		 * clickButton  methods to click button 
		 * Dynamic xpath only require field name
		 */
		 
		    public void clickButton(String name) throws Throwable {
				WebElement element=driver.findElement(By.xpath("//*[contains(text(),'"+name+"')]/parent::button"));
				element.click();
		    }
		    
		    /**
			 * textClick  methods to click text 
			 * Dynamic xpath only require field name
			 */
		    public void textClick(String name) throws Throwable {
				WebElement element=driver.findElement(By.xpath("//label[contains(text(),'"+name+"')]//following::button[1]"));
				element.click();			
		    }
		    /**
			 * verifyTextPresent  methods to verify text 
			 * Dynamic xpath only require field name
			 */
		    protected  boolean verifyTextPresent(String text){
			    try{
			        boolean b = driver.getPageSource().contains(text);
			        return b;
			    }
			    catch(Exception e){
			        return false;
			    }
			  }
		    /**
			 * verifyTextPresent  methods to compare text 
			 * Dynamic xpath only require field name
			 */
		    public void verifyTextWithAcutal(String text) throws Throwable {
				
		     	 WebElement element=driver.findElement(By.xpath("//*[@id=\"widget\"]/div/div[1]/div/div[3]/div/div[1]/div[1]/div[1]/span[1]"));
				 String ActualResult=element.getText();	 
			     Assert.assertEquals(ActualResult,text);		 
			    }
}
