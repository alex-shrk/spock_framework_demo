import io.restassured.RestAssured
import io.restassured.specification.RequestSpecification
import spock.lang.Shared
import spock.lang.Specification

class BookStoreAPISpecification extends Specification {

    @Shared
    protected RequestSpecification api

    def setupSpec() {
        RestAssured.baseURI = "https://demoqa.com/BookStore/v1"
        api = RestAssured.given()
    }

}
