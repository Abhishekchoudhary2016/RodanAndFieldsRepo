package com.project.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class BecomeAnConsultantPage {
	WebDriver driver;
	private By becomeAnConsultant_xpath=By.xpath("//a[@id='corp-opp']");
	private By enrollNow_xpath=By.xpath("//a[@title='Enroll Now']");
	private By textbox_xpath=By.xpath("//input[@id='sponserparam']");
	private By searchButton_xpath=By.xpath("//button[@id='search-sponsor-button']");
	private By pagination_xpath=By.xpath("//a[@class='next']");
	private By searchResult_xpath=By.xpath("//li[text()='287298']");
	
	public BecomeAnConsultantPage(WebDriver driver){
		this.driver=driver;
	}
	
	public void clickOnBecomeAnConsultant() throws InterruptedException
	{
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(becomeAnConsultant_xpath)).build().perform();
		Thread.sleep(5000);
		driver.findElement(enrollNow_xpath).click();
	}
	public void enterText( String text)
	{
		driver.findElement(textbox_xpath).sendKeys(text);
	}
	public void clickOnSearchButton()
	{
		driver.findElement(searchButton_xpath).click();
	}
	public void clickOnPagination()
	{
		driver.findElement(pagination_xpath).click();
	}
	public String getTextForAssertion()
	{
		String text= driver.findElement(searchResult_xpath).getText();
		return text;
	}
	
	
	
}
