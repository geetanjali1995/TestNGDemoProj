package tutorialsninja.register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
//import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class TC_RF_001 {

	
	@Test
	public void Verifylogin() {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.saucedemo.com");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.name("password")).sendKeys("secret_sauce");
		driver.findElement(By.className("btn_action")).click();
	
		//validation1 : title is displayed or not
		Assert.assertTrue(driver.findElement(By.className("title")).isDisplayed());
		
		//String ActualUrl = "https://www.saucedemo.com/inventory.html";
		//	String expectedUrl	= driver.getCurrentUrl();
	//validation 2	: url is expected or not
		//	Assert.assertEquals("ActualUrl","expectedUrl");
	
	//validation 3 : has sort container icon
			
			Assert.assertTrue(driver.findElement(By.className("product_sort_container")).isDisplayed());

			//validation 4: details mentioned about product
	String ActualproperDetails = "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.";
  String expectedPRoperDetails = driver.findElement(By.className("inventory_item_label")).getText();
	
  Assert.assertTrue(expectedPRoperDetails.contains(ActualproperDetails));
	
  driver.quit();
	}

}
