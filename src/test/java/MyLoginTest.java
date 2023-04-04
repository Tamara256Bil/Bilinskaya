import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class MyTest  extends AbstractTest {

        @Test
        void postConnectUsers() {
            given()
                    .queryParam("token", getToken())
                    .contentType("application/x-www-form-urlencoded")
                    .formParam("username", "Bilinskaya")
                    .formParam("password", "767e324e7c")
                    .when()
                    .post(getBaseUrl() + "/gateway/login")
                    .then()
                    .statusCode(200);

            given()
                    .queryParam("token", getToken())
                    .contentType("application/x-www-form-urlencoded")
                    .formParam("username", "Bolshesimvolownepuskaet")
                    .formParam("password", "7354cb5202")
                    .when()
                    .post(getBaseUrl() + "/gateway/login")
                    .then()
                    .statusCode(200);  // баг, система должна выдать ошибку
            System.out.println("баг! в тесте №2, система должна выдать ошибку");

            given()
                    .queryParam("token", getToken())
                    .contentType("application/x-www-form-urlencoded")
                    .formParam("username", "№345")
                    .formParam("password", "27c1e5764e")
                    .when()
                    .post(getBaseUrl() + "/gateway/login")
                    .then()
                    .statusCode(401);

            given()
                    .queryParam("token", getToken())
                    .contentType("application/x-www-form-urlencoded")
                    .formParam("username", "32321456987456321032145")
                    .formParam("password", "382417df20")
                    .when()
                    .post(getBaseUrl() + "/gateway/login")
                    .then()
                    .statusCode(200);  // баг, система должна выдать ошибку
            System.out.println("баг! в тесте №4, система должна выдать ошибку");

            given()
                    .queryParam("token", getToken())
                    .contentType("application/x-www-form-urlencoded")
                    .formParam("username", "fhgh hgj")
                    .formParam("password", "c220645331")
                    .when()
                    .post(getBaseUrl() + "/gateway/login")
                    .then()
                    .statusCode(200);    // баг, система должна выдать ошибку
            System.out.println("баг! в тесте №5, система должна выдать ошибку");

            given()
                    .queryParam("token", getToken())
                    .contentType("application/x-www-form-urlencoded")
                    .formParam("username", "Билинская")
                    .formParam("password", "4e0d7c5f32")
                    .when()
                    .post(getBaseUrl() + "/gateway/login")
                    .then()
                    .statusCode(401);
        }

          @Test
            void getRequestMyPosts() {   //апрос ленты со своими постами
            given()
                    .header("X-Auth-Token", "b9e40aea807bf95b953830b5983c9be7")
                    .queryParam("sort", "createdAt")
                    .queryParam("order", "ASC")
                    .queryParam("page", "1")
                    .when()
                    .get(getPostmanproject()+"?sort=createdAt&order=ASC&page=1")
                    .then()
                    .statusCode(200);

            given()
                    .header("X-Auth-Token", "b9e40aea807bf95b953830b5983c9be7")
                    .queryParam("sort", "createdAt")
                    .queryParam("order", "ASC")
                    .queryParam("page", "3")
                    .contentType("application/json")
                    .response()
                    .log().body()
                    .when()
                    .get(getPostmanproject()+"?sort=createdAt&order=ASC&page=3")
                    .then()
                    .statusCode(200);






        }
            @BeforeAll
           static void setUp () {

                RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
            }
        }



