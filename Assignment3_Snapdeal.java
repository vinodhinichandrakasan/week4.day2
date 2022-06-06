package week4.day2;


import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment3_Snapdeal {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//Driver setup
				WebDriverManager.chromedriver().setup();
				WebDriver driver=new ChromeDriver();
		//browser maximize
				driver.manage().window().maximize();
		//browser implicit wait
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//get the URL
				driver.get("https://www.snapdeal.com/");
				Thread.sleep(5000);
				WebElement ele=driver.findElement(By.xpath("//span[contains(text(),\"Men's Fashion\")]"));
				Actions act=new Actions(driver);
				act.moveToElement(ele).click().perform();
		//clicking sports shoe
				driver.findElement(By.xpath("//*[text()='Sports Shoes']")).click();
		//get count of men's sports shoe
				String shoeCount=driver.findElement(By.xpath("//*[@class='child-cat-node dp-widget-link hashAdded']/div[2]")).getText();
				System.out.println(shoeCount);
		//clicking training shoes
				driver.findElement(By.xpath("//a/div[text()='Training Shoes']")).click();
		//sorting the shoes by Sort by Low to High
				Thread.sleep(5000);
				WebElement ele2=driver.findElement(By.xpath("//*[@class='sorting-sec animBounce']/div/div"));
				System.out.println("success");
				
				Thread.sleep(5000);
				Actions act1=new Actions(driver);
				act1.moveToElement(ele2).click().perform();
				WebElement ele1=driver.findElement(By.xpath("//ul[@class='sort-value']/li[2]"));
				ele1.click();
		//price range setup
				WebElement LowerEle = driver.findElement(By.xpath("//*[@class='price-text-box']/input"));
				LowerEle.clear();
				LowerEle.sendKeys("500");
				System.out.println("lowest range value is set");
				WebElement UpperEle = driver.findElement(By.xpath("(//*[@class='price-text-box']/input)[2]"));
				UpperEle.clear();
				UpperEle.sendKeys("1200");
				System.out.println("Highest range value is set");
				driver.findElement(By.xpath("//div[@class='price-go-arrow btn btn-line btn-theme-secondary']")).click();
		//Filter with color Navy 
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@class='filter-color-tile Navy ']")).click();
		//driver.close();
		//verify the all applied filters 
				String filter1=driver.findElement(By.xpath("//*[@class='filters']/div[1]")).getText();
				System.out.println(filter1);
				String filter2=driver.findElement(By.xpath("//*[@class='filters']/div[2]")).getText();
				System.out.println(filter2);
		//Hover to first resulting shoe
				WebElement result=driver.findElement(By.xpath("//*[@class='col-xs-6  favDp product-tuple-listing js-tuple ']"));
				act.moveToElement(result).perform();
				
		//click on quick view
				driver.findElement(By.xpath("//div[@class='product-tuple-image ']/div[2]/div")).click();
				
				driver.findElement(By.xpath("//*[@class='close close1 marR10']")).click();
		//window handles		
				result.click();
				String Parent=driver.getWindowHandle();
				Set<String> set1=driver.getWindowHandles();
				List<String> list1=new ArrayList<String>(set1);
				driver.switchTo().window(list1.get(1));
		//print the cost and the discount percentage	
				String actual = driver.findElement(By.xpath("//*[@class='pdpCutPrice ']")).getText();
				System.out.println(actual);
				String deal = driver.findElement(By.xpath("//*[@class='payBlkBig']")).getText();
				System.out.println(deal);
				
		//	Take snapshot of the shoe
				
				
		//close child window
				driver.close();
		//switch to parent
				driver.switchTo().window(Parent);
				driver.close();
				
				
				
				
		

	}

}
