package com.project.pages.test;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.project.page.BecomeAnConsultantPage;
import com.project.page.ShopSkinCarePage;

public class RodanAndFieldsTest {
	
	WebDriver driver;
	@BeforeMethod
	public void beforeMethod()
	{
		driver=new FirefoxDriver();
		driver.get("https://www.rodanandfields.com/ca/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	@Test(enabled=false)
	public void testBecomeAnConsultant() throws InterruptedException 
	{
		
		BecomeAnConsultantPage page=new BecomeAnConsultantPage(driver);
		page.clickOnBecomeAnConsultant();
		page.enterText("mary");
		page.clickOnSearchButton();
		page.clickOnPagination();
		String text= page.getTextForAssertion();
		Assert.assertEquals(text,"287298");
	}
	@Test
	public void gotoShopSkincare() throws InterruptedException
	{
		ShopSkinCarePage shopPage=new ShopSkinCarePage(driver);
		shopPage.mouseHoverOnShopSkincare();
		shopPage.clickOnAllProducts();
		shopPage.selectPriceRange();
		String price= shopPage.getPriceForAssertion();
		Assert.assertEquals(price, "CAD$ 71.00");
		shopPage.selectLowToHigh();
		String sortElement = driver.findElement(By.xpath("//span[text()='CAD$ 51.00']")).getText();
		Assert.assertEquals(sortElement, "CAD$ 51.00");
		sortElement = driver.findElement(By.xpath("//span[text()='CAD$ 55.00']")).getText();
		Assert.assertEquals(sortElement, "CAD$ 55.00");
		
		
	}
	
	@AfterMethod
	public void afterMethod()
	{
		driver.quit();
	}

}
