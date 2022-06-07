package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment4_tables {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// Driver setup
				WebDriverManager.chromedriver().setup();
				ChromeOptions option = new ChromeOptions();
				option.addArguments("--disable-notifications");// --disable-notifications
				ChromeDriver driver = new ChromeDriver(option);
		// browser maximize
				driver.manage().window().maximize();
		// browser implicit wait
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// get the URL
				driver.get("http://www.leafground.com/pages/table.html");
				Thread.sleep(5000);
		// Get the count of number of columns
				int colSize = driver.findElements(By.xpath("//table//tr//th")).size();
				System.out.println(colSize);
		// Get the count of number of rows
				int rowSize = driver.findElements(By.xpath("//table//tr")).size();
				System.out.println(rowSize);
		// Get the progress value of 'Learn to interact with Elements'
				List<WebElement> elements = driver.findElements(By.xpath("//*[@class='even']/td[2]"));
				for (int i = 0; i < elements.size(); i++) {
					String str = elements.get(i).getText();
					System.out.println("output Learn to interact with Elements -progress value is  " + str);
				}
		//Check the vital task for the least completed progress.		
		   
			   
		 
				

	}
}

