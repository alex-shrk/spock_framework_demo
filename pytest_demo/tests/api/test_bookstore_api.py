import pytest
import requests
from hamcrest import assert_that, equal_to


class TestBookStore:

    @pytest.mark.description("GET /BookStore/v1/Book")
    def test_get_book_by_isbn(self):
        isbn = "9781449325862"

        response = requests.get("https://demoqa.com/BookStore/v1/Book", params={'ISBN': isbn})

        assert_that(response.status_code, equal_to(200))
        assert_that(response.json().get("isbn"), equal_to(isbn))
