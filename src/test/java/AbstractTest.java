import org.junit.jupiter.api.BeforeAll;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AbstractTest {

    static Properties prop = new Properties();
    private static InputStream configFile;
    private static String token;
    private static String baseUrl;

    private static String postmanProject;

    @BeforeAll
    static void initTest() throws IOException {
        configFile = new FileInputStream("src/main/resources/my.properties");
        prop.load(configFile);

        token =  prop.getProperty("token");
        baseUrl= prop.getProperty("base_url");
        postmanProject = prop.getProperty("postman_project");
    }

    public static String getToken() {
        return token;
    }

    public static String getBaseUrl() {
        return baseUrl;
    }
    public static String getPostmanproject() {
        return postmanProject;
    }
}