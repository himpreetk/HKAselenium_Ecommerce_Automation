# HKAselenium_Ecommerce_Automation

A. Project Description

    This project is a Selenium WebDriver automation script written in Java that automates a basic e-commerce workflow on Amazon. 

B. Project Features

    The script performs the following steps:
        B.1. Opens the Amazon website.
        B.2. Searches for a product (e.g., "Laptop").
        B.3. Clicks on the first product from the search results.
        B.4. Adds the product to the cart.
        B.5. Validates whether the item was successfully added to the cart.

C. Technologies Used

       C.1. Java: Programming language used for writing test scripts.
       C.2. Selenium WebDriver: Browser automation framework.
       C.3. ChromeDriver: WebDriver implementation for Google Chrome.

D. Prerequisites

    Before running the script, ensure you have:
       D.1. Java installed (JDK 8 or higher).
       D.2. Selenium WebDriver dependencies added to your project.
       D.3. ChromeDriver downloaded and placed under the resources folder in the project structure.

E. Installation & Setup

    E.1. Clone this repository:
           - git clone https://github.com/yourusername/ecommerce-automation.git

    E.2. Open the project in an IDE (Eclipse/IntelliJ IDEA).

    E.3. Add Selenium WebDriver dependencies in your pom.xml (if using Maven) or download the required JAR files.

    E.4. Ensure chromedriver.exe is placed in the resources/ folder.

    E.5. Update the System.setProperty path in the script accordingly.

    E.6. Run the Ecommerce.java file as a Java application.

F. Project Structure

     ├── src/
     │   ├── packageecommer/
     │   │   ├── Ecommerce.java
     ├── resources/
     │   ├── chromedriver.exe
     ├── README.md

G. Code Explanation

    G.1. Setting Up WebDriver
         This section initializes the ChromeDriver and sets up browser configurations such as maximizing the window and setting implicit waits.
              System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
              WebDriver driver = new ChromeDriver();
              driver.manage().window().maximize();
              driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    G.2. Opening the E-commerce Website
          This line opens the Amazon website in the Chrome browser.
               -driver.get("https://www.amazon.com");

    G.3. Searching for a Product
         The script locates the search box, enters the keyword "Laptop," and submits the search.
             WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
             searchBox.sendKeys("Laptop");
             searchBox.submit();


    G.4. Clicking on the First Product
         It selects the first product from the search results and clicks on it.
             WebElement firstProduct = driver.findElement(By.cssSelector(".s-main-slot .s-result-item h2 a"));
             firstProduct.click();

    G.5. Adding the Product to the Cart
         Finds the "Add to Cart" button and clicks it.
              WebElement addToCartBtn = driver.findElement(By.id("add-to-cart-button"));
              addToCartBtn.click();

    G.6. Validating Item Added to Cart
         Retrieves the confirmation message and verifies if the item was successfully added.

               WebElement cartMessage = driver.findElement(By.cssSelector("#sw-atc-details-single-container span"));
               if (cartMessage.getText().contains("Added to Cart")) {
                    System.out.println("Test Passed: Item successfully added to cart.");
                   } else {
                    System.out.println("Test Failed: Item not added to cart.");
                   }


    G.7. Handling Errors and Closing the Browser
         Handles any potential errors and ensures that the browser is closed after execution.
               catch (Exception e) {
                  System.out.println("Error occurred: " + e.getMessage());
                } finally {
                  driver.quit();
                }


H. Expected Output

    The script should print a success message if the item is added to the cart.

    If an error occurs, it will print an appropriate error message.

I. Contributing

    Contributions are welcome! Feel free to fork the repo, create a new branch, and submit a pull request.
    
