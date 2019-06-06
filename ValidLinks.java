package Selenium_Automation;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ValidLinks {
	
	public static int valid =0 , invalid=0;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C://Users//vtamilse//Desktop//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		
	    driver.get("http://google.com");
		driver.findElement(By.xpath("//a[@class=\"btn btn-primary-outline\"]")).click();
		driver.findElement(By.xpath("//input[@id=\"user_orig\"]")).sendKeys("BCUV1100");
		driver.findElement(By.xpath("//input[@class=\"form-control empty\"]")).sendKeys("Test$123");
		driver.findElement(By.id("logon_button")).click();  
		
		// tagName as 'a' and attribute as 'href / 'String u = ele.getAttribute("href");
		//tagName as 'img' and attribute as 'Src' /  imgElement != null
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		
		System.out.println("Total number of links present in the page is " + links.size());
	
		for(WebElement ele : links)
		{
			String u = ele.getAttribute("href");
			
		    System.out.println(u);
		    verifyLinks(u);
		}
		
		System.out.println("The number of valid links are " + valid);
		System.out.println("The number of Invalid links are " + invalid);
			
	    }
	
	
	public static void verifyLinks(String url)
	{
		
		
		try {
			
			URL a = new URL(url);
			
			HttpURLConnection con =  (HttpURLConnection)a.openConnection();
			con.setConnectTimeout(1000);
			con.connect();
			
			if(con.getResponseCode()==200){
					System.out.println(  url + " - Valid Link : "+ con.getResponseMessage());
					valid ++;
					
			}
			
			else {
				System.out.println("Invlaid Links " + url + con.getResponseMessage());
				   invalid++;
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception ***** ");
		}
		

	}
	
	

}
