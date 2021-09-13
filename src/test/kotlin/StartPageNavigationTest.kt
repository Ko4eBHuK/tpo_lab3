import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.openqa.selenium.By
import org.openqa.selenium.chrome.ChromeDriver

class StartPageNavigationTest{
    lateinit var webDriver: ChromeDriver

    @BeforeAll
    fun setUp(){
        webDriver = ChromeDriver()
        webDriver.get("https://archive.org/")
    }

    @Test
    fun navigateToAbout(){
        webDriver.findElement(By.xpath("//div[@class='preamble-whoweare']"))
    }
}