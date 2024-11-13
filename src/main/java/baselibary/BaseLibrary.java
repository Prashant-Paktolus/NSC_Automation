package baselibary;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class BaseLibrary {

    public static WebDriver driver;

    public void getLaunchUrl(String browser, String url) {

        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(options);
            System.out.println("Chrome is Launched ");
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            System.out.println("Firebox is Launched ");
        } else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            System.out.println("Edge Browser is Launched ");
        }

        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10L));
        System.out.println(driver.getTitle());
    }
}


