package io.swagger.petstore.userinfo;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.swagger.petstore.constant.EndPoints;
import io.swagger.petstore.model.UserPojo;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.rest.RestRequests.given;

public class UserSteps {
    @Step("creating new user id : {0},username: {1},firstName: {2} ,lastName :{3}, email: {4}, password : {5},phone:{6},userStatus: {7}")
    public ValidatableResponse createNewUser(String id, String username, String firstName, String lastName, String email, String password, String phone, Double userStatus) {
        UserPojo userPojo = new UserPojo();
        userPojo.setId(id);
        userPojo.setUsername(username);
        userPojo.setFirstName(firstName);
        userPojo.setLastName(lastName);
        userPojo.setEmail(email);
        userPojo.setPassword(password);
        userPojo.setPhone(phone);
        userPojo.setUserStatus(userStatus);

        return given()
                .contentType(ContentType.JSON)
                .when()
                .body(userPojo)
                .post("/v2/user")
                .then();
    }
        @Step("get user by username : {0} ")
        public String getUserByUserName(String userName){
            return given()
                    .contentType(ContentType.JSON)
                    .when()
                    .get("/v2/user"+ EndPoints.GET_USER_BY_USERNAME)
                    .then().log().all()
                    .statusCode(200).extract().path("username");
    }

    @Step("creating new user id : {0},username: {1},firstName: {2} ,lastName :{3}, email: {4}, password : {5},phone:{6},userStatus: {7}")
    public ValidatableResponse updateByLastName(String id, String username, String firstName, String updateLastName, String email, String password, String phone, Double userStatus){
        UserPojo userPojo = new UserPojo();
        userPojo.setId(id);
        userPojo.setUsername(username);
        userPojo.setFirstName(firstName);
        userPojo.setLastName(updateLastName);
        userPojo.setEmail(email);
        userPojo.setPassword(password);
        userPojo.setPhone(phone);
        userPojo.setUserStatus(userStatus);

         return given()
                .contentType(ContentType.JSON)
                .when()
                .body(userPojo)
                .put("/v2/user"+ EndPoints.UPDATE_LASTNAME_BY_USERNAME)
                .then().log().all()
                .statusCode(200)
                .extract()
                .path("message");

    }

}
