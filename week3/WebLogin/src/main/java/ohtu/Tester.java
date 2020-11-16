package ohtu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tester {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.get("http://localhost:4567");
        
        sleep(2);
        WebElement registration = driver.findElement(By.linkText("register new user"));

        // Registration //
        registration.click();
        sleep(2);

        registration = driver.findElement(By.name("username"));
        registration.sendKeys("testi");
        registration = driver.findElement(By.name("password"));
        registration.sendKeys("salasana1");
        registration = driver.findElement(By.name("passwordConfirmation"));
        registration.sendKeys("salasana1");
        registration = driver.findElement(By.name("signup"));

        sleep(2);
        registration.submit();

        // Logout after registration
        sleep(2);

        WebElement linkToMainpage = driver.findElement(By.linkText("continue to application mainpage"));
        linkToMainpage.click();

        sleep(2);

        WebElement logout = driver.findElement(By.linkText("logout"));
        logout.click();


        // Login
        WebElement login = driver.findElement(By.linkText("login"));

        login.click();
        sleep(2);

        // Incorrect login with correct username and incorrect password  //
        login = driver.findElement(By.name("username"));
        login.sendKeys("testi");
        login = driver.findElement(By.name("password"));
        login.sendKeys("salasana");
        login = driver.findElement(By.name("login"));

        sleep(2);
        login.submit();

        sleep(1);

        // Correct login
        login = driver.findElement(By.name("username"));
        login.sendKeys("testi");
        login = driver.findElement(By.name("password"));
        login.sendKeys("salasana1");
        login = driver.findElement(By.name("login"));

        sleep(2);
        login.submit();

        sleep(2);
        driver.quit();
    }
    
    private static void sleep(int n){
        try{
            Thread.sleep(n*1000);
        } catch(Exception ignored){}
    }
}
