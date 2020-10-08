
class HeaderCases {

    private final String OAUTH = "OAuth ";
    private final String CONSUMER_KEY = "oauth_consumer_key=\"RKCGzna7bv9YD57c\",";
    private final String CONSUMER_SECRET = "oauth_consumer_secret=\"D+EdQ-gs$-%@2Nu7\"";
    private final String SIGNATURE_METHOD = "oauth_signature_method=\"HMAC-SHA1\",";
    private final String SIGNATURE = "oauth_signature=\"j0Vjk9NqvMKqO9siMv4k7t1vy5c%3D\"";
    private final String INVALID_SIGNATURE = "oauth_signature=\"_j0Vjk9NqvMKqO9siMv4k7t1vy5c%3D\"";
    private final String TIMESTAMP = "oauth_timestamp=\"1602153509\",";
    private final String NONCE = "oauth_nonce=\"tPhr3H\",";
    private final String VERSION = "oauth_version=\"1.0\",";

     String getValidHeader() {
        return OAUTH + CONSUMER_KEY + SIGNATURE_METHOD + SIGNATURE + TIMESTAMP + NONCE + VERSION;
    }

     String getHeaderWithoutConsumerKey() {
        return OAUTH + SIGNATURE_METHOD + SIGNATURE+ TIMESTAMP + NONCE + VERSION;
    }

     String getHeaderWithoutSignatureMethod() {
        return OAUTH + CONSUMER_KEY + SIGNATURE + TIMESTAMP + NONCE + VERSION;
    }

    String getHeaderWithInvalidSignature() {
        return OAUTH + CONSUMER_KEY + SIGNATURE_METHOD + INVALID_SIGNATURE + TIMESTAMP + NONCE + VERSION;
    }

     String getHeaderWithoutTimestamp() {
        return OAUTH + CONSUMER_KEY + SIGNATURE_METHOD + SIGNATURE + NONCE + VERSION;
    }

     String getHeaderWithoutNonce() {
        return OAUTH + CONSUMER_KEY + SIGNATURE_METHOD + SIGNATURE + TIMESTAMP + VERSION;
    }
}
