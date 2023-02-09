import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

import static org.testng.Assert.assertTrue;

public class FamcareTest {

    ChromeDriver chromeDrive;
    WebDriverWait wait;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        chromeDrive = new ChromeDriver();
        wait = new WebDriverWait(chromeDrive,30);
        chromeDrive.get("https://famcare.app/");
    }
    @Test(priority = 1)
    public void isSectionExist(){
        String sectionId="heroSection";
        WebElement heroSection = chromeDrive.findElement(By.id(sectionId));
        assertTrue(heroSection.isDisplayed());
    }
    @Test(priority = 2)
    public void isAcademyBtnDisplay(){
        WebElement academyBtnPath = chromeDrive.findElement(By.xpath("//a[@title='الأكاديمية']"));
        assertTrue(academyBtnPath.isDisplayed());
    }
    @Test(priority = 3)
    public void verifyAcademyBtnOpenAcademy(){
        WebElement academyBtnPath = chromeDrive.findElement(By.xpath("//a[@title='الأكاديمية']"));
        academyBtnPath.click();
        WebElement categoryBox = chromeDrive.findElement(By.xpath("//div[@data-id='3023636']"));
        assertTrue(categoryBox.isDisplayed());
    }
    @Test(priority = 4)
    public void verifyAcademyCategoryBox(){
        WebElement categoryBox = chromeDrive.findElement(By.xpath("//div[@data-id='3023636']"));
        // clickable?
        wait.until(ExpectedConditions.elementToBeClickable(categoryBox));
        categoryBox.click();
    }
}
