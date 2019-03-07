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



public class UrbanLadderExcel {
	WebDriver driver;

	@BeforeMethod
	public void open() {
		System.setProperty("webdriver.chrome.driver", "/home/tyss/Desktop/softwares/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.urbanladder.com/");

	}

	@Test
	public void Test() throws InterruptedException {

		WebElement close = driver
				.findElement(By.xpath("//div[@class='vert-wrapper']/descendant::a[contains(.,'Close')]"));
		close.click();
		Actions a = new Actions(driver);
		List<WebElement> mainmenu = driver.findElements(By.xpath("//div[@id='topnav_wrapper']/descendant::li/span"));
		//System.out.println("mainmenusize-"+mainmenu.size());
		int mainmenuSize = mainmenu.size();
		int row = 1;
		int col = 1;

		for (int i = 0; i < mainmenuSize; i++) {

			String mainmenuTxt = mainmenu.get(i).getText();
			System.out.println(mainmenuTxt);

			WriteToExcel.setCellData("/home/tyss/Desktop/Amish/UrbanLadder/excel/UrbanLadder.xlsx", "UrbanLadder", row,
					col, mainmenuTxt);
			row++;
			a.moveToElement(mainmenu.get(i)).perform();
			Thread.sleep(2000);
			List<WebElement> submenu = driver
					.findElements(By.xpath("//div[@id='topnav_wrapper']/descendant::li/span[contains(.,\"" + mainmenuTxt
							+ "\")]/following-sibling::div/descendant::div[@class='taxontype']/a"));
			//System.out.println("submenusize "+submenu.size());
			for (int j = 0; j < submenu.size(); j++) {
				//System.out.println();
				String submenuTxt = submenu.get(j).getText();
				System.out.println(submenuTxt);

				WriteToExcel.setCellData("/home/tyss/Desktop/Amish/UrbanLadder/excel/UrbanLadder.xlsx", "UrbanLadder",
						row, col, submenuTxt);
				row++;
				a.moveToElement(mainmenu.get(i)).moveToElement(submenu.get(j)).perform();
				Thread.sleep(2000);

				List<WebElement> options = driver
						.findElements(By.xpath("//div[@id='topnav_wrapper']/descendant::li/span[contains(.,\""
								+ mainmenuTxt + "\")]/following-sibling::div/descendant::div[@class='taxontype']/a[contains(.,\""
								+ submenuTxt + "\")]/parent::div/following-sibling::ul[@class='taxonslist']/descendant::li/a[@class='inverted']/span"));
								
				//System.out.println("optionssize "+options.size());
				for (int k = 0; k < options.size(); k++) {

					String optionsTxt = options.get(k).getText();
					System.out.println(optionsTxt);
				
					WriteToExcel.setCellData("/home/tyss/Desktop/Amish/UrbanLadder/excel/UrbanLadder.xlsx",
							"UrbanLadder", row, col, optionsTxt);
					row++;
				}
			
			}//System.out.println();
		}
	}

	@AfterMethod
	public void close() {
		driver.close();
	}
}
