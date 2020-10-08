
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class AuthTest {

    private RequestSpec spec = new RequestSpec();

    @Test
    public void sendRequestWithoutConsumerKey() {

       response(spec.getSpecWithoutConsumerKey())
                .statusCode(401)
                .body("status", equalTo("fail"))
                .body("message", equalTo("HMAC-SHA1 verification failed"))
                .body("signing_key", equalTo("D%2BEdQ-gs%24-%25%402Nu7&"))
                .log().all();
    }


    @Test
    public void sendRequestWithoutSignatureMethod() {

       response(spec.getSpecWithoutSignatureMethod())
                .statusCode(401)
                .body("status", equalTo("fail"))
                .body("message", equalTo("Unsupported signature method."))
                .body("signing_key", equalTo("D%2BEdQ-gs%24-%25%402Nu7&"))
                .log().all();
    }

    @Test()
    public void sendRequestWithoutSignature() {   // Request with corrupted data

       response(spec.getSpecWithInvalidSignature())
                .statusCode(401)
                .body("status", equalTo("fail"))
                .body("message", equalTo("HMAC-SHA1 verification failed"))
                .body("signing_key", equalTo("D%2BEdQ-gs%24-%25%402Nu7&"))
                .log().all();
    }


    @Test()
    public void sendRequestWithoutTimestamp() {   // Request with no HeaderFields

        response(spec.getSpecWithoutTimestamp())
                .statusCode(401)
                .body("status", equalTo("fail"))
                .body("message", equalTo("Timestamp is missing or is not a number"))
                .log().all();
    }


    @Test()
    public void sendRequestWithoutNonce() {   // Request with corrupted data

       response(spec.getSpecWithoutNonce())
                .statusCode(401)
                .body("status", equalTo("fail"))
                .body("message", equalTo("Nonce is missing \"oauth_timestamp\""))
                .log().all();
    }


    @Test
    public void sendValidRequest() {

        response(spec.getValidSpec())
            .statusCode(200)
            .body("status", equalTo("pass"))
            .body("message", equalTo("OAuth-1.0a signature verification was successful"))
            .log().all();
    }

    ValidatableResponse response(RequestSpecification spec) {
        return given()
                .spec(spec).when().get().then();
    }

}
