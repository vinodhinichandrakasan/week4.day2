package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionAssignment_Sortable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
	    options.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		//driver implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//get the url
		driver.get("http://www.leafground.com/pages/sortable.html");
		
		//find the element
		WebElement item4 = driver.findElement(By.xpath("//*[@id=\"sortable\"]/li[4]"));
		WebElement item7 = driver.findElement(By.xpath("//*[@id=\"sortable\"]/li[7]"));
		//action class
		Actions act=new Actions(driver);
		act.clickAndHold(item7)
		.moveToElement(item4)
		.release()
		.perform();
	

	}

}
