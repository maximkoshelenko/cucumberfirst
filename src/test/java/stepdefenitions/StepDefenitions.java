package stepdefenitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertTrue;

public class StepDefenitions {
    private WebDriver driver;

    private WebElement searchField(){
        return driver.findElement(By.name("q"));
    }

    private WebElement numberOfResult(String number){
        String xpath = "(//h3[@class='r']/a)[" + number + "]";
        return driver.findElement(By.xpath(xpath));
    }

    private WebElement wikiLogo(){
        return driver.findElement(By.cssSelector("img[alt='Wikipedia Logo']"));
    }

    private WebElement tubeLogo(){
        return driver.findElement(By.id("logo-icon-container"));
    }

    @Before
    public void before() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
    }

    @Given("^Google Website is opened in Chrome browser$")
    public void google_Website_is_opened_in_Chrome_browser() {
        driver.get("https://www.google.com/");
        }
    @When("^User enters '(.*?)' in the Google Search Field$")
    public void user_enters_Wikipedia_in_the_Google_Search_Field(String messege) {
        searchField().sendKeys(messege, Keys.ENTER);
    }

    @When("^User select '(.*?)' Search result link$")
    public void user_select_first_Dearch_result_link(String number) {
        numberOfResult(number).click();
    }

    @Then("^Wikipedia Website is loaded$")
    public void wikipedia_Website_is_loaded() {
        assertTrue(driver.getTitle().equals("Wikipedia"));
        assertTrue(driver.getCurrentUrl().contains("https://www.wikipedia.org/"));
    }

    @Then("^User can see Wikipedia Logo$")
    public void user_can_see_Wikipedia_Logo() {
        wikiLogo().isDisplayed();
    }


    @Then("^Youtube Website is loaded$")
    public void youtube_Website_is_loaded() {
        assertTrue(driver.getTitle().equals("YouTube"));
        assertTrue(driver.getCurrentUrl().contains("https://www.youtube.com/"));
    }

    @Then("^User can see Youtube Logo$")
    public void user_can_see_Youtube_Logo() {
        tubeLogo().isDisplayed();
    }

    @After
    public void after() {
        driver.quit();
    }
}


