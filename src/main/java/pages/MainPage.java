package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class MainPage {
    private WebDriver driver;

    @FindBy (name = "q")
    public WebElement searchField;

    @FindBy (css = "img[alt='Wikipedia Logo']")
    public WebElement wikiLogo;

    @FindBy (id = "logo-icon-container")
    public WebElement tubeLogo;

    public WebElement numberOfResult(String number){
        String xpath = "(//h3[@class='r']/a)[" + number + "]";
        return driver.findElement(By.xpath(xpath));
    }

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public Boolean checkTitle(String title){
        return driver.getTitle().equals(title);
    }

    public Boolean checkUrl(String url){
        return driver.getCurrentUrl().contains(url);
    }
}
