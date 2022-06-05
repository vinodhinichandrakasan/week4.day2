package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsAssignment1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		/*
		 * 1.https://jqueryui.com/resizable 2.http://www.leafground.com/pages/drag.html
		 * 3.http://www.leafground.com/pages/drop.html
		 * 4.http://www.leafground.com/pages/selectable.html
		 * 5.http://www.leafground.com/pages/sortable.html
		 */
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
	    options.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		//driver implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//get the url
		driver.get("https://jqueryui.com/resizable");
		//driver.manage ( ) . window ( ) . maximize ( ) ;
		WebElement frame = driver.findElement(By.xpath("//*[@id='content']/iframe")) ;
		driver.switchTo( ).frame(frame);
		WebElement element =driver.findElement ( By.xpath ("//* [@id='resizable']/div[3]" ) ) ;
		Actions action = new Actions ( driver ) ;
		action.dragAndDropBy( element , 300 , 100 ).perform() ;
		driver.close();
		
		
		
	}

}
