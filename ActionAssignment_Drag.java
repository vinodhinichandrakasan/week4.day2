package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionAssignment_Drag {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//http://www.leafground.com/pages/drag.html
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
	    options.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		//driver implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//get the url
		driver.get("http://www.leafground.com/pages/drag.html");
		WebElement element = driver.findElement(By.id("draggable"));
		//WebElement element2=driver.findElement(By.id("mydiv"));
		
		Actions act=new Actions(driver);
		act.dragAndDropBy(element, 100, 200).perform();

	}

}
