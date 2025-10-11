import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.List;

public class Activity4 {

    WebDriver driver;

    @BeforeClass
    public void setUp() {       
        WebDriverManager.chromedriver().setup(); 
        driver = new ChromeDriver();
        driver.manage().window().maximize();       
        driver.get("https://alchemy.hguy.co/lms");
    }

    @Test
    public void testSecondPopularCourseTitle() {       
        List<WebElement> popularCourses = driver.findElements(By.cssSelector(".ld_course_grid .entry-title"));   
        Assert.assertTrue(popularCourses.size() >= 2, "Less than two courses found!");
        String actualCourseTitle = popularCourses.get(1).getText();
        String expectedCourseTitle = "Email Marketing Strategies";
        Assert.assertEquals(actualCourseTitle, expectedCourseTitle, "Second course title does not match!");
    }

    @AfterClass
    public void tearDown() {    
        if (driver != null) {
            driver.quit();
        }
    }
}