import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class testngselenium {

    @Test
    public void login() throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        Thread.sleep(2000);

        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        Thread.sleep(2000);

        driver.findElement(By.id("login-button")).click();
        Thread.sleep(2000);

        String getURL = driver.getCurrentUrl();
        Assert.assertTrue((getURL.contains("inventory")));
        Thread.sleep(2000);

        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
        Thread.sleep(1000);

        driver.findElement((By.className("shopping_cart_link"))).click();
        Thread.sleep(1000);

        driver.findElement(By.id("checkout")).click();
        Thread.sleep(1000);

        driver.findElement(By.id("first-name")).sendKeys("Prakash");
        Thread.sleep(1000);

        driver.findElement(By.id("last-name")).sendKeys("V");
        Thread.sleep(1000);

        driver.findElement(By.id("postal-code")).sendKeys("123456");
        Thread.sleep(1000);

        driver.findElement(By.id("continue")).click();
        Thread.sleep(1000);

        driver.findElement(By.id("finish")).click();
        Thread.sleep(1000);

        Assert.assertTrue(driver.getPageSource().contains("Thank you for your order!"));

        driver.findElement(By.id("react-burger-menu-btn")).click();
        Thread.sleep(2000);

        driver.findElement(By.id("logout_sidebar_link")).click();
        Thread.sleep(1000);

//        driver.quit();
    }
}