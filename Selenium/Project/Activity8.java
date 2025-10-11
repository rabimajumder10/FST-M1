 import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity8 {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://alchemy.hguy.co/lms");
    }

    @Test
    public void contactAdmin() throws InterruptedException {       
        WebElement contactMenu = driver.findElement(By.linkText("Contact"));
        contactMenu.click();

        Thread.sleep(2000);
      
        WebElement fullName = driver.findElement(By.id("wpforms-8-field_0"));
        WebElement email = driver.findElement(By.id("wpforms-8-field_1"));
        WebElement subject = driver.findElement(By.id("wpforms-8-field_3"));
        WebElement message = driver.findElement(By.id("wpforms-8-field_2"));
       
        fullName.sendKeys("Rabi Majumder");
        email.sendKeys("rabi.majumder@ibm.com");
        subject.sendKeys("Automation Message");
        message.sendKeys("This is a test message sent via Selenium automation.");
      
        WebElement submitButton = driver.findElement(By.id("wpforms-submit-8"));
        submitButton.click();

        Thread.sleep(2000); 
       
        WebElement successMessage = driver.findElement(By.cssSelector("div.wpforms-confirmation-container"));
        System.out.println("Submission response: " + successMessage.getText());
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}