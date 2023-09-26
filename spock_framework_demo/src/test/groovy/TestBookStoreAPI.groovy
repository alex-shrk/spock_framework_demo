import static org.hamcrest.MatcherAssert.assertThat
import static org.hamcrest.Matchers.equalTo

class TestBookStoreAPI extends BookStoreAPISpecification {

    def "GET /BookStore/v1/Book"() {
        given: "Exists book with ISBN"
        def isbn = "9781449325862"

        when: "Request Book by ISBN"
        def response = api.get("/Book?ISBN={isbn}", isbn)

        then: "Response's status code is 200"
        assertThat(response.getStatusCode(), equalTo(200))

        and: "Response contains Book with exists ISBN"
        assertThat((String) response.jsonPath().get("isbn"), equalTo(isbn))
    }
}
