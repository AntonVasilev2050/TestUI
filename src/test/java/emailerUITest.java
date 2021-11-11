import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class emailerUITest {
    public WebDriver driver;
    public AllCustomersPage allCustomersPage;
    public CustomerInfoPage customerInfoPage;


    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1000, 600));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        allCustomersPage = new AllCustomersPage(driver);
        customerInfoPage = new CustomerInfoPage(driver);
    }

    @AfterTest
    public void testDown() {
        driver.quit();
    }


    @Test
    public void testAllCustomersPage(){
        driver.get("http://localhost:8080");
        allCustomersPage.checkOfAllCustomersPageOpen();
    }

    @Test
    public void testCustomerInfoPage(){
        driver.get("http://localhost:8080");
        allCustomersPage.openCustomerInfo();
        customerInfoPage.checkOfOpenCustomerInfoPage();
    }

    @Test
    public void updateFirstCustomer() {
        driver.get("http://localhost:8080/");
        List<WebElement> elements = driver.findElements(By.xpath("//*[@value='Update']"));
        System.out.println("----");
        elements.get(0).click();
        WebElement inputField = driver.findElement(By.id("name"));
        inputField.clear();
        inputField.sendKeys("Sergey");
        inputField = driver.findElement(By.id("surname"));
        inputField.clear();
        inputField.sendKeys("Ivanov");
        WebElement buttonUpdateCustomer = driver.findElement(By.xpath("//*[@value='Update Customer']"));
        buttonUpdateCustomer.click();
    }

    @Test
    public void addNewCustomer() {
        driver.get("http://localhost:8080/");
        WebElement buttonAddNewCustomer = driver.findElement(By.xpath("//*[@value='Add new Customer']"));
        buttonAddNewCustomer.click();
        WebElement inputField = driver.findElement(By.id("name"));
        inputField.sendKeys("John");
        inputField = driver.findElement(By.id("surname"));
        inputField.sendKeys("Doe");
        inputField = driver.findElement(By.id("dateOfBirth"));
        inputField.sendKeys("25.08.1999");
        inputField = driver.findElement(By.id("email"));
        inputField.sendKeys("john_doe@gmail.com");
        WebElement buttonOK = driver.findElement(By.xpath("//*[@value='OK']"));
        buttonOK.click();
    }

    @Test
    public void deleteCustomer(){
        driver.get("http://localhost:8080/");
        List<WebElement> elements = driver.findElements(By.xpath("//*[@value='Delete']"));
        elements.get(elements.size() - 1).click();
    }

    @Test
    public void newCard(){
        driver.get("http://localhost:8080/");
        List<WebElement> elements = driver.findElements(By.xpath("//*[@value='New Card']"));
        elements.get(elements.size() - 1).click();
    }

}
