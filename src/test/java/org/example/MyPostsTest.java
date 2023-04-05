package org.example;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class MyPostsTest extends AbstractTest {
    @Test
    void getRequestMyPosts() {
        //запрос ленты со своими постами
        given()
                .header("X-Auth-Token", "b9e40aea807bf95b953830b5983c9be7")
                .queryParam("sort", "createdAt")
                .queryParam("order", "ASC")
                .queryParam("page", "1")
                .response()
                .log().body()
                .expect()
                .contentType(ContentType.JSON)
                .when()
                .get(getPostmanproject())
                .then()
                .assertThat()
                .statusCode(200);
    }
        @Test
        void getRequestMyPostsDESC() {
            //запрос ленты со своими постами от новых к старым
        given()
                .header("X-Auth-Token", "b9e40aea807bf95b953830b5983c9be7")
               // .queryParam("sort", "createdAt")
                .queryParam("order", "DESC")
               // .queryParam("page", "1")
                .response()
                .log().body()
                .contentType(ContentType.JSON)
                .when()
                .get(getPostmanproject())
                .then()
                .assertThat()
                .statusCode(200);
    }

        @Test
        void getRequestMyPostsNoPage() {
            //запрос несуществующей странцы в ленте своих постов, в теле ответа должен быть пустой масси data[]
        given()
                .header("X-Auth-Token", "b9e40aea807bf95b953830b5983c9be7")
                .queryParam("sort", "createdAt")
                .queryParam("order", "ASC")
                .queryParam("page", "3")
                .contentType("application/json")
                .response()
                .contentType(ContentType.JSON)
                .when()
                .get(getPostmanproject())
                .then()
                .assertThat()
                .body(containsString("{\"data\":[],\"meta\":{\"prevPage\":2,\"nextPage\":null,\"count\":5}}"))
                .statusCode(200);
    }

        @Test
         void getRequestMyPostsPageNumber() {
             //запрос страницы  в ленте своих постов по указанному номеру
        given()
                .header("X-Auth-Token", "b9e40aea807bf95b953830b5983c9be7")
                //.queryParam("sort", "createdAt")
                //.queryParam("order", "DESC")
                .queryParam("page", "2")
                .response()
                .log().body()
                .contentType(ContentType.JSON)
                .when()
                .get(getPostmanproject())
                .then()
                .assertThat()
                .statusCode(200);
    }
        @Test
        void getRequestMyPostsSort() {
            //запрос страницы в ленте своих постов по дате публикации постов
        given()
                .header("X-Auth-Token", "b9e40aea807bf95b953830b5983c9be7")
                .queryParam("sort", "createdAt")
                //.queryParam("order", "DESC")
                .queryParam("page", "1")
                .response()
                .log().body()
                .contentType(ContentType.JSON)
                .when()
                .get(getPostmanproject())
                .then()
                .assertThat()
                .statusCode(200);

    }
    @BeforeAll
    static void setUp () {

        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }
}





