import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import static org.testng.Assert.assertTrue;

public class FamcareTest {
    MainTest mainTest= new MainTest();
    ChromeDriver driver;
    @BeforeClass
    public void setUp(){
        driver=  mainTest.setUp("https://famcare.app");
    }
    @Test(priority = 1)
    public void isSectionExist(){
        String sectionId="heroSection";
        WebElement heroSection = driver.findElement(By.id(sectionId));
        assertTrue(heroSection.isDisplayed());
    }
    @Test(priority = 2)
    public void isAcademyBtnDisplay(){
        WebElement academyBtnPath = driver.findElement(By.xpath("//a[@title='الأكاديمية']"));
        assertTrue(academyBtnPath.isDisplayed());
    }
    @Test(priority = 3)
    public void verifyAcademyBtnOpenAcademy(){
        WebElement academyBtnPath = driver.findElement(By.xpath("//a[@title='الأكاديمية']"));
        academyBtnPath.click();
        WebElement categoryBox = driver.findElement(By.xpath("//div[@data-id='3023636']"));
        assertTrue(categoryBox.isDisplayed());
    }
    @AfterClass
    public void tearDown(){
        mainTest.tearDown();
    }
}
