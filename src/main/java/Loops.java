import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class Loops {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com/tables");

        WebElement table = driver.findElement(By.id("table1"));

        List<WebElement> rows = table.findElements(By.xpath(".//tbody/tr"));

        for (int i = 1; i <= rows.size(); i++) {

            List<WebElement> cols = table.findElements(By.xpath(".//tbody/tr[" + i + "]/td"));

            for (int j = 1; j <= cols.size(); j++) {

                String value = table.findElement(
                                By.xpath(".//tbody/tr[" + i + "]/td[" + j + "]"))
                        .getText();

                System.out.print(value + "\t");
            }

            System.out.println();
        }

        System.out.println("Table2");

        WebElement table2 = driver.findElement(By.id("table2"));

        List<WebElement> rows2 = table.findElements(By.xpath(".//tbody/tr"));

        for (int i = 1; i <= rows2.size(); i++) {

            List<WebElement> cols2 = table.findElements(By.xpath(".//tbody/tr[" + i + "]/td"));

            for (int j = 1; j <= cols2.size(); j++) {

                String value = table.findElement(
                                By.xpath(".//tbody/tr[" + i + "]/td[" + j + "]"))
                        .getText();

                System.out.print(value + "\t");
            }

            System.out.println();
        }

        driver.quit();
    }
}