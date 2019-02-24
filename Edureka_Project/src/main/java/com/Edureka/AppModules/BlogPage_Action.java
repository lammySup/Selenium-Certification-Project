package com.Edureka.AppModules;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Edureka.PageObjects.BaseClass;
import com.Edureka.PageObjects.BlogsPage;

public class BlogPage_Action extends BaseClass {
	private static WebElement element;
	static Actions action = null;

	public BlogPage_Action(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public static void Execute() throws Exception {
		action = new Actions(driver);
		element = BlogsPage.Blog_button();
		action.keyDown(Keys.CONTROL).keyDown(Keys.SHIFT).click(element)
				.keyUp(Keys.CONTROL).keyUp(Keys.SHIFT).build().perform();

		WebDriverWait waitElement = new WebDriverWait(driver, 30);
		ArrayList<String> tabs = new ArrayList<String>(
				driver.getWindowHandles());
		// Use the list of window handles to switch between windows
		String handleName = tabs.get(1);
		driver.switchTo().window(handleName);
		// Search for edureka selenium blogs
		element = BlogsPage.search_blog();
		action.moveToElement(element).sendKeys("Selenium").sendKeys(Keys.ENTER)
				.build().perform();
		BlogsPage.search_blog().sendKeys("Selenium");
		BlogsPage.search_blog().sendKeys(Keys.ENTER);
		waitElement.until(ExpectedConditions.visibilityOfElementLocated(By
				.className("searchresults")));

		String Search = driver.findElement(By.id("search-tag-name")).getText();
		System.out.println(Search);

		if (Search.equals("selenium")) {
			System.out.println("The search is filtered for selenium");
		}
		Thread.sleep(2000);
		// Get the interview questions blog
		driver.findElement(
				By.xpath("//a[contains(text(),'Interview Questions')]"))
				.click();
		waitElement.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//a[contains(text(),'Interview Questions')]")));
		Thread.sleep(2000);
		driver.getPageSource()
				.contains(
						"Top Selenium Interview Questions And Answers You Must Prepare In 2019");
		System.out.println(driver.getTitle());
		driver.close();
		String originalHandle = tabs.get(0);
		driver.switchTo().window(originalHandle);
		String Pagetitle = driver.getTitle();
		System.out.println(Pagetitle);
		
	}

}
