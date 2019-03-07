package firstt;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UrbanLadder0603 
{
	WebDriver driver;

	@BeforeMethod
	public void open() 
	{
		System.setProperty("webdriver.chrome.driver", "./jars/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.urbanladder.com/");
	}
	@Test
	public void Test() throws InterruptedException 
	{
		WebElement close = driver.findElement(By.xpath("//div[@class='vert-wrapper']/descendant::a[contains(.,'Close')]"));
		close.click();		
		List<WebElement> mainmenu = driver.findElements(By.xpath("//div[@id='topnav_wrapper']/descendant::li/span"));
		int mainmenuSize = mainmenu.size();
		//System.out.println(mainmenuSize);
		int row = 1;
		int col = 1;
		for (int i = 0; i < mainmenuSize; i++) 
		{
			String mainmenuTxt = mainmenu.get(i).getText();
			System.out.println(mainmenuTxt);
			WriteToExcel.setCellData("C:\\Users\\AmishOm\\git\\demo1.1\\firstt\\Excel\\UrbanLadder0603.xlsx", "Sheet1", row,col, mainmenuTxt);
			row++;			
		}
		
	}
	@AfterMethod
	public void close() {
		DataProviderCheck.actual();
		driver.close();
	}
}
