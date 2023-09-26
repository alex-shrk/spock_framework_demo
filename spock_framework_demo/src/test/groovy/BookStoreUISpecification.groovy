import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import spock.lang.Shared
import spock.lang.Specification

class BookStoreUISpecification extends Specification {

    @Shared
    protected WebDriver driver

    def setupSpec() {
        this.driver = new ChromeDriver(
                new ChromeOptions().addArguments("headless"))
    }

    def setup() {
        this.driver.get("https://demoqa.com/books")
    }

    def cleanup() {
        this.driver.manage().deleteAllCookies()
    }

    def cleanupSpec() {
        this.driver.quit()
    }
}
