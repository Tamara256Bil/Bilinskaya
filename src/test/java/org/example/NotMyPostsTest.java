package org.example;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class NotMyPostsTest extends AbstractTest {
    @Test
    void getRequestNotMyPosts() {

        //запрос ленты с чужими постами
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
                .statusCode(200);
        System.out.println("Тест №1 Запррс ленты с чужими постами от старых к новым ");

        given()
                .header("X-Auth-Token", "b9e40aea807bf95b953830b5983c9be7")
                .queryParam("notMe")
                .queryParam("sort", "createdAt")
                .queryParam("order", "DESC")
                // .queryParam("page", "1")
                .response()
                .log().body()
                .expect()
                .contentType(ContentType.JSON)
                .when()
                .get(getPostmanproject())
                .then()
                .statusCode(200);
        System.out.println("Тест №1 Запррс ленты с чужими постами от новых к старым ");


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
                .statusCode(500);
        System.out.println("Тест №1 Запррс ленты с чужими постами All вывести все посты. Негативный тест, " +
                "ожидаем  ошибку  500");

        given()
                .header("X-Auth-Token", "b9e40aea807bf95b953830b5983c9be7")
                .queryParam("notMe")
                .queryParam("sort", "createdAt")
                //.queryParam("order", "ASC")
                // .queryParam("page", "1")
                .response()
                .log().body()
                .expect()
                .contentType(ContentType.JSON)
                .when()
                .get(getPostmanproject())
                .then()
                .statusCode(200);
        System.out.println("Тест №1 Запррс страницы с чужими постами по дате публикации постов ");

        given()
                .header("X-Auth-Token", "b9e40aea807bf95b953830b5983c9be7")
                .queryParam("notMe")
                // .queryParam("sort", "createdAt")
                //.queryParam("order", "ASC")
                .queryParam("page", "1")
                .response()
                .log().body()
                .expect()
                .contentType(ContentType.JSON)
                .when()
                .get(getPostmanproject())
                .then()
                .statusCode(200);
        System.out.println("Тест №1 Запррс страницы с чужими постами по номеру страницы");
    }
        @Test
        void getRequestNotMyPostsNegative() {

        //запрос ленты с чужими постами неавторизованным пользователем
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
                .statusCode(401);
        System.out.println("Тест №1 Запррс ленты с чужими постами неавторизованным пользователем." +
                " Негативный тест, ожидаем ошибку 401");

}
    @BeforeAll
    static void setUp () {

        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }
}


