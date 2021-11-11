import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CustomerInfoPage {
    public CustomerInfoPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h2[text()=\"Customer Info\"]")
    private WebElement targetCustomerInfoText;

    public void checkOfOpenCustomerInfoPage(){
        Assert.assertTrue(targetCustomerInfoText.isDisplayed());
    }

    @FindBy(xpath = "//*[@value='OK']")
    private WebElement buttonOK;

    public void openAllCustomers(){
        buttonOK.click();
    }
}
