import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class OldTest {
    ChromeDriver chdr;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        chdr = new ChromeDriver();
        chdr.get("https://famcare.app/");
        System.out.println("Before");
    }
    @Test
    public void isTitleDisplay(){
        String path="//*[@id='heroText']/div/div[1]/h2";
        WebElement titleText = chdr.findElement(By.xpath(path));
        assertTrue(titleText.isDisplayed());
    }
    @Test
    public void testCheckBtn(){
        String path="//*[@id='heroText']/div/div[3]/a";
        String nextUrl ="https://apps.apple.com/SA/app/id1517781498?mt=8";
        WebElement loginButton = chdr.findElement(By.xpath(path));
        //String btnSite =loginButton.getAttribute("href");
        assertTrue(loginButton.isDisplayed());
        loginButton.click();
        assertEquals(chdr.getCurrentUrl(),nextUrl);
    }

    @Test(enabled = false)
    public void test1(){
        int expected=100;
        int actual=110;
        assertEquals(actual,expected);
        //System.out.println("test1");
    }
    @AfterClass
    public void tearDown(){
        //chdr.quit();
        System.out.println("after");
    }
}
