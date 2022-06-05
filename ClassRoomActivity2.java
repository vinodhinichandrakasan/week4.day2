package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClassRoomActivity2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
	    options.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		//driver implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.snapdeal.com/");
		Thread.sleep(5000);
		WebElement ele=driver.findElement(By.xpath("//span[contains(text(),\"Men's Fashion\")]"));
		Actions act=new Actions(driver);
		act.moveToElement(ele).click().perform();
		driver.findElement(By.xpath("//a/span[text()='Shirts']")).click();
		
		////*[@class='product-image '][1]
		Thread.sleep(3000);
		WebElement ele2=driver.findElement(By.xpath("//picture[@class='picture-elem']/img"));
		//Actions act1=new Actions(driver);
		act.moveToElement(ele2).perform();
		System.out.println("test");
		driver.findElement(By.xpath("//*[@class='clearfix row-disc']/div")).click();
		System.out.println("quick view is opened");
		driver.quit();
	}

}
