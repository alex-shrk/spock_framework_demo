import logging

from hamcrest import assert_that, ends_with
from selenium.webdriver.common.by import By


class TestBookstoreUI:

    def test_open_book_info(self, driver):
        isbn = "9781449325862"
        book_name = "Git Pocket Guide"

        logging.info("Find Book by href link with book name and open it")
        link_element = driver.find_element(By.LINK_TEXT, book_name)
        link_element.click()

        logging.info("Page URL contains book's ISBN")
        assert_that(driver.current_url, ends_with(isbn),
                    "URL should ends with book's ISBN")
