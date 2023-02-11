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
    ChromeDriver chromeDrive;
    WebDriverWait wait;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        chromeDrive = new ChromeDriver();
        wait = new WebDriverWait(chromeDrive,30);
        chromeDrive.get("https://academy.famcare.app/");
    }
    @Test
    public void verifyAcademyCategoryBox(){
        WebElement categoryBox = chromeDrive.findElement(By.xpath("//div[@data-id='3023636']"));
        // clickable?
        wait.until(ExpectedConditions.elementToBeClickable(categoryBox));
        categoryBox.click();
    }
    @AfterClass
    public void tearDown(){
        chromeDrive.quit();
        System.out.println("after");
    }
}
