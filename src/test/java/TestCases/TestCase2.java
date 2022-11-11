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

public class TestCase2
{
    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    String des = "carry.allTheThings() with the sleek, streamlined Sly Pack that" +
            " melds uncompromising style with unequaled laptop and tablet protection.";

    @Test (priority = 1)
    public void openURL()
    {
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        System.out.println("URL opened");
    }

    @Test (priority = 2)
    public void Login()
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
    public void backpack()
    {
        wait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//*[@id=\"item_4_title_link\"]/div")));
        WebElement item = driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div"));
        assertEquals(item.getText(), "Sauce Labs Backpack");
        System.out.println("Item verified");

        item.click();

        wait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//*[@id=\"inventory_item_container\"]/div/div/div[2]/div[1]")));
        WebElement title = driver.findElement
                (By.xpath("//*[@id=\"inventory_item_container\"]/div/div/div[2]/div[1]"));
        assertEquals(title.getText(), "Sauce Labs Backpack");
        System.out.println("Title verified");

        wait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//*[@id=\"inventory_item_container\"]/div/div/div[2]/div[2]")));
        WebElement description = driver.findElement
                (By.xpath("//*[@id=\"inventory_item_container\"]/div/div/div[2]/div[2]"));
        assertEquals(description.getText(), des);
        System.out.println("Description verified");

        wait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//*[@id=\"inventory_item_container\"]/div/div/div[2]/div[3]")));
        WebElement price = driver.findElement
                (By.xpath("//*[@id=\"inventory_item_container\"]/div/div/div[2]/div[3]"));
        assertEquals(price.getText(), "$29.99");
        System.out.println("Price verified");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("add-to-cart-sauce-labs-backpack")));
        WebElement cart = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        assertEquals(cart.getText(), "ADD TO CART");
        System.out.println("Cart verified");

        cart.click();
    }

    @Test (priority = 4)
    public void backToProducts()
    {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("back-to-products")));
        WebElement back = driver.findElement(By.id("back-to-products"));
        assertEquals(back.getText(), "BACK TO PRODUCTS");
        System.out.println("Back verified");

        back.click();
    }

    @Test (priority = 5)
    public void addToCart()
    {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("add-to-cart-sauce-labs-fleece-jacket")));
        WebElement cart = driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket"));
        assertEquals(cart.getText(), "ADD TO CART");
        System.out.println("Cart verified");

        cart.click();
    }

    @Test (priority = 6)
    public void shoppingCart()
    {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"shopping_cart_container\"]")));
        WebElement cart = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]"));
        System.out.println("Cart verified");

        cart.click();
    }

    @Test (priority = 7)
    public void checkout()
    {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("checkout")));
        WebElement Checkout = driver.findElement(By.id("checkout"));
        assertEquals(Checkout.getText(), "CHECKOUT");
        System.out.println("Checkout verified");

        Checkout.click();
    }

    @Test (priority = 8)
    public void input()
    {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("first-name")));
        WebElement firstname = driver.findElement(By.id("first-name"));

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("last-name")));
        WebElement lastname = driver.findElement(By.id("last-name"));

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("postal-code")));
        WebElement zipcode = driver.findElement(By.id("postal-code"));

        firstname.sendKeys("Ime");
        lastname.sendKeys("Prezime");
        zipcode.sendKeys("8888");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("continue")));
        WebElement Continue = driver.findElement(By.id("continue"));

        Continue.click();
        System.out.println("Order started");
    }

    @Test (priority = 9)
    public void ordered()
    {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("finish")));
        WebElement finish = driver.findElement(By.id("finish"));
        assertEquals(finish.getText(), "FINISH");

        finish.click();

        wait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//*[@id=\"checkout_complete_container\"]/h2")));
        WebElement Thanks = driver.findElement(By.xpath("//*[@id=\"checkout_complete_container\"]/h2"));
        assertEquals(Thanks.getText(), "THANK YOU FOR YOUR ORDER");

        wait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//*[@id=\"back-to-products\"]")));
        WebElement home = driver.findElement(By.xpath("//*[@id=\"back-to-products\"]"));
        assertEquals(home.getText(), "BACK HOME");

        home.click();
        System.out.println("Order successful");
    }

    @Test (priority = 10)
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
