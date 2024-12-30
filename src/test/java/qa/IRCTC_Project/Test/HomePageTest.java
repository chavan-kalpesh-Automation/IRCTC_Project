package qa.IRCTC_Project.Test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import qa.IRCTC_Project.Base.TestBase;
import qa.IRCTC_Project.Pages.HomePageClass;

public class HomePageTest extends TestBase {
	HomePageClass homepage;

	public HomePageTest() {
		super();

	}

	@BeforeMethod
	public void setup() {
		initialisation();
		homepage = new HomePageClass();

	}

	@Test
	public boolean homePageTitleText_Test() {
		String homePageTitleText = homepage.validateHomePage_Titletext();
		Assert.assertEquals(homePageTitleText, " BOOK TICKET ");
		Assert.assertEquals(false, true);
		return true;

	}
}
