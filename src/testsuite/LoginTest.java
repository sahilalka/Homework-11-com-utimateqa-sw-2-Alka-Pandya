package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "https://courses.ultimateqa.com/";
    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    @Test
    /**
    1. userShouldNavigateToLoginPageSuccessfully
* click on the ‘Sign In’ link
* Verify the text ‘Welcome Back!’
     */
    public void userShouldNavigateToLoginPageSuccessfully() {
        //Find login link and click on login link
        driver.findElement(By.linkText("Sign In")).click();
        //Verify the text ‘Welcome Back!
        String expectedMessage = "Welcome Back!";
        WebElement actualTestElement = driver.findElement(By.xpath("//h2[@class='page__heading']"));
        String actualMessage = actualTestElement.getText();
        Assert.assertEquals("Error message displayed", expectedMessage, actualMessage);
    }

    /**
    2. verifyTheErrorMessage
* click on the ‘Sign In’ link
* Enter invalid username
* Enter invalid password
* Click on Login button
* Verify the error message ‘Invalid email
or password.’
     */
    @Test
    public void verifyTheErrorMessage() {
        //Find login link and click on login link
        driver.findElement(By.linkText("Sign In")).click();
        // Enter invalid username
        driver.findElement(By.id("user[email]")).sendKeys("abc123@gmail.com");
        //Enter invalid password
        driver.findElement(By.id("user[password]")).sendKeys("12345");
        //Click on Login button
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        //Verify the error message ‘Invalid email or password'
        String expectedMessage = "Invalid email or password.";
        WebElement actualTestElement = driver.findElement(By.xpath("//li[contains(text(),'Invalid email or password')]"));
        String actualMessage = actualTestElement.getText();
        Assert.assertEquals("message is displayed", expectedMessage, actualMessage);
    }
    @After
    public void tearDown() {
        // closeBrowser();
    }
}