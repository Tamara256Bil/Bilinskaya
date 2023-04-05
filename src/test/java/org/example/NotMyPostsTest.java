package org.example;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class NotMyPostsTest extends AbstractTest {
    @Test
    void getRequestNotMyPosts() {
        //запрос ленты с чужими постами авторизованным пользователем
        given()
                .header("X-Auth-Token", "b9e40aea807bf95b953830b5983c9be7")
                .queryParam("notMe")
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
    void getRequestNotMyPostsNegative() {
        //запрос ленты с чужими постами авторизованным пользователем
        given()
                //.header("X-Auth-Token", "b9e40aea807bf95b953830b5983c9be7")
                .queryParam("notMe")
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
                .statusCode(401);
    }

        @Test
        void getRequestNotMyPostsDESC() {
        //Запррс ленты с чужими постами от новых к старым
        given()
                .header("X-Auth-Token", "b9e40aea807bf95b953830b5983c9be7")
                .queryParam("notMe")
                .queryParam("sort", "createdAt")
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
        void getRequestNotMyPostsALL() {
       // Запррс ленты с чужими постами. All вывести все посты
        given()
                .header("X-Auth-Token", "b9e40aea807bf95b953830b5983c9be7")
                .queryParam("notMe")
                .queryParam("sort", "createdAt")
                .queryParam("order", "ALL")
                // .queryParam("page", "1")
                .response()
                .log().body()
                .expect()
                .contentType(ContentType.JSON)
                .when()
                .get(getPostmanproject())
                .then()
                .assertThat()
                .statusCode(500);

    }
        @Test
        void getRequestNotMyPostsSort() {
        //Запррс страницы из ленты с чужими постами по дате публикации постов
        given()
                .header("X-Auth-Token", "b9e40aea807bf95b953830b5983c9be7")
                .queryParam("notMe")
                .queryParam("sort", "createdAt")
                //.queryParam("order", "ASC")
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
        void getRequestNotMyPostsPageNumber() {
       // запрос страницы  в ленте чужих постов по указанному номеру
        given()
                .header("X-Auth-Token", "b9e40aea807bf95b953830b5983c9be7")
                .queryParam("notMe")
                // .queryParam("sort", "createdAt")
                //.queryParam("order", "ASC")
                .queryParam("page", "7")
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


