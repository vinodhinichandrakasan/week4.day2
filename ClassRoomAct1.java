package week4.day2;

import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClassRoomAct1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//driver implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://erail.in");
		WebElement ele1 = driver.findElement(By.id("txtStationFrom"));
		ele1.clear();
		Thread.sleep(4000);
		ele1.sendKeys("MS");
		Thread.sleep(3000);
		ele1.sendKeys(Keys.TAB);
		WebElement ele2=driver.findElement(By.id("txtStationTo"));
		ele2.clear();
		Thread.sleep(4000);
		ele2.sendKeys("MDU");
		Thread.sleep(3000);
		ele2.sendKeys(Keys.TAB);
		driver.findElement(By.id("chkSelectDateOnly")).click();
		
		List<WebElement> list1 = driver.findElements(By.xpath("//*[@id='divTrainsList']/table[1]//tr/td[2]/a"));
		Set<WebElement> set1=new HashSet<WebElement>(list1);
		System.out.println(list1.size());
		System.out.println(set1.size());
		//Set<String> set1=new HashSet<String>(list1);
		for (int i = 1; i < list1.size(); i++) {
			System.out.println(list1.get(i).getText());
		
		}
		
		if(set1.size()==list1.size())
		{
			System.out.println("success no duplication");
		}
		else
		{
			System.out.println("duplicate present");
		}
		
		
		
		driver.quit();
	
	}

}
