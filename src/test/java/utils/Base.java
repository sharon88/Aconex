package utils;

import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {
    public static WebDriver driver;

    private String BASE_PROJECT_PATH = System.getProperty("user.dir");
    private String CHROME_DRIVER_PATH;
    private String FIREFOX_DRIVER_PATH;


    public void initiateDriver() throws IOException {
        switch (OsHelper.getOperatingSystem()) {
            case MAC:
                CHROME_DRIVER_PATH = BASE_PROJECT_PATH + File.separator + "drivers" + File.separator + "macDrivers" + File.separator + "chromedriver";
                FIREFOX_DRIVER_PATH = BASE_PROJECT_PATH + File.separator + "drivers" + File.separator + "macDrivers" + File.separator + "geckodriver";
                break;
            case WINDOWS:
                CHROME_DRIVER_PATH = BASE_PROJECT_PATH + File.separator + "drivers" + File.separator + "windowsDriver" + File.separator + "chromedriver.exe";
                FIREFOX_DRIVER_PATH = BASE_PROJECT_PATH + File.separator + "drivers" + File.separator + "windowsDriver" + File.separator + "geckodriver.exe";
        }
        String browser = getPropertyValue("browser");
        switch (browser) {
            case "firefox":
                System.setProperty("webdriver.gecko.driver", FIREFOX_DRIVER_PATH);
                driver = new FirefoxDriver();
                break;
            case "chrome":
                System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
                driver = new ChromeDriver();
                break;
            default:
                System.out.println("Enter correct driver");
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public WebDriver getDriver() {
        return driver;
    }


    public String getPropertyValue(String key) throws IOException {
        String propertyPath = BASE_PROJECT_PATH + File.separator + "src" + File.separator + "test" + File.separator + "java" + File.separator + "resources" + File.separator + "data.properties";
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream(propertyPath);
        properties.load(fileInputStream);
        return properties.getProperty(key);
    }

    protected void closeDriver(Scenario scenario) {
        try {
            if (scenario.isFailed()) {
                final byte[] screenshot = ((TakesScreenshot) driver)
                        .getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", scenario.getName());
            }
        } finally {
            driver.close();
        }
    }

    protected void startDriver() throws IOException {
        initiateDriver();
    }

}
