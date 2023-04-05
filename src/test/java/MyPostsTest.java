import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;


public class MyPostsTest extends AbstractTest{
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
                .statusCode(200);
        System.out.println("Тест №1 Запррс страницы с моими постами от старых к новым ");


        given()
                .header("X-Auth-Token", "b9e40aea807bf95b953830b5983c9be7")
               // .queryParam("sort", "createdAt")
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
        System.out.println("Тест №2 Запрос страницы с моими постами от новых к старым");

        //запрос несуществующей странцы, в ответе дб пустой масси data[]
        given()
                .header("X-Auth-Token", "b9e40aea807bf95b953830b5983c9be7")
               //.queryParam("sort", "createdAt")
                //.queryParam("order", "ASC")
                .queryParam("page", "3")
                .contentType("application/json")
                .response()
                .log().body()
                .expect()
                .contentType(ContentType.JSON)
                //.body("data:", is( "[]") )
                //.body("meta", is ("{prevPage=2, nextPage=null, count=5}"))
                .when()
                .get(getPostmanproject())
                .then()
                .statusCode(200);
        System.out.println("Тест №2 Запрос несуществующей страницы. В теле ответа должен быть пустой массив data[]");


        //запрос страницы по её номеру
        given()
                .header("X-Auth-Token", "b9e40aea807bf95b953830b5983c9be7")
                //.queryParam("sort", "createdAt")
                //.queryParam("order", "DESC")
                .queryParam("page", "1")
                .response()
                .log().body()
                .expect()
                .contentType(ContentType.JSON)
                .when()
                .get(getPostmanproject())
                .then()
                .statusCode(200);
        System.out.println("Тест №3 Запрос страницы с моими постами по её номеру");

        //запрос страницы по дате публикации постов
        given()
                .header("X-Auth-Token", "b9e40aea807bf95b953830b5983c9be7")
                .queryParam("sort", "createdAt")
                //.queryParam("order", "DESC")
                //.queryParam("page", "1")
                .response()
                .log().body()
                .expect()
                .contentType(ContentType.JSON)
                .when()
                .get(getPostmanproject())
                .then()
                .statusCode(200);
        System.out.println("Тест №3 Запрос страницы с моими постами по дате публикации постов");

    }
    @BeforeAll
    static void setUp () {

        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }
}





