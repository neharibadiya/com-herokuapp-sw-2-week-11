package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = " http://the-internet.herokuapp.com/login";
    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        //Enter username in username field
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        //Enter password in password field
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        //click on 'login' button
        WebElement loginBtn = driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']"));
        loginBtn.click();
        //verify the 'Secure Area'
        String expectedTextDisplay ="";
        WebElement actualTextElement = driver.findElement(By.xpath("//i[@class ='icon-lock']"));
        String actualTextDisplay = actualTextElement.getText();
        Assert.assertEquals("Text is Display", expectedTextDisplay, actualTextDisplay);
    }
    @Test
    public void verifyTheUsernameErrorMessage(){
       // Enter “tomsmith1” username
        driver.findElement(By.id("username")).sendKeys("tomsmith1");

        // Enter “SuperSecretPassword!” password
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");

        //Click on ‘LOGIN’ button
        WebElement loginBtn = driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']"));
        loginBtn.click();

        //Verify the error message “Your username is invalid!”
        String expectedMessage = "Your username is invalid!\n" + "×";
        WebElement actualTextElement = driver.findElement(By.id("flash"));
        String actualMessage = actualTextElement.getText();
        Assert.assertEquals("Erroe message is find", expectedMessage, actualMessage);
    }
    @Test
    public void verifyThePasswordErrorMessage(){
        // Enter “tomsmith1” username
        driver.findElement(By.id("username")).sendKeys("tomsmith1");

        // Enter “SuperSecretPassword” password
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword");

        //Click on ‘LOGIN’ button
        WebElement loginBtn = driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']"));
        loginBtn.click();

        //Verify the error message “Your password is invalid!”
        String expectedMessage ="Your username is invalid!\n"+ "×";
        WebElement actualTextElement = driver.findElement(By.xpath("//div[@class='flash error']"));
        String actualMessage = actualTextElement.getText();
        Assert.assertEquals("Error message is find", expectedMessage, actualMessage);
    }
    //@After
    //public void tearDown(){
    //    closeBrowser();
    //}
}

