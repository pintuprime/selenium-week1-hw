import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

/*
Project-1 - ProjectName : com-nopcommerce
BaseUrl = https://demo.nopcommerce.com/
1. Setup chrome browser.
2. Open URL.
3. Print the title of the page.
4. Print the current url.
5. Print the page source.
6. Navigate to Url.
“https://demo.nopcommerce.com/login?returnUrl=
%2F”
7. Print the current url.
8. Navigate back to the home page.
9. Navigate to the login page.
10. Print the current url.
11. Refresh the page.
12. Enter the email to email field.
13. Enter the password to password field.
14. Click on Login Button.
15. Close the browser
 */
public class MultiBrowserTest {
    static String browser = "Chrome";
    static String baseUrl = "https://demo.nopcommerce.com/";
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        //1.set up multi browser
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Wrong browser name");
        }

        //2.open url
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        //3.print title of the page
        String title = driver.getTitle();
        System.out.println("Title of page" + title);

        //4.print current url
        System.out.println("Current url: " + driver.getCurrentUrl());

        //5.print the page source
        String pageSource = driver.getPageSource();
        System.out.println(driver.getPageSource());
        Thread.sleep(4000);

        //6.navigate to new url
        String newUrl = "https://demo.nopcommerce.com/login?returnUrl=";
        driver.navigate().to(newUrl);

        //7.print current url
        System.out.println("The current Url: " + driver.getCurrentUrl());

        //8.navigate back to home page
        driver.navigate().to(baseUrl);

        //9.navigate to login page
        String loginUrl = "https://demo.nopcommerce.com/login?returnUrl=";
        driver.navigate().to(loginUrl);

        //10.print current url
        System.out.println("Current Url " + driver.getCurrentUrl());

        //11.refresh page
        driver.navigate().refresh();

        //12.enter email to email field
        WebElement emailField = driver.findElement(By.id("Email"));
        emailField.sendKeys("prime123@gmail.com");

        //13.enter password field
        WebElement passwordField = driver.findElement(By.id("Password"));
        passwordField.sendKeys("Prime123");

        //14.click on login button
        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        loginLink.click();

        //15.close browser
        driver.quit();

    }
}
