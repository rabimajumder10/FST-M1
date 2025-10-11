 import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity3 {

    WebDriver driver;
	
    @BeforeClass
    public void setUp() {       
        WebDriverManager.chromedriver().setup(); 
        driver = new ChromeDriver();
        driver.manage().window().maximize();       
        driver.get("https://alchemy.hguy.co/lms");
    }

    @Test
    public void testInfoBoxTitle() {       
        WebElement firstInfoBoxTitle = driver.findElements(By.className("uagb-ifb-title")).get(0);        
        String actualTitle = firstInfoBoxTitle.getText();      
        String expectedTitle = "Actionable Training";       
        Assert.assertEquals(actualTitle, expectedTitle, "First info box title does not match!");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}