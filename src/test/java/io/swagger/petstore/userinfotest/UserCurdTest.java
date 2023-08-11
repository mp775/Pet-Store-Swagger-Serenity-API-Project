package io.swagger.petstore.userinfotest;

import io.restassured.http.ContentType;
import io.swagger.petstore.constant.EndPoints;
import io.swagger.petstore.model.UserPojo;
import io.swagger.petstore.testbase.TestBase;
import io.swagger.petstore.utils.TestUtils;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Title;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class UserCurdTest extends TestBase {
    static String id = "1099";
    static String username = "vp" + id;
    static String firstName = "ved";
    static String lastName = "puran";
    static String updateLastName = "gita";
    static String email = TestUtils.getRandomValue()+ "v.puran123@gmail.com";
    static String password = "vr11";
    static String phone = "07865432987";
    static double userStatus = 1;
    static String message;
    static String userName;
    static String updatedLaseNameResponse;

    @Title("This will create new user")
    @Test()
    public void test001() {
        UserPojo userPojo = new UserPojo();
        userPojo.setId(id);
        userPojo.setUsername(username);
        userPojo.setFirstName(firstName);
        userPojo.setLastName(lastName);
        userPojo.setEmail(email);
        userPojo.setPassword(password);
        userPojo.setPhone(phone);
        userPojo.setUserStatus(userStatus);

        message = SerenityRest.given()
                .contentType(ContentType.JSON)
                .when()
                .body(userPojo)
                .post("/v2/user")
                .then().log().all().statusCode(200)
                .extract()
                .path("message");
        System.out.println("userid :" + message);
        Assert.assertTrue(id.equals(message));
    }
    @Title("This will get user by username")
    @Test
    public void Test002(){
       userName = SerenityRest.given()
                .contentType(ContentType.JSON)
                .when()
                .get("/v2/user"+ EndPoints.GET_USER_BY_USERNAME)
                .then().log().all()
                .statusCode(200).extract().path("username");
        System.out.println("username :" + userName);
        Assert.assertTrue(userName.equals(username));


    }


    @Title("This will update user lastname")
    @Test
    public void test003(){
        UserPojo userPojo = new UserPojo();
        userPojo.setId(id);
        userPojo.setUsername(username);
        userPojo.setFirstName(firstName);
        userPojo.setLastName(updateLastName);
        userPojo.setEmail(email);
        userPojo.setPassword(password);
        userPojo.setPhone(phone);
        userPojo.setUserStatus(userStatus);

        updatedLaseNameResponse = SerenityRest.given()
                .contentType(ContentType.JSON)
                .when()
                .body(userPojo)
                .put("/v2/user"+ EndPoints.UPDATE_LASTNAME_BY_USERNAME)
                .then().log().all()
                .statusCode(200)
                .extract()
                .path("message");
        System.out.println("Last name updated for ID:" + updatedLaseNameResponse);
        Assert.assertTrue(id.equals(updatedLaseNameResponse));

    }

}
