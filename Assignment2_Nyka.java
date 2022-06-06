package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment2_Nyka {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				WebDriverManager.chromedriver().setup();
				ChromeOptions options = new ChromeOptions();
			        options.addArguments("--disable-notifications");
				ChromeDriver driver=new ChromeDriver(options);
				driver.manage().window().maximize();
				//driver implicit wait
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				//get the url
				driver.get("https://www.nykaa.com/");
				Thread.sleep(3000);
				WebElement ele=driver.findElement(By.xpath("//*[@id='headerMenu']/div/ul[2]/li/a"));
				Actions act=new Actions(driver);
				act.moveToElement(ele).perform();
				Thread.sleep(4000);
				driver.findElement(By.linkText("L'Oreal Paris")).click();
				String text=driver.getTitle();
				System.out.println(text);
				//Check the title contains L'Oreal Paris(Hint-GetTitle)
				System.out.println(text.contains("L'Oreal Paris"));
				driver.findElement(By.xpath(" //button[@class=' css-n0ptfk']")).click();
				//Click sort By and select customer top rated
				driver.findElement(By.xpath("//*[@class='control-value']/span[text()='customer top rated']")).click();
				Thread.sleep(3000);
				//Click Category and click Hair->Click haircare->Shampoo
				driver.findElement(By.xpath("//*[@id='first-filter']/div/span")).click();
				driver.findElement(By.xpath("//*[@id='custom-scroll']/ul/li[2]//span")).click();
				driver.findElement(By.xpath("//*[@class=' css-b5p5ep']/span")).click();
				driver.findElement(By.xpath("//*[@class='title']")).click();
				//concern selection
				driver.findElement(By.xpath("//span[text()='Concern']")).click();
				driver.findElement(By.xpath("//span[text()='Color Protection']")).click();
				//driver.close();
				//check the filter have shampoo selected
				String filter=driver.findElement(By.xpath("//*[@class='css-1emjbq5']/span")).getText();
				if(filter.contains("Shampoo"))
				{
					System.out.println("the Filter is applied with Shampoo");
				}
				else
				{
					System.out.println("the Filter is not applied with Shampoo");
				}
				//Click on L'Oreal Paris Colour Protect Shampoo
				String Parent=driver.getWindowHandle();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//div[contains(text(),\"L'Oreal Paris Colour Protect Shampoo\")]")).click();
				Set<String> windowHandles = driver.getWindowHandles();
				List<String> list1=new ArrayList<String>(windowHandles);
				driver.switchTo().window(list1.get(1));
				//select 175 ml 
				WebElement element = driver.findElement(By.xpath("//select[@title='SIZE']"));
				Select sel=new Select(element);
				element.click();
				sel.selectByValue("0");
				String price=driver.findElement(By.xpath("//*[@class='css-1d0jf8e']/span[2]")).getText();
				System.out.println("price of the product is"+price);
				// Click on ADD to BAG
				driver.findElement(By.xpath("//span[text()='Add to Bag']")).click();
				//Go to Shopping Bag
				driver.findElement(By.xpath("//*[@class='css-g4vs13']//span")).click();
				//Print the Grand Total amount
				Thread.sleep(3000);
				WebElement ele3 = driver.findElement(By.className("css-acpm4k"));
				driver.switchTo().frame(ele3);
				String grandTotal=driver.findElement(By.xpath("//*[@class='value medium-strong']")).getText();
				String total=grandTotal.substring(1, 4);
				System.out.println("grandtotal value is"+total);
				
				// Click Proceed
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@class='proceed-btn-text capitalize-uppercase-vernacular']/span")).click();
				//Click on Continue as Guest
				driver.findElement(By.xpath("//*[text()='CONTINUE AS GUEST']")).click();
				//get grand total
				Thread.sleep(5000);
				String finalgrandtot=driver.findElement(By.xpath("//div[@class='payment-details-tbl grand-total-cell prl20']/div[2]/span")).getText();
				System.out.println(finalgrandtot);
				if(finalgrandtot.contains(total))
				{
					System.out.println("the total prices are same");
				}
				else
				{
					System.out.println("there is a variation in the grandtotal");
				}
				driver.quit();

	}

}
