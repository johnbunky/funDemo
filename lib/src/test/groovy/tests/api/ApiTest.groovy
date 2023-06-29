package tests.api

import spock.lang.*
import io.restassured.http.ContentType
import org.apache.commons.lang3.RandomStringUtils
import org.junit.jupiter.api.Test

import static io.restassured.RestAssured.given
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath

class ApiTest {
    def thisEndpoint = "https://dev.pizzaranch.rocketeffect.com/api/user/register/validate"
    private static def charset = (('a'..'z') + ('A'..'Z') + ('0'..'9')).join()
    static def uniqueString = RandomStringUtils.random(7, charset.toCharArray())
    static def unique_email = "${uniqueString}@dev.rocket-email.com"
    def validUser = [
            email : unique_email as String,
            email_confirmation : unique_email as String,
            password : 'AAAaaa11!',
            password_confirmation : 'AAAaaa11!',
            firstname : 'firstname',
            lastname : 'lastname',
            gender : 'm',
            birth_date : '1991-01-01',
            phone : '(225)8888888',
            address : 'address',
            city : 'city,',
            country : 'Zimbabwe',
            state : 'state',
            zip : 88888
    ]

    @Tag('ttt')
    @Test
    void 'success valid registration'() {
        given().
                contentType(ContentType.JSON).
                body(validUser).
                post(thisEndpoint).
        then().
                statusCode(204)
    }

    @Test
    void 'request body is missing Unaddressable'() {
        given().
                header('Accept', 'application/json').
                contentType(ContentType.JSON).
                post(thisEndpoint).
        then().
                statusCode(422).
        and().
                body(matchesJsonSchemaInClasspath('register_validation_error.json'))
    }

    @Test
    void 'header is missing Redirection'() {
        given().
                body(validUser).
                post(thisEndpoint).
        then().
                statusCode(302)
    }

    @Test
    void 'get request is not allowed'() {
        given().
                get(thisEndpoint).
        then().
                statusCode(405)
    }

    @Test
    void 'put request is not allowed'() {
        given().
                put(thisEndpoint).
        then().
                statusCode(405)
    }

    @Test
    void 'delete request is not allowed'() {
        given().
                delete(thisEndpoint).
        then().
                statusCode(405)
    }
}
