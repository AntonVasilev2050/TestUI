import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AllCustomersPage {

    public AllCustomersPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h2[text()=\"All Customers\"]")
    private WebElement targetText;

    @FindBy(xpath = "//*[@value='Add new Customer']")
    private WebElement buttonAddNewCustomer;

    public void checkOfAllCustomersPageOpen(){
        Assert.assertTrue(targetText.isDisplayed());
    }

    public void openCustomerInfo(){
        buttonAddNewCustomer.click();
    }

}
