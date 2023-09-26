import pytest
from selenium import webdriver


@pytest.fixture
def driver():
    chrome_options = webdriver.ChromeOptions().add_argument("--headless")

    driver = webdriver.Chrome(chrome_options)
    yield driver
    driver.close()
