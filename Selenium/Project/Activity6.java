 import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity6 {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup(); 
        driver = new ChromeDriver();             
        driver.manage().window().maximize();    
        driver.get("https://example.com/login"); 
    }

    @Test
    public void testLogin() {      
        WebElement usernameField = driver.findElement(By.id("username")); 
        usernameField.sendKeys("root");
       
        WebElement passwordField = driver.findElement(By.id("password")); 
        passwordField.sendKeys("pa$$w0rd");
       
        WebElement loginButton = driver.findElement(By.id("loginButton")); 
        loginButton.click();
        
        WebElement dashboard = driver.findElement(By.id("dashboard")); 
        Assert.assertTrue(dashboard.isDisplayed(), "Login failed: Dashboard not found.");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}