package io.swagger.petstore.testbase;


import io.restassured.RestAssured;
import io.swagger.petstore.utils.PropertyReader;
import org.junit.BeforeClass;

/**
 * Created by Jay
 */
public class TestBase {
    public static PropertyReader propertyReader;

    @BeforeClass
    public static void init() {
        propertyReader = PropertyReader.getInstance();
        RestAssured.baseURI = propertyReader.getProperty("baseUrl");
       // RestAssured.port = Integer.parseInt(propertyReader.getProperty("port"));
       // RestAssured.basePath = Path.BOOKING;
    }

}
