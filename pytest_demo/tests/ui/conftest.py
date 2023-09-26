import pytest


@pytest.fixture(scope="function", autouse=True)
def open_start_page(driver):
    driver.get("https://demoqa.com/books")
    yield
