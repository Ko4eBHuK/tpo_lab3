import io.kotlintest.matchers.string.shouldContain
import io.kotlintest.specs.StringSpec
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import java.util.concurrent.TimeUnit


class TestWebDriver : StringSpec() {
    private val driver: WebDriver = ChromeDriver()
    private val sheeshUrl = "https://se.ifmo.ru/courses/testing"

    init {
        driver.manage()?.timeouts()?.implicitlyWait(10, TimeUnit.SECONDS)
        driver.manage()?.window()?.maximize()

        "Software Testing page opening" {
            driver.run {
                get(sheeshUrl)
                pageSource.shouldContain("Тестирование")
                quit()
            }
        }
    }
}