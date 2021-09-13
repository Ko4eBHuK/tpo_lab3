import org.junit.jupiter.api.*
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.chrome.ChromeDriver

class StartPageNavigationTest{
    lateinit var webDriver: ChromeDriver

    @BeforeEach
    fun setUp(){
        webDriver = ChromeDriver()
        webDriver.get("https://archive.org/")
    }

    @AfterEach
    fun tearDown(){
        webDriver.quit()
    }

    @Test
    fun navigateToAbout(){
        webDriver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("bash.im")
        val radio: WebElement = webDriver.findElement(By.xpath("//input[@value='WEB']"))
        radio.click()
        webDriver.findElement(By.xpath("//button[normalize-space()='GO']")).click()

        Assertions.assertEquals("https://web.archive.org/web/*/bash.im", webDriver.currentUrl)
    }
}