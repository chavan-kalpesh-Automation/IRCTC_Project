package qa.IRCTC_Project.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import qa.IRCTC_Project.Base.TestBase;

public class HomePageClass extends TestBase {

	@FindBy(xpath = "//label[text()=' BOOK TICKET ']")
	private WebElement bookTicket_TitleText;

//Initialization of the WebElement Using the PageFactory 

	public HomePageClass() {
		PageFactory.initElements(driver, this);
	}

	// Page Actions
	public String validateHomePage_Titletext() {

		return bookTicket_TitleText.getText();
	}

}
