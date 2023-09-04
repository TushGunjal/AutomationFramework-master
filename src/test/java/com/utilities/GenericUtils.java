package com.utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

import org.apache.log4j.Level;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.testCases.BaseClass;


public class GenericUtils extends BaseClass {
	public void click(By elementBy) {
		System.out.println("click");
		WebDriverWait wait;
		wait = new WebDriverWait(Basedriver, Duration.ofSeconds(20));

		// waitVisibility(elementBy);
		try {
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
			Thread.sleep(200);
			Basedriver.findElement(elementBy).click();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void click(WebElement elementBy) {
		System.out.println("click");
		WebDriverWait wait;
		wait = new WebDriverWait(Basedriver, Duration.ofSeconds(20));

		// waitVisibility(elementBy);
		try {
			wait.until(ExpectedConditions.visibilityOf(elementBy));
			wait.until(ExpectedConditions.elementToBeClickable(elementBy));
			elementBy.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void sendKeys(By elementBy, String value) {
		System.out.println("click");
		WebDriverWait wait;
		wait = new WebDriverWait(Basedriver, Duration.ofSeconds(30));

		// waitVisibility(elementBy);
		try {
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));

			Basedriver.findElement(elementBy).sendKeys(value);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void sendKeys(WebElement we, String value) {
		System.out.println("click");
		WebDriverWait wait;
		wait = new WebDriverWait(Basedriver, Duration.ofSeconds(30));

		// waitVisibility(elementBy);
		try {
			wait.until(ExpectedConditions.visibilityOf(we));
			we.sendKeys(value);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

    public void selectItemInList (String itemToSelect) {
    	
        //waitVisibility(driver.findElement(By.id("msCatalogDropdown"));
        System.out.println("select item locator =  msCatalogDropdown");     
        Select msCatalogOption = new Select(Basedriver.findElement(By.id("msCatalogDropdown")));
    	msCatalogOption.selectByValue(itemToSelect);        
    }
	
    
    //select item from list
    public void selectItemFromList (By elementBy,String itemToSelect)
    {
    	boolean srchStringFound=false;  	
    	try
    	{
    		 	WebDriverWait wait;
        	 	wait = new WebDriverWait(Basedriver,Duration.ofSeconds(10));
        	 	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
        	 	
		        System.out.println("select item locator =  " + itemToSelect);     
		        Select selectionList = new Select(Basedriver.findElement(elementBy));	      		      
		        
		        List<WebElement> options = selectionList.getOptions();
		        for (WebElement option : options)
		        {
		        	if(option.getText().contentEquals(itemToSelect))
		        	{
		        		BaseClass.logger.info("Found the option " + itemToSelect);	
		        		srchStringFound= true;
		        		break;
		        	}
		            System.out.println(option.getText()); //Prints "Option", followed by "Not Option"
		        }
		        if (srchStringFound) 
		        {
		        	  selectionList.selectByValue(itemToSelect);  
		        }		        		        
    	}
    	catch(Exception ex) {
    		BaseClass.logger.info(ex.getMessage());
    		System.out.println(ex.getMessage());
    	}
    }
    
    public void selectItemFromListByValue(WebElement we,String itemToSelect)
    {
    	try
    	{
    		 	Select selectionList = new Select(we);	      		      
		        selectionList.selectByValue(itemToSelect);
    	}
    	catch(Exception ex) {
    		BaseClass.logger.info(ex.getMessage());
    		System.out.println(ex.getMessage());
    	}
    }
    

    protected void switchWindow() {
		for(String we:Basedriver.getWindowHandles()) {
			Basedriver.switchTo().window(we);
		}
	}
	    
    protected void switchWindow(WebDriver lDriver) {
		for(String we:lDriver.getWindowHandles()) {
			lDriver.switchTo().window(we);
		}
	}
	
    protected boolean switchWindowWithName(WebDriver driver, String sWindow) {
		String sOldWindHandle=driver.getWindowHandle();
		for(String sWinHandle:driver.getWindowHandles()) {
			driver.switchTo().window(sWinHandle);
			if(driver.getTitle().contains(sWindow)) return true;
		}
		driver.switchTo().window(sOldWindHandle);
		return false;
	}

    protected void launchNewTab() {
    	Basedriver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
    }
    
    protected void hoverToElement(WebElement element ) {
    	Actions action = new Actions(Basedriver);        
        action.moveToElement(element).perform();
    }
    
    protected void sendStringRobot(String text) {
    	StringSelection stringSelection = new StringSelection(text);
    	Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    	clipboard.setContents(stringSelection, stringSelection);
    	Robot robot;
		try {
			robot = new Robot();
	    	robot.keyPress(KeyEvent.VK_CONTROL);
	    	robot.keyPress(KeyEvent.VK_V);
	    	robot.keyRelease(KeyEvent.VK_V);
	    	robot.keyRelease(KeyEvent.VK_CONTROL);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }

    
    public void sendKeysSimple(By elementBy, String value) {
		try {
			Basedriver.findElement(elementBy).sendKeys(value);
			logger.log(Level.INFO, "Set text:"+value);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
    
    public void sendKeysSimple(WebElement element, String value) {
		try {
			element.clear();
			element.sendKeys(value);
			logger.log(Level.INFO, "Set text:"+value);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
    

}
