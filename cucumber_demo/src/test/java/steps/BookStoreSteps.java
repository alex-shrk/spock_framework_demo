package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.endsWith;

public class BookStoreSteps {
    private String isbn;
    private String bookName;
    private WebDriver driver;

    @Before
    public void openBookStorePage() {
        this.driver = new ChromeDriver(new ChromeOptions().addArguments("headless"));
        this.driver.get("https://demoqa.com/books");
    }

    @Given("Exists book with isbn {string} and name {string}")
    public void existsBookWithIsbnAndName(String arg0, String arg1) {
        this.isbn = arg0;
        this.bookName = arg1;
    }


    @When("Find Book by href link with book name and open it")
    public void findBookByNameAndOpenIt() {
        WebElement linkElement = driver.findElement(By.linkText(bookName));
        linkElement.click();
    }

    @Then("Page URL contains book's ISBN")
    public void checkURLContainsBookISBN() {
        assertThat(driver.getCurrentUrl(), endsWith(isbn));
    }

    @After()
    public void closeBrowser() {
        driver.quit();
    }

}
