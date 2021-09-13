import org.junit.jupiter.api.*
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.chrome.ChromeDriver
import java.util.concurrent.TimeUnit
import kotlin.concurrent.thread

class StartPageTest{
    lateinit var webDriver: ChromeDriver

    @BeforeEach
    fun setUp(){
        webDriver = ChromeDriver()
        webDriver.manage()?.window()?.maximize()
        webDriver.get("https://archive.org/")
    }

    @AfterEach
    fun tearDown(){
        webDriver.quit()
    }

    @Test
    fun findWebTest(){
        //webDriver.findElement(By.xpath("//input[@placeholder='Search']")).click()
        webDriver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("bash.im")
        //webDriver.findElement(By.xpath("//input[@value='WEB']")).click()
        webDriver.findElement(By.xpath("//button[normalize-space()='GO']")).click()

        Assertions.assertEquals("https://archive.org/search.php?query=bash.im", webDriver.currentUrl)
    }
}