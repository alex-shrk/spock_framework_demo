import org.openqa.selenium.By

import static org.hamcrest.MatcherAssert.assertThat
import static org.hamcrest.Matchers.endsWith

class TestBookStoreUI extends BookStoreUISpecification {

    def "Open book info"() {
        given: "Exists book with ISBN and name"
        def isbn = "9781449325862"
        def bookName = "Git Pocket Guide"

        when: "Find Book by href link with book name and open it"
        def linkElement = driver.findElement(
                By.linkText(bookName))
        linkElement.click()

        then: "Page URL contains book's ISBN"
        assertThat(driver.currentUrl, endsWith(isbn))
    }

    def "Open book info (DDT)"() {
        when: "Find Book by href link with book name and open it"
        def linkElement = driver.findElement(
                By.linkText(bookName))
        linkElement.click()

        then: "Page URL contains book's ISBN"
        assertThat(driver.currentUrl, endsWith(isbn))

        where: "Exists books with ISBN and name"
        isbn            | bookName
        "9781449325862" | "Git Pocket Guide"
        "9789325968509" | "Core Java for Beginners"
    }
}
