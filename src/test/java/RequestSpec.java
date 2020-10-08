import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;



class RequestSpec {

    private final String BASE_URL = "https://postman-echo.com/oauth1";
    private final HeaderCases headers = new HeaderCases();

    RequestSpecification getBuilder(String header) {
        return new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
                .addHeader("Authorization", header)
                .build();
    }

    RequestSpecification getValidSpec() {
         return getBuilder(headers.getValidHeader());
    }

    RequestSpecification getSpecWithoutConsumerKey() {
        return getBuilder(headers.getHeaderWithoutConsumerKey());
    }

    RequestSpecification getSpecWithInvalidSignature() {
        return getBuilder(headers.getHeaderWithInvalidSignature());
    }

    RequestSpecification getSpecWithoutTimestamp() {
        return getBuilder(headers.getHeaderWithoutTimestamp());
    }

    RequestSpecification getSpecWithoutSignatureMethod() {
        return getBuilder(headers.getHeaderWithoutSignatureMethod());
    }

    RequestSpecification getSpecWithoutNonce() {
        return getBuilder(headers.getHeaderWithoutNonce());
    }

}

