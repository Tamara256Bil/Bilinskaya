package org.example;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class MyLoginTest  extends AbstractTest {

        @Test
        void postConnectUsers() {
            //авторизация пользователя с валидными кредами
            given()
                    .queryParam("token", AbstractTest.getToken())
                    .contentType("application/x-www-form-urlencoded")
                    .formParam("username", "Bilinskaya")
                    .formParam("password", "767e324e7c")
                    .when()
                    .post(AbstractTest.getBaseUrl() + "/gateway/login")
                    .then()
                    .statusCode(200);}
            @Test
            void postConnectUsersNoValid() {
                //авторизация пользователя с невалидными кредами, ожидаем ошибку
            given()
                    .queryParam("token", AbstractTest.getToken())
                    .contentType("application/x-www-form-urlencoded")
                    .formParam("username", "№345")
                    .formParam("password", "27c1e5764e")
                    .when()
                    .post(AbstractTest.getBaseUrl() + "/gateway/login")
                    .then()
                    .statusCode(401);
        }

            @Test
            void postConnectUsersNoValid2() {
                //авторизация пользователя с невалидными кредами, ожидаем ошибку
            given()
                    .queryParam("token", AbstractTest.getToken())
                    .contentType("application/x-www-form-urlencoded")
                    .formParam("username", "Билинская")
                    .formParam("password", "4e0d7c5f32")
                    .when()
                    .post(AbstractTest.getBaseUrl() + "/gateway/login")
                    .then()
                    .statusCode(401);
        }

            @Test
            void postConnectUsersNoValid3() {
                //авторизация пользователя с невалидными кредами, ожидаем ошибку
                // Баг! Система авторизует пользователя
            given()
                    .queryParam("token", AbstractTest.getToken())
                    .contentType("application/x-www-form-urlencoded")
                    .formParam("username", "Bolshesimvolownepuskaet")
                    .formParam("password", "7354cb5202")
                    .when()
                    .post(AbstractTest.getBaseUrl() + "/gateway/login")
                    .then()
                    .statusCode(401);
        }
            @Test
            void postConnectUsersNoValid4() {
                //авторизация пользователя с невалидными кредами, ожидаем ошибку
                // Баг! Система авторизует пользователя
            given()
                    .queryParam("token", AbstractTest.getToken())
                    .contentType("application/x-www-form-urlencoded")
                    .formParam("username", "32321456987456321032145")
                    .formParam("password", "382417df20")
                    .when()
                    .post(AbstractTest.getBaseUrl() + "/gateway/login")
                    .then()
                    .statusCode(401);
        }
           @Test
           void postConnectUsersNoValid5() {
            //авторизация пользователя с невалидными кредами, ожидаем ошибку
            // Баг! Система авторизует пользователя
            given()
                    .queryParam("token", AbstractTest.getToken())
                    .contentType("application/x-www-form-urlencoded")
                    .formParam("username", "fhgh hgj")
                    .formParam("password", "c220645331")
                    .when()
                    .post(AbstractTest.getBaseUrl() + "/gateway/login")
                    .then()
                    .statusCode(400);
        }

            @BeforeAll
           static void setUp () {

                RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
            }
        }



