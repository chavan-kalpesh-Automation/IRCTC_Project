package qa.IRCTC_Project.Base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperClass extends TestBase{


	public void explicitWaitOnVisibility_Custom(WebDriver driver, WebElement element, int timeout) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void explicaitWaitElementTobeClickable(WebDriver driver, WebElement element, int timeout) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
			wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void explicWaitOnVisibilityOfElementLocated(WebDriver driver, WebElement element, int timeout) {
		try {
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timeout));
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy((By) element));
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public void explicWaitTextToBePresentInElement( WebElement element, String value,int timeout) {
		try {
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timeout));
			wait.until(ExpectedConditions.textToBePresentInElement(element, value));
		}
					catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void actions_ClassMethods(WebElement triggerElement, WebElement targetElement) {
		Actions act = new Actions(driver);
		act.moveToElement(triggerElement).perform();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(targetElement));
		targetElement.click();
	}

}
