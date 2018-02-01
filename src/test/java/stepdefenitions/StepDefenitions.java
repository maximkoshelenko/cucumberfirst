package stepdefenitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.MainPage;

import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertTrue;

public class StepDefenitions extends BaseStep {
    private WebDriver driver;

    @Before
    public void before() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        options.addArguments("window-size=1200x600");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
    }

    @Given("^Google Website is opened in Chrome browser$")
    public void google_Website_is_opened_in_Chrome_browser() {
        driver.get("https://www.google.com/");
        }
    @When("^User enters '(.*?)' in the Google Search Field$")
    public void user_enters_Wikipedia_in_the_Google_Search_Field(String messege) {
        mainPage = new MainPage(driver);
        mainPage.searchField.sendKeys(messege, Keys.ENTER);
    }

    @When("^User select '(.*?)' Search result link$")
    public void user_select_first_Dearch_result_link(String number) {
        mainPage.numberOfResult(number).click();
    }


    @Then("^User can see Wikipedia Logo$")
    public void user_can_see_Wikipedia_Logo() {
        mainPage.wikiLogo.isDisplayed();
    }

    @Then("^Wikipedia Website is loaded$")
    public void wikipedia_Website_is_loaded() {
        assertTrue(mainPage.checkTitle("Wikipedia"));
        assertTrue(mainPage.checkUrl("https://www.wikipedia.org/"));
    }

    @Then("^Youtube Website is loaded$")
    public void youtube_Website_is_loaded() {
        assertTrue(mainPage.checkTitle("YouTube"));
        assertTrue(mainPage.checkUrl("https://www.youtube.com/"));
    }

    @Then("^User can see Youtube Logo$")
    public void user_can_see_Youtube_Logo() {
        mainPage.tubeLogo.isDisplayed();
    }

    @After
    public void after() {
        driver.quit();
    }
}


