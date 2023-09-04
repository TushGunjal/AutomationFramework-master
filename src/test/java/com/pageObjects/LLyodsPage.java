package com.pageObjects;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.LogStatus;
import com.utilities.GenericUtils;


//Constructor

public class LLyodsPage extends GenericUtils {
	private WebDriver driver;
	static Logger log = Logger.getLogger(LLyodsPage.class);

	public LLyodsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	@FindBy(xpath = "//*[@id=\"nav-header\"]/div/div/div[2]/ul/li[3]/a")
	private WebElement BranchFinder;

	@FindBy(xpath = "//*[@id=\"results\"]/li")
	private WebElement SearchBranch;

	@FindBy(xpath = "phone-main")
	private WebElement PhoneNumber;



	public void branchFinder(String Postcode,String BranchCode) throws InterruptedException {
		driver.findElement(By.linkText("Branch Finder")).click();
		driver.findElement(By.id("q")).sendKeys(Postcode);
		Thread.sleep(60);
		driver.findElement(By.xpath("//*[@id=\"results\"]/li")).click();
		Thread.sleep(70);
		driver.findElement(By.xpath("//*[@id=\"js-yl-"+BranchCode+"\"]/article/div[1]/h3/a")).click();
		String MobileNumber = driver.findElement(By.id("phone-main")).getText();
		System.out.println("Mobile Number of Branch "+Postcode+" ::"+ MobileNumber);
		log.info("Mobile Number of Branch "+Postcode+" ::"+ MobileNumber);
		}



	



}
