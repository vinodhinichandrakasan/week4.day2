package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionAssignment_Selectable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//http://www.leafground.com/pages/selectable
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
	    options.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		//driver implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//get the url
		driver.get("http://www.leafground.com/pages/selectable.html");
		//find the element
		WebElement item5 = driver.findElement(By.xpath("//*[@class='ui-selectable']/li[text()='Item 5']"));
		WebElement item7 = driver.findElement(By.xpath("//*[@class='ui-selectable']/li[text()='Item 7']"));
		WebElement item6 = driver.findElement(By.xpath("//*[@class='ui-selectable']/li[text()='Item 6']"));
		
		//action class
		Actions builder = new Actions(driver);
		builder.keyDown(Keys.CONTROL)
		.click(item5)
		.click(item7)
		.click(item6)
		.keyUp(Keys.CONTROL)
		.perform();
        driver.close();
	}

}
