import java.sql.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public  class hello {
    public static  void main(String[] args) throws Exception {

        WebDriver driver = new ChromeDriver();
        driver.get("C:\\Users\\praka\\IdeaProjects\\demo\\src\\main\\java\\index.html");

        //connecgtio to mysql
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/sel",
                "root",
                "root"
        );

        driver.findElement(By.id("name")).sendKeys("Guru");
        driver.findElement(By.id("email")).sendKeys("giuru@gmail.com");

        //store the above value in mysql
        // Create the user
        conn.prepareStatement
                        ("insert into users(name,email) values('Guru','giuru@gmail.com')")
                .executeUpdate();
        System.out.println("Added");
        Thread.sleep(1000);
        shows(conn);

        //updation
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("email")).clear();

        driver.findElement(By.id("name")).sendKeys("mathan");
        driver.findElement(By.id("email")).sendKeys("mathan@gmail.com");

        conn.prepareStatement("update users set name='mathan', email='mathan@gmail.com' where id=2").executeUpdate();
        shows(conn);

        conn.prepareStatement("delete from users where id=2").executeUpdate();

        shows(conn);

    }

    public static void shows(Connection conn) throws Exception{
        ResultSet rs = conn.createStatement().executeQuery("select * from users");
        System.out.println("/Users");
        while(rs.next()){
            System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
        }
    }
}
