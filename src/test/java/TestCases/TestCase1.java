package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

import org.testng.annotations.Test;

import java.time.Duration;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCase1
{
    //System.setProperty("webdriver.chrome.driver", "C:\\Users\\dinoa\\Downloads\\chromedriver.exe");

    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    @Test (priority = 1)
    public void openURL()
    {
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        System.out.println("URL opened");
    }

    @Test (priority = 2)
    public void login()
    {
        WebElement username = driver.findElement(By.id("user-name"));
        WebElement password = driver.findElement(By.id("password"));

        username.sendKeys("standard_user");
        password.sendKeys("secret_sauce");

        WebElement login = driver.findElement(By.name("login-button"));
        login.click();

        System.out.println("Login successful");
    }

    @Test (priority = 3)
    public void ceaderVerification()
    {
        wait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//*[@id=\"header_container\"]/div[2]/span")));
        WebElement header = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span"));
        assertEquals(header.getText(), "PRODUCTS");

        System.out.println("Header verified");
    }

    @Test (priority = 4)
    public void cartVerification()
    {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("shopping_cart_container")));
        System.out.println("Shopping cart verified");
    }

    @Test (priority = 5)
    public void burgerMenuVerification()
    {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("react-burger-menu-btn")));
        System.out.println("Burger menu verified");
    }

    @Test (priority = 6)
    public void TwitterLinkVerification()
    {
        wait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//*[@id=\"page_wrapper\"]/footer/ul/li[1]/a")));
        System.out.println("Twitter link verified");
    }

    @Test (priority = 6)
    public void FacebookLinkVerification()
    {
        wait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//*[@id=\"page_wrapper\"]/footer/ul/li[2]/a")));
        System.out.println("Facebook link verified");
    }

    @Test (priority = 6)
    public void LinkedInLinkVerification()
    {
        wait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//*[@id=\"page_wrapper\"]/footer/ul/li[3]/a")));
        System.out.println("LinkedIn link verified");
    }

    @Test (priority = 7)
    public void logout()
    {
        wait.until(ExpectedConditions.elementToBeClickable(By.id("react-burger-menu-btn")));
        WebElement BurgerMenu = driver.findElement(By.id("react-burger-menu-btn"));

        BurgerMenu.click();

        wait.until(ExpectedConditions.elementToBeClickable(By.id("logout_sidebar_link")));
        WebElement logout = driver.findElement(By.id("logout_sidebar_link"));

        logout.click();

        System.out.println("Logout successful");
    }

    @AfterTest
    public void terminateBrowser()
    {
        driver.quit();
        System.out.println("Browser terminated");
    }
}
