import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;


public class ToolsQA {
    public static void main(String[] args) throws InterruptedException{
        WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/automation-practice-form");

        driver.manage().window().maximize();

        driver.findElement(By.id("firstName")).sendKeys("Prakash");
        Thread.sleep(2000);

        driver.findElement(By.id("lastName")).sendKeys("V");
        Thread.sleep(2000);

        driver.findElement(By.id("userEmail")).sendKeys("Prakash@gmail.com");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//label[text()='Male']")).click();
        Thread.sleep(2000);

        driver.findElement(By.id("userNumber")).sendKeys("1234567890");
        Thread.sleep(2000);

        driver.findElement(By.id("dateOfBirthInput")).click();

        Select month = new Select(driver.findElement(By.className("react-datepicker__month-select")));
        month.selectByVisibleText("November");
        Thread.sleep(2000);


        Select year = new Select(driver.findElement(By.className("react-datepicker__year-select")));
        year.selectByVisibleText("2006");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//div[text()='30']")).click();
        Thread.sleep(2000);

        driver.findElement(By.id("subjectsInput")).sendKeys("Maths");
        driver.findElement(By.id("subjectsInput")).sendKeys("\n");
        Thread.sleep(2000);


        driver.findElement(By.xpath("//label[text()='Sports']")).click();
        driver.findElement(By.xpath("//label[text()='Reading']")).click();
        Thread.sleep(2000);

        driver.findElement(By.id("uploadPicture")).sendKeys("C:\\Users\\praka\\Desktop\\Whisk_66fbf2175e9165588e34da75a14c2656dr.jpeg");
        Thread.sleep(2000);

        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)");


        driver.findElement(By.id("currentAddress")).sendKeys("12,Coimbatore");
        Thread.sleep(2000);

        driver.findElement(By.id("react-select-3-input")).sendKeys("NCR");
        driver.findElement(By.id("react-select-3-input")).sendKeys("\n");
        driver.findElement(By.id("react-select-4-input")).sendKeys("Gurgaon");
        driver.findElement(By.id("react-select-4-input")).sendKeys("\n");
        Thread.sleep(2000);

        Thread.sleep(3000);

        driver.findElement(By.id("submit")).click();

        System.out.println("Form filled");

        driver.quit();

    }
}
