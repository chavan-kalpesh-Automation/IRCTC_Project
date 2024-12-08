package qa.IRCTC_Project.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static Properties prop;
	public static WebDriver driver;

	protected TestBase() {
		try {
			prop = new Properties();
			Path root = FileSystems.getDefault().getPath("").toAbsolutePath();

			Path filePath = Paths.get(root.toString(), "Configue.properties");
			FileInputStream fis = new FileInputStream(filePath.toString());
			prop.load(fis);

		} catch (FileNotFoundException e) {
			e.getStackTrace();
		} catch (IOException e) {
			e.getStackTrace();

		}
	}

	protected static void initialisation() {
		String browsername = prop.getProperty("browser");

		if (browsername.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().clearDriverCache().setup();
//			WebDriverManager.chromedriver().setup();

			driver = new ChromeDriver();

		} else if (browsername.equals("firefox")) {
			WebDriverManager.firefoxdriver().clearDriverCache().setup();
			driver = new FirefoxDriver();

		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.get(prop.getProperty("url"));

	}
}
