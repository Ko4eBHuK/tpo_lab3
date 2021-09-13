import io.kotlintest.matchers.string.shouldContain
import io.kotlintest.specs.StringSpec
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import java.util.concurrent.TimeUnit


class TestSignup : StringSpec() {
    private val driver: WebDriver = ChromeDriver()
    private val signupUrl = "https://se.ifmo.ru/courses/testing"

    init {
        driver.manage()?.timeouts()?.implicitlyWait(10, TimeUnit.SECONDS)
        driver.manage()?.window()?.maximize()

        "Страница регистрации открывается" {
            driver.run {
                get(signupUrl)
                pageSource.shouldContain("Тестирование ")
                quit()
            }
        }
    }
}