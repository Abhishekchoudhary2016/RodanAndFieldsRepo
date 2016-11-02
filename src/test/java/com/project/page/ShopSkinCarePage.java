package com.project.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ShopSkinCarePage {
	WebDriver driver;
	public By shopSkinCare_xpath=By.xpath("//a[@id='our-products']");
	private By allProducts_xpath=By.xpath("//a[@title='All Products']");
	private By dropdown_xpath= By.xpath("//input[@tabindex='2']");
	private By priceRange_xpath=By.xpath("//input[@id='CAD$50 TO CAD$199.99']");
	private By searchResult_xpath=By.xpath("//span[text()='CAD$ 71.00']");
	private By lowToHigh_xpath=By.xpath("//select[@id='sortOptions']");
	private By lowToHighResult_xpath=By.xpath("//div[@class='quick-product-wrapper row product-catalogue']");
	public ShopSkinCarePage(WebDriver driver)
	{
		this.driver=driver;
	}
	public void mouseHoverOnShopSkincare() throws InterruptedException
	{
	Actions action = new Actions(driver);
	action.moveToElement(driver.findElement(shopSkinCare_xpath)).build().perform();
	Thread.sleep(5000);
	}
	public void clickOnAllProducts()
	{
		driver.findElement(allProducts_xpath).click();
	}
	public void selectPriceRange() throws InterruptedException
	{
		driver.findElement(dropdown_xpath).click();
		Thread.sleep(3000);
		WebElement element= driver.findElement(By.xpath(".//*[@id='quick-refine']/div[2]/div[2]/ul/li[2]/form/div/div[1]/div[2]/div"));
		
			element.click();
			//System.out.println(element.isSelected());
	}
	public String getPriceForAssertion()
	{
		String price= driver.findElement(searchResult_xpath).getText();
		return price;
		
	}
	public void selectLowToHigh()
	{
		Select select = new Select(driver.findElement(lowToHigh_xpath));
		select.selectByIndex(1);
	}
	
	public String getFirstElement()
	{
		String text=driver.findElement(By.xpath("//span[text()='CAD$ 51.00']")).getText();
		return text;
	}
	public String getSecondElement()
	{
		String text=driver.findElement(By.xpath("//span[text()='CAD$ 55.00']")).getText();
		return text;
	}
}
