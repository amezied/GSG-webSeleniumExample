import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class AcademyTest {
    MainTest mainTest= new MainTest();
    ChromeDriver driver;
    @BeforeClass
    public void setUp(){
        driver=  mainTest.setUp("https://academy.famcare.app");
    }
    @Test
    public void verifyAcademyCategoryBox(){
        WebElement categoryBox = driver.findElement(By.xpath("//div[@data-id='3023636']"));
        // clickable?
        //wait.until(ExpectedConditions.elementToBeClickable(categoryBox));
        categoryBox.click();
    }
    @AfterClass
    public void tearDown(){
        mainTest.tearDown();
    }
}
