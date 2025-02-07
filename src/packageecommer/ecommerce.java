package packageecommer;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ecommerce {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Setup the chrome driver
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\raman\\eclipse-workspace\\testerr\\HKAselenium_Ecommerce_Workflow\\resources\\chromedriver.exe");
	
        //Initialize the browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //implicit wait
		
		try
		{
			//Step1 : Open E-commerce website
			driver.get("https://www.amazon.com");
		
			//Step2: Search for a product
			WebElement searchBox = driver.findElement(By.id("twotabsearchbox"));
			searchBox.sendKeys("Laptop");
			searchBox.submit();
			
			//Step3: Click on the first product
			WebElement FirstProduct = driver.findElement(By.cssSelector(".s-main-slot .s-result-item h2 a"));
			FirstProduct.click();
			
			//Step4: Add the Item to the Cart
			WebElement addToCartBtn = driver.findElement(By.id("add-to-cart-button"));
			addToCartBtn.click();
			
			   // Step 5: Validate item added to the cart
            WebElement cartMessage = driver.findElement(By.cssSelector("#sw-atc-details-single-container span"));
            if (cartMessage.getText().contains("Added to Cart")) {
                System.out.println("Test Passed: Item successfully added to the cart.");
            } else {
                System.out.println("Test Failed: Item not added to the cart.");
            }
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        } finally {
            // Close browser
            driver.quit();
        }
	}
}
