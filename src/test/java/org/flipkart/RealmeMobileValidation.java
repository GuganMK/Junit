package org.flipkart;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class RealmeMobileValidation {
	static WebDriver driver;
	static long startTime;
	static String name1;
	@BeforeClass
	public static void BeforeClass() {
	
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.get("http://flipkart.com");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Ignore
	@AfterClass
	public static void AfterClass() {
		driver.quit();
	}
	
	@Before
	public void Before() {
	 startTime = System.currentTimeMillis();
	}
	
	@After
	public void After() {
		long endTime = System.currentTimeMillis();
		System.out.println("Time taken is:" + (endTime - startTime));
		
	}
	@Test
	public void method1() {
		try {
			WebElement close = driver.findElement(By.xpath("//button[@class=\"_2KpZ6l _2doB4z\']"));
			close.click();
		}
		catch (Exception e) {
			
		}
	}
	@Test
	public void method2() {
		WebElement search = driver.findElement(By.name("q"));
		search.sendKeys("realme moliles",Keys.ENTER);
	}
	
	@Test
	public void method3() {
		WebElement mobile = driver.findElement(By.xpath("(//div[@class='_4rR01T'])[1]"));
		name1 = mobile.getText();
		mobile.click();
		System.out.println(name1);
	}
	
	@Test
	public void method4() {
		String parent = driver.getWindowHandle();
		Set<String> child = driver.getWindowHandles();
		for (String x: child) {
			if(!parent.equals(x)) {
			driver.switchTo().window(x);
		}}}
		
	@Test
	public void method5() {
		WebElement mobile2 = driver.findElement(By.xpath("//span[contains(text(),'realme C11')]"));
		String name2 = mobile2.getText();
		System.out.println(name2);
		
	Assert.assertEquals(name1,name2);
	
	}
	}
	