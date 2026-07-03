import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;
import org.apache.logging.log4j.Level;
import org.testng.annotations.Test;

public class PlayGame {
    static Logger log = LogManager.getLogger(PlayGame.class);
    @Test
    public void game() throws  InterruptedException{
        log.info("Chrome Driver is getting URL");
        WebDriver driver = new ChromeDriver();
        driver.get("https://play2048.co/");

        log.trace("Left Button");
        driver.findElement(By.tagName("body")).sendKeys(Keys.ARROW_LEFT);
        Thread.sleep(2000);

        log.trace("Right Button");
        driver.findElement(By.tagName("body")).sendKeys(Keys.ARROW_RIGHT);
        Thread.sleep(2000);

        log.trace("Up Button");
        driver.findElement(By.tagName("body")).sendKeys(Keys.ARROW_UP);
        Thread.sleep(2000);

        log.trace("Down Button");
        driver.findElement(By.tagName("body")).sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(2000);

        Configurator.setRootLevel(Level.OFF);

    }
}
