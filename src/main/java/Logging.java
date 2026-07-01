import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.config.Configurator;

public class Logging {
    private static final Logger logging = LogManager.getLogger(Logging.class);

    public static void main(String[] args){
        logging.trace("Opening Chrome Browser");
        logging.info("Selenium Page Automation");

        WebDriver driver =  new ChromeDriver();

        driver.get("https://www.selenium.dev/");

        logging.info("Clicking Download");
        driver.findElement(By.linkText("Downloads")).click();
        logging.info("URL:- "+ driver.getCurrentUrl());

        Configurator.setLevel(Logging.class.getName(),Level.OFF);

        logging.warn("Warning");
        driver.close();
    }
}
