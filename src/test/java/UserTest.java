import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * User story:
 *
 *   As a user I want to calculate squared of an integer
 *
 * Class name ends in IT so it runs with "mvn integration-test", not "mvn test".
 */
public class UserTest {
    
    //creating a web driver
    WebDriver driver = new ChromeDriver();

    //preparing the webdriver for the url
    @Before
    public void setUp() {
        driver.get("http://http://lowcost-env.8jm8a7kdcg.us-west-2.elasticbeanstalk.com/webapi/users");
    }

    //after test, closing the browser
    @After
    public void tearDown() {
        driver.quit(); // close browser
    }

    /**
     * Acceptance test:
     *
     *   Given I am on the hello page
     *   When I enter an integer
     *   Then I see the squared of the integer
     */
    
    
    
    
    @Test
    public void testTheOutputIsRight() {
        
        //sending the input
        driver.findElement(By.id("inputInt")).sendKeys("3");
        
        //clicking the submit button
        driver.findElement(By.id("submitInt")).click();
        
        //waiting for the output return
        (new WebDriverWait(driver, 10))
            .until(ExpectedConditions.textToBe(By.id("outputInt"), "9"));
    
    }
    
}   


